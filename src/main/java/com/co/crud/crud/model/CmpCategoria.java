package com.co.crud.crud.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "cmp_categorias")
public class CmpCategoria {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long codigo;

	@Column(name = "descripcion")
	private String descripcion;

	@Override
	public String toString() {
		return "CmpCategoria [codigo=" + codigo + ", descripcion=" + descripcion + "]";
	}

	public long getCodigo() {
		return codigo;
	}

	public void setCodigo(long codigo) {
		this.codigo = codigo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public CmpCategoria() {

	}

	public CmpCategoria(String descripcion) {
		this.descripcion = descripcion;
	}

	public CmpCategoria(long codigo, String descripcion) {
		super();
		this.codigo = codigo;
		this.descripcion = descripcion;
	}

}