package com.contaminacao.crescente.controllers;

import java.util.List;

import com.contaminacao.crescente.services.FocoService;
import org.springframework.beans.factory.annotation.Autowired;
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
    public List<Object> validarUsuario(@PathVariable("lng") String lng, @PathVariable("lat") String lat) {

        return service.verificarLocal(lng, lat);
    }

}
