# BaaS
Testing fuctionality of BaaS

This is a RESTful Spring Boot Service using Spring Security for basic authentication.
Users and roles are stored in an PostgreSql Database. 

# How to setup database:

install postgre sql and define access properties in application.properties.

Create following tables for users and roles:

```sql
CREATE TABLE users(
   username varchar(20) NOT NULL,
   password varchar(20) NOT NULL,
   enabled boolean NOT NULL DEFAULT FALSE,
   primary key(username)
);

create table user_roles (
  user_role_id SERIAL PRIMARY KEY,
  username varchar(20) NOT NULL,
  role varchar(20) NOT NULL,
  UNIQUE (username,role),
  FOREIGN KEY (username) REFERENCES users (username)
);
```

