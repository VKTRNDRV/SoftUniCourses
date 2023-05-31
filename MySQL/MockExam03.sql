
create database ruk_database;

create table branches(
	id int primary key auto_increment,
    `name` varchar(30) not null unique
);

create table employees(
	id int primary key auto_increment,
	first_name varchar(20) not null,
    last_name varchar(20) not null,
    salary decimal(10, 2) not null,
    started_on date not null,
    branch_id int not null,
constraint fk_b_id foreign key (branch_id)
	references branches(id)
);

create table clients(
	id int primary key auto_increment,
	full_name varchar(50) not null,
	age int not null
);

create table bank_accounts(
	id int primary key auto_increment,
    account_number varchar(10) not null,
    balance decimal(10, 2) not null,
    client_id int not null unique,
constraint fk_c_id foreign key (client_id)
	references clients(id)
);

create table cards(
	id int primary key auto_increment,
	card_number varchar(19) not null,
	card_status varchar(7) not null,
	bank_account_id int not null,
constraint fk_ba_id foreign key (bank_account_id)
	references bank_accounts(id)
);

create table employees_clients(
	employee_id int,
    client_id int,
constraint fk_e_id foreign key (employee_id)
	references employees(id),
constraint fk_cl_id foreign key (client_id)
	references clients(id)
);

# 02
/*You will have to insert records of data into the cards table, based on the clients table. 
For clients with id between 191 and 200 (inclusive), insert data in the cards table with the following values:
•	card_number – set it to full name of the client, but reversed!
•	card_status – set it to "Active".
•	bank_account_id –set it to client's id value. 
*/

insert into cards(card_number, card_status, bank_account_id)
select
	(reverse(full_name)) as `card_number`,
    ('Active') as `card_status`,
    clients.id as `bank_account_id`
from clients
where id between 191 and 200;


# 03
/*Update all clients which have the same id as the employee they are appointed to.
Set their employee_id with the employee with the lowest count of clients.
If there are 2 such employees with equal count of clients, take the one with the lowest id.
*/
UPDATE employees_clients
SET employee_id = (
    SELECT `min`.employee_id
    FROM(
		select ec.employee_id, count(client_id) as `count`
		FROM employees_clients as ec
		group by ec.employee_id
		ORDER BY `count`, employee_id
		LIMIT 1
        ) as `min`
)
WHERE employee_id = client_id;




# 04
/*Delete all employees which do not have any clients. */
DELETE 
FROM employees
WHERE id NOT IN (
    SELECT DISTINCT employee_id
    FROM employees_clients
    WHERE client_id IS NOT NULL
);



# 05
/*Extract from the database, all of the clients. 
Order the results ascending by client id.
Required Columns
•	id (clients)
•	full_name
*/
select id, full_name
from clients
order by id;



# 06
/*Extract from the database, all of the employees, which have salary greater than or equal to 100000
and have started later than or equal to the 1st of January - 2018. 
The salary should have a "$" as a prefix.
Order the results descending by salary, then by id.
Required Columns
•	id (employees)
•	full_name (first_name + " " + last_name)
•	salary
•	started_on
*/
select id, 
	concat_ws(' ', first_name, last_name) as `full_name`,
    concat('$', cast(salary as char)) as `salary`,
    started_on
from employees
where started_on >= '2018-01-01'
	and salary >= 100000
order by salary desc, id;



# 07
/*Extract from the database, all of the cards, and the clients that own them,
so that they end up in the following format:
{card_number} : {full_name}
Order the results descending by card id. Required Columns
•	id (cards)
•	card_token
Example
id	card_token
500	SM80 M775 4918 653X : Erin Cullingworth
*/
select ca.id, concat(ca.card_number, ' : ', cl.full_name) as `card_token`
from clients as cl
	join bank_accounts as ba on cl.id = ba.client_id
    join cards as ca on ba.id = ca.bank_account_id
order by ca.id desc;



# 08
/*Extract from the database, the top 5 employees, in terms of clients assigned to them.
Order the results descending by count of clients, and ascending by employee id.
•	name (employees)
•	started_on
•	count_of_clients
name	started_on	count_of_clients
Trula Glasscott	2017-08-23	14
*/
select concat_ws(' ', e.first_name, e.last_name) as `name`, 
	e.started_on,
    count(ec.client_id) as `count_of_clients`
from employees as e
	join employees_clients as ec on e.id = ec.employee_id
group by e.id
order by `count_of_clients` desc, e.id
limit 5;



# 09
/*Extract from the database, all branches with the count of their issued cards. Order the results by the count of cards, then by branch name.
Required Columns
•	name (branch)
•	count_of_cards
Example
name	count_of_cards
Becker Branch	93
Mifflin Branch	82
Mendota Branch	67
Moulton Branch	58
*/
SELECT b.`name` AS `name`, COUNT(c.id) AS count_of_cards
FROM branches b
	LEFT JOIN employees e ON b.id = e.branch_id
	LEFT JOIN employees_clients ec ON e.id = ec.employee_id
	LEFT JOIN clients cl ON ec.client_id = cl.id
	LEFT JOIN bank_accounts ba ON cl.id = ba.client_id
	LEFT JOIN cards c ON ba.id = c.bank_account_id
GROUP BY b.`name`
ORDER BY count_of_cards DESC, `name`;



# 10
/*Create a user defined function with the name udf_client_cards_count(name VARCHAR(30))
that receives a client's full name and returns the number of cards he has.
•	full_name (clients)
•	cards (count of cards)
SELECT c.full_name, udf_client_cards_count('Baxy David') as `cards` FROM clients c
WHERE c.full_name = 'Baxy David';
full_name	cards
Baxy David	6
*/

delimiter $$
create function udf_client_cards_count(`name` VARCHAR(30))
returns int
deterministic
begin
	declare card_count int;
    
	select count(cr.id) into card_count
    from clients cl
		join bank_accounts ba on cl.id = ba.client_id
        join cards cr on ba.id = cr.bank_account_id
	where cl.full_name = `name`
    limit 1;
    
    return card_count;
end
$$ delimiter ;

SELECT c.full_name, udf_client_cards_count('Baxy David') as `cards` FROM clients c
WHERE c.full_name = 'Baxy David';



# 11
/*Create a stored procedure udp_clientinfo which accepts the following parameters:
•	full_name
And extracts data about the client with the given full name.
Aside from the full_name extract the client's age, bank account number and balance.
The account’s salary should have "$" prefix.
full_name		age		account_number	balance
Hunter Wesgate	33		69666616-8		$803355.32
*/
delimiter $$
create procedure udp_clientinfo(full_name varchar(50))
begin
	if full_name not in (select full_name from clients)
		then rollback;
    end if;
	
    select c.full_name, c.age, ba.account_number, concat('$', cast(ba.balance as char)) as `balance`
    from clients as c
		join bank_accounts as ba on c.id = ba.client_id
	where c.full_name = full_name;
end
$$ delimiter ;