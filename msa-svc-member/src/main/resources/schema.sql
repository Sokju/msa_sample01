use mylab01;

DROP TABLE IF EXISTS members;

CREATE TABLE members (
  email        VARCHAR(100) PRIMARY KEY NOT NULL,
  name         VARCHAR(100) NOT NULL,
  comment      VARCHAR(300)
);

INSERT INTO members (email, name, comment)
VALUES ('james@sample01.com', 'james', 'Administrator'');

INSERT INTO members (email, name, comment)
VALUES ('john@sample01.com', 'john', 'Tester'');

INSERT INTO members (email, name, comment)
VALUES ('harry@sample01.com', 'harry', 'developer'');
