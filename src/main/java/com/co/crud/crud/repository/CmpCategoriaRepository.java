package com.co.crud.crud.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.co.crud.crud.model.CmpCategoria;

public interface CmpCategoriaRepository extends JpaRepository<CmpCategoria, Long> {
	List<CmpCategoria> findByDescripcion(String description);

	CmpCategoria save(String description);
}