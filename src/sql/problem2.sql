-- A.5.0.
SELECT 'Han-Bit' AS 'companry_name' ,concat(first_name, ' ', last_name) AS 'Name', department_name, city
FROM employees
	JOIN departments ON employees.department_id = departments.department_id
    JOIN locations ON departments.location_id = locations.location_id
WHERE state_province = 'Oxford';

-- A.5.1.
SELECT department_name, COUNT(employees.department_id)
FROM employees
	JOIN departments ON employees.department_id = departments.department_id
GROUP BY employees.department_id
HAVING COUNT(employees.department_id) >= 5
ORDER BY COUNT(employees.department_id) desc;

-- A.5.2.
SELECT concat(first_name, ' ', last_name) AS 'Name', job_title, department_name, hire_date, salary,
	CASE
    WHEN salary >= 1000 AND salary <= 2999 THEN 'A'
    WHEN salary >= 3000 AND salary <= 5999 THEN 'B'
    WHEN salary >= 6000 AND salary <= 9999 THEN 'C'
    WHEN salary >= 10000 AND salary <= 14999 THEN 'D'
    WHEN salary >= 15000 AND salary <= 24999 THEN 'E'
    WHEN salary >= 25000 AND salary <= 40000 THEN 'F'
    END AS grade_level
FROM employees
    JOIN jobs ON employees.job_id = jobs.job_id
	JOIN departments ON employees.department_id = departments.department_id;

-- A.5.3.
SELECT concat(e1.first_name, ' ', e1.last_name, ' report to ', UPPER(e2.first_name), ' ', UPPER(e2.last_name)) AS 'REPORT'
FROM employees AS e1
	LEFT JOIN employees AS e2 ON e1.manager_id = e2.employee_id;