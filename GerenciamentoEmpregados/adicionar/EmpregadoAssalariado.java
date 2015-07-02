package br.com.anderson.adicionar;


//Classe empregado assalariada filha de Empregado; 

public class EmpregadoAssalariado extends Empregado {

	public int salarioMensal;

	public void setSalarioMensal(int salarioMensal) {
		this.salarioMensal = salarioMensal;
	}

	public int getSalarioMensal() {
		return salarioMensal;
	}
}
