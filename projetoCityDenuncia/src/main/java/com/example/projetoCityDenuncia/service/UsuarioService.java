package com.example.projetoCityDenuncia.service;

import com.example.projetoCityDenuncia.dto.UsuarioRequestDTO;
import com.example.projetoCityDenuncia.dto.UsuarioResponseDTO;
import com.example.projetoCityDenuncia.model.Usuario;
import com.example.projetoCityDenuncia.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public UsuarioResponseDTO salvarUsuario(UsuarioRequestDTO dto) {

        if (usuarioRepository.findByEmail(dto.getEmail()) != null) {
            throw new RuntimeException("Email já cadastrado");
        }

        Usuario usuario = new Usuario();
        usuario.setNome(dto.getNome());
        usuario.setEmail(dto.getEmail());
        usuario.setSenha(dto.getSenha());

        Usuario usuarioSalvo = usuarioRepository.save(usuario);

        UsuarioResponseDTO response = new UsuarioResponseDTO();
        response.setId(usuarioSalvo.getId());
        response.setNome(usuarioSalvo.getNome());
        response.setEmail(usuarioSalvo.getEmail());

        return response;
    }

    public Usuario buscarPorEmail(String email) {
        return usuarioRepository.findByEmail(email);
    }

    public boolean autenticar(String email, String senha) {

        Usuario usuario = usuarioRepository.findByEmail(email);

        if (usuario == null) {
            return false;
        }

        return usuario.getSenha().equals(senha);
    }
}