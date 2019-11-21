package com.jorge.drogaria.service;

import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import com.google.gson.Gson;
import com.jorge.drogaria.dao.FabricanteDAO;
import com.jorge.drogaria.domain.Fabricante;

//http://127.0.0.1:8080/Drogaria/rest/fabricante
@Path("fabricante")
public class FabricanteService {
	@GET
	public String listar() {
		FabricanteDAO fabricanteDAO = new FabricanteDAO();
		List<Fabricante> fabricantes = fabricanteDAO.listar("descricao");
	
		Gson gson = new Gson();
		String json = gson.toJson(fabricantes);
		
	return json;
	}
	
	//http://127.0.0.1:8080/Drogaria/rest/fabricante/{codigo}
	//http://127.0.0.1:8080/Drogaria/rest/fabricante/1
	@GET
	@Path("{codigo}")
	public String buscar(@PathParam("codigo") Long codigo) {
		FabricanteDAO fabricanteDAO = new FabricanteDAO();
		Fabricante fabricante = fabricanteDAO.buscar(codigo);
	
		Gson gson = new Gson();
		String json = gson.toJson(fabricante);
		
	return json;
	}
	//http://127.0.0.1:8080/Drogaria/rest/fabricante
	@POST
	public String guardar(String json){
		Gson gson = new Gson();
		Fabricante fabricante = gson.fromJson(json, Fabricante.class);
		FabricanteDAO fabricanteDAO = new FabricanteDAO();
		fabricanteDAO.guardar(fabricante);
		
		String jsonSaida = gson.toJson(fabricante);
		return jsonSaida;
	}
	
	@PUT
	public String editar(String json) {
		Gson gson = new Gson();
		Fabricante fabricante = gson.fromJson(json, Fabricante.class);
		FabricanteDAO fabricanteDAO = new FabricanteDAO();
		fabricanteDAO.editar(fabricante);
		
		String jsonSaida = gson.toJson(fabricante);
		return jsonSaida;
		
	}
	
	@DELETE
	public String apagar(String json) {
		Gson gson = new Gson();
		Fabricante fabricante = gson.fromJson(json, Fabricante.class);
		FabricanteDAO fabricanteDAO = new FabricanteDAO();
		fabricante = fabricanteDAO.buscar(fabricante.getCodigo());
		fabricanteDAO.apagar(fabricante);
		
		String saida = gson.toJson(fabricante);
		return saida;
		
	}


}
