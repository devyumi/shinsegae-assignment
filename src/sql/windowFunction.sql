-- ROW_NUMBER()
SELECT ROW_NUMBER() OVER(ORDER BY amount DESC) AS num, customer_id, amount
FROM (
   SELECT customer_id, SUM(amount) AS amount FROM payment GROUP BY customer_id
)AS x;

SELECT ROW_NUMBER() OVER(ORDER BY amount DESC, customer_id DESC) AS num, customer_id, amount
FROM (
   SELECT customer_id, SUM(amount) AS amount FROM payment GROUP BY customer_id
)AS x;

-- RANK()
SELECT RANK() OVER(ORDER BY amount DESC) AS num, customer_id, amount
FROM (
	SELECT customer_id, SUM(amount) AS amount
    FROM payment
    GROUP BY customer_id
) AS x;

SELECT staff_id, ROW_NUMBER() OVER(PARTITION BY staff_id ORDER BY amount DESC, customer_id ASC) AS num, customer_id, amount
FROM (
   SELECT customer_id, staff_id, SUM(amount) AS amount FROM payment GROUP BY customer_id, staff_id
)AS x;

-- DENSE_RANK()
SELECT DENSE_RANK() OVER(ORDER BY amount DESC) AS num, customer_id, amount
FROM (
	SELECT customer_id, staff_id, SUM(amount) AS amount
    FROM payment
    GROUP BY customer_id, staff_id
) AS x;

-- NTILE()
SELECT NTILE(100) OVER(ORDER BY amount DESC) AS num, customer_id, amount
FROM (
	SELECT customer_id, SUM(amount) AS amount
    FROM payment
    GROUP BY customer_id
) AS x;

-- LAG(), LEAD()
SELECT x.payment_date, LAG(x.amount) OVER(ORDER BY x.payment_date ASC) AS lag_amount, amount,
	LEAD(x.amount) OVER(ORDER BY x.payment_date ASC) AS lead_amount
FROM (
	SELECT DATE_FORMAT(payment_date, '%y-%m-%d') AS payment_date, SUM(amount) AS amount
    FROM payment
    GROUP BY DATE_FORMAT(payment_date, '%y-%m-%d')
) AS x
ORDER BY x.payment_date;

-- CUME_DIST()
SELECT x.customer_id, x.amount, CUME_DIST() OVER(ORDER BY x.amount DESC)
FROM (
	SELECT customer_id, SUM(amount) AS amount
    FROM payment
    GROUP BY customer_id
) AS x
ORDER BY x.amount DESC;

-- PERCENT_RANK()
SELECT x.customer_id, x.amount, PERCENT_RANK() OVER(ORDER BY x.amount DESC)
FROM (
	SELECT customer_id, SUM(amount) AS amount
    FROM payment
    GROUP BY customer_id
) AS x
ORDER BY x.amount DESC;