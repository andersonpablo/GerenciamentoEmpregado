package br.com.anderson.mvc.Adicionar;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.anderson.mvc.Servlet.ContatoDaoTemporarioservlet;



//Adiciona empregado  Temporario

public class AdicionarEmpregadoTemporarioservlet extends HttpServlet {
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
			int vigencia = Integer.parseInt((String) request.getParameter("vigencia"));
			int valorContrato = Integer.parseInt((String)request.getParameter("valorContrato"));
			
			String nome = request.getParameter("nome");
			
			String endereco = request.getParameter("endereco");
			
		
			

			// monta um objeto contato
			EmpregadoTemporarioservlet empregado = new EmpregadoTemporarioservlet();
 
			empregado.setTipo(tipo);
			empregado.setVigencia(vigencia);
			empregado.setValorContrato(valorContrato);
			empregado.setNome(nome);
			empregado.setEndereco(endereco);
			
			

			// salva o contato
			ContatoDaoTemporarioservlet dao = new ContatoDaoTemporarioservlet();
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
