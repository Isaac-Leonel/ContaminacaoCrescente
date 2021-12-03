package com.contaminacao.crescente.repository;

import java.util.List;

import com.contaminacao.crescente.model.Rio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface GrafoRioRepository extends JpaRepository<Rio, Long>{
    

    @Query(value ="SELECT va.id_vertice2 FROM `rio` r INNER join vertices_arestas va on r.id = va.id_vertice1 where r.id =:v1", nativeQuery = true)
    public Integer buscarArestas(@Param("v1") int v1);

    @Query(value = "SELECT `id` FROM `rio` ORDER by `id` DESC LIMIT 1", nativeQuery = true)
    public int ultimoId();

    @Query(value = "SELECT `ponto_referencia` FROM `rio` ORDER BY `id`" , nativeQuery = true)
    public List<String> buscarNomeAresta();

    @Query(value = "SELECT SUM(f.quantidade_relatos) FROM `rio` r inner join focos f on f.id_vertice = r.id WHERE `ponto_referencia` =:pontoReferencia", nativeQuery = true)
    public Long buscarQuantidadeRelatos(@Param("pontoReferencia") String pontoReferencia);
}
