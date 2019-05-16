package br.ufsc.ine.bucha.vendinha;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import br.ufsc.ine.bucha.vendinha.uteis.Estocavel;

public class Compra implements Estocavel {
	
	public Compra() {
		itens = new ArrayList<ItemCompra>();
	}
	
	private List<ItemCompra> itens;

	public List<ItemCompra> getItens() {
		return itens;
	}

	public void setItens(List<ItemCompra> itens) {
		this.itens = itens;
	}

	@Override
	public void adquirir(Produto produto, int quantidade) {
		ItemCompra itemCompra = getItens().stream().filter(ic -> ic.getProduto().getIdentificador().equals(produto.getIdentificador())).findFirst().orElse(null);
		if (itemCompra == null) {
			itemCompra = new ItemCompra();
			itemCompra.setProduto(produto);
			itemCompra.setQuantidade(quantidade);
			getItens().add(itemCompra);
		} else {
			itemCompra.setQuantidade(itemCompra.getQuantidade()+quantidade);
		}
	}

	@Override
	public void remover(Produto produto, int quantidade) {
		getItens().forEach(ic -> {
			if (ic.getProduto().equals(produto)) {
				int novaQuantidade = ic.getQuantidade()-quantidade;
				if (novaQuantidade < 0) {
					System.out.println("Solicitada a remoção de mais itens do que há na compra. Removendo todos");
				}
				ic.setQuantidade(novaQuantidade);
			}
		});
	}

	@Override
	public Map<Produto, Integer> listarItens() {		
		return getItens().stream().collect(Collectors.toMap(ItemCompra::getProduto, ItemCompra::getQuantidade));
	}

}
