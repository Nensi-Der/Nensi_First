--Krijo nje tabele me emrin kursi
CREATE TABLE KURSI (
	ID SERIAL PRIMARY KEY,
	EMRI_KURSIT VARCHAR(100),
	KOHEZGJATJA INT,
	CREATE_DATE DATE DEFAULT CURRENT_DATE,
	UPDATE_DATE DATE DEFAULT CURRENT_DATE
);

-- Mbushja me 10 kurse
INSERT INTO
	KURSI (EMRI_KURSIT, KOHEZGJATJA)
VALUES
	('Python Basics', 30),
	('Java Fundamentals', 45),
	('Web Development', 60),
	('Data Science', 90),
	('DevOps', 40),
	('Cyber Security', 50),
	('Database Design', 35),
	('Cloud Computing', 55),
	('Machine Learning', 80),
	('Mobile App Dev', 70);

--Shto fushen programming_language
ALTER TABLE KURSI
ADD PROGRAMMING_LANGUAGE VARCHAR(50);

--Update te dhenat
UPDATE KURSI
SET
	PROGRAMMING_LANGUAGE = 'Python'
WHERE
	EMRI_KURSIT = 'Python Basics';

UPDATE KURSI
SET
	PROGRAMMING_LANGUAGE = 'Java'
WHERE
	EMRI_KURSIT = 'Java Fundamentals';

UPDATE KURSI
SET
	PROGRAMMING_LANGUAGE = 'JavaScript'
WHERE
	EMRI_KURSIT = 'Web Development';

UPDATE KURSI
SET
	PROGRAMMING_LANGUAGE = 'Python'
WHERE
	EMRI_KURSIT = 'Data Science';

UPDATE KURSI
SET
	PROGRAMMING_LANGUAGE = 'Bash'
WHERE
	EMRI_KURSIT = 'DevOps';

UPDATE KURSI
SET
	PROGRAMMING_LANGUAGE = 'C'
WHERE
	EMRI_KURSIT = 'Cyber Security';

UPDATE KURSI
SET
	PROGRAMMING_LANGUAGE = 'SQL'
WHERE
	EMRI_KURSIT = 'Database Design';

UPDATE KURSI
SET
	PROGRAMMING_LANGUAGE = 'AWS CLI'
WHERE
	EMRI_KURSIT = 'Cloud Computing';

UPDATE KURSI
SET
	PROGRAMMING_LANGUAGE = 'Python'
WHERE
	EMRI_KURSIT = 'Machine Learning';

UPDATE KURSI
SET
	PROGRAMMING_LANGUAGE = 'Kotlin'
WHERE
	EMRI_KURSIT = 'Mobile App Dev';

-- Fshij nj kurs
DELETE FROM KURSI
WHERE
	EMRI_KURSIT = 'Cyber Security';

-- Krijo tabelen student
CREATE TABLE STUDENT (
	ID SERIAL PRIMARY KEY,
	EMRI VARCHAR(100),
	EMAIL VARCHAR(100),
	BIRTH_DATE DATE,
	PHONE_NUMBER VARCHAR(20),
	PIKE INT,
	KURS_ID INT REFERENCES KURSI (ID)
);

-- Mbush tabelen student
INSERT INTO
	STUDENT (
		EMRI,
		EMAIL,
		BIRTH_DATE,
		PHONE_NUMBER,
		PIKE,
		KURS_ID
	)
VALUES
	('A', 'a@gmail.com', '1998-04-10', '068', 85, 1),
	('B', 'b@gmail.com', '2000-06-15', '069', 92, 2),
	('C', 'c@gmail.com', '1997-12-20', '067', 78, 3),
	('D', 'd@gmail.com', '1995-03-30', '066', 76, 4),
	('E', 'e@gmail.com', '1990-09-10', '065', 88, 5),
	('F', 'f@gmail.com', '1999-11-25', '064', 80, 1);

ALTER TABLE STUDENT
RENAME COLUMN PIKE TO NOTA;

--Listo te gjithe kurset
SELECT
	*
FROM
	KURSI;

--Listo studentet qe u nis emri me A
SELECT
	*
FROM
	STUDENT
WHERE
	EMRI LIKE 'A%';

--Listo kurset nga 2023 ne 2025
SELECT
	*
FROM
	KURSI
WHERE
	CREATE_DATE BETWEEN '2023-01-01' AND '2025-12-31';

--Studentet mbi 25 vjec
SELECT
	*
FROM
	STUDENT
WHERE
	BIRTH_DATE <= CURRENT_DATE - INTERVAL '25 years';

--Join per te marre te dhena nga te dyja tabelat
SELECT
	STUDENT.EMRI AS EMRI_STUDENTIT,
	KURSI.EMRI_KURSIT,
	KURSI.PROGRAMMING_LANGUAGE
FROM
	STUDENT
	JOIN KURSI ON STUDENT.KURS_ID = KURSI.ID;

--lidhje shume me shume
CREATE TABLE STUDENT_KURS (
	STUDENT_ID INT REFERENCES STUDENT (ID),
	KURS_ID INT REFERENCES KURSI (ID),
	DATA_REGJISTRIMIT DATE DEFAULT CURRENT_DATE,
	PRIMARY KEY (STUDENT_ID, KURS_ID)
);

--fut te dhenat te tabelen ndermjetese
INSERT INTO
	STUDENT_KURS (STUDENT_ID, KURS_ID)
VALUES
	(1, 1),
	(1, 3),
	(2, 2),
	(2, 3),
	(3, 4),
	(4, 1);

--Join midis 3 tabelave 
SELECT
	S.EMRI AS STUDENT,
	K.EMRI_KURSIT AS KURSI,
	K.PROGRAMMING_LANGUAGE,
	SK.DATA_REGJISTRIMIT
FROM
	STUDENT_KURS SK
	JOIN STUDENT S ON SK.STUDENT_ID = S.ID
	JOIN KURSI K ON SK.KURS_ID = K.ID;