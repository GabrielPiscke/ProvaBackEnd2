package com.example.ProvaBack2.Repository;

import com.example.ProvaBack2.Entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    List<Usuario> findAllByNome (String nome);
    List<Usuario> findByCpf (String cpf);
}
