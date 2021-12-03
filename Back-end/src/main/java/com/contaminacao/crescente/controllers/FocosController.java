package com.contaminacao.crescente.controllers;

import java.util.List;

import com.contaminacao.crescente.services.FocoService;
import com.google.gson.Gson;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@CrossOrigin
@RestController
@RequestMapping("/focos")
public class FocosController {

    @Autowired
    private FocoService service;

    @GetMapping("/longlat/{lng}/{lat}")
    public ResponseEntity<Object> validarUsuario(@PathVariable("lng") String lng, @PathVariable("lat") String lat) {
        return ResponseEntity.ok(new Gson().toJson(service.verificarLocal(lng, lat)));
    }

}