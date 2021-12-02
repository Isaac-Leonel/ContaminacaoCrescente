package com.contaminacao.crescente.services;

import java.util.ArrayList;
import java.util.List;
import com.contaminacao.crescente.repository.GrafoRioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GrafoRioService {

    @Autowired
    private GrafoRioRepository repository;

    public ArrayList<String> gerarGrafo() {

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
        ArrayList<String> teste = new ArrayList<>();
        return buscaEmProfundidadeNaoInterativa(visi, ini, vertices, G, teste);

    }

    public ArrayList<String> buscaEmProfundidadeNaoInterativa(boolean visitado[], int inicio, String vertices[],
            Integer G[][], ArrayList<String> teste) {
        visitado[inicio] = true;
        Long quantidadeRelatos = repository.buscarQuantidadeRelatos(vertices[inicio]);
        String nome;
        if (quantidadeRelatos == null) {
            nome = vertices[inicio] + " quantidade de Relatos é " + 0 + " - ";
        } else {
            nome = vertices[inicio] + " quantidade de Relatos é " + quantidadeRelatos + " - ";
        }
        teste.add(nome);
        int i;
        for (i = 0; i < G.length; i++) {
            if (G[inicio][i] == 1 && visitado[i] == false) {

                buscaEmProfundidadeNaoInterativa(visitado, i, vertices, G, teste);
            }
        }
        return teste;
    }
}