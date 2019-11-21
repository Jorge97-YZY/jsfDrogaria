package com.jorge.drogaria.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@SuppressWarnings("serial")
@Entity
public class Funcionario extends GenericDomain {
	
	@Column(length = 15, nullable = false)
	private String carteiraTrabalho;
	@Temporal(TemporalType.DATE)
	private Date dataAdmicao;
	@OneToOne
	@JoinColumn(nullable = false)
	private Pessoa pessoa;
	public String getCarteiraTrabalho() {
		return carteiraTrabalho;
	}
	public void setCarteiraTrabalho(String carteiraTrabalho) {
		this.carteiraTrabalho = carteiraTrabalho;
	}
	public Date getDataAdmicao() {
		return dataAdmicao;
	}
	public void setDataAdmicao(Date dataAdmicao) {
		this.dataAdmicao = dataAdmicao;
	}
	public Pessoa getPessoa() {
		return pessoa;
	}
	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}
	
	}

