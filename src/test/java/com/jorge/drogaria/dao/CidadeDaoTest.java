package com.jorge.drogaria.dao;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import com.jorge.drogaria.domain.Cidade;
import com.jorge.drogaria.domain.Estado;

public class CidadeDaoTest {
	@Test
	@Ignore
	public void guardar() {
		EstadoDAO estadoDAO = new EstadoDAO();
		Estado estado = estadoDAO.buscar(2L);
		Cidade cidade = new Cidade();
		cidade.setNome("Rio de Janeiro");
		cidade.setEstado(estado);

		CidadeDAO cidadeDAO = new CidadeDAO();
		cidadeDAO.guardar(cidade);
	}

	@Test
	@Ignore
	public void listar() {
		CidadeDAO cidadeDAO = new CidadeDAO();
		List<Cidade> resultado = cidadeDAO.listar();
		for (Cidade cidade : resultado) {
			System.out.println("Codigo da Cidade: " + cidade.getCodigo());
			System.out.println("Nome da Cidade: " + cidade.getNome());
			System.out.println("Nome  do Estado: " + cidade.getEstado().getCodigo());
			System.out.println("Nome  do Estado: " + cidade.getEstado().getSigla());
			System.out.println("Nome  do Estado: " + cidade.getEstado().getNome());
			System.out.println();
		}
	}

	@Test
	@Ignore
	public void buscar() {
		Long codigo = 2L;
		CidadeDAO cidadeDAO = new CidadeDAO();
		Cidade cidade = cidadeDAO.buscar(codigo);
		if (cidade == null) {
			System.out.println("Registro da Cidade nao entrontrado !");
		} else {

			System.out.println("Codigo da Cidade: " + cidade.getCodigo());
			System.out.println("Nome da Cidade: " + cidade.getNome());
			System.out.println("Nome  do Estado: " + cidade.getEstado().getCodigo());
			System.out.println("Nome  do Estado: " + cidade.getEstado().getSigla());
			System.out.println("Nome  do Estado: " + cidade.getEstado().getNome());
		}

	}

	@Test
	@Ignore
	public void apagar() {
		Long codigo = 4L;
		CidadeDAO cidadeDAO = new CidadeDAO();
		Cidade cidade = cidadeDAO.buscar(codigo);
		if (cidade == null) {
			System.out.println("Registro nao encotrado");
		} else {
			cidadeDAO.apagar(cidade);
			System.out.println("Codigo da Cidade: " + cidade.getCodigo());
			System.out.println("Nome da Cidade: " + cidade.getNome());
			System.out.println("Nome  do Estado: " + cidade.getEstado().getCodigo());
			System.out.println("Nome  do Estado: " + cidade.getEstado().getSigla());
			System.out.println("Nome  do Estado: " + cidade.getEstado().getNome());
		}

	}
	
	@Test
	@Ignore
	public void editar() {
		Long codigo = 2L;
		EstadoDAO estadoDAO = new EstadoDAO();
		Estado estado = estadoDAO.buscar(2L);
		CidadeDAO cidadeDAO = new CidadeDAO();
		Cidade cidade = cidadeDAO.buscar(codigo);
		if (cidade == null) {
			System.out.println("Registro nao encotrado");
		} else {
			System.out.println("Registro Antes de Ser Editado");
			System.out.println("Codigo da Cidade: " + cidade.getCodigo());
			System.out.println("Nome da Cidade: " + cidade.getNome());
			System.out.println("Nome  do Estado: " + cidade.getEstado().getCodigo());
			System.out.println("Nome  do Estado: " + cidade.getEstado().getSigla());
			System.out.println("Nome  do Estado: " + cidade.getEstado().getNome());
			cidade.setNome("Rio de Janeiro");
			cidade.setEstado(estado);
			cidadeDAO.editar(cidade);
			System.out.println("Registro Depois de Editado");
			System.out.println("Codigo da Cidade: " + cidade.getCodigo());
			System.out.println("Nome da Cidade: " + cidade.getNome());
			System.out.println("Nome  do Estado: " + cidade.getEstado().getCodigo());
			System.out.println("Nome  do Estado: " + cidade.getEstado().getSigla());
			System.out.println("Nome  do Estado: " + cidade.getEstado().getNome());
		}

	}
	
	@Test
	public void buscarPorEstado() {
		Long estadoCodigo = 1L;
		
		CidadeDAO cidadeDAO = new CidadeDAO();
		List<Cidade> resultado = cidadeDAO.buscarPorEstado(estadoCodigo);
		for (Cidade cidade : resultado) {
			System.out.println("Codigo da Cidade: " + cidade.getCodigo());
			System.out.println("Nome da Cidade: " + cidade.getNome());
			System.out.println("Nome  do Estado: " + cidade.getEstado().getCodigo());
			System.out.println("Nome  do Estado: " + cidade.getEstado().getSigla());
			System.out.println("Nome  do Estado: " + cidade.getEstado().getNome());
			System.out.println();
		}
	}

}
