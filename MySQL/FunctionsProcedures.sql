# Exercises: Database Programmability and Transactions #####################################################

# 1. Employees with Salary Above 35000 #####################################################################
delimiter $$
create procedure usp_get_employees_salary_above_35000()
begin
	select first_name, last_name
    from employees
    where salary > 35000
    order by first_name, last_name, employee_id;
end $$
delimiter ;



# 2. Employees with Salary Above Number ###################################################################
delimiter $$
create procedure usp_get_employees_salary_above(min_salary decimal(12,4))
begin
	select first_name, last_name
    from employees
    where salary >= min_salary
    order by first_name, last_name, employee_id;
end
$$ delimiter ;



# 3. Town Names Starting With ###########################################################################
delimiter $$
create procedure usp_get_towns_starting_with(beginning varchar(20))
begin
	select `name`
    from towns
    where `name` like concat(beginning, '%')
    order by `name`;
end
$$ delimiter ;



# 4. Employees from Town ###############################################################################
delimiter $$
create procedure usp_get_employees_from_town(town_name varchar(31))
begin
	select employees.first_name, employees.last_name
    from employees
		join addresses on employees.address_id = addresses.address_id
        join towns on addresses.town_id = towns.town_id
	where towns.`name` = town_name
    order by employees.first_name, employees.last_name, employees.employee_id;
end
$$ delimiter ;



# 5. Salary Level Function ##############################################################################
delimiter $$
create function ufn_get_salary_level(salary decimal(12, 2))
returns varchar(15)
deterministic
begin
	declare salary_level varchar(15);
    if salary < 30000 then set salary_level = 'Low';
    elseif salary >= 30000 and salary <= 50000 then set salary_level = 'Average';
    else set salary_level = 'High';
    end if;
    return salary_level;
end
$$ delimiter ;



# 6. Employees by Salary Level #########################################################################
delimiter $$
create procedure usp_get_employees_by_salary_level(salary_level varchar(8))
begin
	declare min_salary decimal(12, 2);
    declare max_salary decimal(12, 2);
    if lower(salary_level) = 'low' then
		set min_salary = 0;
		set max_salary = 29999.99;
	elseif lower(salary_level) = 'average' then
		set min_salary = 30000;
        set max_salary = 50000;
	elseif lower(salary_level) = 'high' then
		set min_salary = 50000.01;
        set max_salary = 999999999.99;
    end if;
    
    select first_name, last_name
    from employees
    where salary >= min_salary
		and salary <= max_salary
	order by first_name desc, last_name desc;
end
$$ delimiter ;



# 7. Define Function #####################################################################################
delimiter $$
create function ufn_is_word_comprised(set_of_letters varchar(50), word varchar(50))
returns int
deterministic
begin
	return word regexp (concat('^[', set_of_letters, ']+$'));
end
$$ delimiter ;



# 08. Find Full Name #####################################################################################
delimiter $$
create procedure usp_get_holders_full_name()
begin
	select concat_ws(' ', account_holders.first_name, account_holders.last_name) as `full_name`
    from account_holders
    order by `full_name`, account_holders.id;
end
$$ delimiter ;



# 10. Future Value Function #############################################################################
delimiter $$
create function ufn_calculate_future_value(intial_sum decimal(19, 4), yearly_interest_rate double, num_of_years int)
returns decimal(19, 4)
deterministic
begin
	return intial_sum * (POW((1 + yearly_interest_rate), num_of_years));
end
$$ delimiter ;

select ufn_calculate_future_value(1000, 0.5, 5);



# 11. Calculating Interest ##############################################################################
delimiter $$
create procedure usp_calculate_future_value_for_account(acc_id int, interest_rate decimal(19, 4))
begin
	select accounts.id as `account_id`,
		account_holders.first_name,
        account_holders.last_name,
        accounts.balance as `current_balance`,
		ufn_calculate_future_value(accounts.balance, interest_rate, 5) as `balance_in_5_years`
    from account_holders
		join accounts on accounts.account_holder_id = account_holders.id
	where accounts.id = acc_id;
end
$$ delimiter ;

call usp_calculate_future_value_for_account(1, 0.1);











