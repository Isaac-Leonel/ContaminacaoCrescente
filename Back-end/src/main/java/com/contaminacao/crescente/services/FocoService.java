package com.contaminacao.crescente.services;

import java.util.List;

import com.contaminacao.crescente.dto.PontoReferenciaDTO;
import com.contaminacao.crescente.model.Focos;
import com.contaminacao.crescente.model.Rio;
import com.contaminacao.crescente.repository.FocosRepository;
import com.contaminacao.crescente.repository.GrafoRioRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FocoService {

    @Autowired
    private FocosRepository repository;

    @Autowired
    private GrafoRioRepository rioRepository;

    public void salvarNovoFoco(Long idVertice) {
        Focos focos = new Focos();
        focos.setIdVertice(idVertice);
        Long quantidadeRelatos = (long) 1;
        focos.setQuantidadeRelatos(quantidadeRelatos);
        repository.save(focos);
    }

    public PontoReferenciaDTO verificarLocal(String lng, String lat) {
        List<Rio> rio = rioRepository.findAll();
        String resposta = "";
        PontoReferenciaDTO dto = new PontoReferenciaDTO();
        double lgn1 = Double.parseDouble(lng);
        double ltd1 = Double.parseDouble(lat);
        double menor = 999999999;
        long id;

        for (Rio rio2 : rio) {
            double lgn2 = Double.parseDouble(rio2.getLatitude());
            double ltd2 = Double.parseDouble(rio2.getLongitude());
            double distancia = distance(ltd1, lgn1, ltd2, lgn2, "k");
            System.out.println("A distancia é " + distancia);
            if (distancia < menor) {
                menor = distancia;
                id = rio2.getId();
                System.out.println("A distancia é " + distancia + "com o id " + id);
                resposta = "O ponto mais perto é " + id;
                dto.setId(id);
                dto.setPontoReferencia(rio2.getPontoReferencia());
            }
        }

        return dto;
    }

    public double distance(double lat1, double lon1, double lat2, double lon2, String sr) {

        double theta = lon1 - lon2;
        double dist = Math.sin(deg2rad(lat1)) * Math.sin(deg2rad(lat2))
                + Math.cos(deg2rad(lat1)) * Math.cos(deg2rad(lat2)) * Math.cos(deg2rad(theta));
        dist = Math.acos(dist);
        dist = rad2deg(dist);
        dist = dist * 60 * 1.1515;
        if (sr.equals("K")) {
            dist = dist * 1.609344;
        } else if (sr.equals("N")) {
            dist = dist * 0.8684;
        }
        return (dist);
    }

    public double deg2rad(double deg) {
        return (deg * Math.PI / 180.0);
    }

    public double rad2deg(double rad) {
        return (rad * 180.0 / Math.PI);
    }
}
