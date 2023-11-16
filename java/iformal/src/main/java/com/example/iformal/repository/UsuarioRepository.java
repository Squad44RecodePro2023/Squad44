package com.example.iformal.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.iformal.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
    // TODO
};
