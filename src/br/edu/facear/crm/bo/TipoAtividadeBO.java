package br.edu.facear.crm.bo;

import java.util.ArrayList;

import br.edu.facear.crm.dao.TipoAtividadeDAO;
import br.edu.facear.crm.entity.TipoAtividade;

public class TipoAtividadeBO implements InterfaceBO<TipoAtividade> {

	TipoAtividadeDAO tipoatividadeDAO = new TipoAtividadeDAO();

	// CADASTRAR
	@Override
	public void Cadastrar(TipoAtividade o) throws Exception {
		if (o.getNome() == null) {
			throw new Exception("Nome do tipo de atividade Inv�lido!");
		}
		else if (o.getNome().isEmpty()) {
			throw new Exception("Preencha o campo nome!");
		}
		tipoatividadeDAO.Cadastrar(o);
	}

	// ALTERAR
	@Override
	public void Alterar(TipoAtividade o) throws Exception {
		if (o.getNome() == null) {
			throw new Exception("Nome do tipo de atividade Inv�lido!");
		}
		else if (o.getNome().isEmpty()) {
			throw new Exception("Preencha o campo nome!");
		}
		tipoatividadeDAO.Alterar(o);
	}

	// EXCLUIR
	@Override
	public void Excluir(TipoAtividade o) throws Exception {
		if (o.getNome() == null) {
			throw new Exception("Tipo de Atividade Selecionada � Inv�lida!");
		}
		tipoatividadeDAO.Excluir(o);
	}

	// LISTAR
	@Override
	public ArrayList<TipoAtividade> Listar() throws Exception {
		ArrayList<TipoAtividade> tipoatividade = tipoatividadeDAO.Listar();
		if (tipoatividade == null) {
			throw new Exception("Nenhuma Tipo de Atividade Cadastrada!");
		}
		return tipoatividade;
	}

	// BUSCAR ID
	@Override
	public TipoAtividade BuscarID(Long id) throws Exception {
		if (id == null) {
			throw new Exception("Tipo de Atividade Pesquisado � Inv�lido!");
		} else if (id <= 0) {
			throw new Exception("Tipo de Atividade Pesquisado � Inv�lido!");
		}
		return tipoatividadeDAO.BuscarID(id);
	}
}