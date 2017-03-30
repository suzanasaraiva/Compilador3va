package compiler.tree.expression;

import compiler.tree.Tipo;

public class ExprLogica implements Expressao {
	private Expressao exp1;
	private Expressao exp2;
	private String operLogico;

	public ExprLogica(Expressao e1, Expressao e2, String oper) {
		this.exp1 = e1;
		this.exp2 = e2;
		this.operLogico = oper;
	}
	
	@Override
	public Boolean verificarSemantica() {
		Tipo tipoExp1 = exp1.getTipo();
		Tipo tipoExp2 = exp2.getTipo();

		boolean result = false;
		
		if ((tipoExp1 == tipoExp2 && (tipoExp1 == Tipo.BOOLEAN))
				&&(operLogico.equals("AND")|| operLogico.equals("OR"))) {
			result = true;
		} else {
			System.err.println("Tipo exp1 ["+tipoExp1+"] nao eh igual ao tipo exp2 ["+tipoExp2+"] na operacao "+operLogico+" ou nao eh(sao) boolean");
			
		}
		return result;
	}

	@Override
	public Tipo getTipo() {
		Tipo result = null;
		Tipo tipoExp1 = exp1.getTipo();
		Tipo tipoExp2 = exp2.getTipo();
		
		if ((tipoExp1 == tipoExp2 && (tipoExp1 == Tipo.BOOLEAN))
				&&(operLogico.equals("AND")|| operLogico.equals("OR"))) {
			result = Tipo.BOOLEAN;
		} else {
			System.err.println("Tipo exp1 ["+tipoExp1+"] nao eh igual ao tipo exp2 ["+tipoExp2+"] na operacao "+operLogico+" ou nao eh(sao) boolean");
			
		}
		return result;
	}

	@Override
	public String gerarCodigoIntermediario(String filename) {
		return null;
	}

}
