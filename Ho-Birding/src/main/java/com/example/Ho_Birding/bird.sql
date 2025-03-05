CREATE TABLE bird2025 (
    id INT PRIMARY KEY AUTO_INCREMENT,
    nickname VARCHAR(255) NOT NULL UNIQUE,
    q1 TINYINT(1) NOT NULL,
    q2 TINYINT(1) NOT NULL,
    q3 TINYINT(1) NOT NULL,
    q4 TINYINT(1) NOT NULL,
    q5 TINYINT(1) NOT NULL,
    q6 TINYINT(1) NOT NULL,
    q7 TINYINT(1) NOT NULL,
    mbti VARCHAR(4),
    time TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);