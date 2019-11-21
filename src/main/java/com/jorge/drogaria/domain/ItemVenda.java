package com.jorge.drogaria.domain;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@SuppressWarnings("serial")
@Entity
public class ItemVenda extends GenericDomain {
	@Column(nullable = false)
	private Short quantidade;
	@Column(nullable = false, precision = 7, scale = 2)
	private BigDecimal valorPacial;
	@OneToOne
	@JoinColumn(nullable = false)
	private Produto produto;
	@OneToOne
	@JoinColumn(nullable = false)
	private Venda venda;

	public Short getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Short quantidade) {
		this.quantidade = quantidade;
	}

	public BigDecimal getValorPacial() {
		return valorPacial;
	}

	public void setValorPacial(BigDecimal valorPacial) {
		this.valorPacial = valorPacial;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public Venda getVenda() {
		return venda;
	}

	public void setVenda(Venda venda) {
		this.venda = venda;
	}

}
