package compiler.tree.command;

import compiler.tree.Tipo;
import compiler.tree.expression.Expressao;

public class Iteracao implements Comando {

	private Expressao expressao;
	private Comando comando;

	public Iteracao(Expressao expressao, Comando comando) {
		this.expressao = expressao;
		this.comando = comando;
	}

	@Override
	public Boolean verificarSemantica() {
		if (expressao.getTipo() == Tipo.BOOLEAN) {
			return comando.verificarSemantica();
		} 
		
		return null;
	}
	
	@Override
	public Tipo getTipo() {
		return null;
	}

	@Override
	public String gerarCodigoIntermediario(String filename) {
		return null;
	}

}
