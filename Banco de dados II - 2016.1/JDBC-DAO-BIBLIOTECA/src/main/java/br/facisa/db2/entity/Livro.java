package br.facisa.db2.entity;

public class Livro {
	
	private int id;
	private String titulo;
	private String descricao;
	private String autor;
	private double valor;

	public Livro() {
	}

	public Livro(String titulo, String descricao, String autor, double valor) {
		this.titulo = titulo;
		this.descricao = descricao;
		this.autor = autor;
		this.valor = valor;
	}

	public int getId() {
		return id;
	}

	public String getTitulo() {
		return titulo;
	}

	public String getDescricao() {
		return descricao;
	}

	public String getAutor() {
		return autor;
	}

	public double getValor() {
		return valor;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setTitulo(String tiitulo) {
		this.titulo = tiitulo;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	@Override
	public String toString() {
		return "Livro [titulo=" + titulo + ", descricao=" + descricao + ", autor=" + autor + ", valor=" + valor + "]";
	}

}
