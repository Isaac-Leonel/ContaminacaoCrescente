package com.contaminacao.crescente.controllers;

import com.contaminacao.crescente.dto.PontoReferenciaDTO;
import com.contaminacao.crescente.services.FocoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/focos")
public class FocosController {

    @Autowired
    private FocoService service;

    @GetMapping("/longlat/{lng}/{lat}")
    public PontoReferenciaDTO validarUsuario(@PathVariable("lng") String lng, @PathVariable("lat") String lat) {

        return service.verificarLocal(lng, lat);
    }

}
