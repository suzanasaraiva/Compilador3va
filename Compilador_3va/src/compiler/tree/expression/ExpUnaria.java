package compiler.tree.expression;

import compiler.tree.Tipo;

public class ExpUnaria implements Expressao {
	private Expressao expr;
	private String operacao;

	public ExpUnaria(String operacao, Expressao expr) {
		this.operacao = operacao;
		this.expr = expr;
	}

	
	@Override
	public Boolean verificarSemantica() {
		
		boolean result = false;
		Tipo tipoExp = expr.getTipo();
		
		if (operacao.equals("SUB") 
				&& (tipoExp == Tipo.FLOAT || tipoExp == Tipo.INT)) {
			result = true;
		} else  {
			System.err.println("Tipo exp [" + tipoExp
					+ "] nao eh um tipo numerico (int ou float)");	
		}
		if(operacao.equals("NOT")&& (tipoExp == Tipo.BOOLEAN)){
			result = true;
		}
		return result;
	}

	@Override
	public Tipo getTipo() {
		Tipo result = null;
		Tipo tipoExp = expr.getTipo();
		
		if (operacao.equals("SUB") 
				&& (tipoExp == Tipo.FLOAT || tipoExp == Tipo.INT)) {
			result = tipoExp;
		} else {
			System.err.println("Tipo exp [" + tipoExp
					+ "] nao eh um tipo numerico (int ou float)");
		}
		if(operacao.equals("NOT")&& (tipoExp == Tipo.BOOLEAN)){
			result = Tipo.BOOLEAN;
		}else
			System.out.println("tipo nao booleano");
		return result;
	}
	
	
	
	public String gerarCodigoIntermediario(String filename) {
		return null;
	}
}