package compiler.tree.expression;

import compiler.tree.Tipo;

public class ExprAritmetica implements Expressao {

	private Expressao exp1;
	private Expressao exp2;
	private String operacao;

	public ExprAritmetica(Expressao exp1, Expressao exp2, String operacao) {
		this.exp1 = exp1;
		this.exp2 = exp2;
		this.operacao = operacao;
	}

	@Override
	public Boolean verificarSemantica() {
		boolean result = false;
		if (exp1.verificarSemantica() & exp2.verificarSemantica()) { 
			/*	verifica o nivel inferior antes de executar a analise semantica da expressao  
			 * */														
			Tipo tipoExp1 = exp1.getTipo();							
			Tipo tipoExp2 = exp2.getTipo();


			// Verifica se sao de tipos iguais na hora da atribuicao
			if (tipoExp1 == tipoExp2 && (tipoExp1 == Tipo.FLOAT || tipoExp1 == Tipo.INT)) {
				if((operacao.equals("+") || operacao.equals("-")||operacao.equals("*") || operacao.equals("/"))){
					result = true;
					}else if(operacao.equals("%") && tipoExp1 == Tipo.INT){
						result = true;
					}else {
						System.err.println("Tipo exp1 [" + tipoExp1
								+ "] nao e igual ao tipo exp2 [" + tipoExp2 + "] na operacao "+operacao);
					}
				
			} else if((tipoExp1 == Tipo.CHAR && tipoExp2 == Tipo.INT)&&
					(operacao.equals("+")|| operacao.equals("-"))){
				return true;
			}else {
				System.err.println("Tipo exp1 [" + tipoExp1
						+ "] nao e igual ao tipo exp2 [" + tipoExp2 + "] na operacao "+operacao);
			}		
			
		}
		return result;

	}
	
	@Override
	public Tipo getTipo() {
		Tipo tipoExp1 = exp1.getTipo();
		Tipo tipoExp2 = exp2.getTipo();

		Tipo result = null;


		if (tipoExp1 == tipoExp2 && (tipoExp1 == Tipo.FLOAT || tipoExp1 == Tipo.INT)) {
			result = tipoExp1;
		} else if ((operacao.equals("+") || operacao.equals("-")||
				operacao.equals("*")||operacao.equals("/")||operacao.equals("%"))
				&& (tipoExp1 == Tipo.CHAR && (tipoExp2 == Tipo.INT || tipoExp2 == Tipo.FLOAT))) {
			result = Tipo.CHAR;
		} else {
			System.err.println("Tipo exp1 [" + tipoExp1
					+ "] nao eh igual ao tipo exp2 [" + tipoExp2 + "] na operacao "+operacao);		}
		return result;

	}

	@Override
	public String gerarCodigoIntermediario(String filename) {
		return null;
	}

}
