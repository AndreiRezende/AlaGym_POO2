package com.br.ala_gym_poo2.services;

import com.br.ala_gym_poo2.model.UsuarioDetails;
import com.br.ala_gym_poo2.repository.UsuarioRepository;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UsuarioDetailsService implements org.springframework.security.core.userdetails.UserDetailsService {
    private final UsuarioRepository usuarioRepository;

    UsuarioDetailsService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public UsuarioDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return new UsuarioDetails(
                this.usuarioRepository.findByEmail(email).
                        orElseThrow(() -> new UsernameNotFoundException("User not found: " + email))
        );
    }
}
