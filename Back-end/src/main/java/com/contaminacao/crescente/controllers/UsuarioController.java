package com.contaminacao.crescente.controllers;

import javax.servlet.http.HttpServletRequest;

import com.contaminacao.crescente.model.Usuario;
import com.contaminacao.crescente.services.UsuarioService;
import com.google.gson.Gson;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService service;


    @PostMapping("/salvar-usuario")
    public String salvarUsuario(@RequestBody Usuario usuario, HttpServletRequest request) {
        return service.salvarUsuario(usuario);
    }

    @GetMapping("/validar-usuario/{email}/{senha}")
    public boolean validarUsuario(@PathVariable("email") String email, @PathVariable("senha") String senha) {
        return service.validarUsuario(email, senha);
    }

    @GetMapping(value = "/informar-foco/{idVertice}/{causaPoluicao}")
    public ResponseEntity<String> informarFoco(@PathVariable("idVertice") Long idVertice, @PathVariable("causaPoluicao") String causaPoluicao) {
        return ResponseEntity.ok(new Gson().toJson(service.informarFoco(idVertice, causaPoluicao)));
        
    }

}
