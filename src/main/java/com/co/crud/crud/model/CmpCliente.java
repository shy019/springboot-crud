package com.co.crud.crud.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "cmp_clientes")
public class CmpCliente {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long codigo;

	@Column(name = "nombre")
	private String nombre;

	@Column(name = "telefono")
	private String telefono;

	@Column(name = "mail")
	private String mail;

	@Column(name = "direccion")
	private String direccion;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "codigocliente")
	private CmpFactura codigocliente;

	public long getCodigo() {
		return codigo;
	}

	public void setCodigo(long codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public CmpCliente() {
		super();
	}

	public CmpFactura getCodigocliente() {
		return codigocliente;
	}

	public void setCodigocliente(CmpFactura codigocliente) {
		this.codigocliente = codigocliente;
	}

	public CmpCliente(long codigo, String nombre, String telefono, String mail, String direccion,
			CmpFactura codigocliente) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
		this.telefono = telefono;
		this.mail = mail;
		this.direccion = direccion;
		this.codigocliente = codigocliente;
	}

}