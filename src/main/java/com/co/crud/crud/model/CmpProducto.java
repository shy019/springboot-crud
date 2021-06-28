package com.co.crud.crud.model;

import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "cmp_producto")
public class CmpProducto {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long codigo;

	@Column(name = "descripcion")
	private String descripcion;

	@Column(name = "precio")
	private Double precio;

	@OneToMany(mappedBy = "codigocategoria", cascade = { CascadeType.ALL })
	private List<CmpFactura> codigocategoria;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "codigoproducto")
	private List<CmpDetalleFactura> codigoproducto;

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

	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}

	public List<CmpFactura> getCodigocategoria() {
		return codigocategoria;
	}

	public void setCodigocategoria(List<CmpFactura> codigocategoria) {
		this.codigocategoria = codigocategoria;
	}

	public List<CmpDetalleFactura> getCodigoproducto() {
		return codigoproducto;
	}

	public void setCodigoproducto(List<CmpDetalleFactura> codigoproducto) {
		this.codigoproducto = codigoproducto;
	}

	public CmpProducto(long codigo, String descripcion, Double precio, List<CmpFactura> codigocategoria,
			List<CmpDetalleFactura> codigoproducto) {
		super();
		this.codigo = codigo;
		this.descripcion = descripcion;
		this.precio = precio;
		this.codigocategoria = codigocategoria;
		this.codigoproducto = codigoproducto;
	}

	public CmpProducto() {
		super();
	}
}