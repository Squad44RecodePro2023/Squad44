package com.example.iformal.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.iformal.model.Servicos;

public interface ServicosRepository extends JpaRepository <Servicos, Integer> {
}
