package br.edu.facear.crm.bo;

import java.util.ArrayList;

import br.edu.facear.crm.dao.TipoContatoDAO;
import br.edu.facear.crm.entity.TipoContato;

public class TipoContatoBO implements InterfaceBO<TipoContato> {

	TipoContatoDAO tipocontatoDAO = new TipoContatoDAO();

	// CADASTRAR
	@Override
	public void Cadastrar(TipoContato o) throws Exception {
		if (o.getNome() == null) {
			throw new Exception("Nome do tipo de contato � inv�lido!");
		}
		else if (o.getNome().isEmpty()) {
			throw new Exception("Preencha o campo nome!");
		}
		tipocontatoDAO.Cadastrar(o);
	}

	// ALTERAR
	@Override
	public void Alterar(TipoContato o) throws Exception {
		if (o.getNome() == null) {
			throw new Exception("Nome do tipo de contato � inv�lido!");
		}
		else if (o.getNome().isEmpty()) {
			throw new Exception("Preencha o campo nome!");
		}
		tipocontatoDAO.Alterar(o);
	}

	// EXCLUIR
	@Override
	public void Excluir(TipoContato o) throws Exception {
		if (o.getNome() == null) {
			throw new Exception("Tipo de contato selecionado � inv�lido!");
		}
		tipocontatoDAO.Excluir(o);
	}

	// LISTAR
	@Override
	public ArrayList<TipoContato> Listar() throws Exception {
		ArrayList<TipoContato> tipocontato = tipocontatoDAO.Listar();
		if (tipocontato == null) {
			throw new Exception("Nenhum tipo de contato cadastrado!");
		}
		return tipocontato;
	}

	// BUSCAR ID
	@Override
	public TipoContato BuscarID(Long id) throws Exception {
		if (id == null) {
			throw new Exception("Tipo de contato pesquisado � inv�lido!");
		} else if (id <= 0) {
			throw new Exception("Tipo de contato pesquisado � inv�lido!");
		}
		return tipocontatoDAO.BuscarID(id);
	}
}