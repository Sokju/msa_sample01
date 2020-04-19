DROP TABLE IF EXISTS members;

CREATE TABLE members (
  email        VARCHAR(100) PRIMARY KEY NOT NULL,
  name         VARCHAR(100) NOT NULL,
  comment      VARCHAR(300)
);

