package br.com.anderson.mvc.Servlet;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.com.anderson.mvc.Adicionar.EmpregadoComissionadoservlet;

//Contato Dao adiciona de Comissionado

public class ContatoDaoComissionadoservlet {
	private Connection connection;

	public ContatoDaoComissionadoservlet() {
		this.connection = new ConnectionFactory().getConnection();
	}

	// Metodo Adiciona

	public void adiciona(EmpregadoComissionadoservlet empregado) {
		String sql = "insert into empregadocomissionado "
				+ "(tipo,salarioMensal,taxaComissao,nome,endereco)"
				+ " values (?,?,?,?,?)";
		try {
			// prepared statement para insersão
			PreparedStatement stmt = connection.prepareStatement(sql);
			// seta os valores
			stmt.setString(1, empregado.getTipo());
			stmt.setInt(2, empregado.getSalarioMensal());
			stmt.setInt(3, empregado.getTaxaComissao());

			stmt.setString(4, empregado.getNome());

			stmt.setString(5, empregado.getEndereco());

			// executa
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

}
