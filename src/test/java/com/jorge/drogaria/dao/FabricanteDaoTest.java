package com.jorge.drogaria.dao;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import com.jorge.drogaria.domain.Fabricante;



public class FabricanteDaoTest {

	@Test
	@Ignore
		public void guardar() {
			Fabricante fabricante = new Fabricante();
			fabricante.setDescricao("Farmacia ABC");
			FabricanteDAO fabricanteDao = new FabricanteDAO();
			fabricanteDao.guardar(fabricante);
		}
	@Test
	@Ignore
	public void listar() {
		FabricanteDAO fabricanteDAO = new FabricanteDAO();
		List<Fabricante> resultado = fabricanteDAO.listar();
		System.out.println("Total de Registros Encontrados: " + resultado.size());
		for(Fabricante fabricante : resultado) {
			System.out.println(fabricante.getCodigo() + "-" + fabricante.getDescricao());
		}
	}
	@Test
	@Ignore
	public void buscar() {
		Long codigo = 1L;
		FabricanteDAO fabricanteDAO = new FabricanteDAO();
		Fabricante fabricante = fabricanteDAO.buscar(codigo);
		if(fabricante == null) {
			System.out.println("Registro nao encontrado");
		}else {
			System.out.println("Regitro Encontrado");
			System.out.println(fabricante.getCodigo() + "-" + fabricante.getDescricao());
		}
			}
	@Test
	@Ignore
	public void apagar() {
		Long codigo = 3L;
		FabricanteDAO fabricanteDAO = new FabricanteDAO();
		Fabricante fabricante = fabricanteDAO.buscar(codigo);
		if(fabricante == null) {
			System.out.println("Registro nao encontrado");
		}else {
			fabricanteDAO.apagar(fabricante);
			System.out.println("Regitro Removido");
			System.out.println(fabricante.getCodigo() + "-" + fabricante.getDescricao());
		}
	}
	@Test
	@Ignore
	public void editar() {
		Long codigo = 2L;
		FabricanteDAO fabricanteDAO = new FabricanteDAO();
		Fabricante fabricante = fabricanteDAO.buscar(codigo);
		
		if(fabricante == null) {
			System.out.println("Registro nao encontrado");
		}else {
			System.out.println("Regitro Editado - Antes");
			System.out.println(fabricante.getCodigo() + "-" + fabricante.getDescricao());
			fabricante.setDescricao("Jorge Manuel");
			fabricanteDAO.editar(fabricante);
			System.out.println("Regitro Editado - Depois ");
			System.out.println(fabricante.getCodigo() + "-" + fabricante.getDescricao());
		}
		
	}
	@Test
	
		public void merge() {
			//Fabricante fabricante = new Fabricante();
			//fabricante.setDescricao("Fabricante A");
			//FabricanteDAO fabricanteDao = new FabricanteDAO();
			//fabricanteDao.merge(fabricante);
			
		FabricanteDAO fabricanteDAO = new FabricanteDAO();
		Fabricante fabricante = fabricanteDAO.buscar(3L);
		fabricante.setDescricao("Fabricante B");
		fabricanteDAO.merge(fabricante);
		}

}
