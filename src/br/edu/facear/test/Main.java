package br.edu.facear.test;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import br.edu.facear.crm.bo.AtividadeBO;
import br.edu.facear.crm.bo.CidadeBO;
import br.edu.facear.crm.bo.ContatoBO;
import br.edu.facear.crm.bo.EmpresaBO;
import br.edu.facear.crm.bo.EstadoBO;
import br.edu.facear.crm.bo.ItemBO;
import br.edu.facear.crm.bo.LigacaoBO;
import br.edu.facear.crm.bo.NegocioBO;
import br.edu.facear.crm.bo.OrigemContatoBO;
import br.edu.facear.crm.bo.ProdutoBO;
import br.edu.facear.crm.bo.TelefoneBO;
import br.edu.facear.crm.bo.TipoAtividadeBO;
import br.edu.facear.crm.bo.TipoComunicadorBO;
import br.edu.facear.crm.bo.TipoContatoBO;
import br.edu.facear.crm.bo.TipoEmpresaBO;
import br.edu.facear.crm.bo.TipoTelefoneBO;
import br.edu.facear.crm.bo.TipoUsuarioBO;
import br.edu.facear.crm.bo.UsuarioBO;
import br.edu.facear.crm.dao.EmpresaDAO;
import br.edu.facear.crm.entity.Atividade;
import br.edu.facear.crm.entity.Cidade;
import br.edu.facear.crm.entity.Comunicador;
import br.edu.facear.crm.entity.Contato;
import br.edu.facear.crm.entity.Empresa;
import br.edu.facear.crm.entity.Estado;
import br.edu.facear.crm.entity.Genero;
import br.edu.facear.crm.entity.Item;
import br.edu.facear.crm.entity.Ligacao;
import br.edu.facear.crm.entity.Negocio;
import br.edu.facear.crm.entity.OrigemContato;
import br.edu.facear.crm.entity.Produto;
import br.edu.facear.crm.entity.Situacao;
import br.edu.facear.crm.entity.Status;
import br.edu.facear.crm.entity.Telefone;
import br.edu.facear.crm.entity.TipoAtividade;
import br.edu.facear.crm.entity.TipoComunicador;
import br.edu.facear.crm.entity.TipoContato;
import br.edu.facear.crm.entity.TipoEmpresa;
import br.edu.facear.crm.entity.TipoLigacao;
import br.edu.facear.crm.entity.TipoTelefone;
import br.edu.facear.crm.entity.TipoUsuario;
import br.edu.facear.crm.entity.Usuario;
import br.edu.facear.facade.FacadeHappyCustomer;
import br.edu.facear.resource.AuthenticationService;

public class Main {
	
	public static void main(String[] args) throws Exception {
		
//		gerenciarTipoTelefone();
//		gerenciarTipoEmpresa();
//		gerenciarTelefone();
//		gerenciarProduto();
//		gerenciarEstado();
//		gerenciarCidade();
//		gerenciarOrigemContato();
//		gerenciarTipoUsuario();
//		gerenciarTipoComunicador();
//		gerenciarTipoContato();
//		gerenciarTipoAtividade();
//		gerenciarUsuario();
//		gerenciarContato();		
//		gerenciarEmpresa();
//		gerenciarNegocio();
//		gerenciarItem();
//		gerenciarAtividade();
//		gerenciarLigacao();
		
		validaUsuario();
	}

	public static void validaUsuario() throws Exception{
		
		Usuario u = new FacadeHappyCustomer().BuscarUsuarioPorId(1l);
		
		String hash = u.getLogin()+u.getSenha();
		String result = new AuthenticationService().getmd5(hash);
		
		
		Usuario u2 = new FacadeHappyCustomer().BuscarUsuarioPorId(1l);
		
		String hash2 = u2.getLogin()+u2.getSenha();
		String result2 = new AuthenticationService().getmd5(hash2);
		
		
		System.out.println("from client: "+result);
		System.out.println("from server: "+result2);
		
	}
	
	public static void gerenciarTipoTelefone() throws Exception {
		TipoTelefoneBO ttBO = new TipoTelefoneBO();
		TipoTelefone tt = new TipoTelefone();
		/* cadastro de tipo de telefone */
		tt.setNome("Teste fuking jpa");
		ttBO.Cadastrar(tt);
		// System.out.println("Busca Tipos de Telefone:");
		tt = ttBO.BuscarID(1l);
		// System.out.println(tt.getId() +" - "+tt.getNome());
		tt.setNome("Movel");
		ttBO.Alterar(tt);

		// ttBO.Excluir(tt);

		System.out.println("Tipos de Telefone:");
		List<TipoTelefone> lista_tt = ttBO.Listar();
		for (TipoTelefone current_tt : lista_tt) {
			System.out.println(current_tt.getId() + " - " + current_tt.getNome());
		}

	}

	public static void gerenciarTipoEmpresa() throws Exception {
		TipoEmpresaBO teBO = new TipoEmpresaBO();
		TipoEmpresa te = new TipoEmpresa();

		/* cadastro de tipo de empresas */
		te.setNome("Tipo Empresa  Teste Cadastrar BO2");
		teBO.Cadastrar(te);

		System.out.println("Busca Tipos de Empresa:");
		te = teBO.BuscarID(1l);
		System.out.println(te.getId() + " - " + te.getNome());
		// teBO.Excluir(te);
		// te.setNome("Tipo Empresa Teste AlterarBO");
		// teBO.Alterar(te);
		System.out.println("Tipos de Empresa:");
		List<TipoEmpresa> lista_te = teBO.Listar();
		for (TipoEmpresa current_te : lista_te) {
			System.out.println(current_te.getId() + " - " + current_te.getNome());
		}

	}

	public static void gerenciarTelefone() throws Exception {

		TelefoneBO telefoneBO = new TelefoneBO();
		Telefone telefone = new Telefone();

		TipoTelefoneBO tipotelefoneBO = new TipoTelefoneBO();
		TipoTelefone tipotelefone = new TipoTelefone();
		tipotelefone = tipotelefoneBO.BuscarID(1l);

		telefone.setTipotelefone(tipotelefone);
		telefone.setNumero("4188888888");
		telefoneBO.Cadastrar(telefone);
		// System.out.println("Busca Telefone:");
		telefone = telefoneBO.BuscarID(1l);
		// System.out.println(telefone.getId() +" - "+telefone.getNumero() + "-
		// tipotelefone:" + telefone.getTipotelefone().getNome());

		// /*Alterar telefone*/
//		telefone.setNumero("4191758834");
//		telefoneBO.Alterar(telefone);
		// telefoneBO.Excluir(telefone);

		// System.out.println("Telefone:");
		List<Telefone> lista_tf = telefoneBO.Listar();
		for (Telefone current_tf : lista_tf) {
			// System.out.println(current_tf.getId() +" -
			// "+current_tf.getNumero() + "- tipotelefone:" +
			// current_tf.getTipotelefone().getNome());

		}

	}

	public static void gerenciarProduto() throws Exception {
		ProdutoBO produtoBO = new ProdutoBO();
		Produto produto = new Produto();

		/* cadastro de produtos */
		produto.setNome("Iphone 7");
		produto.setPreco(649.99f);
		produtoBO.Cadastrar(produto);

		System.out.println("Busca Produtos:");
		produto = produtoBO.BuscarID(1l);
		System.out.println("id: " + produto.getId() + " Nome: " + produto.getNome() + " Pre�o: " + produto.getPreco());

		produto.setNome("Teste ProdutoBO Alterar2");
		produto.setPreco(1.99f);
		produtoBO.Alterar(produto);

		// produtoBO.Excluir(produto);

		// System.out.println("Produtos: ");
		List<Produto> lista_p = produtoBO.Listar();
		for (Produto current_p : lista_p) {
			System.out.println(
					"id: " + current_p.getId() + " Nome: " + current_p.getNome() + " Pre�o: " + current_p.getPreco());

		}

	}

	public static void gerenciarEstado() throws Exception {
		EstadoBO eBO = new EstadoBO();
		Estado e = new Estado();

		/* cadastro de estado */
		e.setNome("Pernambuco");
		e.setPais("Republica das Bananas");
		eBO.Cadastrar(e);

		// System.out.println("Busca Estado:");
		e = eBO.BuscarID(1l);
		System.out.println(e.getId() + " - " + e.getNome());

		e.setNome("Belo Horizonte");
		eBO.Alterar(e);

		System.out.println("Estados: ");
		List<Estado> lista_e = eBO.Listar();
		for (Estado current_e : lista_e) {
			System.out.println(current_e.getId() + " - " + current_e.getNome());
		}

		// eDAO.Excluir(e);

	}

	public static void gerenciarCidade() throws Exception {
		CidadeBO cBO = new CidadeBO();
		Cidade c = new Cidade();

		/* cadastro de estado */
		EstadoBO eBO = new EstadoBO();
		Estado e = new Estado();
		e = eBO.BuscarID(1l);

		c.setNome("S�o Jos� dos Campo");
		c.setEstado(e);
		cBO.Cadastrar(c);
		//

		System.out.println("Busca Cidade:");
		c = cBO.BuscarID(1l);
		System.out.println(c.getId() + " - " + c.getNome());

		c.setNome("S�o Jos� dos Campos");
		cBO.Alterar(c);

		System.out.println("Cidades: ");
		List<Cidade> lista_c = cBO.Listar();
		for (Cidade current_c : lista_c) {
			System.out
					.println(current_c.getId() + " - " + current_c.getNome() + " - " + current_c.getEstado().getNome());
		}

		// cBO.Excluir(c);

	}

	public static void gerenciarOrigemContato() throws Exception {
		OrigemContatoBO oBO = new OrigemContatoBO();
		OrigemContato o = new OrigemContato();

		/* cadastro de origem do contato */
		o.setNome("Instagram");
		oBO.Cadastrar(o);

		// System.out.println("Busca Origem de Contato:");
		o = oBO.BuscarID(1l);
		// System.out.println(o.getId() +" - "+o.getDescricao());

		o.setNome("Telegram");
		oBO.Alterar(o);

		// System.out.println("Estados: ");
		List<OrigemContato> lista_o = oBO.Listar();
		for (OrigemContato current_o : lista_o) {
			// System.out.println(current_o.getId() +" -
			// "+current_o.getDescricao());
		}

		// eDAO.Excluir(e);
	}

	public static void gerenciarTipoUsuario() throws Exception {

		TipoUsuarioBO tuBO = new TipoUsuarioBO();
		TipoUsuario tu = new TipoUsuario();

		/* cadastro de Tipo de contato */
		tu.setNome("Operador");
		tuBO.Cadastrar(tu);

		// System.out.println("Busca Tipo TipoUsuario:");
		tu = tuBO.BuscarID(1l);
		// System.out.println(tu.getId() +" - "+tu.getNome());

		tu.setId(1l);
		tu.setNome("Administrador");
		tuBO.Alterar(tu);

		// System.out.println("Tipo Contato: ");
		List<TipoUsuario> lista_tu = tuBO.Listar();
		for (TipoUsuario current_tu : lista_tu) {
			// System.out.println(current_tu.getId() +" -
			// "+current_tu.getNome());
		}

		// tuBO.Excluir(tu);

	}

	private static void gerenciarUsuario() throws Exception {
		UsuarioBO usBO = new UsuarioBO();
		Usuario us = new Usuario();

		TipoUsuarioBO tuBO = new TipoUsuarioBO();
		TipoUsuario tu = new TipoUsuario();
		tu = tuBO.BuscarID(1l);
		us.setTipousuario(tu);
		CidadeBO cBO = new CidadeBO();
		Cidade c = new Cidade();
		c = cBO.BuscarID(1l);
		us.setCidade(c);
		us.setBairro("Teste@colorbit.com.br");
		us.setSenha("123");
		us.setNome("Teste teste");
		us.setCpf("080.779.555.55");
		us.setGenero(Genero.Masculino);
		us.setCargo("cargo de teste");
		// date formating
		SimpleDateFormat sdf = new SimpleDateFormat("dd MM yyyy   HH:mm:ss");
		us.setDatanascimento("09/051/997");
		us.setEndereco("Rua dos zef");
		us.setNumero(126l);
		us.setCep("81170680");

		Telefone t = new Telefone();
		Telefone t2 = new Telefone();
		t = new TelefoneBO().BuscarID(1l);
		t2 = new TelefoneBO().BuscarID(2l);

		// ArrayList telefones = new ArrayList<Telefone>();
		// telefones.add(t);
		// telefones.add(t2);
		// us.setTelefones(telefones);
		usBO.Cadastrar(us);

		System.out.println("Busca Usuario:");
		us = usBO.BuscarID(1l);
		System.out.println("id: " + us.getId() + " nome: " + us.getNome() + " tipoUsuario: "
				+ us.getTipousuario().getNome() + " Estado: " + us.getCidade().getEstado().getNome() + " Cidade: "
				+ us.getCidade().getNome() + " Email: " + us.getBairro() + " Senha: " + us.getSenha() + " cpf: "
				+ us.getCpf() + " Genero: " + us.getGenero().toString() + " Cargo: " + us.getCargo()
				+ " DataNascimento " + us.getDatanascimento().toString() + " Endere�o: " + us.getEndereco()
				+ " Numero: " + us.getNumero() + " Cep: " + us.getCep());
		us = usBO.BuscarID(1l);
		us.setCpf("111.000.000.00");
		// usBO.Alterar(us);

		System.out.println("Lista de Usuarios: ");
		List<Usuario> lista_tc = usBO.Listar();
		for (Usuario current_tc : lista_tc) {
			System.out.println("id: " + current_tc.getId() + " nome: " + current_tc.getNome() + " tipoUsuario: "
					+ current_tc.getTipousuario().getNome() + " Estado: " + current_tc.getCidade().getEstado().getNome()
					+ " Cidade: " + current_tc.getCidade().getNome() + " Email: " + current_tc.getBairro() + " Senha: "
					+ current_tc.getSenha() + " cpf: " + current_tc.getCpf() + " Genero: "
					+ current_tc.getGenero().toString() + " Cargo: " + current_tc.getCargo() + " DataNascimento "
					+ current_tc.getDatanascimento().toString() + " Endere�o: " + current_tc.getEndereco() + " Numero: "
					+ current_tc.getNumero() + " Cep: " + current_tc.getCep());
		}

	}

	public static void gerenciarTipoContato() throws Exception {

		TipoContatoBO tcBO = new TipoContatoBO();
		TipoContato tc = new TipoContato();

		/* cadastro de Tipo de contato */
		tc.setNome("teste");
		tcBO.Cadastrar(tc);

		System.out.println("Busca Tipo Contato:");
		tc = tcBO.BuscarID(1l);
		System.out.println(tc.getId() + " - " + tc.getNome());
		tc.setNome("Teste Alterar");
		tcBO.Alterar(tc);

		System.out.println("Tipo Contato: ");
		List<TipoContato> lista_tc = tcBO.Listar();
		for (TipoContato current_tc : lista_tc) {
			System.out.println(current_tc.getId() + " - " + current_tc.getNome());
		}

		// tcBO.Excluir(tc);
	}

	public static void gerenciarContato() throws Exception {
		ContatoBO coBO = new ContatoBO();
		Contato co = new Contato();

		TipoContatoBO tcBO = new TipoContatoBO();
		TipoContato tc = new TipoContato();
		tc = tcBO.BuscarID(1l);
		co.setTipocontato(tc);

		TipoComunicadorBO tcoBO = new TipoComunicadorBO();
		TipoComunicador tco = new TipoComunicador();
		tco = tcoBO.BuscarID(1l);
		// co.setTipocomunicador(tco);

		OrigemContatoBO oBO = new OrigemContatoBO();
		OrigemContato o = new OrigemContato();
		o = oBO.BuscarID(2l);
		co.setOrigemcontato(o);

		UsuarioBO uBO = new UsuarioBO();
		Usuario u = new Usuario();
		u = uBO.BuscarID(1l);
		co.setUsuarioresponsavel(u);

		CidadeBO cBO = new CidadeBO();
		Cidade c = new Cidade();
		c = cBO.BuscarID(1l);
		co.setCidade(c);
		co.setNome("Chappie");
		co.setCpf("111.111.111.11");
		co.setFoto("C://localhost/fake_path");
		co.setGenero(Genero.Masculino);
		co.setCargo("iam CEO, bitch!");

		// date formating
		SimpleDateFormat sdf = new SimpleDateFormat("dd MM yyyy   HH:mm:ss");
		Calendar calendar = new GregorianCalendar(25, 11, 1993);
		co.setDatanascimento("30/09/1994");

		co.setEndereco("rua dos bobos");
		co.setNumero(0l);
		co.setCep("00000000l");
		coBO.Cadastrar(co);

		// co.setCpf("222.222.222.22");
		// coBO.Alterar(co);

		System.out.println("Busca Contato:");
		co = coBO.BuscarID(1l);
		System.out.println("id: " + co.getId() + " nome: " + co.getNome() + " usuarioResponsavel: "
				+ co.getUsuarioresponsavel().getNome() + " tipoContato: " + co.getTipocontato().getNome() + " Estado: "
				+ co.getCidade().getEstado().getNome() + " Cidade: " + co.getCidade().getNome() + " cpf: " + co.getCpf()
				+ " Genero: " + co.getGenero().toString() + " Cargo: " + co.getCargo() + " DataNascimento "
				+ co.getDatanascimento().toString() + " Endere�o: " + co.getEndereco() + " Numero: " + co.getNumero()
				+ " Cep: " + co.getCep());

		System.out.println("Cidades: ");
		List<Contato> lista_c = coBO.Listar();
		for (Contato current_co : lista_c) {
			System.out.println("id: " + current_co.getId() + " nome: " + current_co.getNome() + " usuarioResponsavel: "
					+ current_co.getUsuarioresponsavel().getNome() + " tipoContato: "
					+ current_co.getTipocontato().getNome() + " Estado: " + current_co.getCidade().getEstado().getNome()
					+ " Cidade: " + current_co.getCidade().getNome() + " cpf: " + current_co.getCpf() + " Genero: "
					+ current_co.getGenero().toString() + " Cargo: " + current_co.getCargo() + " DataNascimento "
					+ current_co.getDatanascimento().toString() + " Endere�o: " + current_co.getEndereco() + " Numero: "
					+ current_co.getNumero() + " Cep: " + co.getCep());
		}

		// cDAO.Excluir(c);

	}

	public static void gerenciarTipoComunicador() throws Exception {

		TipoComunicadorBO tcBO = new TipoComunicadorBO();
		TipoComunicador tc = new TipoComunicador();

		/* cadastro de Tipo de contato */
		tc.setNome("Telefone Fixo");
		tcBO.Cadastrar(tc);

		System.out.println("Busca TipoComunicador:");
		tc = tcBO.BuscarID(1l);
		System.out.println(tc.getId() + " - " + tc.getNome());
		tc.setNome("Teste Alterar");
		tcBO.Alterar(tc);

		System.out.println("Tipo Contato: ");
		List<TipoComunicador> lista_tc = tcBO.Listar();
		for (TipoComunicador current_tc : lista_tc) {
			System.out.println(current_tc.getId() + " - " + current_tc.getNome());
		}

		// tcBO.Excluir(tc);
	}

	public static void gerenciarTipoAtividade() throws Exception {

		TipoAtividadeBO taBO = new TipoAtividadeBO();
		TipoAtividade ta = new TipoAtividade();

		/* cadastro de Tipo de contato */
		ta.setNome("Tarefa");
		taBO.Cadastrar(ta);

		System.out.println("Busca TipoAtividade:");
		ta = taBO.BuscarID(1l);
		System.out.println(ta.getId() + " - " + ta.getNome());
		ta.setNome("Teste Alterar");
		taBO.Alterar(ta);

		System.out.println("Tipo Contato: ");
		List<TipoAtividade> lista_ta = taBO.Listar();
		for (TipoAtividade current_ta : lista_ta) {
			System.out.println(current_ta.getId() + " - " + current_ta.getNome());
		}

		// taBO.Excluir(ta);
	}

	private static void gerenciarEmpresa() throws Exception {
		// ATRIBUTOS
		Empresa Empresa = new Empresa();
		Contato Contato = new Contato();
		Usuario Usuario = new Usuario();
		TipoEmpresa TipoEmpresa = new TipoEmpresa();
		Cidade Cidade = new Cidade();
		Telefone Telefone = new Telefone();
		TipoTelefone TipoTelefone = new TipoTelefone();
		Comunicador Comunicador = new Comunicador();
		FacadeHappyCustomer facade = new FacadeHappyCustomer();
		TipoComunicador TipoComunicador = new TipoComunicador();
				Empresa.setRazaosocial("Gelopar");
				Empresa.setCnpj("75190074000160");
				Empresa.setInscricaoestadual("1352678934");
				Empresa.setEndereco("Rua Dr. Eli Volpato");
				Empresa.setNumero(250l);
				Empresa.setComplemento("Pr�ximo a Petrobr�s");
				Empresa.setCep("83707250");
				Empresa.setBairro("Chapada");
				Empresa.setSite("www.gelopar.com.br");
				Empresa.setRamo("Refrigera��o");
				// Calendar datacadastro = new GregorianCalendar(27, 10, 2016);
				Empresa.setDatacadastro("15/11/2016");
				Empresa.setStatus(Status.Ativo);

				// CIDADE
				Cidade.setId(2l);
				Empresa.setCidade(Cidade);

				// TIPO DE EMPRESA
				TipoEmpresa.setId(1l);
				Empresa.setTipoempresa(TipoEmpresa);

				// USU�RIO RESPONS�VEL PELA EMPRESA
				Usuario.setId(1l);
				Empresa.setUsuarioresponsavel(Usuario);

				// CADASTRANDO TELEFONE
				
				Telefone = new FacadeHappyCustomer().BuscarTelefonePorId(2l);

				List<Telefone> telefones_empresa = new ArrayList<Telefone>();
				telefones_empresa.add(Telefone);
				Empresa.setTelefones_empresa(telefones_empresa);

				// CADASTRANDO COMUNICADOR
				Comunicador.setNome("gelopar@gelopar.com");
				TipoComunicador.setId(1l);
				Comunicador.setTipocomunicador(TipoComunicador);
				facade.CadastrarComunicador(Comunicador);

				List<Comunicador> comunicadores_empresa = new ArrayList<Comunicador>();
				comunicadores_empresa.add(Comunicador);
				Empresa.setComunicadores_empresa(comunicadores_empresa);

				// CADASTRANDO CONTATOS

				Contato = new FacadeHappyCustomer().BuscarContatoPorId(3l); 
				List<Contato> contatos_empresa = new ArrayList<Contato>(); 
				contatos_empresa.add(Contato);
				Empresa.setContatos(contatos_empresa);
				 

				// CADASTRAR
				facade.CadastrarEmpresa(Empresa);
	}

	public static void gerenciarNegocio() throws Exception {

		NegocioBO nbo = new NegocioBO();
		Negocio n = new Negocio();

		/* cadastro de Tipo de contato */
		Empresa e = new Empresa();
		e = new EmpresaDAO().BuscarID(1l);
		n.setEmpresa(e);
		SimpleDateFormat sdf = new SimpleDateFormat("dd MM yyyy   HH:mm:ss");
		Calendar calendar = new GregorianCalendar(25, 11, 2016);
		n.setData("19/11/2016");

		nbo.Cadastrar(n);

		System.out.println("Busca Negocio:");
		n = nbo.BuscarID(1l);
		System.out
				.println(" ID: " + n.getId() + " Empresa: " + n.getEmpresa().getRazaosocial() + "Data: " + n.getData());
		calendar = new GregorianCalendar(25, 11, 2017);
		n.setData("20/11/2016");
		nbo.Alterar(n);

		System.out.println("Tipo Contato: ");
		List<Negocio> lista_ta = nbo.Listar();
		for (Negocio current_ta : lista_ta) {
			System.out.println(" ID: " + current_ta.getId() + " Empresa: " + current_ta.getEmpresa().getDatacadastro()
					+ "Data: " + current_ta.getData());

		}

		// taBO.Excluir(ta);
	}

	public static void gerenciarItem() throws Exception {

		ItemBO ibo = new ItemBO();
		Item i = new Item();

		/* cadastro de Item */
		NegocioBO nbo = new NegocioBO();
		Negocio n = nbo.BuscarID(1l);
//		i.setNegocio(n);
		Produto p = new ProdutoBO().BuscarID(1l);
		i.setProduto(p);
		i.setQuantidade(123l);

		ibo.Cadastrar(i);

		System.out.println("Busca Itens:");
		i = ibo.BuscarID(1l);
//		System.out.println(" id: " + i.getId() + " Produto:  " + i.getProduto().getNome() + " Quantidade: "
//				+ i.getQuantidade() + " Empresa: " + i.getNegocio().getEmpresa().getRazaosocial());
		i.setQuantidade(321l);
		ibo.Alterar(i);

		System.out.println("Itens: ");
		List<Item> lista_ta = ibo.Listar();
//		for (Item current_i : lista_ta) {
//			System.out.println(" id: " + current_i.getId() + " Produto:  " + current_i.getProduto().getNome()
//					+ " Quantidade: " + current_i.getQuantidade() + " Empresa: "
//					+ current_i.getNegocio().getEmpresa().getRazaosocial());
//		}

		// taBO.Excluir(ta);
	}

	public static void gerenciarAtividade() throws Exception {

		AtividadeBO abo = new AtividadeBO();
		Atividade a = new Atividade();

		Usuario u = new UsuarioBO().BuscarID(1l);
		a.setUsuarioresponsavel(u);

		Empresa e = new EmpresaBO().BuscarID(1l);
		a.setEmpresa(e);

		TipoAtividade ta = new TipoAtividadeBO().BuscarID(1l);
		a.setTipoatividade(ta);

		// TipoComunicador tc = new TipoComunicadorBO().BuscarID(1l);
		// a.setTipocomunicador(tc);

		Contato c = new ContatoBO().BuscarID(1l);
		a.setContato(c);

		a.setSituacao(Situacao.Finalizado);

		// date formating
		SimpleDateFormat sdf = new SimpleDateFormat("dd MM yyyy   HH:mm:ss");
		Calendar calendar = new GregorianCalendar(20, 9, 2016);
		a.setDatainicio("19/11/2016");
		Calendar calendarfim = new GregorianCalendar(27, 11, 2016);
		a.setDatafim("20/11/2016");
		a.setDescricao("Lorem ipsum");
		a.setNome("Cadastrar contato para empresa");

		abo.Cadastrar(a);

		a = abo.BuscarID(1l);
		a.setDescricao("Ipsum Lorem");
		abo.Alterar(a);

		System.out.println("Atividades: ");
		List<Atividade> lista_a = abo.Listar();
		for (Atividade current_a : lista_a) {
			System.out.println(" id: " + current_a.getId() + " Nome:  " + current_a.getNome() + " TipoAtividade:  "
					+ current_a.getTipoatividade() + " Usuario:  " + current_a.getUsuarioresponsavel().getNome()
					+ " Empresa: " + current_a.getEmpresa().getRazaosocial() + " TipoComunicador: "
					+ current_a.getTipoatividade().getNome() + " Contato: " + current_a.getContato().getNome()
					+ " Status: " + current_a.getSituacao() + " DataInicio: " + current_a.getDatainicio() + " DataFim: "
					+ current_a.getDatafim() + " Status: " + current_a.getDescricao());
		}

		// aBO.Excluir(a);
	}

	public static void gerenciarLigacao() throws Exception {

		LigacaoBO lbo = new LigacaoBO();
		Ligacao l = new Ligacao();

		Contato c = new ContatoBO().BuscarID(1l);
		l.setContato(c);

		Atividade a = new AtividadeBO().BuscarID(1l);
		l.setAtividade(a);

		Usuario u = new UsuarioBO().BuscarID(1l);
		l.setUsuarioresponsavel(u);

		Empresa e = new EmpresaBO().BuscarID(1l);
		l.setEmpresa(e);

		l.setDuracao("1 minuto e 20 segundos");

		// date formating
		SimpleDateFormat sdf = new SimpleDateFormat("dd MM yyyy   HH:mm:ss");
		Calendar calendar = new GregorianCalendar(20, 9, 2016);
		//l.setData(calendar.getTime());
		l.setData("19/11/2016");

		l.setTipoligacao(TipoLigacao.Efetuada);
		l.setResumo("falar sobre assuntos peculiares");

		lbo.Cadastrar(l);

		l = lbo.BuscarID(1l);
		l.setDuracao("3 minutos e 44 segundos");
		lbo.Alterar(l);

		System.out.println("Ligacoes: ");
		List<Ligacao> lista_l = lbo.Listar();
		for (Ligacao current_l : lista_l) {
			System.out.println(" id: " + current_l.getId() + " Contato:  " + current_l.getContato().getNome()
					+ " Atividade:  " + current_l.getAtividade().getNome() + " Usuario:  "
					+ current_l.getUsuarioresponsavel().getNome() + " Empresa: "
					+ current_l.getEmpresa().getRazaosocial() + " Duracao: " + current_l.getDuracao() + " Data: "
					+ current_l.getData() + " DataInicio: " + current_l.getDuracao() + " Resumo: "
					+ current_l.getResumo());
		}

		// lBO.Excluir(l);
	}

}