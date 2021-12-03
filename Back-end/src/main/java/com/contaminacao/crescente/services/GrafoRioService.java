package com.contaminacao.crescente.services;

import java.util.ArrayList;
import java.util.List;

import com.contaminacao.crescente.dto.GrafoDTO;
import com.contaminacao.crescente.repository.GrafoRioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GrafoRioService {

    @Autowired
    private GrafoRioRepository repository;

    public ArrayList<Object> gerarGrafo() {

        Integer quantidadeVertice = repository.ultimoId();
        Integer G[][] = new Integer[quantidadeVertice][quantidadeVertice];
        String vertices[] = new String[quantidadeVertice];
        System.out.println(quantidadeVertice);
        int cont = 0;

        List<String> nomeAresta = repository.buscarNomeAresta();
        for (String nome : nomeAresta) {
            vertices[cont] = nome;
            System.out.println(nome);
            cont++;
        }

        for (Integer i = 0; i <= quantidadeVertice; i++) {
            Integer result = repository.buscarArestas(i + 1);
            if (result == null) {
            } else {
                G[i][result - 1] = 1;
            }
        }

        for (int i = 0; i < quantidadeVertice; i++) {
            for (int j = 0; j < quantidadeVertice; j++) {
                if (G[i][j] == null) {
                    G[i][j] = 0;
                }
            }
        }
        for (int i = 0; i < quantidadeVertice; i++) {
            System.out.print((i + 1) + " ");
            for (int j = 0; j < quantidadeVertice; j++) {
                System.out.print(G[i][j] + " ");
            }
            System.out.print("\n");
        }
        boolean visi[] = new boolean[G.length];
        int ini = 39;
        ArrayList<Object> teste = new ArrayList<Object>();
        return buscaEmProfundidadeNaoInterativa(visi, ini, vertices, G, teste);
    }

    public ArrayList<Object> buscaEmProfundidadeNaoInterativa(boolean visitado[], int inicio, String vertices[],
            Integer G[][], ArrayList<Object> teste) {
        visitado[inicio] = true;
        Long quantidadeRelatos = repository.buscarQuantidadeRelatos(vertices[inicio]);
        GrafoDTO dto = new GrafoDTO();
        if (quantidadeRelatos != null) {
            dto.setPontoReferecnia(vertices[inicio]);
            dto.setQuantidadeRelato(quantidadeRelatos);
            teste.add(dto);
        } else {
        }
        int i;
        for (i = 0; i < G.length; i++) {
            if (G[inicio][i] == 1 && visitado[i] == false) {

                buscaEmProfundidadeNaoInterativa(visitado, i, vertices, G, teste);
            }
        }
        return teste;
    }
}