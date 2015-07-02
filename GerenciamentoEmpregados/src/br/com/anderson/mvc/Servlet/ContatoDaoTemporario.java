package br.com.anderson.mvc.Servlet;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.com.anderson.mvc.Adicionar.EmpregadoTemporarioservlet;

//Contato Dao adiciona de Temporario

public class ContatoDaoTemporarioservlet {
	private Connection connection;

	public ContatoDaoTemporarioservlet() {
		this.connection = new ConnectionFactory().getConnection();
	}

	// Metodo Adiciona

	public void adiciona(EmpregadoTemporarioservlet empregado) {
		String sql = "insert into empregadotemporario "
				+ "(tipo,vigencia,valorContrato,nome,endereco)"
				+ " values (?,?,?,?,?)";
		try {
			// prepared statement para insersão
			PreparedStatement stmt = connection.prepareStatement(sql);
			// seta os valores
			stmt.setString(1, empregado.getTipo());
			stmt.setInt(3, empregado.getVigencia());
			stmt.setInt(3, empregado.getValorContrato());
			stmt.setString(2, empregado.getNome());
			stmt.setString(4, empregado.getEndereco());

			// executa
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

}
