package br.com.anderson.mvc.Servlet;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.com.anderson.mvc.Adicionar.EmpregadoAssalariadoservlet;

//Contato Dao adiciona de Assalariado

public class ContatoDaoAssalariadoservlet {
	private Connection connection;

	public ContatoDaoAssalariadoservlet() {
		this.connection = new ConnectionFactory().getConnection();
	}

	// Metodo Adiciona

	public void adiciona(EmpregadoAssalariadoservlet empregado) {
		String sql = "insert into empregadoAssalariado "
				+ "(tipo,salarioMensal,nome,endereco)" + " values (?,?,?,?)";
		try {
			// prepared statement para insersão
			PreparedStatement stmt = connection.prepareStatement(sql);
			// seta os valores
			stmt.setString(1, empregado.getTipo());
			stmt.setInt(2, empregado.getSalarioMensal());
			stmt.setString(3, empregado.getNome());
			stmt.setString(4, empregado.getEndereco());

			// executa
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}
}
