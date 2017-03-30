package compiler.tree.expression;

import compiler.syntax.Simbolo;
import compiler.syntax.TabelaSimbolos;
import compiler.tree.Tipo;

public class ExprIdentificador implements Expressao {
	private String identificador;

	public ExprIdentificador(String identificador) {
		this.identificador = identificador;
	}

	@Override
	public Boolean verificarSemantica() {
		TabelaSimbolos tabela = TabelaSimbolos.getInstance();
		Simbolo simbolo = tabela.getSimbolo(identificador);

		boolean result = false;

		if (simbolo != null) {
			result = true;
		} else {
			System.err.println("Identificador ["+identificador+"] não declarado anteriormente!");

		}
		return result;
	}

	@Override
	public Tipo getTipo() {
		TabelaSimbolos tabela = TabelaSimbolos.getInstance();
		Simbolo simbolo = tabela.getSimbolo(identificador);

		Tipo result = null;

		if (simbolo != null) { 
			if (simbolo.isVariavel()) {
				result = simbolo.getTipo();
			} else {
				result = simbolo.getTipoRetorno();
			}
		} else {
			System.err.println("Identificador ["+identificador+"] não declarado anteriormente!");
		}
		return result;
	}

	@Override
	public String gerarCodigoIntermediario(String filename) {
		return null;
	}

}
