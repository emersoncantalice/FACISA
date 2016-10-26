package br.facisa.db2.dao;

import java.util.List;

import br.facisa.db2.entity.Livro;

public interface LivroDAO {
	
	public void cadastra(Livro entity);
	
	public void exclusao(int id);
	
	public void atualizacao(Livro entity);
	
	public List<Livro> todosOsLivros();
	
	public Livro buscarLivro(int i);
	
	
}
