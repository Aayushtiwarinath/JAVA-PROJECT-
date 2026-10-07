-- Optional: Hibernate creates this automatically (ddl-auto=update).
CREATE DATABASE IF NOT EXISTS student_db;
USE student_db;
CREATE TABLE IF NOT EXISTS students (
  id BIGINT AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(100) NOT NULL,
  email VARCHAR(120) NOT NULL UNIQUE,
  course VARCHAR(60) NOT NULL,
  semester INT NOT NULL
);
