package com.example.projetoCityDenuncia.repository;

import com.example.projetoCityDenuncia.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    Usuario findByEmail(String email);
}
