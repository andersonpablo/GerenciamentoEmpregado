package br.com.anderson.mvc.Adicionar;


//Classe empregado assalariada filha de Empregado; 

public class EmpregadoAssalariadoservlet extends Empregadoservlet {

	private int salarioMensal;

	public void setSalarioMensal(int salarioMensal) {
		this.salarioMensal = salarioMensal;
	}

	public int getSalarioMensal() {
		return salarioMensal;
	}
}
