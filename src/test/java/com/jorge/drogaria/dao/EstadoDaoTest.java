package com.jorge.drogaria.dao;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import com.jorge.drogaria.domain.Estado;

public class EstadoDaoTest {
	@Test
	@Ignore
		public void guardar() {
			Estado estado = new Estado();
			estado.setNome("Rio de Janeiro");
			estado.setSigla("RJ");
			EstadoDAO estadoDao = new EstadoDAO();
			estadoDao.guardar(estado);
		}
	@Test
	@Ignore
	public void listar() {
		EstadoDAO estadoDAO = new EstadoDAO();
		List<Estado> resultado = estadoDAO.listar();
		System.out.println("Total de Registros Encontrados: " + resultado.size());
		for(Estado estado : resultado) {
			System.out.println(estado.getCodigo() + "-" + estado.getSigla() + "-" + estado.getNome());
		}
	}
	@Test
	@Ignore
	public void buscar() {
		Long codigo = 1L;
		EstadoDAO estadoDAO = new EstadoDAO();
		Estado estado = estadoDAO.buscar(codigo);
		if(estado == null) {
			System.out.println("Registro nao encontrado");
		}else {
			System.out.println("Regitro Encontrado");
			System.out.println(estado.getCodigo() + "-" + estado.getSigla() + "-" + estado.getNome());
		}
			}
	@Test
	@Ignore
	public void apagar() {
		Long codigo = 3L;
		EstadoDAO estadoDAO = new EstadoDAO();
		Estado estado = estadoDAO.buscar(codigo);
		if(estado == null) {
			System.out.println("Registro nao encontrado");
		}else {
			estadoDAO.apagar(estado);
			System.out.println("Regitro Removido");
			System.out.println(estado.getCodigo() + "-" + estado.getSigla() + "-" + estado.getNome());
		}
	}
	@Test
	public void editar() {
		Long codigo = 4L;
		EstadoDAO estadoDAO = new EstadoDAO();
		Estado estado = estadoDAO.buscar(codigo);
		
		if(estado == null) {
			System.out.println("Registro nao encontrado");
		}else {
			System.out.println("Regitro Editado - Antes");
			System.out.println(estado.getCodigo() + "-" + estado.getSigla() + "-" + estado.getNome());
			estado.setNome("Jorge Manuel");
			estado.setSigla("JM");
			estadoDAO.editar(estado);
			System.out.println("Regitro Editado - Depois ");
			System.out.println(estado.getCodigo() + "-" + estado.getSigla() + "-" + estado.getNome());
		}
		
	}
}
