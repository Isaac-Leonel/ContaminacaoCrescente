package com.contaminacao.crescente.services;

import com.contaminacao.crescente.model.Usuario;
import com.contaminacao.crescente.repository.UsuarioRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {
    
    @Autowired
    private UsuarioRepository repository;

    public String salvarUsuario(Usuario usuario){
        try {
            repository.save(usuario);
            return "Deu certo!";
        } catch (Exception e) {
            return "Deu errado gay!";
        }
    }
}
