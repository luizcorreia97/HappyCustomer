package br.edu.facear.crm.bo;

import java.util.ArrayList;

import br.edu.facear.crm.dao.CidadeDAO;
import br.edu.facear.crm.entity.Cidade;

public class CidadeBO implements InterfaceBO<Cidade> {

	CidadeDAO cidadeDAO = new CidadeDAO();

	// CADASTRAR
	@Override
	public void Cadastrar(Cidade cidade) throws Exception {
		if (cidade.getNome() == null) {
			throw new Exception("Nome da Cidade � Invalido!");
		} else if (cidade.getEstado() == null) {
			throw new Exception("Selecione um estado!");
		}
		cidadeDAO.Cadastrar(cidade);
	}

	// ALTERAR
	@Override
	public void Alterar(Cidade cidade) throws Exception {
		if (cidade.getNome() == null) {
			throw new Exception("Nome da Cidade � Invalido!");
		} else if (cidade.getEstado() == null) {
			throw new Exception("Nome Estado � Invalido!");
		}
		cidadeDAO.Alterar(cidade);
	}

	// EXCLUIR
	@Override
	public void Excluir(Cidade cidade) throws Exception {
		if (cidade.getNome() == null) {
			throw new Exception("Cidade selecionada � inv�lida!");
		}
		cidadeDAO.Excluir(cidade);
	}

	// LISTAR
	@Override
	public ArrayList<Cidade> Listar() throws Exception {
		ArrayList<Cidade> cidades = cidadeDAO.Listar();
		if (cidades == null) {
			throw new Exception("Nenhuma cidade cadastrada!");
		}
		return cidades;
	}

	// BUSCAR ID
	@Override
	public Cidade BuscarID(Long id) throws Exception {
		if (id == null) {
			throw new Exception("Cidade Pesquisada � Inv�lida!");
		} else if (id <= 0) {
			throw new Exception("Cidade Pesquisada � Inv�lida!");
		}
		return cidadeDAO.BuscarID(id);
	}
}