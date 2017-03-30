package compiler.tree.command;

import java.util.LinkedList;

import compiler.syntax.Simbolo;
import compiler.syntax.TabelaSimbolos;
import compiler.tree.DeclGlobal;
import compiler.tree.Tipo;

public class DeclVariavel implements Comando, DeclGlobal {
	private LinkedList<String> idents;
	private Tipo tipo;

	public DeclVariavel() {
		this.idents = new LinkedList<String>();
	}

	public DeclVariavel(LinkedList<String> ids, Tipo tipo) {
		this.idents = ids;
		this.tipo = tipo;
		TabelaSimbolos tabela = TabelaSimbolos.getInstance();
		for (String id : ids) {
			Simbolo simbolo = new Simbolo(id, tipo);
			tabela.put(simbolo);
			}
	}

	public DeclVariavel(String id, Tipo tipo) {
		this.idents = new LinkedList<String>();
		idents.addLast(id);
		this.tipo = tipo;
		TabelaSimbolos tabela = TabelaSimbolos.getInstance();
		Simbolo simbolo = new Simbolo(id, tipo);
		tabela.put(simbolo);
	}
	
	
	public LinkedList<String> getIdents() {
		return idents;
	}

	@Override
	public Boolean verificarSemantica() {	
		TabelaSimbolos tabela = TabelaSimbolos.getInstance();
		Simbolo simbolo = null;
		
		for (String identificador : idents) {
			simbolo = tabela.getSimbolo(identificador);
			if (simbolo == null) {
				System.err.println("Identificador ["+identificador+"] nao declarado anteriormente");
				
			} else if (simbolo.getTipo() != tipo){
				System.err.println("Identificador nao tem o mesmo tipo da expressao");
				
			}
		}
		return true;
	}

	@Override
	public String gerarCodigoIntermediario(String filename) {
		return null;
	}

	@Override
	public Tipo getTipo() {
		// TODO Auto-generated method stub
		return null;
	}

}
