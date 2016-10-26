package br.facisa.db2;

import java.util.List;

import br.facisa.db2.dao.LivroDAO;
import br.facisa.db2.entity.Livro;

public class GerenciadorDeLivros {
	
	public static void cadastraLivro(LivroDAO livroDAO, Livro livro ) {
		livroDAO.cadastra(livro);
	}
	
	public static void atualiza(LivroDAO livroDAO, Livro livro ) {
		livroDAO.atualizacao(livro);
	}
	
	public static List<Livro> listaTodosLivros(LivroDAO livroDAO) {
		return livroDAO.todosOsLivros();
	}
	
	public static void remover(LivroDAO livroDAO, int id) {
		livroDAO.exclusao(id);
	}

	public static Livro buscarLivro(LivroDAO livroDAO, int i) {
		return livroDAO.buscarLivro(i);
	}

}
