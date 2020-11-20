package com.desafio.crud.gestores.repository;

import com.desafio.crud.gestores.model.Gestor;

import org.springframework.data.jpa.repository.JpaRepository;

public interface GestorRepository extends JpaRepository<Gestor, Integer>{

}
