package com.example.projetoCityDenuncia.service;

import com.example.projetoCityDenuncia.model.Denuncia;
import com.example.projetoCityDenuncia.repository.DenunciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DenunciaService {

    @Autowired
    private DenunciaRepository repository;

    public Denuncia salvar(Denuncia denuncia) {
        return repository.save(denuncia);
    }

    public List<Denuncia> listar() {
        return repository.findAll();
    }
}
