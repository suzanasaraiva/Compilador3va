package compiler.tree;

import java.util.LinkedList;

import compiler.tree.DeclVariavel;

public class ParamFormais {
	private LinkedList<DeclVariavel> paramFormais;

	public ParamFormais(LinkedList<DeclVariavel> paramFormais) {
		this.paramFormais = paramFormais;
	}

	public ParamFormais() {
		paramFormais = new LinkedList<DeclVariavel>();
	}

	public void add(DeclVariavel d) {
		paramFormais.addLast(d);
	}
	
	public Boolean verificarSemantica() {
		boolean result = true;
		for (DeclVariavel declVariavel : paramFormais) {
			if (!declVariavel.verificarSemantica()) {
				System.err.println("Erro ao verificar declVariavel!");
				result = false;
			}else 
				result = true;
		}
		
		return result;
	}
	
	public String gerarCodigoIntermediario(String filename) {
		return null;
	}
}
