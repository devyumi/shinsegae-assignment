-- 1. Tucker(last_name) 사원보다 급여를 많이 받고 있는 사원의 성과 이름(Name), 업무, 급여 조회 (15 rows)
SELECT CONCAT(e1.first_name, ' ', e1.last_name) Name, e1.job_id, e1.salary
FROM employees e1
	JOIN jobs j ON e1.job_id = j.job_id
WHERE e1.salary > (
	SELECT e2.salary
    FROM employees e2
    WHERE e2.last_name = 'Tucker');

-- 2. 업무별 최소 급여를 받고 있는 사원의 성과 이름(Name), 업무, 급여, 입사일 조회
SELECT CONCAT(e1.first_name, ' ', e1.last_name) Name, e1.job_id, e1.salary, e1.hire_date
FROM employees e1
WHERE salary = ANY (
	SELECT min_salary
	FROM jobs j
		JOIN employees e2 ON j.job_id = e2.job_id
	WHERE e1.job_id = e2.job_id
    GROUP BY j.job_id
)
ORDER BY department_id, salary;

-- 3. 소속 부서의 평균 급여보다 많은 급여를 받는 사원의 성과 이름(Name), 급여, 부서번호, 업무 조회
SELECT CONCAT(first_name, ' ', last_name) Name, salary, department_id, job_id
FROM employees e1
WHERE salary > ANY (
	SELECT distinct AVG(salary)
	FROM employees
	WHERE department_id = ANY(
		SELECT department_id
		FROM employees e2
        WHERE e1.department_id = e2.department_id)
	)
ORDER BY department_id, salary;

-- 4. 도시 이름이 영문 'O' 로 시작하는 지역에 살고있는 사원의 사번, 이름, 업무, 입사일 조회 (34 rows)
SELECT e.employee_id, CONCAT(e.first_name, ' ', e.last_name) Name, e.job_id, hire_date
FROM employees e
WHERE e.department_id = (
	SELECT d.department_id
    FROM departments d
    WHERE d.location_id = (
		SELECT l.location_id
        FROM locations l
        WHERE city LIKE 'O%'));

-- 5. 모든 사원의 소속부서 별 평균연봉을 계산하여 사원별로 성과 이름(Name), 업무, 급여, 부서번호, 부서 평균연봉(Department Avg Salary) 조회
SELECT CONCAT(e1.first_name, ' ', e1.last_name) Name, e1.job_id, e1.salary, e1.department_id, Department_Avg_Salary
FROM employees e1, (
		SELECT e2.department_id, AVG(salary * 12) Department_Avg_Salary
		FROM employees e2
		GROUP BY e2.department_id) avg_e
WHERE e1.department_id = avg_e.department_id
ORDER BY e1.department_id;

-- 6. ‘Kochhar’의 급여보다 많은 사원의 사원번호, 이름, 담당업무, 급여 조회 (1 row)
SELECT e1.employee_id, CONCAT(e1.first_name, ' ', e1.last_name) Name, job_title, e1.salary
FROM employees e1
	JOIN jobs j ON e1.job_id = j.job_id
WHERE e1.salary > (
	SELECT e2.salary
    FROM employees e2
    WHERE e2.last_name = 'Kochhar');

-- 7. 급여의 평균보다 적은 사원의 사원번호, 이름, 담당업무, 급여, 부서번호 조회 (56 rows)
SELECT employee_id, CONCAT(first_name, ' ', last_name) Name, job_id, salary, department_id
FROM employees
WHERE salary < (
	SELECT AVG(salary)
    FROM employees)
ORDER BY salary;

-- 8. 100번 부서의 최소 급여보다 최소 급여가 많은 다른 모든 부서 조회 (WHERE 절에 group 합수 불가. GROUP BY HAVING 이용) (4 rows)
SELECT MIN(salary)
FROM employees
WHERE department_id = 100;

SELECT department_id, MIN(salary)
FROM employees
GROUP BY department_id
HAVING MIN(salary) > (
	SELECT MIN(salary)
	FROM employees
	WHERE department_id = 100);

-- 9. 업무별로 최소 급여를 받는 사원의 사원번호, 이름, 업무, 부서번호 조회 (정렬: 업무별)
SELECT employee_id, CONCAT(first_name, ' ', last_name) Name, j.job_id, department_id
FROM employees e
	JOIN jobs j ON e.job_id = j.job_id
GROUP BY j.job_id
HAVING MIN(salary)
ORDER BY j.job_id;

-- 10. 100번 부서의 최소 급여보다 최소 급여가 많은 다른 모든 부서 조회
SELECT MIN(salary)
FROM employees
WHERE department_id = 100;

SELECT department_id, MIN(salary)
FROM employees
GROUP BY department_id
HAVING MIN(salary) > (
	SELECT MIN(salary)
	FROM employees
	WHERE department_id = 100);

-- 11. 업무가 SA_MAN 사원의 이름, 업무, 부서명, 근무지 조회 (5 rows)
-- 방법 1)
SELECT CONCAT(first_name, ' ', last_name) Name, j.job_id, department_name, street_address
FROM employees e
	JOIN jobs j ON e.job_id = j.job_id
    JOIN departments d ON e.department_id = d.department_id
    JOIN locations l ON d.location_id = l.location_id
WHERE j.job_id = 'SA_MAN';

-- 방법 2)
SELECT CONCAT(first_name, ' ', last_name) Name, job_id, department_name, street_address
FROM employees e
	JOIN departments d ON e.department_id = d.department_id
    JOIN locations l ON d.location_id = l.location_id
WHERE job_id = ANY (
	SELECT 'SA_MAN'
    FROM jobs);

-- 12. 가장 많은 부하직원을 갖는 MANAGER의 사원번호, 이름 조회 (FROM 서브쿼리 활용)
SELECT e1.employee_id, CONCAT(first_name, ' ', last_name) Name, subordinate
FROM employees e1, (
	SELECT manager_id, COUNT(e2.manager_id) subordinate
	FROM employees e2
	GROUP BY manager_id
) rs
WHERE e1.employee_id = rs.manager_id
ORDER BY subordinate DESC
LIMIT 1;

-- 13. 사원번호가 123인 사원과 업무가 같고, 사원번호가 192인 사원의 급여(SAL))보다 많은 사원의 사원번호, 이름, 직업(?), 급여 조회 (5 rows)
SELECT employee_id, CONCAT(first_name, ' ', last_name) Name, job_id, salary
FROM employees
WHERE job_id = (
	SELECT job_id
	FROM employees
	WHERE employee_id = 123)
AND salary > (
	SELECT salary
	FROM employees
	WHERE employee_id = 192);

-- 14. 50번 부서에서 최소 급여를 받는 사원보다 많은 급여를 받는 사원의 사원번호, 이름, 업무, 입사일자, 급여, 부서번호 조회 (단, 50번 부서의 사원 제외) (61 rows)
SELECT employee_id, CONCAT(first_name, ' ', last_name) Name, job_id, hire_date, salary, department_id
FROM employees
WHERE salary > (
	SELECT MIN(salary)
	FROM employees
	WHERE department_id = 50)
AND department_id != 50;

-- 15. 50번 부서의 최고 급여를 받는 사원 보다 많은 급여를 받는 사원의 사원번호, 이름, 업무, 입사일자, 급여, 부서번호 조회 (단, 50번 부서의 사원 제외) (31 rows)
SELECT employee_id, CONCAT(first_name, ' ', last_name) Name, job_id, hire_date, salary, department_id
FROM employees
WHERE salary > (
	SELECT MAX(salary)
	FROM employees
	WHERE department_id = 50);