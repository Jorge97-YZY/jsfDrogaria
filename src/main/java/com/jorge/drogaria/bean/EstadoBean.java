package com.jorge.drogaria.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import org.omnifaces.util.Messages;

import com.jorge.drogaria.dao.EstadoDAO;
import com.jorge.drogaria.domain.Estado;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class EstadoBean implements Serializable {
	private Estado estado;
	private List<Estado> estados;

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	public List<Estado> getEstados() {
		return estados;
	}

	public void setEstados(List<Estado> estados) {
		this.estados = estados;
	}
	

	@PostConstruct
	public void listar() {
		try {
			EstadoDAO estadoDAO = new EstadoDAO();
			estados = estadoDAO.listar();
		} catch (RuntimeException erro) {
			Messages.addGlobalError("Ocorreu um Erro ao Tentar Listar");
			erro.printStackTrace();
		}
	}

	public void novo() {
		estado = new Estado();
	}

	public void guardar() {
		try {
			EstadoDAO estadoDAO = new EstadoDAO();
			estadoDAO.merge(estado);

			estado = new Estado();
			estados =  estadoDAO.listar();
			
			Messages.addGlobalInfo("Estado Guardado com Sucesso");

		} catch (RuntimeException erro) {
			Messages.addGlobalError("Ocorreu um Erro ao Tentar Salvar");
			erro.printStackTrace();
		}
	}

	public void apagar(ActionEvent evento) {
		try {
			estado = (Estado) evento.getComponent().getAttributes().get("estadoSelecionado");
			
			EstadoDAO estadoDAO = new EstadoDAO();
			estadoDAO.apagar(estado);
			
			estados =  estadoDAO.listar();
			
			Messages.addGlobalInfo("Estado Removido Com Sucesso ");
		}catch(RuntimeException erro) {
			Messages.addFlashGlobalError("Ocorreu um erro ao tentar remover o estado");
			erro.printStackTrace();
		}
		
	}
	
	public void editar(ActionEvent evento) {
		try {
			estado = (Estado) evento.getComponent().getAttributes().get("estadoSelecionado");
			
			Messages.addGlobalInfo("Editado Com Sucesso");
					
		}catch(RuntimeException erro) {
			Messages.addGlobalError("Occoreu um erro ao tentar editar");
			erro.printStackTrace();
			
		}
		
	}
}
