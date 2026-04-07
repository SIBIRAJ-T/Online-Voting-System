CREATE DATABASE voting_db;

USE voting_db;

CREATE TABLE votes (
    id INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(50),
    candidate VARCHAR(50)
);