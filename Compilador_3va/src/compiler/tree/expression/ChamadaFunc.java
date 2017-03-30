package compiler.tree.expression;

import java.util.LinkedList;
import java.util.List;

import compiler.syntax.Simbolo;
import compiler.syntax.TabelaSimbolos;
import compiler.tree.Tipo;
import compiler.tree.command.Comando;
import compiler.tree.command.DeclVariavel;
import compiler.tree.expression.*;

public class ChamadaFunc implements Expressao, Comando {
	private String identificador;
	private LinkedList<Expressao> lista_exprs;

	public ChamadaFunc(String identificador, LinkedList<Expressao> lista_exprs) {
		this.identificador = identificador;
		this.lista_exprs = lista_exprs;
	}
	
	@Override
	public Boolean verificarSemantica() {
		TabelaSimbolos tabela = TabelaSimbolos.getInstance();
		Simbolo simbolo = tabela.getSimbolo(identificador);
		
		if (simbolo == null) {
			System.err.println("Identificador ["+identificador+"] não declarado anteriormente!");
		} // precisa ver se o identificador eh variavel ou funcoa?
		
		if (!simbolo.isVariavel()) {
			List<DeclVariavel> parametros = simbolo.getParametros();
			if (lista_exprs.size() != parametros.size()) {
			
			}
			for (int i = 0; i<parametros.size(); i++) {
				if (lista_exprs.get(i).getTipo() != parametros.get(i).getTipo()) {
					
				}
			}
		}
		
		for (Expressao exp : lista_exprs) {
			exp.verificarSemantica();
		}
		
		return true;

	}

	@Override
	public Tipo getTipo() {

		TabelaSimbolos tabela = TabelaSimbolos.getInstance();
		Simbolo simbolo = tabela.getSimbolo(identificador);
		
		Tipo result = null;
		
		if (simbolo == null) {
			System.err.println("Identificador ["+identificador+"] não declarado anteriormente!");
		} else {
			if (simbolo.isVariavel()) {
				result = simbolo.getTipo();
			} else {
				result = simbolo.getTipoRetorno();
			}
		}
		return result;
	}
	
	@Override
	public String gerarCodigoIntermediario(String filename) {
		return null;
	}
}
