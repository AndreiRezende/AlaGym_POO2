package com.br.ala_gym_poo2.services;

import com.br.ala_gym_poo2.configurations.SecurityConfiguration;
import com.br.ala_gym_poo2.repository.UsuarioRepository;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    private final AuthenticationManager authenticationManager;
    private final UsuarioRepository usuarioRepository;
    private final JwtTokenService jwtTokenService;
    private final SecurityConfiguration securityConfiguration;

    UsuarioService(
            AuthenticationManager authenticationManager,
            JwtTokenService jwtTokenService,
            UsuarioRepository usuarioRepository,
            SecurityConfiguration securityConfiguration
    ) {
        this.authenticationManager = authenticationManager;
        this.usuarioRepository = usuarioRepository;
        this.jwtTokenService = jwtTokenService;
        this.securityConfiguration = securityConfiguration;
    }
}
