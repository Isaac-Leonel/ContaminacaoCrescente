package com.contaminacao.crescente.repository;

import com.contaminacao.crescente.model.Focos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface FocosRepository extends JpaRepository<Focos, Long>{
    
    @Query(value = "SELECT `longitude`, `latitude`, `ponto_referencia` FROM `rio`", nativeQuery = true)
}
