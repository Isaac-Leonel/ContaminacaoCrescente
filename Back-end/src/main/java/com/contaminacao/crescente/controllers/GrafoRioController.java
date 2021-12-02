package com.contaminacao.crescente.controllers;

import java.util.ArrayList;

import com.contaminacao.crescente.services.GrafoRioService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/grafo")
public class GrafoRioController {
    
    @Autowired
    private GrafoRioService service; 

    @GetMapping(value = "gerar")
    public ArrayList<String> grafo(){
      return  service.gerarGrafo();
    }
}
