package br.edu.facear.crm.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.annotations.ForeignKey;

@XmlRootElement
// CRIA TABELA
@Entity
@Table(name = "\"TB_TELEFONE\"")

public class Telefone {

	// CHAVE PRIMARIA
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // CRIA O ID COMO AUTO-INCREMENT
	private Long id;

	// CHAVES ESTRANGEIRAS
	@ManyToOne
	@ForeignKey(name = "fk_tipotelefone")
	private TipoTelefone tipotelefone;

	// TELEFONE_USUARIOS
	//@ManyToMany(mappedBy = "telefones_usuario")
	//private List<Usuario> usuarios;

	// TELEFONE_EMPRESAS
	//@ManyToMany(mappedBy = "telefones_empresa")
	//private List<Empresa> empresas;

	// TELEFONE_CONTATOS
	//@ManyToMany(mappedBy = "telefones_contato")
	//private List<Contato> contatos;

	// ATRIBUTOS
	private String numero;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public TipoTelefone getTipotelefone() {
		return tipotelefone;
	}

	public void setTipotelefone(TipoTelefone tipotelefone) {
		this.tipotelefone = tipotelefone;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((numero == null) ? 0 : numero.hashCode());
		result = prime * result + ((tipotelefone == null) ? 0 : tipotelefone.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Telefone other = (Telefone) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (numero == null) {
			if (other.numero != null)
				return false;
		} else if (!numero.equals(other.numero))
			return false;
		if (tipotelefone == null) {
			if (other.tipotelefone != null)
				return false;
		} else if (!tipotelefone.equals(other.tipotelefone))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Telefone [id=" + id + ", tipotelefone=" + tipotelefone + ", numero=" + numero + "]";
	}

	public Telefone(Long id, TipoTelefone tipotelefone, String numero) {
		super();
		this.id = id;
		this.tipotelefone = tipotelefone;
		this.numero = numero;
	}

	public Telefone() {
		super();
		// TODO Auto-generated constructor stub
	}

	

	// GETTERS E SETTERS
	

	// HASHCODE
	

	// EQUALS
	

	// TO STRING
	

	// CONSTRUCTOR USING FIELDS
	

	// CONSTRUCTORS FROM SUPERCLASS
	
}