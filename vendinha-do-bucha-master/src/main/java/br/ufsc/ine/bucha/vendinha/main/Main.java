package br.ufsc.ine.bucha.vendinha.main;

import java.math.BigDecimal;
import java.util.Scanner;

import br.ufsc.ine.bucha.vendinha.Compra;
import br.ufsc.ine.bucha.vendinha.ItemCompra;
import br.ufsc.ine.bucha.vendinha.Produto;
import br.ufsc.ine.bucha.vendinha.uteis.ControladorMercado;

public class Main {
	
	private static ControladorMercado controlador;
	
	private static Compra compra;
	
	private static Scanner scanner;

	public static void main(String[] args) {
		controlador = new ControladorMercado();
		compra = new Compra();
		scanner = new Scanner(System.in);
		
		exibirCabecalho();
		while (true) {
			exibirMenuPrincipal();
			String opcaoStr = scanner.nextLine();
			Integer opcao = new Integer(opcaoStr);
			switch (opcao) {
				case 1:
					listarProdutos();
					break;
				case 2:
					System.out.println("Qual produto deseja ver os detalhes?");
					String chave = scanner.nextLine();
					detalhesDoProduto(chave);
					break;
				case 3:
					adicionarAoCarrinho();
					break;
				case 4:
					removerProdutosDoCarrinho();
					break;
				case 5:
					visualizarCompra();
					break;
				case 6:
				default:
					finalizarCompra();
					break;
			}
		}
		
		// ... depois disso, o controlador assume tudo que o mercado precisa fazer.
	}
	
	public static void exibirCabecalho() {
		StringBuilder sb = new StringBuilder();
		sb.append("=====================================\n");
		sb.append("==========VENDINHA DO BUCHA==========\n");
		sb.append("=====================================\n");
		System.out.println(sb.toString());
	}
	
	public static void exibirMenuPrincipal() {
		StringBuilder sb = new StringBuilder();
		sb.append("Selecione uma opção:");
		sb.append("\n");
		sb.append("1: Listar produtos"); 
		sb.append("\n");
		sb.append("2: Detalhes do produto"); 
		sb.append("\n");
		sb.append("3: Adicionar produtos ao carrinho"); 
		sb.append("\n");
		sb.append("4: Remover produtos do carrinho");
		sb.append("\n");
		sb.append("5: Visualizar compra");
		sb.append("\n");
		sb.append("6: Finalizar compra");
		sb.append("\n");
		System.out.println(sb.toString());
	}
	
	public static void removerProdutosDoCarrinho() {
		System.out.println("Digite a chave do produto a ser removido:");
		String chave = scanner.nextLine();
		Produto produto = controlador.getCatalogo().recuperarProdutoPorChave(chave);
		if (produto != null) {
			ItemCompra itemCompra = compra.getItens().stream().filter(ic -> ic.getProduto().equals(produto)).findFirst().orElse(null);
			if (itemCompra == null) {
				System.out.println("Não há item para o produto informado na compra.");
				return;
			}
			
			System.out.println("Quantos itens deseja remover?");
			String quantidadeRemoverStr = scanner.nextLine();
			Integer quantidadeRemover = new Integer(quantidadeRemoverStr);
			
			compra.remover(produto, quantidadeRemover);
			System.out.println("Itens removidos\n\n");
			visualizarCompra();
		} else {
			System.out.println("Produto inexistente.");
			return;
		}		
	}
	
	public static void adicionarAoCarrinho() {
		System.out.println("Digite a chave do produto a ser adicionado:");
		String chave = scanner.nextLine();
		Produto produto = controlador.getCatalogo().recuperarProdutoPorChave(chave);
		if (produto != null) {			
			System.out.println("Quantos itens deseja adicionar?");
			String quantidadeAdicionarStr = scanner.nextLine();
			Integer quantidadeAdicionar = new Integer(quantidadeAdicionarStr);
			
			Integer quantidadeDisponivel = controlador.getEstoque().getProdutos().get(produto);
			if (quantidadeDisponivel < quantidadeAdicionar) {
				System.out.println("Não há produtos suficientes desse tipo em estoque.");
				return;
			}
			
			compra.adquirir(produto, quantidadeAdicionar);
			controlador.removerDeEstoque(produto, quantidadeAdicionar);
			System.out.println("Itens adicionados\n\n");
			visualizarCompra();
		} else {
			System.out.println("Produto inexistente.");
			return;
		}		
	}
	
	public static void visualizarCompra() {
		StringBuilder sb = new StringBuilder();
		sb.append("Visualizando compra:");
		sb.append("\n");
		compra.getItens().forEach(ic -> {
			sb.append(ic.getProduto().getDescricao()).append(": ").append(ic.getQuantidade()).append("\n");
		});
		sb.append("\n");
		System.out.println(sb.toString());
	}
	
	public static void finalizarCompra() {
		StringBuilder sb = new StringBuilder();
		BigDecimal total = BigDecimal.ZERO;
		total = compra.getItens().stream().map(ic -> ic.getProduto().getPreco().multiply(new BigDecimal(ic.getQuantidade()))).reduce(total, BigDecimal::add);
		sb.append("Finalizando compra. Total a pagar: " + total);
		System.out.println(sb.toString());
		System.exit(0);
	}
	
	public static void listarProdutos() {
		StringBuilder sb = new StringBuilder();
		sb.append("Listando produtos:");
		sb.append("\n");
		sb.append("\n");
		controlador.getCatalogo().getProdutos().forEach(p -> {
			detalhesDoProduto(p);
		});
		System.out.println(sb.toString());
	}
	
	public static void detalhesDoProduto(String chave) {
		detalhesDoProduto(controlador.getCatalogo().recuperarProdutoPorChave(chave));
	}
	
	public static void detalhesDoProduto(Produto p) {
		StringBuilder sb = new StringBuilder();
		sb.append("chave: ").append(p.getIdentificador());
		sb.append("\n");
		sb.append("-------------------------------------");
		sb.append("\n");
		sb.append("Descricao: ").append(p.getDescricao());
		sb.append("\n");
		sb.append("Preço: ").append(p.getPreco());
		sb.append("\n");
		sb.append("Estoque: ").append(controlador.getEstoque().getProdutos().get(p));
		sb.append("\n");
		sb.append("\n");
		System.out.println(sb.toString());
	}
	
	public static void exibirMenuCompra() {
		StringBuilder sb = new StringBuilder();
		System.out.println(sb.toString());
	}

}
