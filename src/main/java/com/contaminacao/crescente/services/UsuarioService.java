package com.contaminacao.crescente.services;

import java.util.List;

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
            return "Usuario Salvo!";
        } catch (Exception e) {
            return "Erro ao salvar!";
        }
    }

    public boolean validarUsuario(String email, String senha){
        List<Object[]> validar = repository.validarUsuario(email);
       if(validar.isEmpty()){
           return false;
       }else{
           return true;
       }
    }
}
