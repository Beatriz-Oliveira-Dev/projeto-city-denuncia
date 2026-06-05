package com.example.projetoCityDenuncia.controller;

import com.example.projetoCityDenuncia.dto.LoginRequestDTO;
import com.example.projetoCityDenuncia.dto.UsuarioRequestDTO;
import com.example.projetoCityDenuncia.dto.UsuarioResponseDTO;
import com.example.projetoCityDenuncia.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping
    public ResponseEntity<?> cadastrarUsuario(
            @RequestBody UsuarioRequestDTO dto) {

        try {
            UsuarioResponseDTO response =
                    usuarioService.salvarUsuario(dto);

            return ResponseEntity.ok(response);

        } catch (RuntimeException e) {

            return ResponseEntity.badRequest()
                    .body(e.getMessage());
        }
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginRequestDTO dto) {

        boolean autenticado = usuarioService.autenticar(
                dto.getEmail(),
                dto.getSenha()
        );

        if (autenticado) {
            return ResponseEntity.ok("Login realizado com sucesso");
        }

        return ResponseEntity.badRequest().body("Email ou senha inválidos");
    }
}