DROP TABLE IF EXISTS voting;
DROP TABLE IF EXISTS dishs;
DROP TABLE IF EXISTS user_roles;
DROP TABLE IF EXISTS restaurant;
DROP TABLE IF EXISTS users;
DROP SEQUENCE IF EXISTS global_seq;

CREATE SEQUENCE GLOBAL_SEQ   START WITH 100000;
CREATE TABLE users
(
  id         INTEGER PRIMARY KEY DEFAULT nextval('GLOBAL_SEQ'),
  name       VARCHAR                 NOT NULL,
  email      VARCHAR                 NOT NULL,
  password   VARCHAR                 NOT NULL,
  registered TIMESTAMP DEFAULT now() NOT NULL
);
CREATE UNIQUE INDEX users_unique_email_idx  ON USERS (email);

CREATE TABLE user_roles
(
  user_id INTEGER NOT NULL,
  role    VARCHAR,
  CONSTRAINT user_roles_idx UNIQUE (user_id, role),
  FOREIGN KEY (user_id) REFERENCES USERS (id)  ON DELETE CASCADE
);
CREATE TABLE restaurant
(
  id   INTEGER PRIMARY KEY DEFAULT nextval('GLOBAL_SEQ'),
  name VARCHAR NOT NULL
);

CREATE TABLE voting
(
  id            INTEGER PRIMARY KEY DEFAULT nextval('GLOBAL_SEQ'),

  user_id       INTEGER                 NOT NULL,
  restaurant_id INTEGER                 NOT NULL,
  date_time     TIMESTAMP DEFAULT now() NOT NULL,
  FOREIGN KEY (restaurant_id) REFERENCES restaurant (id)   ON DELETE CASCADE
);

CREATE TABLE dishs
(
  id            INTEGER PRIMARY KEY DEFAULT nextval('GLOBAL_SEQ'),
  name          VARCHAR                   NOT NULL,
  restaurant_id INTEGER                   NOT NULL,
  date          TIMESTAMP DEFAULT now()   NOT NULL,
  price         INTEGER                   NOT NULL,
  FOREIGN KEY (restaurant_id) REFERENCES restaurant (id)   ON DELETE CASCADE

);
CREATE UNIQUE INDEX dishs_unique_name_idx  ON DISHS (name, restaurant_id);
