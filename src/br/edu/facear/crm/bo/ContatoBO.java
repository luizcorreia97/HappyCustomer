package br.edu.facear.crm.bo;

import java.util.ArrayList;

import br.edu.facear.crm.dao.ContatoDAO;
import br.edu.facear.crm.entity.Contato;

public class ContatoBO implements InterfaceBO<Contato> {

	ContatoDAO contatoDAO = new ContatoDAO();

	// CADASTRAR
	@Override
	public void Cadastrar(Contato contato) throws Exception {

//		if (contato.getUsuarioresponsavel() == null) {
//			throw new Exception("Selecione um Usu�rio Responsavel");
//		}
		if (contato.getTipocontato() == null) {
			throw new Exception("Selecione uma Tipo de Contato.");
		} else if (contato.getOrigemcontato() == null) {
			throw new Exception("Selecione um Origem Contato.");
		} else if (contato.getCidade() == null) {
			throw new Exception("Selecione uma Cidade.");
		} 
//		else if (contato.getTelefones_contato() == null) {
//			throw new Exception("Selecione um Telefone.");
//		} else if (contato.getComunicadores_contato() == null) {
//			throw new Exception("Selecione um Comunicador Contato.");
//		} 
//		else if (contato.getEmpresas() == null) {
//			throw new Exception("Selecione uma Empresa.");
//		}
		else if (contato.getNome() == null) {
			throw new Exception("Nome Fornecido Invalido.");
		} else if (contato.getCpf() == null) {
			throw new Exception("Cpf Fornecido Invalido.");
		} else if (contato.getDatanascimento() == null) {
			throw new Exception("Data de Nascimento Invalido.");
		} else if (contato.getEndereco() == null) {
			throw new Exception("Endereco Fornecido Invalido.");
		} else if (contato.getNumero() == null) {
			throw new Exception("Numero Fornecido Invalido.");
		} else if (contato.getComplemento() == null) {
			throw new Exception("Complemento Fornecido Invalido.");
		} else if (contato.getCep() == null) {
			throw new Exception("Cep Fornecido Invalido.");
		} else if (contato.getBairro() == null) {
			throw new Exception("Bairro Fornecido Invalido.");
		} else if (contato.getGenero() == null) {
			throw new Exception("Genero Fornecido Invalido.");
		} else if (contato.getCargo() == null) {
			throw new Exception("Cargo Fornecido Invalido.");
		} 
//		else if (contato.getFoto() == null) {
//			throw new Exception("Foto Fornecida Invalido.");
//		} 
		else if (contato.getDatacadastro() == null) {
			throw new Exception("Data de Cadastro Fornecida Invalida.");
		} else if (contato.getStatus() == null) {
			throw new Exception("Status Fornecido Invalido.");
		}

		contatoDAO.Cadastrar(contato);
	}

	// ALTERAR
	@Override
	public void Alterar(Contato contato) throws Exception {

		if (contato.getUsuarioresponsavel() == null) {
			throw new Exception("Selecione um Usu�rio Responsavel");
		} else if (contato.getTipocontato() == null) {
			throw new Exception("Selecione uma Tipo de Contato.");
		} else if (contato.getOrigemcontato() == null) {
			throw new Exception("Selecione um Origem Contato.");
		} else if (contato.getCidade() == null) {
			throw new Exception("Selecione uma Cidade.");
		} 
//		else if (contato.getTelefones_contato() == null) {
//			throw new Exception("Selecione um Telefone.");
//		} 
//		else if (contato.getComunicadores_contato() == null) {
//			throw new Exception("Selecione um Comunicador Contato.");
//		}
//		else if (contato.getEmpresas() == null) {
//			throw new Exception("Selecione uma Empresa.");
//		}
		else if (contato.getNome() == null) {
			throw new Exception("Nome Fornecido Invalido.");
		} else if (contato.getCpf() == null) {
			throw new Exception("Cpf Fornecido Invalido.");
		} else if (contato.getDatanascimento() == null) {
			throw new Exception("Data de Nascimento Invalido.");
		} else if (contato.getEndereco() == null) {
			throw new Exception("Endereco Fornecido Invalido.");
		} else if (contato.getNumero() == null) {
			throw new Exception("Numero Fornecido Invalido.");
		} else if (contato.getComplemento() == null) {
			throw new Exception("Complemento Fornecido Invalido.");
		} else if (contato.getCep() == null) {
			throw new Exception("Cep Fornecido Invalido.");
		} else if (contato.getBairro() == null) {
			throw new Exception("Bairro Fornecido Invalido.");
		} else if (contato.getGenero() == null) {
			throw new Exception("Genero Fornecido Invalido.");
		} else if (contato.getCargo() == null) {
			throw new Exception("Cargo Fornecido Invalido.");
		} 
//		else if (contato.getFoto() == null) {
//			throw new Exception("Foto Fornecida Invalido.");
//		} 
		else if (contato.getDatacadastro() == null) {
			throw new Exception("Data de Cadastro Fornecido Invalido.");
		} else if (contato.getStatus() == null) {
			throw new Exception("Status Fornecido Invalido.");
		}
		contatoDAO.Alterar(contato);
	}

	// EXCLUIR
	@Override
	public void Excluir(Contato o) throws Exception {
		if (o.getNome() == null) {
			throw new Exception("Usuario Selecionada � inv�lido.");
		}
		contatoDAO.Excluir(o);
	}

	// LISTAR
	@Override
	public ArrayList<Contato> Listar() throws Exception {
		ArrayList<Contato> c = contatoDAO.Listar();
		if (c == null) {
			throw new Exception("Nenhum contato cadastrado");
		}
		return c;
	}

	// BUSCAR ID
	@Override
	public Contato BuscarID(Long id) throws Exception {
		if (id == null) {
			throw new Exception("Contato pesquisado � Inv�lido");
		} else if (id <= 0) {
			throw new Exception("Contato Pesquisado � Inv�lido");
		}
		return contatoDAO.BuscarID(id);
	}
}