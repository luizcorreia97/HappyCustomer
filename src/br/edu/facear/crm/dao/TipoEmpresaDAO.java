package br.edu.facear.crm.dao;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.edu.facear.crm.entity.TipoEmpresa;

public class TipoEmpresaDAO implements InterfaceDAO<TipoEmpresa> {

	// CONECTA AO BANCO
	EntityManager em = Connection.getEntityManager();

	// CADASTRAR
	@Override
	public void Cadastrar(TipoEmpresa o) throws CrmException {
		em.getTransaction().begin();
		em.persist(o);
		em.getTransaction().commit();

	}

	// ALTERAR
	@Override
	public void Alterar(TipoEmpresa o) {
		em.getTransaction().begin();
		em.merge(o);
		em.getTransaction().commit();

	}

	// EXCLUIR
	@Override
	public void Excluir(TipoEmpresa o) {
		em.getTransaction().begin();
		TipoEmpresa tipoempresa = em.merge(o);
		em.remove(tipoempresa);
		em.getTransaction().commit();
	}

	// LISTAR
	@Override
	public ArrayList<TipoEmpresa> Listar() {
		Query q = em.createQuery("from TipoEmpresa a order by id");
		return (ArrayList<TipoEmpresa>) q.getResultList();
	}

	// BUSCAR ID
	@Override
	public TipoEmpresa BuscarID(Long id) {
		return em.find(TipoEmpresa.class, id);
	}
}