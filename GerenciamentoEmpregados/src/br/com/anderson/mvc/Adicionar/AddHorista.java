package br.com.anderson.mvc.Adicionar;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.anderson.mvc.Servlet.ContatoDaoHoristaservlet;

//Adiciona empregado Horista

public class AdicionarEmpregadoHoristaservlet extends HttpServlet {
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
			String nome = request.getParameter("nome");
			int salarioPorHora = Integer.parseInt((String) request
					.getParameter("salarioPorHora"));
			String endereco = request.getParameter("endereco");

			// monta um objeto contato
			EmpregadoHoristaservlet empregado = new EmpregadoHoristaservlet();

			empregado.setNome(nome);
			empregado.setEndereco(endereco);
			empregado.setsalarioPorHora(salarioPorHora);
			empregado.setTipo(tipo);

			// salva o contato
			ContatoDaoHoristaservlet dao = new ContatoDaoHoristaservlet();
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