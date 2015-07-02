package br.com.anderson.mvc.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.anderson.mvc.logica.Logica;

public class ControllerServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String parametro = request.getParameter("logica");

		String nomeDaClasse = "br.com.anderson.mvc.Logica." + parametro;

		try {
			@SuppressWarnings("rawtypes")
			Class classe = Class.forName(nomeDaClasse);
			System.out.println(parametro);
			Logica logica = (Logica) classe.newInstance();
			logica.executa(request, response);

		} catch (Exception e) {
			throw new ServletException("A l�gica de "
					+ " neg�cios causou uma exce��o", e);
		}
	}
}