package com.example.projetoCityDenuncia.controller;

import com.example.projetoCityDenuncia.model.Denuncia;
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
    public Denuncia salvar(@RequestBody Denuncia denuncia) {

        return service.salvar(denuncia);
    }

    @GetMapping("/denuncias")
    @ResponseBody
    public List<Denuncia> listar() {
        return service.listar();
    }
}