package com.example.projetoCityDenuncia.service;

import com.example.projetoCityDenuncia.dto.DenunciaRequestDTO;
import com.example.projetoCityDenuncia.dto.DenunciaResponseDTO;
import com.example.projetoCityDenuncia.model.Denuncia;
import com.example.projetoCityDenuncia.repository.DenunciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DenunciaService {

    @Autowired
    private DenunciaRepository repository;

    public DenunciaResponseDTO salvar(DenunciaRequestDTO dto) {

        Denuncia denuncia = new Denuncia();

        denuncia.setTitulo(dto.getTitulo());
        denuncia.setCategoria(dto.getCategoria());
        denuncia.setBairro(dto.getBairro());
        denuncia.setEndereco(dto.getEndereco());
        denuncia.setDescricao(dto.getDescricao());
        denuncia.setImagem(dto.getImagem());

        Denuncia denunciaSalva = repository.save(denuncia);

        DenunciaResponseDTO response = new DenunciaResponseDTO();

        response.setId(denunciaSalva.getId());
        response.setTitulo(denunciaSalva.getTitulo());
        response.setCategoria(denunciaSalva.getCategoria());
        response.setBairro(denunciaSalva.getBairro());
        response.setEndereco(denunciaSalva.getEndereco());
        response.setDescricao(denunciaSalva.getDescricao());
        response.setImagem(denunciaSalva.getImagem());
        response.setStatus(denunciaSalva.getStatus());
        response.setDataCriacao(denunciaSalva.getDataCriacao());

        return response;
    }

    public List<DenunciaResponseDTO> listar() {

        return repository.findAll()
                .stream()
                .map(denuncia -> {

                    DenunciaResponseDTO dto =
                            new DenunciaResponseDTO();

                    dto.setId(denuncia.getId());
                    dto.setTitulo(denuncia.getTitulo());
                    dto.setCategoria(denuncia.getCategoria());
                    dto.setBairro(denuncia.getBairro());
                    dto.setEndereco(denuncia.getEndereco());
                    dto.setDescricao(denuncia.getDescricao());
                    dto.setImagem(denuncia.getImagem());
                    dto.setStatus(denuncia.getStatus());
                    dto.setDataCriacao(denuncia.getDataCriacao());

                    return dto;
                })
                .toList();
    }
}