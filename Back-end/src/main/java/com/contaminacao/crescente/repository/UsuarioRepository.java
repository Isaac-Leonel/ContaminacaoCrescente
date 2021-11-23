package com.contaminacao.crescente.repository;

import java.util.List;

import com.contaminacao.crescente.model.Usuario;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
    
    @Query(value = "SELECT * FROM usuarios WHERE email =:email", nativeQuery = true)
    public List<Object[]> validarUsuario(@Param("email") String email);
}
