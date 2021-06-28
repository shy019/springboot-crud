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
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "cmp_detallefactura")
public class CmpDetalleFactura {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long codigo;

	@OneToMany(mappedBy = "codigofactura", cascade = { CascadeType.ALL })
	private List<CmpFactura> codigofactura;

	@OneToMany(mappedBy = "codigoproducto", cascade = { CascadeType.ALL })
	private List<CmpProducto> codigoproducto;

	@Column(name = "precio")
	private String precio;

	@Column(name = "cantidad")
	private String cantidad;

	public long getCodigo() {
		return codigo;
	}

	public void setCodigo(long codigo) {
		this.codigo = codigo;
	}

	public List<CmpFactura> getEmployeeContacts() {
		return codigofactura;
	}

	public void setCodigoFactura(List<CmpFactura> codigofactura) {
		this.codigofactura = codigofactura;
	}

	public String getPrecio() {
		return precio;
	}

	public void setPrecio(String precio) {
		this.precio = precio;
	}

	public String getCantidad() {
		return cantidad;
	}

	public void setCantidad(String cantidad) {
		this.cantidad = cantidad;
	}

	public List<CmpFactura> getCodigofactura() {
		return codigofactura;
	}

	public void setCodigofactura(List<CmpFactura> codigofactura) {
		this.codigofactura = codigofactura;
	}

	public List<CmpProducto> getCodigoproducto() {
		return codigoproducto;
	}

	public void setCodigoproducto(List<CmpProducto> codigoproducto) {
		this.codigoproducto = codigoproducto;
	}

	public CmpDetalleFactura(long codigo, List<CmpFactura> codigofactura, List<CmpProducto> codigoproducto,
			String precio, String cantidad) {
		super();
		this.codigo = codigo;
		this.codigofactura = codigofactura;
		this.codigoproducto = codigoproducto;
		this.precio = precio;
		this.cantidad = cantidad;
	}

	public CmpDetalleFactura() {
		super();
	}
}