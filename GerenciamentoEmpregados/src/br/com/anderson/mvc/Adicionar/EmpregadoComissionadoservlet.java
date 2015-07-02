package br.com.anderson.mvc.Adicionar;


//Classe empregado Comissionado filha de Empregado;
public class EmpregadoComissionadoservlet extends Empregadoservlet {
	
	private int salarioMensal;
	private int taxaComissao;

	public int getSalarioMensal() {
		return salarioMensal;
	}

	public int getTaxaComissao() {
		return taxaComissao;
	}

	public void setSalarioMensal(int salarioMensal) {
		this.salarioMensal = salarioMensal;
	}

	public void setTaxaComissao(int taxaComissao) {
		this.taxaComissao = taxaComissao;
	}

}
