package br.ufsc.ine.bucha.vendinha.uteis;

import java.math.BigDecimal;

import br.ufsc.ine.bucha.vendinha.Catalogo;
import br.ufsc.ine.bucha.vendinha.Estoque;
import br.ufsc.ine.bucha.vendinha.Produto;
import br.ufsc.ine.bucha.vendinha.ProdutoLimpeza;
import br.ufsc.ine.bucha.vendinha.ProdutoPadaria;

public class ControladorMercado {
	
	public ControladorMercado() {
		estoque = new Estoque();
		catalogo = new Catalogo();
		
		//Populando o catálogo de produtos
		adicionarProdutoAoCatalogo(new ProdutoLimpeza("detergente", "Detergente", new BigDecimal("1.49")));
		adicionarProdutoAoCatalogo(new ProdutoLimpeza("agua-sanitaria", "Água Sanitária", new BigDecimal("4.99")));
		adicionarProdutoAoCatalogo(new ProdutoLimpeza("limpa-vidros", "Limpa Vidros", new BigDecimal("6.99")));
		adicionarProdutoAoCatalogo(new ProdutoPadaria("pao-frances", "Pão Francês", new BigDecimal("0.60")));
		adicionarProdutoAoCatalogo(new ProdutoPadaria("pao-doce", "Pão Doce", new BigDecimal("0.60")));
		adicionarProdutoAoCatalogo(new ProdutoPadaria("cuca", "Cuca", new BigDecimal("4.49")));
		adicionarProdutoAoCatalogo(new ProdutoPadaria("corpinho-do-bucha", "Corpinho do Bucha", new BigDecimal("0.01")));
		
		//Adquirindo estoque inicial (cada produto possuirá 100 unidades)
		catalogo.getProdutos().forEach(p -> {
			incrementarEstoque(p, 100);
		});
	}
	
	private Estoque estoque;
	
	private Catalogo catalogo;

	public Estoque getEstoque() {
		return estoque;
	}

	public void setEstoque(Estoque estoque) {
		this.estoque = estoque;
	}

	public Catalogo getCatalogo() {
		return catalogo;
	}

	public void setCatalogo(Catalogo catalogo) {
		this.catalogo = catalogo;
	}

	public void adicionarProdutoAoCatalogo(Produto produto) {
		getCatalogo().adicionarProduto(produto);
	}

	public void removerProdutoDoCatalogo(Produto produto) {
		getCatalogo().removerProduto(produto);
	}

	public void incrementarEstoque(Produto produto, int quantidade) {
		getEstoque().adquirir(produto, quantidade);
	}

	public void incrementarEstoque(Produto produto) {
		getEstoque().adquirir(produto);
	}

	public void removerDeEstoque(Produto produto, int quantidade) {
		getEstoque().remover(produto, quantidade);
	}

	public void removerDeEstoque(Produto produto) {
		getEstoque().remover(produto);
	}

}
