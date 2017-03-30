package compiler.tree;

import compiler.tree.command.Bloco;

public class DeclFuncao implements DeclGlobal {
	private NomeArgs nomesParams;
	private Bloco bloco;
	private Tipo tipo;
	
	public DeclFuncao(NomeArgs assinatura, Bloco bloco) {
		this.nomesParams = assinatura;
		this.bloco = bloco;
	}

	@Override
	public Boolean verificarSemantica() {
		return NomeArgs.verificarSemantica() & bloco.verificarSemantica();
	}


	@Override
	public String gerarCodigoIntermediario(String filename) {
		String retorno = ".method ";
		retorno += nomesParams.gerarCodigoIntermediario(filename);
		retorno += bloco.gerarCodigoIntermediario(filename);
		return retorno;
	}

}
