package com.contaminacao.crescente.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "focos")
public class Focos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "id_vertice", nullable = false)
    private Long idVertice;

    @Column(name = "quantidade_relatos", nullable = false)
    private Long quantidadeRelatos;

    @Column(name = "causa_poluicao", nullable = false)
    private String causaPoluicao;

    public Long getIdVertice() {
        return idVertice;
    }

    public void setIdVertice(Long idVertice) {
        this.idVertice = idVertice;
    }

    public Long getQuantidadeRelatos() {
        return quantidadeRelatos;
    }

    public void setQuantidadeRelatos(Long quantidadeRelatos) {
        this.quantidadeRelatos = quantidadeRelatos;
    }

    public static long getSerialversionuid() {
        return serialVersionUID;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCausaPoluicao() {
        return causaPoluicao;
    }

    public void setCausaPoluicao(String causaPoluicao) {
        this.causaPoluicao = causaPoluicao;
    }

}
