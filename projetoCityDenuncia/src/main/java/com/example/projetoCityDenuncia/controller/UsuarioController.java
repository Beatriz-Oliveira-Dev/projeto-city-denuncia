package com.example.projetoCityDenuncia.controller;

import com.example.projetoCityDenuncia.model.Usuario;
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
    public ResponseEntity<?> cadastrarUsuario(@RequestBody Usuario usuario) {

        try {

            Usuario novoUsuario = usuarioService.salvarUsuario(usuario);

            return ResponseEntity.ok(novoUsuario);

        } catch (RuntimeException e) {

            return ResponseEntity.badRequest()
                    .body(e.getMessage());
        }
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody Usuario usuario) {

        boolean autenticado = usuarioService.autenticar(
                usuario.getEmail(),
                usuario.getSenha()
        );

        if (autenticado) {
            return ResponseEntity.ok("Login realizado com sucesso");
        }

        return ResponseEntity.badRequest().body("Email ou senha inválidos");
    }
}