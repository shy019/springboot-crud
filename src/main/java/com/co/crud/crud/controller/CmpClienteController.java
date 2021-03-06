package com.co.crud.crud.controller;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.co.crud.crud.model.CmpCliente;
import com.co.crud.crud.repository.CmpClienteRepository;
import com.co.crud.crud.util.PDFGenerator;


@RestController
@RequestMapping("/api/pdf")
public class CmpClienteController {
	
    @Autowired
    CmpClienteRepository customerRepository;

    @GetMapping(value = "/clientes",
            produces = MediaType.APPLICATION_PDF_VALUE)
    public ResponseEntity<InputStreamResource> customersReport() throws IOException {
    	//List<CmpCliente> customers = (List<CmpCliente>) customerRepository.findNameDateTelMailDireccion();
        List<CmpCliente> customers = (List<CmpCliente>) customerRepository.findAll();

        ByteArrayInputStream bis = PDFGenerator.customerPDFReport(customers);

        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "inline; filename=Cliente.pdf");

        return ResponseEntity
                .ok()
                .headers(headers)
                .contentType(MediaType.APPLICATION_PDF)
                .body(new InputStreamResource(bis));
    }
}