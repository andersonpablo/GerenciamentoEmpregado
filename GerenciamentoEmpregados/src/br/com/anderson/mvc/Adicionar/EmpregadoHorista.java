package br.com.anderson.mvc.Adicionar;


//Classe empregado Horista filha de Empregado;

public class EmpregadoHoristaservlet extends Empregadoservlet  {

	
	private int salarioPorHora;
 
	
	public void setsalarioPorHora(int salarioPorHora) {
		this.salarioPorHora=salarioPorHora;
	}

	public int getsalarioPorHora() {
		return salarioPorHora;
	}
	 }

