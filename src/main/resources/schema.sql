drop table if exists user_roles;
drop table if exists users;

CREATE TABLE users(
   id SERIAL PRIMARY KEY,
   username VARCHAR NOT NULL,
   password VARCHAR NOT NULL,
   enabled boolean NOT NULL DEFAULT TRUE,
   UNIQUE (username)
);
create table user_roles (
  id SERIAL PRIMARY KEY,
  username VARCHAR NOT NULL,
  role VARCHAR NOT NULL,
  UNIQUE (username,role),
  FOREIGN KEY (username) REFERENCES users (username)
);