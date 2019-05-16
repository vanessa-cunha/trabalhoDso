package br.ufsc.ine.bucha.vendinha;

import java.math.BigDecimal;

public class ProdutoPadaria extends Produto {

	public ProdutoPadaria() {
		super();
	}

	public ProdutoPadaria(String identificador, String descricao, BigDecimal preco) {
		super(identificador, descricao, preco);
	}

}
