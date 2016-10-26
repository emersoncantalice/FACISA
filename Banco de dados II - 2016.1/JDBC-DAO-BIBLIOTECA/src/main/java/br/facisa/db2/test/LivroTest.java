package br.facisa.db2.test;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.facisa.db2.GerenciadorDeLivros;
import br.facisa.db2.dao.LivroJDBCDAO;
import br.facisa.db2.entity.Livro;

public class LivroTest {

	@Test
	public void cadastro() {
		String titulo, descricao, autor;
		double valor;
		titulo = "Hackers Expostos";
		descricao = "Reforce a segurança de seu sistema e anule as ferramentas e "
				+ "táticas dos cibercriminosos com os conselhos e estratégia de defesa "
				+ "da mundialmente renomada equipe de Hackers Expostos.";
		autor = "Mcclure,Stuart";
		valor = Double.parseDouble("136.00");
		Livro l = new Livro(titulo, descricao, autor, valor);
		GerenciadorDeLivros.cadastraLivro(new LivroJDBCDAO(), l);
	}
	
	@Test
	public void atualiza() {
		cadastro();
		// Busca livro
		Livro livroDB = GerenciadorDeLivros.buscarLivro(new LivroJDBCDAO(), 1);

		// Atualiza
		String novoNome = "Hacker Invasão";
		double valor = Double.parseDouble("240.00");
		livroDB.setTitulo(novoNome);
		livroDB.setValor(valor);
		GerenciadorDeLivros.atualiza(new LivroJDBCDAO(), livroDB);
	}
	
	@Ignore
	@Test
	public void remove() {
		cadastro();
		cadastro();
		// Busca livro
		Livro livroDB = GerenciadorDeLivros.buscarLivro(new LivroJDBCDAO(), 2);

		// Remove
		GerenciadorDeLivros.remover(new LivroJDBCDAO(), livroDB.getId());
	}
	
	@Test
	public void listaTodos() {
		List<Livro> livros = GerenciadorDeLivros.listaTodosLivros(new LivroJDBCDAO());
		for (Livro livro : livros) {
			System.out.println(livro.getId());
			System.out.println(livro.getTitulo());
			System.out.println(livro.getValor() + "\n");
		}
	}

}
