package br.edu.facear.crm.bo;

import java.util.ArrayList;

import br.edu.facear.crm.dao.TipoEmpresaDAO;
import br.edu.facear.crm.entity.TipoEmpresa;

public class TipoEmpresaBO implements InterfaceBO<TipoEmpresa> {

	TipoEmpresaDAO tipoempresaDAO = new TipoEmpresaDAO();

	// CADASTRAR
	@Override
	public void Cadastrar(TipoEmpresa tipoempresa) throws Exception {
		if (tipoempresa.getNome() == null) {
			throw new Exception("Nome do tipo de empresa � inv�lido!");
		}
		else if (tipoempresa.getNome().isEmpty()) {
			throw new Exception("Preencha o campo nome!");
		}
		tipoempresaDAO.Cadastrar(tipoempresa);
	}

	// ALTERAR
	@Override
	public void Alterar(TipoEmpresa tipoempresa) throws Exception {
		if (tipoempresa.getNome() == null) {
			throw new Exception("Nome de tipo de empresa � invalida!");
		}
		else if (tipoempresa.getNome().isEmpty()) {
			throw new Exception("Preencha o campo nome!");
		}
		tipoempresaDAO.Alterar(tipoempresa);
	}

	// EXCLUIR
	@Override
	public void Excluir(TipoEmpresa tipoempresa) throws Exception {
		if (tipoempresa.getNome() == null) {
			throw new Exception("Tipo de Empresa Selecionada � inv�lida!");
		}
		tipoempresaDAO.Excluir(tipoempresa);
	}

	// LISTAR
	@Override
	public ArrayList<TipoEmpresa> Listar() throws Exception {
		ArrayList<TipoEmpresa> tipoempresa = tipoempresaDAO.Listar();
		if (tipoempresa == null) {
			throw new Exception("Nenhum tipo de empresa cadastrada!");
		}
		return tipoempresa;
	}

	// BUSCAR ID
	@Override
	public TipoEmpresa BuscarID(Long id) throws Exception {
		if (id == null) {
			throw new Exception("Tipo de Empresa pesquisada � inv�lida!");
		} else if (id <= 0) {
			throw new Exception("Tipo de Empresa pesquisada � inv�lida!");
		}
		return tipoempresaDAO.BuscarID(id);
	}
}