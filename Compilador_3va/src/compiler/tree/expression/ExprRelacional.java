package compiler.tree.expression;

import compiler.tree.Tipo;

public class ExprRelacional implements Expressao {

	private Expressao expr1;
	private Expressao expr2;
	private String operador;

	public ExprRelacional(Expressao expr1, Expressao expr2, String operador) {
		this.expr1 = expr1;
		this.expr2 = expr2;
		this.operador = operador;
	}
	
	@Override
	public Boolean verificarSemantica() {
		Tipo tipoExpr1 = expr1.getTipo();
		Tipo tipoExpr2 = expr2.getTipo();

		boolean result = false;
		
		if((tipoExpr1 == tipoExpr2)&&(tipoExpr1 == Tipo.INT || tipoExpr1 == Tipo.FLOAT)){
			if(operador.equals("<") ||operador.equals("<=") 
					||operador.equals(">") ||operador.equals(">=")){
				result = true;
			}else{
			System.out.println("Tipos invalidos");
			}
		}else if (tipoExpr1 == tipoExpr2){
			if(operador.equals("==")|| operador.equals("!=")){
				result = true;
			}else
				System.out.println("operacao invalida");
		}
		return result;
	}

	@Override
	public Tipo getTipo() {
		Tipo tipoExpr1 = expr1.getTipo();
		Tipo tipoExpr2 = expr2.getTipo();

		Tipo result = null;
		
		if ((operador.equals("==") || operador.equals("!="))
				&& (tipoExpr1 == tipoExpr2 && tipoExpr1 != Tipo.STRING)) {
			result = Tipo.BOOLEAN;
		} else if (tipoExpr1 == tipoExpr2 
				&& (operador.equals("<") || operador.equals("<=") || operador.equals(">") || operador.equals(">="))
				&& (tipoExpr1 == Tipo.FLOAT || tipoExpr1 == Tipo.INT)) {
			result = Tipo.BOOLEAN;
		} else {
			System.err.println("Tipo exp1 ["+tipoExpr1+"] nao eh igual ao tipo exp2 ["+tipoExpr2+"] na operacao "+operador+" ou sao do tipo String");
		}
		return result;
	}
	
	@Override
	public String gerarCodigoIntermediario(String filename) {
		return null;
	}

}

