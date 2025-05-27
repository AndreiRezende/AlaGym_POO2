package com.br.ala_gym_poo2.repository;

import com.br.ala_gym_poo2.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

}
