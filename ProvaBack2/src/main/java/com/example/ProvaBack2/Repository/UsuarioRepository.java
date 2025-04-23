package com.example.ProvaBack2.Repository;

import com.example.ProvaBack2.Entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    List<Usuario> findAllByNome (String nome);
    Optional<Usuario> findByCpf (String cpf);
}
