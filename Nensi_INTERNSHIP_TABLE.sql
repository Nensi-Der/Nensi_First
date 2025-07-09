CREATE TABLE kursi
(
id SERIAL PRIMARY KEY,
    emri_kursit VARCHAR(100) NOT NULL,
    kohezgjatja VARCHAR(50),
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);
INSERT INTO kursi (emri_kursit, kohezgjatja)
VALUES 
  ('Programim Web', '3 muaj'),
  ('Bazat e Python', '2 muaj'),
  ('Zhvillimi i Aplikacioneve Mobile', '4 muaj'),
  ('Bazat e SQL', '1 muaj'),
  ('Inteligjenca Artificiale', '5 muaj'),
  ('Rrjetet Kompjuterike', '3 muaj'),
  ('Siguria Kibernetike', '4 muaj'),
  ('Analiza e të Dhënave', '3 muaj'),
  ('Dizajn Grafik', '2 muaj'),
  ('Menaxhimi i Projekteve IT', '2 muaj');
  ALTER TABLE kursi
ADD COLUMN programming_language VARCHAR(50);
UPDATE kursi
SET programming_language = 'JavaScript'
WHERE emri_kursit = 'Programim Web';

UPDATE kursi
SET programming_language = 'Python'
WHERE emri_kursit = 'Bazat e Python';

UPDATE kursi
SET programming_language = 'Java'
WHERE emri_kursit = 'Zhvillimi i Aplikacioneve Mobile';

UPDATE kursi
SET programming_language = 'SQL'
WHERE emri_kursit = 'Bazat e SQL';

UPDATE kursi
SET programming_language = 'Python'
WHERE emri_kursit = 'Inteligjenca Artificiale';

UPDATE kursi
SET programming_language = 'Cisco CLI'
WHERE emri_kursit = 'Rrjetet Kompjuterike';

UPDATE kursi
SET programming_language = 'Python'
WHERE emri_kursit = 'Siguria Kibernetike';

UPDATE kursi
SET programming_language = 'R'
WHERE emri_kursit = 'Analiza e të Dhënave';

UPDATE kursi
SET programming_language = 'Adobe Tools'
WHERE emri_kursit = 'Dizajn Grafik';

UPDATE kursi
SET programming_language = 'N/A'
WHERE emri_kursit = 'Menaxhimi i Projekteve IT';
DELETE FROM kursi
WHERE emri_kursit = 'Bazat e SQL';
CREATE TABLE student (
    id SERIAL PRIMARY KEY,
    emri VARCHAR(100) NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL,
    birth_date DATE,
    phone_number VARCHAR(20),
    pike NUMERIC(5,2),
    internship_id INTEGER,
    CONSTRAINT fk_internship
      FOREIGN KEY (internship_id)
      REFERENCES internship(id)
      ON DELETE SET NULL
);
INSERT INTO student (emri, email, birth_date, phone_number, pike, internship_id)
VALUES
  ('A', 'a@gmail.com', '1998-05-12', '062', 88.5, 1),
  ('B', 'b@gmail.com', '1999-08-23', '063', 92.0, 2),
  ('C', 'c@gmail.com', '2000-01-15', '064', 79.75, 3),
  ('D', 'd@gmail.com', '1997-11-30', '065', 85.0, 1),
  ('E', 'e@gmail.com', '1998-07-08', '066', 90.25, 2),
  ('F', 'f@gmail.com', '1999-03-21', '067', 87.0, 3),
  ('G', 'g@gmail.com', '2000-10-05', '068', 93.5, NULL),
  ('H', 'h@gmail.com', '1997-06-17', '069', 80.0, 2),
  ('I', 'i@gmail.com', '1998-09-29', '061', 91.0, 1),
  ('J', 'j@gmail.com', '1999-12-11', '060', 78.5, NULL);
  ALTER TABLE student
RENAME COLUMN pike TO nota;
SELECT * FROM kursi;
SELECT * FROM student
WHERE emri LIKE 'A%';
SELECT * FROM kursi
WHERE created_at >= '2023-01-01' 
  AND created_at < '2026-01-01';
  SELECT *
FROM student
WHERE birth_date <= (CURRENT_DATE - INTERVAL '25 years');