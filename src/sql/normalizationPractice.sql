-- 제3정규화 실습
CREATE TABLE department (
	id INT NOT NULL,
    name VARCHAR(20) NOT NULL,
    addr VARCHAR(50) NOT NULL,
    tel VARCHAR(15) NOT NULL,
    fax VARCHAR(15) NULL,
    PRIMARY KEY (id)
);

CREATE TABLE student (
	id INT NOT NULL,
    name VARCHAR(10) NOT NULL,
    birth DATE NOT NULL,
    addr VARCHAR(50) NOT NULL,
    phone CHAR(13) NOT NULL,
    dept_id INT NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE club (
	id INT NOT NULL,
    name VARCHAR(15) NOT NULL,
    reg_date DATE NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE club_join (
	student_id INT NOT NULL,
    club_id INT NOT NULL,
    join_date DATE NOT NULL,
    PRIMARY KEY (student_id, club_id)
);

ALTER TABLE student ADD CONSTRAINT fk_student_dept_id FOREIGN KEY(dept_id) REFERENCES department(id);
ALTER TABLE club_join ADD CONSTRAINT fk_club_join_student_id FOREIGN KEY(student_id) REFERENCES student(id);
ALTER TABLE club_join ADD CONSTRAINT fk_club_join_club_id FOREIGN KEY(club_id) REFERENCES club(id);

-- insert data
INSERT INTO department VALUES
(1, '화학공학과', '경기도', '031-123-123', '070-123-1234'),
(2, '경영학과', '경기도', '031-123-456', '070-123-1344'),
(3, '통계학과', '경기도', '031-133-123', '070-133-1444'),
(4, '역사학과', '경기도', '031-111-112', '070-132-1125');

INSERT INTO student VALUES
(231001, '문지영', '1978-03-23', '서울', '010-3456-3729', 1),
(231002, '배경민', '1789-05-13', '제주도', '010-3236-2359', 4),
(231003, '김명희', '1435-12-30', '강원도', '010-1116-1119', 2),
(231004, '천은정', '1948-11-03', '충청남도', '010-1112-3789', 2),
(231005, '이현경', '1938-02-11', '경기도', '010-3346-1119', 3);

INSERT INTO club VALUES
(1, '지구한바퀴여행', '2000-02-01'),
(2, '클래식연주동아리', '2010-06-05'),
(3, '워너비골퍼', '2020-03-01'),
(4, '쉘위댄스', '2021-07-01');

INSERT INTO club_join VALUES
(231001, 1, '2023-04-01'),
(231002, 1, '2023-04-03'),
(231003, 2, '2023-03-22'),
(231004, 3, '2023-03-07'),
(231002, 3, '2023-04-02'),
(231001, 4, '2023-04-30'),
(231005, 4, '2023-03-27');