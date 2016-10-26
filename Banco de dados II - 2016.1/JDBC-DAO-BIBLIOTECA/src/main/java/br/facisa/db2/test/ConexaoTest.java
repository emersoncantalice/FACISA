package br.facisa.db2.test;

import java.sql.Connection;
import java.sql.SQLException;

import org.junit.Test;

import br.facisa.db2.dao.ConnectionFactory;

public class ConexaoTest {

	@Test
	public void conectar() {
		try {
			Connection con;
			con = ConnectionFactory.getConnection();
			System.out.println("Conexão Realizada");
			System.out.println("Fechando conexao...");
			con.close();
			System.out.println("Conexão fechada!");
		} catch (SQLException e) {
			System.out.println("Falha na conexao");
		}
	}

}
