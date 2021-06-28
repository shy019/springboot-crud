package com.co.crud.crud.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.co.crud.crud.model.CmpCliente;

import org.springframework.data.jpa.repository.Query;

public interface CmpClienteRepository extends CrudRepository<CmpCliente, Long> {

	@Query(value = "select cli.nombre, fact.fecha, cli.telefono, cli.mail, cli.direccion from cmp_clientes as cli inner join cmp_facturas as fact on fact.codigocliente = cli.codigo", nativeQuery = true)
	public List<CmpCliente> findNameDateTelMailDireccion();
}