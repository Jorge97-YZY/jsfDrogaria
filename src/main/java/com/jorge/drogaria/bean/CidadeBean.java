package com.jorge.drogaria.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import org.omnifaces.util.Messages;

import com.jorge.drogaria.dao.CidadeDAO;
import com.jorge.drogaria.dao.EstadoDAO;
import com.jorge.drogaria.domain.Cidade;
import com.jorge.drogaria.domain.Estado;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class CidadeBean implements Serializable {
	private Cidade cidade;
	private List<Cidade> cidades;
	private List<Estado> estados;

	public Cidade getCidade() {
		return cidade;
	}

	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}

	public List<Cidade> getCidades() {
		return cidades;
	}

	public void setCidades(List<Cidade> cidades) {
		this.cidades = cidades;
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
			CidadeDAO cidadeDAO = new CidadeDAO();
			cidades = cidadeDAO.listar();

		} catch (RuntimeException erro) {
			Messages.addFlashGlobalError("Ocorreu um erro ao tentar Listar as Cidades");
			erro.printStackTrace();
		}

	}

	public void novo() {
		try {

			cidade = new Cidade();
			EstadoDAO estadoDAO = new EstadoDAO();
			estados = estadoDAO.listar("nome");
		} catch (RuntimeException erro) {
			Messages.addFlashGlobalError("Ocorreu um erro ao gerar Estado");
			erro.printStackTrace();
		}
	}

	public void guardar() {
		try {
			CidadeDAO cidadeDAO = new CidadeDAO();
			cidadeDAO.merge(cidade);

			cidade = new Cidade();

			EstadoDAO estadoDAO = new EstadoDAO();
			estados = estadoDAO.listar("nome");

			cidades = cidadeDAO.listar();

			Messages.addGlobalInfo("Cidade Guardada com Sucesso");
		} catch (RuntimeException erro) {
			Messages.addFlashGlobalError("Ocorreu um erro ao Tentar Guardar uma Nova Cidade");
			erro.printStackTrace();
		}
	}

	public void apagar(ActionEvent evento) {
		try {
			cidade = (Cidade) evento.getComponent().getAttributes().get("cidadeSelecionado");

			CidadeDAO cidadeDAO = new CidadeDAO();
			cidadeDAO.apagar(cidade);

			cidades = cidadeDAO.listar();

			Messages.addGlobalInfo("Estado Removido Com Sucesso ");
		} catch (RuntimeException erro) {
			Messages.addFlashGlobalError("Ocorreu um erro ao tentar remover o estado");
			erro.printStackTrace();
		}

	}

	public void editar(ActionEvent evento) {
		try {
			cidade =  (Cidade) evento.getComponent().getAttributes().get("cidadeSelecionado");
			EstadoDAO estadoDAO = new EstadoDAO();
			estados = estadoDAO.listar("nome");

		} catch (RuntimeException erro) {
			Messages.addGlobalError("Occoreu um erro ao tentar editar");
			erro.printStackTrace();

		}

	}

}
