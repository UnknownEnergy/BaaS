insert into users (username, password) values ('user', 'test123');
insert into users (username, password) values ('admin', 'test123');

insert into user_roles (username, role) values ('user', 'ROLE_USER');
insert into user_roles (username, role) values ('admin', 'ROLE_USER');
insert into user_roles (username, role) values ('admin', 'ROLE_ADMIN');