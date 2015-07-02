package br.com.anderson.adicionar;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.anderson.mvc.servlet.ContatoDaoAssalariadoservlet;

// Adiciona Empregado Assalariado

public class AddAssalariado extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException {

		@SuppressWarnings("unused")
		PrintWriter out = response.getWriter();
		try {

			String tipo = request.getParameter("tipo");
			int salarioMensal = Integer.parseInt((String) request
					.getParameter("salarioMensal"));
			String nome = request.getParameter("nome");
			String endereco = request.getParameter("endereco");

			// monta um objeto contato
			EmpregadoAssalariado empregado = new EmpregadoAssalariado();

			empregado.setTipo(tipo);
			empregado.setSalarioMensal(salarioMensal);

			empregado.setNome(nome);
			empregado.setEndereco(endereco);

			// salva o contato
			ContatoDaoAssalariadoservlet dao = new ContatoDaoAssalariadoservlet();
			dao.adiciona(empregado);

			// imprime o nome do contato que foi adicionado
			RequestDispatcher rd = request
					.getRequestDispatcher("/empregado-adicionado.jsp");
			rd.forward(request, response);

		} catch (Exception erro) {
			System.out.println("Erro ao cadastrar Empregado: " + erro);
		}
	}

}
