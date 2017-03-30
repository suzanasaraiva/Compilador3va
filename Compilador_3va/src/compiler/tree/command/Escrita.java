package compiler.tree.command;

import java.util.LinkedList;
import java.util.List;

import compiler.tree.Tipo;
import compiler.tree.expression.Expressao;

public class Escrita implements Comando {
	private Expressao expressao;
	private LinkedList<Expressao> expressao1;
	

	public Escrita(Expressao expressao) {
		this.expressao = expressao;
	}
	public Escrita(LinkedList<Expressao> exp) {
		this.expressao1 = exp;
	}
	@Override
	public Boolean verificarSemantica() {
		return expressao.verificarSemantica();
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
