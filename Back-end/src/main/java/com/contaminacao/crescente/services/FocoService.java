package com.contaminacao.crescente.services;

import com.contaminacao.crescente.model.Focos;
import com.contaminacao.crescente.repository.FocosRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FocoService {

    @Autowired
    private FocosRepository repository;

    public void salvarNovoFoco(Long idVertice) {
        Focos focos = new Focos();
        focos.setIdVertice(idVertice);
        Long quantidadeRelatos = (long) 1;
        focos.setQuantidadeRelatos(quantidadeRelatos);
        repository.save(focos);
    }

}
