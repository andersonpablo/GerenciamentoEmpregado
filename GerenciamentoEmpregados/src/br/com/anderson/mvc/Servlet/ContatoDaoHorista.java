package br.com.anderson.mvc.Servlet;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.com.anderson.mvc.Adicionar.EmpregadoHoristaservlet;

//Contato Dao adiciona de Horista

public class ContatoDaoHoristaservlet {
	private Connection connection;

	public ContatoDaoHoristaservlet() {
		this.connection = new ConnectionFactory().getConnection();
	}

	// Metodo Adiciona

	public void adiciona(EmpregadoHoristaservlet empregado) {
		String sql = "insert into empregadohorista " + "(tipo,nome,salarioPorHora,endereco)"
				+ " values (?,?,?,?)";
		try {
			// prepared statement para insersão
			PreparedStatement stmt = connection.prepareStatement(sql);
			// seta os valores
			stmt.setString(1, empregado.getTipo());
			stmt.setString(2, empregado.getNome());
			stmt.setInt(3, empregado.getsalarioPorHora());
			stmt.setString(4, empregado.getEndereco());
			
			// executa
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

}
