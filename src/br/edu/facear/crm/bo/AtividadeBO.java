package br.edu.facear.crm.bo;

import java.util.ArrayList;

import br.edu.facear.crm.dao.AtividadeDAO;
import br.edu.facear.crm.entity.Atividade;
                         //TODOS IMPLEMENTES INTERFACE BO PQ?
public class AtividadeBO implements InterfaceBO<Atividade> {

	AtividadeDAO atividadeDAO = new AtividadeDAO();

	// CADASTRAR
	@Override
	public void Cadastrar(Atividade atividade) throws Exception {
		if (atividade.getUsuarioresponsavel() == null) {
			throw new Exception("Selecione um Usu�rio");
		} else if (atividade.getEmpresa() == null) {
			throw new Exception("Selecione uma Empresa.");
		} else if (atividade.getTipoatividade() == null) {
			throw new Exception("Selecione uma Atividade.");
		} else if (atividade.getContato() == null) {
			throw new Exception("Selecione uma Contato.");
		} else if (atividade.getSituacao() == null) {
			throw new Exception("Selecione um Status.");
		} else if (atividade.getNome() == null) {
			throw new Exception("Nome da atividade Invalido.");
		} 
//		else if (atividade.getDatainicio() == null) {
//			throw new Exception("Data Inicio Invalida.");
//		} 
//		else if (atividade.getDatafim() == null) {
//			throw new Exception("Data Fim Invalida.");
//		} 
		else if (atividade.getDescricao() == null) {
			throw new Exception("Nome da Descri��o Invalida.");
		}

		atividadeDAO.Cadastrar(atividade);
	}

	// ALTERAR
	@Override
	public void Alterar(Atividade atividade) throws Exception {

		if (atividade.getUsuarioresponsavel() == null) {
			throw new Exception("Selecione um Usu�rio");
		} else if (atividade.getEmpresa() == null) {
			throw new Exception("Selecione uma Empresa.");
		} else if (atividade.getTipoatividade() == null) {
			throw new Exception("Selecione uma Atividade.");
		} else if (atividade.getContato() == null) {
			throw new Exception("Selecione uma Contato.");
		} else if (atividade.getSituacao() == null) {
			throw new Exception("Selecione um Status.");
		} else if (atividade.getNome() == null) {
			throw new Exception("Nome da atividade Invalido.");
		} 
//		else if (atividade.getDatainicio() == null) {
//			throw new Exception("Data Invalida.");
//		} 
		else if (atividade.getDescricao() == null) {
			throw new Exception("Nome da Descri��o Invalida.");
		}

		atividadeDAO.Alterar(atividade);
	}

	// EXCLUIR
	@Override
	public void Excluir(Atividade o) throws Exception {
		if (o.getNome() == null) {
			throw new Exception("Atividade Selecionada � inv�lida.");
		}
		atividadeDAO.Excluir(o);
	}

	// LISTAR
	@Override
	public ArrayList<Atividade> Listar() throws Exception {
		ArrayList<Atividade> a = atividadeDAO.Listar();
		if (a == null) {
			throw new Exception("Nenhuma Atividade cadastrada");
		}
		return a;
	}
	// LISTAR ATIVOS
	public ArrayList<Atividade> ListarAtividadesAtivas() throws Exception {
		ArrayList<Atividade> a = atividadeDAO.ListarAtividadesAtivas();
		if (a == null) {
			throw new Exception("Nenhuma Atividade cadastrada");
		}
		return a;
	}

	// BUSCAR ID
	@Override
	public Atividade BuscarID(Long id) throws Exception {
		if (id == null) {
			throw new Exception("Atividade pesquisada � inv�lida");
		} else if (id <= 0) {
			throw new Exception("Atividade pesquisado � inv�lida");
		}
		return atividadeDAO.BuscarID(id);
	}
}