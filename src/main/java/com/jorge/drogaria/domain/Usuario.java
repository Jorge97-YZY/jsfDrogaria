package com.jorge.drogaria.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Transient;

@SuppressWarnings("serial")
@Entity
public class Usuario extends GenericDomain {
	@Column(length = 32, nullable = false)
	private String senha;
	@Column(nullable = false)
	private Character tipo;
	@Column(nullable = false)
	private Boolean activo;
	@OneToOne
	@JoinColumn(nullable = false)
	private Pessoa pessoa;

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Character getTipo() {
		return tipo;
	}

	public void setTipo(Character tipo) {
		this.tipo = tipo;
	}
	
	@Transient
	public String getTipoFormatado() {
		String tipoFormatado = null;
		
		if(tipo  == 'A') {
			tipoFormatado = "Administrador";
		}else if (tipo == 'B') {
			tipoFormatado = "Balconista";
		}else if(tipo == 'G') {
			tipoFormatado = "Gerente";
		}
		
		return tipoFormatado;
	}

	public Boolean getActivo() {
		return activo;
	}
	

	public void setActivo(Boolean activo) {
		this.activo = activo;
	}
	@Transient
	public String getActivoFormatado(){
		String activoFormatado = "Não";
		
		if (activo) {
			activoFormatado = "Sim";
		}
		
		return activoFormatado;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

}
