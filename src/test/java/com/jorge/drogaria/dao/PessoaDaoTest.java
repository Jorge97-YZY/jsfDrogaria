package com.jorge.drogaria.dao;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import com.jorge.drogaria.domain.Cidade;
import com.jorge.drogaria.domain.Pessoa;

public class PessoaDaoTest {
	@Test
	@Ignore
	public void guardar() {
		CidadeDAO cidadeDAO = new CidadeDAO();
		Cidade cidade = cidadeDAO.buscar(2L);
		Pessoa pessoa = new Pessoa();
		pessoa.setBairro("Santo Antonio");
		pessoa.setNome("Mauro Arsenio Manuel");
		pessoa.setCelular("929195723");
		pessoa.setCidade(cidade);
		pessoa.setComplemento("ADASDA");
		pessoa.setCpe("edsa");
		pessoa.setCpf("Gfavd");
		pessoa.setEmail("Mauro1232@live.com");
		pessoa.setNumero((short) 320);
		pessoa.setRg("ADSA");
		pessoa.setRua("Machiqueira");
		pessoa.setTelefone("23423423");
		
		PessoaDAO pessoaDAO = new PessoaDAO();
		pessoaDAO.guardar(pessoa);
		
			}
	@Test
	public void listar() {
		PessoaDAO pessoaDAO = new PessoaDAO();
		List<Pessoa> resultado = pessoaDAO.listar();
		for(Pessoa pessoa : resultado ) {
			System.out.println("Codigo da Pessoa: " + pessoa.getCodigo());
			System.out.println("Bairro da Pessoa: " + pessoa.getBairro());
			System.out.println("Celular da Pessoa: " + pessoa.getCelular());
			System.out.println("Complemento da Pessoa: " + pessoa.getComplemento());
			System.out.println("CPE da Pessoa: " + pessoa.getCpe());
			System.out.println("CPF da Pessoa: " + pessoa.getCpf());
			System.out.println("Email da Pessoa: " + pessoa.getEmail());
			System.out.println("Nome da Pessoa: " + pessoa.getNome());
			System.out.println("RG da Pessoa: " + pessoa.getRg());
			System.out.println("RUA da Pessoa: " + pessoa.getRua());
			System.out.println("Telefone da Pessoa: " + pessoa.getTelefone());
			System.out.println("Numero da Pessoa: " + pessoa.getNumero());
			System.out.println("Codigo da Cidade da Pessoa: " + pessoa.getCidade().getCodigo());
			System.out.println("Nome da Cidade da Pessoa: " + pessoa.getCidade().getNome());
			System.out.println("Codigo de Estado da Pessoa: " + pessoa.getCidade().getEstado().getCodigo());
			System.out.println("Nome de Estado da Pessoa: " + pessoa.getCidade().getEstado().getNome());
			System.out.println("Sigla do Estado da Pessoa: " + pessoa.getCidade().getEstado().getSigla());
			System.out.println();
		}
	}

}
