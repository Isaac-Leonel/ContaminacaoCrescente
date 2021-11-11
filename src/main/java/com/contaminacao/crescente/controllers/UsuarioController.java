package com.contaminacao.crescente.controllers;

import com.contaminacao.crescente.model.Usuario;
import com.contaminacao.crescente.services.UsuarioService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/usuario")
public class UsuarioController {
    
    @Autowired
    private UsuarioService service;
    
    @PostMapping("/salvar-Usuario")
    public String salvarUsuario(@RequestBody Usuario usuario){

        return service.salvarUsuario(usuario);
    }

}
