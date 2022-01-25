create table users(
                      username varchar(50) not null primary key,
                      password varchar(255) not null,
                      enabled boolean not null
);

create table authorities(
                            username varchar(50) not null,
                            authority varchar(255) not null,
                            foreign key (username) references users(username), unique (username, authority)
);

insert into users(username, password, enabled) values
                                                   ('alex', '{bcrypt}$2a$12$Lv22bizCGwR5rzLhB1eUaO5CWp/7CVx3iYyT8B/bQYJ60Dn387k02', true),
                                                   ('john', '{bcrypt}$2a$12$J70ghsrR8LspjUv7zYu3/OczJwroI3nARsbpi/Hsb0u.m88/iKW.u', true)
;

insert into authorities(username, authority) values
                                                 ('alex', 'ROLE_USER'),
                                                 ('alex', 'ROLE_ADMIN'),
                                                 ('john', 'ROLE_USER')
;

insert into authorities(username, authority) values
    ('john', 'ROLE_ADMIN');

delete from authorities where username = 'john' and authority = 'ROLE_ADMIN';

