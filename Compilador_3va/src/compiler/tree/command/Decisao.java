package compiler.tree.command;

import compiler.tree.Tipo;
import compiler.tree.expression.Expressao;

public class Decisao implements Comando {
	private Expressao expressao;
	private Comando comandoIf;
	private Comando comandoElse;

	/**
	 * Construtor para if-else completo.
	 */
	public Decisao(Expressao expr, Comando cmdIf, Comando cmdElse) {
		this.expressao = expr;
		this.comandoIf = cmdIf;
		this.comandoElse = cmdElse;
	}

	/**
	 * Construtor para if sem else.
	 */
	public Decisao(Expressao expr, Comando cmdIf) {
		this.expressao = expr;
		this.comandoIf = cmdIf;
	}

	@Override
	public Boolean verificarSemantica() {
		boolean result = true;
		comandoIf.verificarSemantica();
		if (comandoElse != null) {
			comandoElse.verificarSemantica();
		}
		return result;
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
