package br.edu.facear.crm.bo;

import java.util.ArrayList;

import br.edu.facear.crm.dao.OrigemContatoDAO;
import br.edu.facear.crm.entity.OrigemContato;

public class OrigemContatoBO implements InterfaceBO<OrigemContato> {

	OrigemContatoDAO origemcontatoDAO = new OrigemContatoDAO();

	// CADASTRAR
	@Override
	public void Cadastrar(OrigemContato origemcontato) throws Exception {
		if (origemcontato.getNome() == null) {
			throw new Exception("Nome da origem de contato � inv�lido!");
		}
		origemcontatoDAO.Cadastrar(origemcontato);
	}

	// ALTERAR
	@Override
	public void Alterar(OrigemContato origemcontato) throws Exception {
		if (origemcontato.getNome() == null) {
			throw new Exception("Nome da origem de contato � inv�lido!");
		}
		origemcontatoDAO.Alterar(origemcontato);
	}

	// EXCLUIR
	@Override
	public void Excluir(OrigemContato origemcontato) throws Exception {
		if (origemcontato.getNome() == null) {
			throw new Exception("Origem de Contato Selecionada � inv�lida!");
		}
		origemcontatoDAO.Excluir(origemcontato);
	}

	// BUSCAR ID
	@Override
	public OrigemContato BuscarID(Long id) throws Exception {
		if (id == null) {
			throw new Exception("Origem de Contato Pesquisada � Inv�lida!");
		} else if (id <= 0) {
			throw new Exception("Origem de Contato Pesquisada � Inv�lida!");
		}
		return origemcontatoDAO.BuscarID(id);
	}

	// LISTAR
	@Override
	public ArrayList<OrigemContato> Listar() throws Exception {
		ArrayList<OrigemContato> listaorigemcontato = origemcontatoDAO.Listar();
		if (listaorigemcontato == null) {
			throw new Exception("Nenhuma origem de contato cadastrada");
		}
		return listaorigemcontato;
	}
}