package br.ufsc.ine.bucha.vendinha;

import java.math.BigDecimal;

public abstract class Produto {
	
	public Produto() {
	}

	public Produto(String identificador, String descricao, BigDecimal preco) {
		super();
		this.identificador = identificador;
		this.descricao = descricao;
		this.preco = preco;
	}

	private String identificador;
	private String descricao;
	private BigDecimal preco;

	public String getIdentificador() {
		return identificador;
	}

	public void setIdentificador(String identificador) {
		this.identificador = identificador;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public BigDecimal getPreco() {
		return preco;
	}

	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((identificador == null) ? 0 : identificador.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null) return false;
		if (getClass() != obj.getClass()) return false;
		Produto other = (Produto) obj;
		if (identificador == null) {
			if (other.identificador != null) return false;
		} else if (!identificador.equals(other.identificador)) return false;
		return true;
	}

}
