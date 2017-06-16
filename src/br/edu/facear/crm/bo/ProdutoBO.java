package br.edu.facear.crm.bo;

import java.util.ArrayList;

import br.edu.facear.crm.dao.ProdutoDAO;
import br.edu.facear.crm.entity.Produto;

public class ProdutoBO implements InterfaceBO<Produto> {

	ProdutoDAO produtoDAO = new ProdutoDAO();

	// CADASTRAR
	@Override
	public void Cadastrar(Produto produto) throws Exception {
		if (produto.getNome() == null) {
			throw new Exception("Nome do produto � inv�lido!");
		} else if (produto.getPreco() == null) {
			throw new Exception("Pre�o do produto � inv�lido!");
		}
		produtoDAO.Cadastrar(produto);
	}

	// ALTERAR
	@Override
	public void Alterar(Produto produto) throws Exception {
		if (produto.getNome() == null) {
			throw new Exception("Nome do produto � inv�lido!");
		} else if (produto.getPreco() == null) {
			throw new Exception("Pre�o do produto � inv�lido!");
		}
		produtoDAO.Alterar(produto);
	}

	// EXCLUIR
	@Override
	public void Excluir(Produto produto) throws Exception {
		if (produto.getNome() == null) {
			throw new Exception("Produto selecionado � inv�lido!");
		}
		produtoDAO.Excluir(produto);
	}

	// LISTAR
	@Override
	public ArrayList<Produto> Listar() throws Exception {
		ArrayList<Produto> produtos = produtoDAO.Listar();
		if (produtos == null) {
			throw new Exception("Nenhumm produto cadastrado!");
		}
		return produtos;
	}

	// BUSCAR ID
	@Override
	public Produto BuscarID(Long id) throws Exception {
		if (id == null) {
			throw new Exception("Produto pesquisado � inv�lido!");
		} else if (id <= 0) {
			throw new Exception("Produto pesquisado � inv�lido!");
		}
		return produtoDAO.BuscarID(id);
	}
}