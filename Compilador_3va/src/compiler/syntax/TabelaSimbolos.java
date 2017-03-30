package compiler.syntax;

import java.util.HashMap;
import java.util.Map;

public class TabelaSimbolos {
	private static TabelaSimbolos tabelaSimbolos;
	
	private static Map<String, Simbolo> tabelaLocal;
	private static Map<String, Simbolo> tabelaGlobal;
	
	private TabelaSimbolos(){
		tabelaGlobal = new HashMap<String, Simbolo>();
	}
	
	public static void criarTabelaLocal() {
		if (tabelaLocal != null) {
			tabelaLocal.clear();
		}
		tabelaLocal = new HashMap<String, Simbolo>();
	}
	
	public static void put(Simbolo simbolo) {
		// ver como fica a local e global
		if (tabelaLocal == null) {
			tabelaGlobal.put(simbolo.getNome(), simbolo);
		} else {
			tabelaLocal.put(simbolo.getNome(), simbolo);
		}
	}
	
	public Simbolo getSimbolo(String nome) {
		Simbolo simbolo = null;
		if (tabelaLocal != null && !tabelaLocal.isEmpty()) {
			simbolo = tabelaLocal.get(nome);
		} 
		
		if (simbolo == null) {
			simbolo = tabelaGlobal.get(nome);
		}
		return simbolo;
	}
	public static synchronized TabelaSimbolos getInstance() {
		if (tabelaSimbolos == null) {
			tabelaSimbolos = new TabelaSimbolos();
		} return tabelaSimbolos;
	}
}
