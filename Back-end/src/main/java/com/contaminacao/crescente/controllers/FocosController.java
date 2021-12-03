package com.contaminacao.crescente.controllers;

import java.util.List;
<<<<<<< Updated upstream

import com.contaminacao.crescente.dto.PontoReferenciaDTO;
=======
>>>>>>> Stashed changes
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
<<<<<<< Updated upstream
    public List<Object> validarUsuario(@PathVariable("lng") String lng, @PathVariable("lat") String lat) {

=======

    public List<Object> validarUsuario(@PathVariable("lng") String lng, @PathVariable("lat") String lat) {
       System.out.println(lng + " " + lat);
>>>>>>> Stashed changes
        return service.verificarLocal(lng, lat);
    }

}
