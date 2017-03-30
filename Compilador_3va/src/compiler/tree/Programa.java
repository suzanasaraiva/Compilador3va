package compiler.tree;

import java.util.LinkedList;

public class Programa {
	private LinkedList<DeclGlobal> declaracoes;

	public Programa() {
		declaracoes = new LinkedList<DeclGlobal>();
	}

	public void addLast(DeclGlobal dec) {
		this.declaracoes.addLast(dec);
	}
	
	public Boolean verificarSemantica() {
		boolean result = true;
		
		for (DeclGlobal declGlobal : declaracoes) {
			if (!declGlobal.verificarSemantica()) {
				System.err.println("Erro em uma das declaracoes!");
				result = false;
			}
		}
		return result;
	}
	
	public String gerarCodigoIntermediario(String filename) {
		return null;
	}
}