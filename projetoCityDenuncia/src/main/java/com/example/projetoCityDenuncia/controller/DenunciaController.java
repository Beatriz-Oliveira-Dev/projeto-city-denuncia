package com.example.projetoCityDenuncia.controller;

import com.example.projetoCityDenuncia.model.Denuncia;
import com.example.projetoCityDenuncia.service.DenunciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/salvar")
    @ResponseBody
    public String salvar(@RequestBody Denuncia denuncia) {

        service.salvar(denuncia);

        return "Denúncia salva com sucesso!";
    }
}