-- A.1.0.
SELECT employees.employee_id, concat(first_name, ' ', last_name) AS 'Name', salary, job_title, hire_date, employees.manager_id
FROM employees
	JOIN jobs ON employees.job_id = jobs.job_id
ORDER BY employees.employee_id;

-- A.1.1.
SELECT concat(first_name, ' ', last_name) AS 'Name', job_title AS 'Job', salary AS 'Salary',
(salary * 12 + 100) AS 'Increased Ann_Salary', (salary + 100) * 12 AS 'Increased Salary'
FROM employees
	JOIN jobs ON employees.job_id = jobs.job_id;

-- A.1.2.
SELECT concat('이름: ', last_name, ' / 1 Year Salary = $', salary * 12) AS '1 Year Salary'
FROM employees
GROUP BY employee_id
ORDER BY employee_id;

-- A.1.3.
SELECT distinct department_name
FROM departments;

-- A.2.0.
SELECT concat(first_name, ' ', last_name) AS 'Name', salary
FROM employees
WHERE salary not between 7000 and 10000
ORDER BY salary;

-- A.2.1.
SELECT last_name AS 'e and o Name'
FROM employees
WHERE last_name LIKE '%e%'
AND last_name LIKE '%o%';

-- A.2.2.
SELECT concat(first_name, ' ', last_name) AS 'Name', employee_id, hire_date
FROM employees
WHERE DATE(hire_date) BETWEEN '2006-05-20' AND '2007-05-20'
ORDER BY hire_date;

-- A.2.3.
SELECT concat(first_name, ' ', last_name) AS 'Name', salary, job_title, commission_pct
FROM employees
	JOIN jobs ON employees.job_id = jobs.job_id
WHERE commission_pct IS NOT NULL
ORDER BY salary desc, commission_pct desc;

-- A.3.0.
SELECT employee_id, concat(first_name, ' ', last_name) AS 'Name', salary, ROUND((salary + salary * 0.123), 0) AS 'Increased Salary'
FROM employees;

-- A.3.1.
SELECT concat(first_name, ' ', last_name, ' is a ', UPPER(SUBSTR(job_title, 1, 2)), '_', UPPER(SUBSTR(job_title, 3))) AS 'Employee JOBs'
FROM employees
	JOIN jobs ON employees.job_id = jobs.job_id
WHERE last_name LIKE '%s';

-- A.3.2.
SELECT concat(first_name, ' ', last_name) AS 'Name', salary,
	CASE
    WHEN commission_pct IS NULL THEN concat('Salary only: ', salary * 12)
    ELSE concat('Salary + Commission: ', (salary + salary * commission_pct) * 12)
    END AS income
FROM employees
ORDER BY income desc;

-- A.3.3.
SELECT concat(first_name, ' ', last_name) AS 'Name', hire_date, DAYNAME(hire_date) AS hire_day_of_the_week
FROM employees;

-- A.4.0.
SELECT COUNT(DISTINCT manager_id)
FROM employees;

-- A.4.1.
SELECT department_id,
	concat('$', FORMAT(RPAD(ROUND(SUM(salary), 0), 6, '0'), 0)) AS 'SUM',
	concat('$', FORMAT(RPAD(ROUND(AVG(salary), 0), 6, '0'), 0)) AS 'AVG',
    concat('$', FORMAT(RPAD(ROUND(MAX(salary), 0), 6, '0'), 0)) AS 'MAX',
    concat('$', FORMAT(RPAD(ROUND(MIN(salary), 0), 6, '0'), 0)) AS 'MIN'
FROM employees
WHERE department_id IS NOT NULL
GROUP BY department_id
ORDER BY department_id;

-- A.4.2.
SELECT job_title, AVG(salary) AS 'AVG'
FROM employees
	JOIN jobs ON employees.job_id = jobs.job_id
WHERE job_title NOT LIKE '%Clerk%'
GROUP BY employees.job_id
HAVING AVG(salary) > 10000
ORDER BY 'AVG';