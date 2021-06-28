package com.co.crud.crud.model;

import java.sql.Date;
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
@Table(name = "cmp_facturas")
public class CmpFactura {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long codigo;

	@Column(name = "fecha")
	private Date fecha;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "codigocliente")
	private CmpCliente codigocliente;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "codigocategoria")
	private CmpProducto codigocategoria;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "codigofactura")
	private CmpDetalleFactura codigofactura;

	public long getCodigo() {
		return codigo;
	}

	public void setCodigo(long codigo) {
		this.codigo = codigo;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public CmpFactura() {
		super();
	}

	public CmpCliente getCodigocliente() {
		return codigocliente;
	}

	public void setCodigocliente(CmpCliente codigocliente) {
		this.codigocliente = codigocliente;
	}

	public CmpProducto getCodigocategoria() {
		return codigocategoria;
	}

	public void setCodigocategoria(CmpProducto codigocategoria) {
		this.codigocategoria = codigocategoria;
	}

	public CmpDetalleFactura getCodigofactura() {
		return codigofactura;
	}

	public void setCodigofactura(CmpDetalleFactura codigofactura) {
		this.codigofactura = codigofactura;
	}

	public CmpFactura(long codigo, Date fecha, CmpCliente codigocliente, CmpProducto codigocategoria,
			CmpDetalleFactura codigofactura) {
		super();
		this.codigo = codigo;
		this.fecha = fecha;
		this.codigocliente = codigocliente;
		this.codigocategoria = codigocategoria;
		this.codigofactura = codigofactura;
	}

}