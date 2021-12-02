package com.contaminacao.crescente.repository;

import java.util.List;

import com.contaminacao.crescente.model.Usuario;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    @Query(value = "SELECT * FROM usuarios WHERE email =:email", nativeQuery = true)
    public List<Object[]> validarUsuario(@Param("email") String email);

    @Query(value = "SELECT `quantidade_relatos` FROM `focos` WHERE `id_vertice` =:idVertice", nativeQuery = true)
    public Long quantidadeRelatos(@Param("idVertice") Long idVertice);

    @Modifying
    @Transactional
    @Query(value = "UPDATE `focos` SET `quantidade_relatos`=:quantidade WHERE `id_vertice`=:idVertice", nativeQuery = true)
    public void atualizarRelatos(@Param("quantidade") Long quantidade, @Param("idVertice") Long idVertice);

    @Query(value = "INSERT INTO `focos`(`id_vertice`, `quantidade_relatos`) VALUES (idVertice, quantidade)", nativeQuery = true)
    public void inserirRelatos(@Param("quantidade") Long quantidade, @Param("idVertice") Long idVertice);
}
