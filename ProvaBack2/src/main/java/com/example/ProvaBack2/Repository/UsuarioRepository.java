package com.example.ProvaBack2.Repository;

import com.example.ProvaBack2.Entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    List<Usuario> findAllByNome (String nome);
}
