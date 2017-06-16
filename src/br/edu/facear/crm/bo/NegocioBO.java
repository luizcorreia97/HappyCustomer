package br.edu.facear.crm.bo;

import java.util.ArrayList;

import br.edu.facear.crm.dao.NegocioDAO;
import br.edu.facear.crm.entity.Negocio;

public class NegocioBO implements InterfaceBO<Negocio> {

	NegocioDAO negocioDAO = new NegocioDAO();

	// CADASTRAR
	@Override
	public void Cadastrar(Negocio negocio) throws Exception {

//		if (negocio.getEmpresa() == null) {
//			throw new Exception("Selecione Tipo Empresa");
//		}
		if (negocio.getData() == null) {
			throw new Exception("Data Informada Inv�lida .");
		}
		negocioDAO.Cadastrar(negocio);
	}

	// ALTERAR
	@Override
	public void Alterar(Negocio negocio) throws Exception {

		if (negocio.getEmpresa() == null) {
			throw new Exception("Selecione Tipo Empresa");
		} else if (negocio.getData() == null) {
			throw new Exception("Date Informado Invalido .");
		}
		negocioDAO.Alterar(negocio);
	}

	// EXCLUIR
	@Override
	public void Excluir(Negocio o) throws Exception {
		if (o.getId() == null) {
			throw new Exception("Negocio Selecionada � inv�lido.");
		}
		negocioDAO.Excluir(o);
	}

	// LISTAR
	@Override
	public ArrayList<Negocio> Listar() throws Exception {
		ArrayList<Negocio> n = negocioDAO.Listar();
		if (n == null) {
			throw new Exception("Nenhuma negocio cadastrado");
		}
		return n;
	}

	// BUSCAR ID
	@Override
	public Negocio BuscarID(Long id) throws Exception {
		if (id == null) {
			throw new Exception("Item pesquisado � Inv�lido");
		} else if (id <= 0) {
			throw new Exception("Item Pesquisado � Inv�lido");
		}
		return negocioDAO.BuscarID(id);
	}
}