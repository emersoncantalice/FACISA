create database biblioteca;

-- DROP TABLE livros;

create table livros (
  id_livro serial primary key,
  titulo varchar(30),
  descricao varchar(500),
  autor varchar(30),
  valor decimal(5,2)
)

select * from livros;