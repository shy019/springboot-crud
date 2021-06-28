package com.co.crud.crud.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.co.crud.crud.repository.CmpClienteRepository;

@Component
public class CmpClienteService {

  @Autowired
  private CmpClienteRepository repo;

  public void run() {
  }
}
