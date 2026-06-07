package com.example.projetoCityDenuncia.service;

import com.example.projetoCityDenuncia.model.Complaint;
import com.example.projetoCityDenuncia.repository.ComplaintRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ComplaintService {

    @Autowired
    private ComplaintRepository repository;

    public ResponseEntity<String> save(Complaint denuncia) {
        repository.save(denuncia);

        return ResponseEntity.status(HttpStatus.OK).body("Sua denúncia foi criada com sucesso!");
    }

    public List<Complaint> list() {
        return repository.findAll();
    }
}
