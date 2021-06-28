package com.co.crud.crud.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.co.crud.crud.model.CmpCategoria;
import com.co.crud.crud.repository.CmpCategoriaRepository;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api")
public class CmpCategoriaController {

	@Autowired
	CmpCategoriaRepository cmpCategoriaRepository;

	@GetMapping("/cmpCategorias")
	public ResponseEntity<List<CmpCategoria>> getAllCmpCategorias(@RequestParam(required = false) String descripcion) {
		try {
			List<CmpCategoria> cmpCategorias = new ArrayList<CmpCategoria>();
			if (descripcion == null)
				cmpCategoriaRepository.findAll().forEach(cmpCategorias::add);
			else
				cmpCategoriaRepository.findByDescripcion(descripcion).forEach(cmpCategorias::add);

			System.out.println("sd" + cmpCategorias);
			if (cmpCategorias.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(cmpCategorias, HttpStatus.OK);
		} catch (Exception e) {
			System.out.println(e);
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/cmpCategorias/{codigo}")
	public ResponseEntity<CmpCategoria> getCmpCategoriaById(@PathVariable("codigo") long codigo) {
		Optional<CmpCategoria> cmpCategoriaData = cmpCategoriaRepository.findById(codigo);

		if (cmpCategoriaData.isPresent()) {
			return new ResponseEntity<>(cmpCategoriaData.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping("/cmpCategorias")
	public ResponseEntity<CmpCategoria> createCmpCategoria(@RequestBody CmpCategoria cmpCategoria) {
		try {
			CmpCategoria _cmpCategoria = cmpCategoriaRepository.save(new CmpCategoria(cmpCategoria.getDescripcion()));
			return new ResponseEntity<>(_cmpCategoria, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/cmpCategorias/{codigo}")
	public ResponseEntity<CmpCategoria> updateCmpCategoria(@PathVariable("codigo") long codigo,
			@RequestBody CmpCategoria cmpCategoria) {
		Optional<CmpCategoria> cmpCategoriaData = cmpCategoriaRepository.findById(codigo);

		if (cmpCategoriaData.isPresent()) {
			CmpCategoria _cmpCategoria = cmpCategoriaData.get();
			_cmpCategoria.setDescripcion(cmpCategoria.getDescripcion());
			return new ResponseEntity<>(cmpCategoriaRepository.save(_cmpCategoria), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("/cmpCategorias/{codigo}")
	public ResponseEntity<CmpCategoria> deleteCmpCategoria(@PathVariable("codigo") long codigo) {
		Optional<CmpCategoria> cmpCategoriaData = cmpCategoriaRepository.findById(codigo);
		if (cmpCategoriaData.isPresent()) {
			cmpCategoriaRepository.deleteById(codigo);
			return new ResponseEntity<>(cmpCategoriaData.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("/cmpCategorias")
	public ResponseEntity<HttpStatus> deleteAllCmpCategorias() {
		try {
			cmpCategoriaRepository.deleteAll();
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}