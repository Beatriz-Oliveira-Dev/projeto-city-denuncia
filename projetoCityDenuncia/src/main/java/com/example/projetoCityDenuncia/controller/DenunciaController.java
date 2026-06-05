package com.example.projetoCityDenuncia.controller;

import com.example.projetoCityDenuncia.dto.DenunciaRequestDTO;
import com.example.projetoCityDenuncia.dto.DenunciaResponseDTO;
import com.example.projetoCityDenuncia.service.DenunciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class DenunciaController {

    @Autowired
    private DenunciaService service;

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/denuncia")
    public String denuncia() {
        return "denuncia";
    }

    @PostMapping("/denuncias")
    @ResponseBody
    public DenunciaResponseDTO salvar(
            @RequestBody DenunciaRequestDTO dto) {

        return service.salvar(dto);
    }

    @GetMapping("/denuncias")
    @ResponseBody
    public List<DenunciaResponseDTO> listar() {
        return service.listar();
    }
}