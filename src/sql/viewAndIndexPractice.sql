-- View
CREATE VIEW Vorders
AS SELECT o.orderid, o.custid, c.name, o.bookid, b.bookname, o.saleprice, o.orderdate
   FROM Customer c, Orders o, Book b
   WHERE c.custid = o.custid AND b.bookid = o.bookid;

SELECT *
FROM Vorders
WHERE name = '김연아';

CREATE VIEW vm_Book_ball
AS SELECT *
   FROM BOOK
   WHERE  bookname LIKE '%축구%';

SELECT *
FROM vm_Customer;

CREATE OR REPLACE VIEW vm_Customer(custid, name, address)
AS SELECT custid, name, address
   FROM Customer
   WHERE  address LIKE '%영국%';

DROP VIEW vm_Customer;

-- 인덱스
-- 1번
CREATE VIEW highorders AS
	SELECT b.bookid, bookname, name, publisher, saleprice
    FROM orders o
		JOIN book b ON o.bookid = b.bookid
        JOIN customer c ON o.custid = c.custid;

-- 2번
SELECT bookname, name
FROM highorders;

-- 3번
DROP VIEW highorders;

CREATE VIEW highorders AS
	SELECT b.bookid, bookname, name, publisher
    FROM orders o
		JOIN book b ON o.bookid = b.bookid
        JOIN customer c ON o.custid = c.custid;