create table "user" (
	id bigserial,
	username varchar(50) not null,
	password varchar(255) not null,
	enabled boolean not null,
	primary key(id)
);

create table "role" (
	id bigserial,
	name varchar(50) not null,
	primary key(id)
);

create table authority (
	id bigserial,
	name varchar(50) not null,
	primary key(id)
);

create table user_role (
	user_id bigint not null,
	role_id bigint not null,
	primary key (user_id, role_id),
	foreign key (user_id) references "user" (id),
	foreign key (role_id) references "role" (id)
);

create table user_authority (
	user_id bigint not null,
	authority_id bigint not null,
	primary key (user_id, authority_id),
	foreign key (user_id) references "user" (id),
	foreign key (authority_id) references "authority" (id)
);

insert into "user"(username, "password", enabled) values 
('alex', '{bcrypt}$2a$12$Lv22bizCGwR5rzLhB1eUaO5CWp/7CVx3iYyT8B/bQYJ60Dn387k02', true),
('john', '{bcrypt}$2a$12$J70ghsrR8LspjUv7zYu3/OczJwroI3nARsbpi/Hsb0u.m88/iKW.u', true)
;

insert into "role"("name") values
('ROLE_USER'),
('ROLE_ADMIN')
;

insert into authority("name") values
('READ_INFO')
;

insert into user_role(user_id, role_id) values
(1, 1),
(1, 2),
(2, 1)
;

insert into user_authority(user_id, authority_id) values
(2, 1)
;