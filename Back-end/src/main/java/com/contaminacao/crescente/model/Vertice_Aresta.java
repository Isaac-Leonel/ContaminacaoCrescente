package com.contaminacao.crescente.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table( name= "vertices_arestas")
public class Vertice_Aresta implements Serializable{

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    
    @Column(name = "id_vertice1", nullable = false)
    private Long id_vertice1;
    @Column(name = "aresta", nullable = false)
    private boolean aresta;
    @Column(name = "id_vertice2", nullable = false)
    private Long id_vertice2;
    public Long getId_vertice1() {
        return id_vertice1;
    }
    public void setId_vertice1(Long id_vertice1) {
        this.id_vertice1 = id_vertice1;
    }
    public boolean isAresta() {
        return aresta;
    }
    public void setAresta(boolean aresta) {
        this.aresta = aresta;
    }
    public Long getId_vertice2() {
        return id_vertice2;
    }
    public void setId_vertice2(Long id_vertice2) {
        this.id_vertice2 = id_vertice2;
    } 

    
}
