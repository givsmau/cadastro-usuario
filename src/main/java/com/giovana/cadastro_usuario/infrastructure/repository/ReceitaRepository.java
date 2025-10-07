package com.giovana.cadastro_usuario.infrastructure.repository;

import com.giovana.cadastro_usuario.infrastructure.entitys.Receita;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

public interface ReceitaRepository extends JpaRepository<Receita, Integer> {

    Optional<Receita> findByTitulo(String titulo);

    @Transactional
    void deleteByTitulo(String titulo);
}
