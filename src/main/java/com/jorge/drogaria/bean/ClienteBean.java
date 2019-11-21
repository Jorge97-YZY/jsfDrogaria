package com.jorge.drogaria.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import org.omnifaces.util.Messages;

import com.jorge.drogaria.dao.ClienteDAO;
import com.jorge.drogaria.dao.PessoaDAO;
import com.jorge.drogaria.domain.Cliente;
import com.jorge.drogaria.domain.Pessoa;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class ClienteBean implements Serializable {
	private Cliente cliente;
	private List<Cliente> clientes;
	private List<Pessoa> pessoas;

	 public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public List<Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}

	
	public List<Pessoa> getPessoas() {
		return pessoas;
	}

	public void setPessoas(List<Pessoa> pessoas) {
		this.pessoas = pessoas;
	}

	@PostConstruct
	public void listar() {
		try {
			ClienteDAO clienteDAO = new ClienteDAO();
			clientes = clienteDAO.listar("dataCadastro");

		} catch (RuntimeException erro) {
			Messages.addFlashGlobalError("Ocorreu um erro ao tentar Listar as Pessoas");
			erro.printStackTrace();
		}

	}

	public void novo() {
		try {

			cliente = new  Cliente();
			
			PessoaDAO pessoaDAO = new PessoaDAO();
			pessoas = pessoaDAO.listar("nome");

		} catch (RuntimeException erro) {
			Messages.addFlashGlobalError("Ocorreu um erro ao tentar criar um novo Cliente");
			erro.printStackTrace();
		}


	}
	
	public void guardar() {
		try {
			ClienteDAO clienteDAO = new ClienteDAO();
			clienteDAO.merge(cliente);
			
			cliente = new Cliente();
			
			PessoaDAO pessoaDAO = new PessoaDAO();
			pessoas = pessoaDAO.listar("nome");
			
			clientes = clienteDAO.listar("dataCadastro");
			Messages.addFlashGlobalInfo("Cliente guardado com sucesso");

		} catch (RuntimeException erro) {
			Messages.addFlashGlobalError("Ocorreu um erro ao tentar criar um novo Cliente");
			erro.printStackTrace();
		}
		
	}

	public void apagar(ActionEvent evento) {
		try {
			cliente = (Cliente) evento.getComponent().getAttributes().get("clienteSelecionado");

			ClienteDAO clienteDAO = new ClienteDAO();
			clienteDAO.apagar(cliente);

			clientes = clienteDAO.listar();

			Messages.addGlobalInfo("Pessoa Removido Com Sucesso ");
		} catch (RuntimeException erro) {
			Messages.addFlashGlobalError("Ocorreu um erro ao tentar remover a Pessoa");
			erro.printStackTrace();
		}

	}

	public void editar(ActionEvent evento) {
		
		try {
			cliente =  (Cliente) evento.getComponent().getAttributes().get("clienteSelecionado");
			PessoaDAO pessoaDAO = new PessoaDAO();
			pessoas = pessoaDAO.listar("nome");

		} catch (RuntimeException erro) {
			Messages.addGlobalError("Occoreu um erro ao tentar editar");
			erro.printStackTrace();

		}

	}

}
