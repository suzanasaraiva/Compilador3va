package compiler.tree;

import java.util.LinkedList;
import java.util.List;

import compiler.syntax.Simbolo;
import compiler.syntax.TabelaSimbolos;
import compiler.tree.command.DeclVariavel;

public class NomeArgs {
	private static LinkedList<DeclVariavel> paramFormais;
	private Tipo tipo;
	private String identificador;

	public NomeArgs(String identificar, LinkedList<DeclVariavel> paramFormais) {
		this.paramFormais = paramFormais;
//		this.tipo = tipo;
		this.identificador = identificar;
		Simbolo simbolo = new Simbolo(identificar, tipo, paramFormais);
//		tabela.put(simbolo);
//		tabela.criarTabelaLocal();
	}
	

	public static Boolean verificarSemantica() {
		//verificar tabela e adicionar ou dar erro.
		boolean result = true;
		for (DeclVariavel declVariavel : paramFormais) {
			if (!declVariavel.verificarSemantica()) {
				System.err.println("Erro ao verificar declVariavel!");
			}
		}
		return result;
	}
	private String switchType(Tipo t) {
		String retorno = "";
		if (t == Tipo.INT) {
			retorno += "i";
		} else if (t == Tipo.FLOAT) {
			retorno += "f";
		} else if (t == Tipo.BOOLEAN) {
			retorno += "b";
		} else if (t == Tipo.CHAR) {
			retorno += "c";
		} else if (t == Tipo.STRING) {
			retorno += "a";
		}
		return retorno;
	}

	public String gerarCodigoIntermediario(String filename) {
		String retorno = identificador + "(";
		for (DeclVariavel declVariavel : paramFormais) {
			retorno += switchType(declVariavel.getTipo());
		}
		
		retorno += ")";
		
		retorno += switchType(tipo);
		
		retorno += "\n";
		
		return retorno;
	}
}