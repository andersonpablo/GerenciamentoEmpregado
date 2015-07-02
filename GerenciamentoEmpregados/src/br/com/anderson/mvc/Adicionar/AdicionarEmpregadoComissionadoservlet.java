package br.com.anderson.mvc.Adicionar;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.anderson.mvc.Servlet.ContatoDaoComissionadoservlet;

//Adiciona empregado Comissionado

public class AdicionarEmpregadoComissionadoservlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException {

		try {
			String tipo = request.getParameter("tipo");

			int salarioMensal = Integer.parseInt((String) request
					.getParameter("salarioMensal"));
			int taxaComissao = Integer.parseInt((String) request
					.getParameter("taxaComissao"));
			String nome = request.getParameter("nome");
			String endereco = request.getParameter("endereco");

			// monta um objeto contato
			EmpregadoComissionadoservlet empregado = new EmpregadoComissionadoservlet();

			empregado.setTipo(tipo);
			empregado.setSalarioMensal(salarioMensal);
			empregado.setTaxaComissao(taxaComissao);
			empregado.setNome(nome);
			empregado.setEndereco(endereco);

			// salva o contato
			ContatoDaoComissionadoservlet dao = new ContatoDaoComissionadoservlet();
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
