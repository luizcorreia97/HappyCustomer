package br.edu.facear.resource;

import java.util.ArrayList;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.edu.facear.crm.entity.Estado;
import br.edu.facear.facade.FacadeHappyCustomer;

@Path("/restEstado")
public class EstadoRestful {

	@GET
	@Path("/listarTodos")
	@Produces({ MediaType.APPLICATION_JSON })
	public ArrayList<Estado> findAll() throws Exception {

		return (ArrayList<Estado>) new FacadeHappyCustomer().ListarEstado();
	}

	@POST
	@Consumes({ MediaType.APPLICATION_FORM_URLENCODED, MediaType.APPLICATION_JSON })
	@Produces("text/plain")
	@Path("/Salvar")
	public void cadastrarCliente(Estado Estado) throws Exception {
		if (Estado.getId() == null)
			new FacadeHappyCustomer().CadastrarEstado(Estado);
		else
			new FacadeHappyCustomer().AlterarEstado(Estado);
	}

	@GET
	@Path("/Editar/{id}")
	@Produces("application/json")
	public Estado editarEstado(@PathParam(value = "id") String codigo) throws Exception {
		Long id = Long.parseUnsignedLong(codigo);
		Estado e = new FacadeHappyCustomer().BuscarEstadoPorId(id);

		return e;
	}
	
	@POST
	@Path("/Excluir/{id}")
	@Produces("application/json")
	public void excluirEstado(@PathParam(value = "id") String codigo) throws Exception {
		Long id = Long.parseUnsignedLong(codigo);
		Estado e = new FacadeHappyCustomer().BuscarEstadoPorId(id);
		FacadeHappyCustomer fhc = new FacadeHappyCustomer();
		fhc.ExcluirEstado(e);
	}
}