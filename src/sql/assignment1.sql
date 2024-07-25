-- 1. 모든 사원의 이름, 부서번호, 부서 이름 조회
SELECT concat(first_name, ' ', last_name) AS 'Name', departments.department_id, department_name
FROM employees
	JOIN departments ON employees.department_id = departments.department_id;

-- 2. 부서번호가 80인 부서 이름과 위치 조회
SELECT job_title, street_address
FROM jobs j
	JOIN Employees e ON j.job_id = e.job_id
	JOIN departments d ON e.department_id = d.department_id
    JOIN locations l ON d.location_id = l.location_id
WHERE d.department_id = 80;

-- 3. 커미션을 받는 사원의 이름, 부서 이름, 위치 번호, 도시명 조회
SELECT concat(first_name, ' ', last_name) AS 'Name', department_name, postal_code, city
FROM employees
	JOIN departments ON employees.department_id = departments.department_id
    JOIN locations ON departments.location_id = locations.location_id
WHERE commission_pct IS NOT NULL;

-- 4. 이름에 문자 'a'가 포함된 모든 사원의 이름과 부서명 조회
SELECT concat(first_name, ' ', last_name) AS 'Name', department_name
FROM employees
	JOIN departments ON employees.department_id = departments.department_id
WHERE last_name LIKE '%a%';

-- 5. 'Toronto'에서 근무하는 모든 사원의 이름, 업무, 부서번호, 부서명 조회
SELECT concat(first_name, ' ', last_name) AS 'Name', job_title, departments.department_id, department_name
FROM employees
	JOIN departments ON employees.department_id = departments.department_id
    JOIN locations ON departments.location_id = locations.location_id
    JOIN jobs ON employees.job_id = jobs.job_id
WHERE city = 'Toronto';

-- 6. 사원 이름, 사원번호, 관리자 이름, 관리자 번호 조회
SELECT concat(e1.first_name, ' ', e1.last_name) AS 'Employee', e1.employee_id AS 'Emp#', concat(e2.first_name, ' ', e2.last_name) AS 'Manager', e2.employee_id AS 'Mgr#'
FROM employees AS e1
	LEFT JOIN employees AS e2 ON e1.manager_id = e2.employee_id;

-- 7. 관리자가 없는 모든 사원 조회 (정렬: 사원번호)
SELECT concat(e1.first_name, ' ', e1.last_name) AS 'Employee', e1.employee_id AS 'Emp#'
FROM employees AS e1
	JOIN employees AS e2 ON e1.employee_id = e2.employee_id
WHERE e1.manager_id IS NULL
ORDER BY e1.employee_id;

-- 8. 지정한 사원 이름의 부서와 동일한 부서에서 근무하는 모든 사원을 조회
SELECT concat(employees.first_name, ' ', employees.last_name) AS 'Name', employees.department_id
FROM (
	SELECT employees.department_id
    FROM employees
    WHERE last_name = 'King'
) AS filter_employees
JOIN employees ON filter_employees.department_id = employees.department_id;

-- 9. 모든 사원의 이름, 부서 이름, 급여, 급여 등급 조회
SELECT concat(first_name, ' ', last_name) AS 'Name', job_title, department_name, salary,
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