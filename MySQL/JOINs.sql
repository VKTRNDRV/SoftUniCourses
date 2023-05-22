# Exercises: Subqueries and JOINs #################################################################################################

# 1. Employee Address ############################################################################################################
select e.employee_id, e.job_title, e.address_id, a.address_text
from employees as e 
join addresses as a 
on e.address_id = a.address_id
order by address_id asc
limit 5;



# 02. Addresses with Towns ######################################################################################################
select e.first_name, e.last_name, t.`name` as 'town', a.address_text
from employees as e
join addresses as a on e.address_id = a.address_id
join towns as t on a.town_id = t.town_id
order by e.first_name, e.last_name
limit 5;



# 03. Sales Employee ############################################################################################################
select e.employee_id, e.first_name, e.last_name, d.`name` as `department_name`
from employees as e
join departments as d on e.department_id = d.department_id
where d.`name` = 'Sales'
order by e.employee_id desc;



# 04. Employee Departments #####################################################################################################
select e.employee_id, e.first_name, e.salary, d.`name` as `department_name`
from employees as e
join departments as d on e.department_id = d.department_id
where e.salary > 15000
order by d.department_id desc
limit 5;



# 05. Employees Without Project ###############################################################################################
select e.employee_id, e.first_name
from employees as e
left join employees_projects as ep
	on e.employee_id = ep.employee_id
where ep.project_id is null
order by e.employee_id desc
limit 3;



# 06. Employees Hired After ################################################################################################
SELECT 
    e.first_name,
    e.last_name,
    e.hire_date,
    d.`name` AS `dept_name`
FROM
    employees AS e
        JOIN
    departments AS d ON e.department_id = d.department_id
WHERE
    e.hire_date > '1999-01-01'
        AND d.`name` = 'Sales'
        OR d.`name` = 'Finance'
ORDER BY e.hire_date;



# 07. Employees with Project ################################################################################################
SELECT 
    e.employee_id, e.first_name, p.`name` AS 'project_name'
FROM
    employees AS e
        JOIN
    employees_projects AS ep ON e.employee_id = ep.employee_id
        JOIN
    projects AS p ON ep.project_id = p.project_id
WHERE
    DATE(p.start_date) > '2002-08-13'
        AND p.end_date IS NULL
ORDER BY e.first_name ASC , p.`name` ASC
LIMIT 5;



# 08. Employee 24 ##########################################################################################################
SELECT 
    e.employee_id,
    e.first_name,
    (CASE
        WHEN DATE(p.start_date) >= '2005-01-01' THEN NULL
        ELSE p.`name`
    END) AS project_name
FROM
    employees AS e
        JOIN
    employees_projects AS ep ON e.employee_id = ep.employee_id
        RIGHT JOIN
    projects AS p ON ep.project_id = p.project_id
WHERE
    e.employee_id = 24
ORDER BY p.`name`;



# 09. Employee Manager ####################################################################################################
SELECT
	e.employee_id, 
    e.first_name, 
    e.manager_id, 
    m.first_name as `manager_name`
FROM
	employees as e
	join
	employees as m ON e.manager_id = m.employee_id
WHERE
	e.manager_id in (3, 7)
ORDER BY
	e.first_name;
    
    
    
# 10. Employee Summary ######################################################################################################
SELECT 
	e.employee_id, 
    concat_ws(' ', e.first_name, e.last_name) as employee_name, 
    concat_ws(' ', m.first_name, m.last_name) as manager_name, 
    d.`name` as `department_name`
FROM
	employees as e
	join
	employees as m ON e.manager_id = m.employee_id
    join
    departments as d ON e.department_id = d.department_id
WHERE
	e.manager_id is not null
ORDER BY
	e.employee_id
LIMIT 5;



# 11. Min Average Salary ####################################################################################################
SELECT avg(salary) as `min_average_salary`
FROM employees
GROUP BY department_id
ORDER BY `min_average_salary`
LIMIT 1;



# 12. Highest Peaks in Bulgaria ###############################################################################################
SELECT c.country_code, m.mountain_range, p.peak_name, p.elevation
FROM 
	countries as c
    JOIN mountains_countries as mc ON c.country_code = mc.country_code
    JOIN peaks as p ON mc.mountain_id = p.mountain_id
    JOIN mountains as m ON mc.mountain_id = m.id
WHERE
	c.country_code = 'BG'
    and p.elevation > 2835
ORDER BY 
	p.elevation desc;
    
    
    
# 13. Count Mountain Ranges ##################################################################################################
SELECT 
	c.country_code, 
    count(mc.mountain_id) as `mountain_range`
FROM 
	countries as c
    JOIN mountains_countries as mc ON c.country_code = mc.country_code
WHERE
	c.country_code IN ('BG', 'RU', 'US')
GROUP BY
	c.country_code
ORDER BY
	`mountain_range` desc;



# 14. Countries with Rivers ################################################################################################
SELECT c.country_name, r.river_name
FROM
	countries as c
	LEFT JOIN countries_rivers as cr ON c.country_code = cr.country_code
    LEFT JOIN rivers as r ON r.id = cr.river_id
WHERE
	c.continent_code = 'AF'
ORDER BY
	c.country_name asc
LIMIT 5;



# 16. Countries Without Any Mountains ######################################################################################
SELECT
	count(c.country_code) as `country_count`
FROM
	countries as c
    LEFT JOIN mountains_countries as mc ON c.country_code = mc.country_code
WHERE
	mc.mountain_id is null;
    
    
    
# 17. Highest Peak and Longest River by Country ############################################################################
SELECT
	c.country_name,
    max(p.elevation) as `highest_peak_elevation`,
    max(r.length) as `longest_river_length`
FROM 
	countries as c
	INNER JOIN countries_rivers as cr ON c.country_code = cr.country_code
    INNER JOIN rivers as r ON cr.river_id = r.id
    INNER JOIN mountains_countries as mc ON c.country_code = mc.country_code
    INNER JOIN mountains as m ON mc.mountain_id = m.id
    INNER JOIN peaks as p ON m.id = p.mountain_id
GROUP BY 
	c.country_name
ORDER BY
	`highest_peak_elevation` desc,
	`longest_river_length` desc,
    c.country_name
LIMIT 5;
	












