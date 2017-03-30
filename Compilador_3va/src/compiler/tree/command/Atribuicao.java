package compiler.tree.command;

import compiler.syntax.Simbolo;
import compiler.syntax.TabelaSimbolos;
import compiler.tree.Tipo;
import compiler.tree.expression.Expressao;

public class Atribuicao implements Comando {
	private String identificador;
	private Expressao expressao;

	public Atribuicao(String ident, Expressao expressao) {
		this.identificador = ident;
		this.expressao = expressao;
	}

	@Override
	public Boolean verificarSemantica() {
		TabelaSimbolos tabela = TabelaSimbolos.getInstance();
		Simbolo simbolo = null;
		
		Tipo tipoExp = expressao.getTipo();

		if (tipoExp == null ) {
			System.err.println("Tipo da expressao ["+expressao.getClass().getName()+"]nao identificado!");
		}
		
			simbolo = tabela.getSimbolo(identificador);
			if (simbolo == null) {
				System.err.println("Identificador ["+identificador+"] não declarado anteriormente!");
			} else if (!simbolo.isVariavel()){
				System.err.println("Identificador ["+identificador+"] não é do tipo variavel!");
			} else if (simbolo.getTipo() != tipoExp){
				System.err.println("Identificador ["+identificador+"] não tem o mesmo tipo da expressao!");
			}
		
		return true;
		
	}
	
@Override
	public Tipo getTipo() {
		return expressao.getTipo();
	}

	@Override
	public String gerarCodigoIntermediario(String filename) {
		return null;
	}

}
