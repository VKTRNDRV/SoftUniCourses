-- 1. Find Names of All Employees by First Name@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
select first_name, last_name
from employees
WHERE first_name COLLATE utf8_general_ci LIKE 'sa%'
order by employee_id;



-- 02. Find Names of All Employees by Last Name @@@@@@@@@@@@@@@@@@@@
select first_name, last_name
from employees
where last_name regexp '\w*ei\w*'
order by employee_id;



-- 3. Find First Names of All Employees @@@@@@@@@@@@@@@@@@@@@@@@@@@@
select first_name
from employees
where (department_id = 3 or department_id = 10)
	and (extract(year FROM hire_date) >= 1995 and extract(year FROM hire_date) <= 2005)
order by employee_id;



-- 04. Find All Employees Except Engineers @@@@@@@@@@@@@@@@@@@@@@@@@
select first_name, last_name
from employees
where job_title not regexp '\w*engineer\w*'
order by employee_id;



-- 05. Find Towns with Name Length @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
select `name`
from towns
where length(`name`) = 5
	or length(`name`) = 6
order by `name` asc;



-- 06. Find Towns Starting With @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
select town_id, `name`
from towns
where `name` like 'M%'
	or `name` like 'K%'
   or `name` like 'B%'
   or `name` like 'E%'
	or `name` like 'm%'
   or `name` like 'k%'
   or `name` like 'b%'
   or `name` like 'e%'
order by `name` asc;

-- 7. Find Towns Not Starting With @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
select town_id, `name`
from towns
where `name` not like 'R%'
	and `name` not like 'D%'
   and `name` not like 'B%'
   and `name` not like 'r%'
	and `name` not like 'd%'
   and `name` not like 'b%'
order by `name` asc;



-- 08. Create View Employees Hired After 2000 Year @@@@@@@@@@@@@@@@@@@@@@@@@@@
create view v_employees_hired_after_2000 as
select first_name, last_name
from employees
where year(hire_date) > 2000;

select * from v_employees_hired_after_2000;



-- 9. Length of Last Name @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
select first_name, last_name
from employees
where length(last_name) = 5;



-- 10. Countries Holding 'A' 3 or More Times @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
select country_name, iso_code
from countries
where (char_length(lower(country_name)) - char_length(replace(lower(country_name), 'a', ''))) >= 3
order by iso_code;



-- 11. Mix of Peak and River Names
select p.peak_name, 
	r.river_name, 
	concat(left(lower(p.peak_name), char_length(peak_name) - 1), lower(r.river_name)) as mix
from peaks as p 
join rivers as r
where right(lower(p.peak_name), 1) = left(lower(r.river_name), 1)
order by mix;



-- 12. Games from 2011 and 2012 Year @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
select `name`, date_format(start, '%Y-%m-%d') as `start`
from games
where year(`start`) = 2011
	or year(`start`) = 2012
order by `start`
limit 50;



-- 13. User Email Providers @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
select user_name, CASE WHEN email REGEXP '@.*' THEN SUBSTRING_INDEX(email, '@', -1) END AS `email provider`
from users
order by `email provider`, user_name;



-- 14. Get Users with IP Address Like Pattern @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
select user_name, ip_address
from users
where ip_address like '___.1%.%.___'
order by user_name;



-- 15. Show All Games with Duration and Part of the Day @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
select `name` as `game`,
case
	when hour(`start`)  >= 0 and hour(`start`) < 12
		then 'Morning'
	when hour(`start`)  >= 12 and hour(`start`) < 18
		then 'Afternoon'
	when hour(`start`)  >= 18 and hour(`start`) < 124
		then 'Evening'
end as `Part of the Day`,
case
	when duration <= 3 then 'Extra Short'
    when duration > 3 and duration <= 6 then 'Short'
    when duration > 6 and duration <= 10 then 'Long'
    when duration > 10 or duration is null then 'Extra Long'
end as `Duration`
from games;



-- 16. Orders Table @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
select product_name, 
	order_date,
    date_add(order_date, interval 3 day) as `pay_due`,
    date_add(order_date, interval 1 month) as `deliver_due`   
from orders;