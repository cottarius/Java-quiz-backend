CREATE TABLE users (
                       id BIGSERIAL PRIMARY KEY,
                       firstname VARCHAR(255),
                       lastname VARCHAR(255),
                       username VARCHAR(255),
                       password VARCHAR(255),
                       email VARCHAR(255) NOT NULL,
                       role VARCHAR(20) NOT NULL, -- ← добавлено
                       verification_code VARCHAR(255),
                       email_verified BOOLEAN DEFAULT FALSE,
                       verification_attempts INTEGER DEFAULT 0
);

