package com.idat.examen.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.idat.examen.model.Cliente;

@RepositoryRestResource(path = "cliente")
public interface ClienteRepository extends JpaRepository<Cliente, Integer>{

}
