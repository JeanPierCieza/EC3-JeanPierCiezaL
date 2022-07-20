package com.idat.examen.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name = "usuario_clientes")
public class UsuarioCliente implements Serializable{
	
	
	@Id
	private UsuarioClientePK fk = new UsuarioClientePK();
	
	private Integer idCliente;

	public UsuarioClientePK getFk() {
		return fk;
	}

	public void setFk(UsuarioClientePK fk) {
		this.fk = fk;
	}
	
	

	public Integer getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(Integer idCliente) {
		this.idCliente = idCliente;
	}
}
	
	@Embeddable
	class UsuarioClientePK implements Serializable{

		
		private static final long serialVersionUID = 1L;

		@Column(name = "id_cliente", nullable = false, unique = true)
		private Integer idCliente;
		
		@Column(name = "id_usuario", nullable = false, unique = true)
		private Integer idUsuario;
		

		public Integer getIdCliente() {
			return idCliente;
		}

		public void setIdCliente(Integer idCliente) {
			this.idCliente = idCliente;
		}

		public Integer getIdUsuario() {
			return idUsuario;
		}

		public void setIdUsuario(Integer idUsuario) {
			this.idUsuario = idUsuario;
		}
	
	
}
