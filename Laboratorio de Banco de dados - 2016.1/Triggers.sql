CREATE DATABASE Cadastro_pessoas;

CREATE TABLE pessoas (
	id int,
	nome varchar(200),
	data_nascimento date
);

CREATE TABLE backup (
	id int,
	nome varchar(200),
	data_nascimento date,
	data_exclusao date
);

alter table pessoas add constraint pessoas_pk primary key(id);
alter table backup add constraint backup_pk primary key(id);

insert into pessoas values (1,'E','12-12-1994');
insert into pessoas values (2,'R','12-12-1995');
insert into pessoas values (3,'T','12-12-1996');
insert into pessoas values (4,'Y','12-12-1997');
insert into pessoas values (5,'U','12-12-1998');
insert into pessoas values (6,'I','12-12-1999');
insert into pessoas values (7,'O','12-12-1991');
insert into pessoas values (8,'K','12-12-1992');
insert into pessoas values (9,'J','12-12-1993');
insert into pessoas values (10,'F','12-12-1990');

CREATE or replace FUNCTION BCK_PESSOAS()
RETURNS TRIGGER AS
$$
BEGIN
	insert into backup values (OLD.id,OLd.nome,OLD.data_nascimento,NOW());
	RETURN NEW;
END;
$$ LANGUAGE plpgsql

alter table backup drop constraint backup_pk;

create trigger t_pessoas
	after delete on
	pessoas for each row
	execute procedure BCK_PESSOAS();

delete from pessoas where id = 1;

select * from backup;

select * from pessoas;
