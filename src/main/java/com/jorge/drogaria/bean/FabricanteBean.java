package com.jorge.drogaria.bean;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;

import org.omnifaces.util.Messages;

import com.google.gson.Gson;
import com.jorge.drogaria.dao.FabricanteDAO;
import com.jorge.drogaria.domain.Fabricante;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class FabricanteBean implements Serializable {
	private Fabricante fabricante;

	private List<Fabricante> fabricantes;

	public Fabricante getFabricante() {
		return fabricante;
	}

	public void setFabricante(Fabricante fabricante) {
		this.fabricante = fabricante;
	}

	public void novo() {
		fabricante = new Fabricante();

	}

	public List<Fabricante> getFabricantes() {
		return fabricantes;
	}

	public void setFabricantes(List<Fabricante> fabricantes) {
		this.fabricantes = fabricantes;
	}

	@PostConstruct
	public void listar() {
		try {
			//FabricanteDAO fabricanteDAO = new FabricanteDAO();
			//fabricantes = fabricanteDAO.listar();
			
			Client cliente = ClientBuilder.newClient();
			WebTarget caminho = cliente.target("http://127.0.0.1:8080/Drogaria/rest/fabricante");
			String json = caminho.request().get(String.class);
		
			Gson gson = new Gson();
			Fabricante[] vetor = gson.fromJson(json, Fabricante[].class);
			
			fabricantes = Arrays.asList(vetor);  
		} catch (RuntimeException erro) {
			Messages.addGlobalError("Ocorreu um Erro ao Tentar Listar");
			erro.printStackTrace();
		}
	}

	public void guardar() {
		try {
			//FabricanteDAO fabricanteDAO = new FabricanteDAO();
			//fabricanteDAO.merge(fabricante);

			//fabricante = new Fabricante();
			//fabricantes = fabricanteDAO.listar();

			Client cliente = ClientBuilder.newClient();
			WebTarget caminho = cliente.target("http://127.0.0.1:8080/Drogaria/rest/fabricante");
			
			Gson gson = new Gson();
			String json = gson.toJson(fabricante);
			
			caminho.request().post(Entity.json(json));
			
			fabricante = new Fabricante();
			
			json = caminho.request().get(String.class);
			Fabricante[] vetor = gson.fromJson(json, Fabricante[].class);
			fabricantes = Arrays.asList(vetor);
			
			Messages.addGlobalInfo("Estado Guardado com Sucesso");

		} catch (RuntimeException erro) {
			Messages.addGlobalError("Ocorreu um Erro ao Tentar Salvar");
			erro.printStackTrace();
		}
	}
	
	public void apagar(ActionEvent evento) {
		try {
			fabricante =  (Fabricante) evento.getComponent().getAttributes().get("fabricanteSelecionado");
			
			FabricanteDAO fabricanteDAO = new FabricanteDAO();
			fabricanteDAO.apagar(fabricante);
			
			fabricantes =  fabricanteDAO.listar();
						
			Messages.addGlobalInfo("Estado Removido Com Sucesso ");
		}catch(RuntimeException erro) {
			Messages.addFlashGlobalError("Ocorreu um erro ao tentar remover o estado");
			erro.printStackTrace();
		}
		
	}
	
	public void editar(ActionEvent evento) {
		try {
			fabricante =  (Fabricante) evento.getComponent().getAttributes().get("fabricanteSelecionado");
			
			Messages.addGlobalInfo("Editado Com Sucesso");
					
		}catch(RuntimeException erro) {
			Messages.addGlobalError("Occoreu um erro ao tentar editar");
			erro.printStackTrace();
			
		}
		
	}
}


