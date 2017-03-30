package compiler.tree.command;

import compiler.tree.Tipo;

public interface Comando {
	Boolean verificarSemantica();
		Tipo getTipo();
	String gerarCodigoIntermediario(String filename);
}
