-- EXERCISES BASIC CRUD @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
-- 1. Find All Information About Departments 

SELECT * FROM departments
ORDER BY department_id;



-- 02. Find all Department Names @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
select `name`
from departments
order by department_id;



-- 03. Find Salary of Each Employee @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
select first_name, last_name, salary
from employees
order by employee_id;



-- 4. Find Full Name of Each Employee @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
select first_name, middle_name, last_name
from employees
order by employee_id;




-- 05. Find Email Address of Each Employee @@@@@@@@@@@@@@@@@@@@@@@@@@@@
select concat(first_name, '.', last_name, '@softuni.bg') as `full_email_address`
from employees;



-- 06. Find All Different Employee’s Salaries @@@@@@@@@@@@@@@@@@@@@@@@
select distinct salary
from employees;



-- 07. Find all Information About Employees @@@@@@@@@@@@@@@@@@@@@@@@@@@@
select *
from employees
where job_title = 'Sales Representative'
order by employee_id;



-- 08. Find Names of All Employees by Salary in Range @@@@@@@@@@@@@@@@@@
select first_name, last_name, job_title
from employees
where salary >= 20000 and salary <= 30000
order by employee_id;



-- 9. Find Names of All Employees @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
select concat_ws(' ', first_name, middle_name, last_name) as 'Full Name'
from employees
where salary in (25000, 14000, 12500, 23600);



-- 10. Find All Employees Without Manager @@@@@@@@@@@@@@@@@@@@@@@@@@@@@
select first_name, last_name
from employees
where manager_id is null;



-- 11. Find All Employees with salary More Than 50000 @@@@@@@@@@@@@@@@@
select first_name, last_name, salary
from employees
where salary > 50000
order by salary desc;



-- Find 5 Best Paid Employees @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
select first_name, last_name
from employees
order by salary desc
limit 5;



-- 13. Find All Employees Except Marketing @@@@@@@@@@@@@@@@@@@@@@@@@@
select first_name, last_name
from employees
where not department_id = 4;



-- 14. Sort Employees Table @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
select * 
from employees
order by salary desc, first_name asc, last_name desc, middle_name asc, employee_id;



-- 15. Create View Employees with Salaries @@@@@@@@@@@@@@@@@@@@@@@@@
create view `v_employees_salaries` as
select first_name, last_name, salary
from employees;



-- 16. Create View Employees with Job Titles @@@@@@@@@@@@@@@@@@@@@@@
create view `v_employees_job_titles` as
SELECT CONCAT(first_name, ' ', IFNULL(CONCAT_WS(' ', middle_name, ''), ''), last_name) as 'full_name',
	job_title
from employees;



-- 17. Distinct Job Titles @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
select distinct job_title
from employees
order by job_title asc;



-- 18. Find First 10 Started Projects @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
select *
from projects
order by `start_date`, `name`, `project_id`
limit 10;



-- 19. Last 7 Hired Employees @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
select first_name, last_name, hire_date
from employees
order by hire_date desc
limit 7;



-- 20. Increase Salaries @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
update employees
set salary = salary * 1.12
where department_id  in (1, 2, 4, 11);

select salary
from employees;