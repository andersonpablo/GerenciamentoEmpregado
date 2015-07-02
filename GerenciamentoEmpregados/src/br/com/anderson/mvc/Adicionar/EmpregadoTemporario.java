package br.com.anderson.mvc.Adicionar;

//Classe empregado Temporario filha de Empregado;

public class EmpregadoTemporarioservlet extends Empregadoservlet {

	private int vigencia;
	private int valorContrato;

	public void setVigencia(int vigencia) {
		this.vigencia = vigencia;
	}

	public void setValorContrato(int valorContrato) {
		this.valorContrato = valorContrato;
	}

	public int getVigencia() {
		return vigencia;
	}

	public int getValorContrato() {
		return valorContrato;
	}

}
