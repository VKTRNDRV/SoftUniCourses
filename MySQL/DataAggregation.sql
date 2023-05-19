-- Exercises: Data Aggregation @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

-- 1. Records' Count @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
select count(wd.id) as `count`
from wizzard_deposits as wd;



-- 02. Longest Magic Wand @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
select max(wd.magic_wand_size) as `longest_magic_wand`
from wizzard_deposits as wd;



-- 03. Longest Magic Wand per Deposit Groups @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
select wd.deposit_group, max(wd.magic_wand_size) as `longest_magic_wand`
from wizzard_deposits as wd
group by wd.deposit_group
order by longest_magic_wand asc, wd.deposit_group; 



-- 04. Smallest Deposit Group per Magic Wand Size @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
select deposit_group
from wizzard_deposits
group by deposit_group
order by avg(magic_wand_size)
limit 1;



-- 05. Deposits Sum @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
select deposit_group, sum(deposit_amount) as total_sum
from wizzard_deposits
group by deposit_group
order by total_sum asc;



-- 06. Deposits Sum for Ollivander Family @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
select deposit_group, sum(deposit_amount) as total_sum
from wizzard_deposits
where magic_wand_creator = 'Ollivander family'
group by deposit_group
order by deposit_group;



-- 07. Deposits Filter @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
select deposit_group, sum(deposit_amount) as total_sum
from wizzard_deposits
where magic_wand_creator = 'Ollivander family'
group by deposit_group
having total_sum < 150000
order by total_sum desc;



-- 08. Deposit Charge @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
SELECT `deposit_group`, `magic_wand_creator`, MIN(`deposit_charge`) AS 'min_deposit_charge'
FROM `wizzard_deposits`
GROUP BY `deposit_group`, `magic_wand_creator`
ORDER BY `magic_wand_creator`, `deposit_group`;



-- 9. Age Groups @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
SELECT (CASE
        WHEN `age` BETWEEN 0 AND 10 THEN '[0-10]'
        WHEN `age` BETWEEN 11 AND 20 THEN '[11-20]'
        WHEN `age` BETWEEN 21 AND 30 THEN '[21-30]'
        WHEN `age` BETWEEN 31 AND 40 THEN '[31-40]'
        WHEN `age` BETWEEN 41 AND 50 THEN '[41-50]'
        WHEN `age` BETWEEN 51 AND 60 THEN '[51-60]'
        WHEN `age` >= 61 THEN '[61+]'
    END) AS `age_group`, COUNT(age) AS `wizard_count` FROM `wizzard_deposits`
GROUP BY `age_group`
ORDER BY `age_group`;



-- 10. First Letter @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
select left(first_name, 1) as first_letter
from wizzard_deposits
where deposit_group = 'Troll Chest'
group by first_letter
order by first_letter;



-- 11. Average Interest @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
select deposit_group, is_deposit_expired, avg(deposit_interest) as avg_interest
from wizzard_deposits
where deposit_start_date > '1985-01-01'
group by deposit_group, is_deposit_expired
order by deposit_group desc, is_deposit_expired;



-- 12. Employees Minimum Salaries @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
select department_id, min(salary) as minimum_salary
from employees
where department_id in (2, 5, 7)
	and hire_date > '2000-01-01 00:00:00.000000' 
group by department_id
order by department_id;



-- 13. Employees Average Salaries @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
CREATE TABLE `salary_more_than` AS
SELECT *
FROM `employees`
WHERE `salary` > 30000;

delete from salary_more_than
where manager_id = 42;

update salary_more_than
set salary = salary + 5000
where department_id = 1;

select department_id, avg(salary) as avg_salary
from salary_more_than
group by department_id
order by department_id;



-- 14. Employees Maximum Salaries @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
select department_id, max(salary) as max_salary
from employees
group by department_id
having max_salary < 30000 or max_salary > 70000
order by department_id;



-- 15. Employees Count Salaries @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
select count(employee_id) as ''
from employees
where manager_id is null
	and salary is not null;
    


-- 16. 3rd Highest Salary* @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
select distinct department_id, 
	(
    select distinct salary
    from employees `e`
    where e.`department_id` = `employees`.`department_id`
    order by salary desc
    limit 1 offset 2
    ) as third_highest_salary
from employees
having third_highest_salary is not null
order by department_id;



-- 17. Salary Challenge @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
select first_name, last_name, department_id
from employees
where salary > (
				select avg(salary)
                from employees as e
                where e.department_id = employees.department_id
				)
order by department_id, employee_id
limit 10;



-- 18. Departments Total Salaries @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
select department_id,
	(
    select sum(salary)
    from employees m
    where m.department_id = e.department_id
    ) as total_salary
from employees e
group by department_id
order by department_id;