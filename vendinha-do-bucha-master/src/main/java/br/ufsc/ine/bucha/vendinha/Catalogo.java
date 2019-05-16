package br.ufsc.ine.bucha.vendinha;

import java.util.HashSet;
import java.util.Set;

public class Catalogo {
	
	public Catalogo() {
		produtos = new HashSet<Produto>();
	}
	
	private Set<Produto> produtos;

	public Set<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(Set<Produto> produtos) {
		this.produtos = produtos;
	}
	
	public void adicionarProduto(Produto produto) {
		getProdutos().add(produto);
	}
	
	public void removerProduto(Produto produto) {
		getProdutos().remove(produto);
	}
	
	public Produto recuperarProdutoPorChave(String chave) {
		return getProdutos().stream().filter(p -> p.getIdentificador().equals(chave)).findFirst().orElseThrow(() -> new RuntimeException("Nenhum produto encontrado com identificador " + chave));
	}

}
