package br.facisa.db2.dao;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.facisa.db2.entity.Livro;

public class LivroJDBCDAO implements LivroDAO {

	public LivroJDBCDAO() {
	}

	public void cadastra(Livro entity) {
		Connection con = null;
		try {
			con = ConnectionFactory.getConnection();
			String insert_sql = "insert into livros (titulo, descricao, autor, valor) values (?, ?, ?, ?)";
			PreparedStatement pst;
			pst = con.prepareStatement(insert_sql);
			pst.setString(1, entity.getTitulo());
			pst.setString(2, entity.getDescricao());
			pst.setString(3, entity.getAutor());
			pst.setBigDecimal(4, new BigDecimal(entity.getValor()));
			pst.executeUpdate();
		} catch (SQLException e) {
			throw new DAOException("Operação não realizada com sucesso.", e);
		} finally {
			try {
				if (con != null)
					con.close();
			} catch (SQLException e) {
				throw new DAOException("Não foi possível fechar a conexão.", e);
			}
		}
	}

	public void exclusao(int id) {
		Connection con = null;
		try {
			con = ConnectionFactory.getConnection();
			String sql = "delete from livros where id_livro = ?";
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setInt(1, id);
			pst.executeUpdate();
		} catch (SQLException e) {
			throw new DAOException("Operação não realizada com sucesso.", e);
		} finally {
			try {
				if (con != null)
					con.close();
			} catch (SQLException e) {
				throw new DAOException("Não foi possível fechar a conexão.", e);
			}
		}
	}

	private Livro mapeamento(ResultSet rs) throws SQLException {
		Livro livro = new Livro();
		livro.setId(rs.getInt("id_livro"));
		livro.setTitulo(rs.getString("titulo"));
		livro.setDescricao(rs.getString("descricao"));
		livro.setAutor(rs.getString("autor"));
		livro.setValor(rs.getBigDecimal("valor").doubleValue());
		return livro;
	}

	public List<Livro> todosOsLivros() {
		Connection con = null;
		List<Livro> result = null;
		try {
			con = ConnectionFactory.getConnection();
			PreparedStatement pst;
			String sql = "select * from livros";
			pst = con.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			result = new ArrayList<Livro>();
			while (rs.next()) {
				Livro cl = mapeamento(rs);
				result.add(cl);
			}
		} catch (SQLException e) {
			throw new DAOException("Operação não realizada com sucesso.", e);
		} finally {
			try {
				if (con != null)
					con.close();
			} catch (SQLException e) {
				throw new DAOException("Não foi possível fechar a conexão.", e);
			}
		}
		return result;
	}

	public void atualizacao(Livro entity) {
		Connection con = null;
		try {
			con = ConnectionFactory.getConnection();
			String update_sql = "update livros set titulo = ?, descricao = ?, autor = ?, valor = ? where id_livro = ?";
			PreparedStatement pst;
			pst = con.prepareStatement(update_sql);
			pst.setInt(5, entity.getId());
			pst.setString(1, entity.getTitulo());
			pst.setString(2, entity.getDescricao());
			pst.setString(3, entity.getAutor());
			pst.setBigDecimal(4, new BigDecimal(entity.getValor()));
			pst.executeUpdate();
		} catch (SQLException e) {
			throw new DAOException("Operação não realizada com sucesso.", e);
		} finally {
			try {
				if (con != null)
					con.close();
			} catch (SQLException e) {
				throw new DAOException("Não foi possível fechar a conexão.", e);
			}
		}
	}

	public Livro buscarLivro(int id) {
		Connection con = null;
		Livro livro = null;
		try {
			con = ConnectionFactory.getConnection();
			PreparedStatement pst;
			String sql = "select * from livros where id_livro = ?";
			pst = con.prepareStatement(sql);
			pst.setInt(1, id);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				livro = mapeamento(rs);
			}
		} catch (SQLException e) {
			throw new DAOException("Operação não realizada com sucesso.", e);
		} finally {
			try {
				if (con != null)
					con.close();
			} catch (SQLException e) {
				throw new DAOException("Não foi possível fechar a conexão.", e);
			}
		}
		return livro;
	}

}
