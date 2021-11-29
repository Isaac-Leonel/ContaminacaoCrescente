package com.contaminacao.crescente.services;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import com.contaminacao.crescente.repository.GrafoRioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GrafoRioService {

    @Autowired
    private GrafoRioRepository repository;

    public void gerarGrafo() {

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
        buscaEmProfundidadeNaoInterativa(visi, ini, vertices, G);
        // buscaEmLarguraNaoInterativa(G, vertices);
    }

    public void buscaEmProfundidadeNaoInterativa(boolean visitado[], int inicio, String vertices[], Integer G[][]) {
        visitado[inicio] = true;
        System.out.print(vertices[inicio] + " - ");
        int i;
        for (i = 0; i < G.length; i++) {
            if (G[inicio][i] == 1 && visitado[i] == false) {
                buscaEmProfundidadeNaoInterativa(visitado, i, vertices, G);
            }
        }
    }

    public void buscaEmLarguraNaoInterativa(Integer g[][], String vertices[]) {
        int i, aux = g.length, first = 0;
        Queue<Integer> Fila = new LinkedList<>();
        Fila.add(first);

        boolean visitado[] = new boolean[g.length];

        while (aux != 0) {
            first = Fila.poll();
            visitado[first] = true;

            System.out.print(vertices[first] + " - ");
            for (i = 0; i < g.length; i++) {
                // System.out.println(g[first][i]);
                if (g[first][i] != 0 && visitado[i] == false) {
                    Fila.add(i);
                }
                if (i == g.length - 1) {
                    aux--;
                }
            }
        }
    }
}
