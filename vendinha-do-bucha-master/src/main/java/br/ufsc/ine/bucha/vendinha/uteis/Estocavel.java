package br.ufsc.ine.bucha.vendinha.uteis;

import java.util.Map;

import br.ufsc.ine.bucha.vendinha.Produto;

/**
 * Representa um objeto que pode estocar produtos. Por exemplo:
 * Estoque
 * Carrinho
 *
 */
public interface Estocavel {
	
	void adquirir(Produto produto, int quantidade);
	
	default void adquirir(Produto produto) {
		adquirir(produto,1);
	}
	
	void remover(Produto produto, int quantidade);
	
	default void remover(Produto produto) {
		remover(produto,1);
	}
	
	Map<Produto, Integer> listarItens();

}
