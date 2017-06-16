package br.edu.facear.test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import br.edu.facear.crm.entity.TipoTelefone;
import br.edu.facear.facade.FacadeHappyCustomer;

public class TipoTelefoneTest {

	FacadeHappyCustomer facade = new FacadeHappyCustomer();

	// CADASTRAR
	@Test
	public void testCadastrarTipoTelefone() throws Exception {

		TipoTelefone TipoTelefone = new TipoTelefone();
		TipoTelefone.setNome("Celular");
		facade.CadastrarTipoTelefone(TipoTelefone);
		Assert.assertEquals(true, TipoTelefone.getId() != null);

	}

	// ALTERAR
	// @Test
	public void testAterarTipoTelefone() throws Exception {
		TipoTelefone TipoTelefone = facade.BuscarTipoTelefonePorId(1l);
		TipoTelefone.setNome("Resid�ncial");
		facade.AlterarTipoTelefone(TipoTelefone);
		Assert.assertEquals(true, TipoTelefone.getNome().equals("Resid�ncial"));
	}

	// EXCLUIR
	// @Test
	public void testExcluirTipoTelefone() throws Exception {
		TipoTelefone TipoTelefone = facade.BuscarTipoTelefonePorId(2l);
		facade.ExcluirTipoTelefone(TipoTelefone);
		// TipoTelefone = facade.BuscarTipoTelefonePorId(2l);
		// Assert.assertEquals(true, TipoTelefone.getTipoTelefoneID() == null);
	}

	// LISTAR
	// @Test
	public void testListarTipoTelefone() throws Exception {
		List<TipoTelefone> TipoTelefone = new ArrayList<TipoTelefone>();
		TipoTelefone = facade.ListarTipoTelefone();
		Assert.assertEquals(true, TipoTelefone.size() > 0);
		System.out.println("TIPOS DE TELEFONE(S) CADASTRADO(S)");
		for (TipoTelefone TipoTelefone2 : TipoTelefone) {
			System.out.println("Id: " + TipoTelefone2.getId() + "  Nome: " + TipoTelefone2.getNome());
		}
	}
}