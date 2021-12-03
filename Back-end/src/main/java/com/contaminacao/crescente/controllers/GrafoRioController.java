package com.contaminacao.crescente.controllers;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import com.contaminacao.crescente.services.GrafoRioService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping("/grafo")
public class GrafoRioController {
    
    @Autowired
    private GrafoRioService service; 

    @GetMapping(value = "/gerar")
    public ArrayList<Object> grafo(HttpServletRequest request){
      return  service.gerarGrafo();
    }
}
