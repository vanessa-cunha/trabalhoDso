package br.ufsc.ine.bucha.vendinha;

import java.util.HashMap;
import java.util.Map;

import br.ufsc.ine.bucha.vendinha.uteis.Estocavel;

public class Estoque implements Estocavel {
	
	public Estoque() {
		produtos = new HashMap<Produto, Integer>();
	}
	
	private Map<Produto, Integer> produtos;

	public Map<Produto, Integer> getProdutos() {
		return produtos;
	}

	public void setProdutos(Map<Produto, Integer> produtos) {
		this.produtos = produtos;
	}

	@Override
	public void adquirir(Produto produto, int quantidade) {
		if (!getProdutos().containsKey(produto)) {
			//Se o produto não existe no estoque, deve ser criada uma entrada no mapa com a quantidade adquirida
			getProdutos().put(produto, quantidade);
		} else {
			//Se o produto já existe no estoque, deve-se adicionar a quantidade adquirida à quantidade já existente no estoque
			getProdutos().put(produto, (getProdutos().get(produto) + quantidade));
		}
	}

	@Override
	public void remover(Produto produto, int quantidade) {
		if (getProdutos().containsKey(produto) && getProdutos().get(produto) >= quantidade) {
			getProdutos().put(produto, (getProdutos().get(produto)-quantidade));
		} else {
			// Produto não existe em estoque ou não há quantidade suficiente
			throw new RuntimeException("Produto esgotado ou em quantidade insuficiente.");
		}
	}

	@Override
	public Map<Produto, Integer> listarItens() {
		return getProdutos();
	}

}
