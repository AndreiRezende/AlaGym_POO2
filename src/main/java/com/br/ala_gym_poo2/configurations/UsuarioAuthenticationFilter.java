package com.br.ala_gym_poo2.configurations;

import com.br.ala_gym_poo2.model.Usuario;
import com.br.ala_gym_poo2.model.UsuarioDetails;
import com.br.ala_gym_poo2.repository.UsuarioRepository;
import com.br.ala_gym_poo2.services.JwtTokenService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class UsuarioAuthenticationFilter extends OncePerRequestFilter {
    private final JwtTokenService jwtTokenService;
    private final UsuarioRepository usuarioRepository;

    public UsuarioAuthenticationFilter(JwtTokenService jwtTokenService, UsuarioRepository usuarioRepository) {
        this.jwtTokenService = jwtTokenService;
        this.usuarioRepository = usuarioRepository;
    }

    private UsuarioDetails getUsuarioDetails(String email) {
        Usuario usuario = usuarioRepository.findByEmail(email).orElseThrow(() -> new RuntimeException("Usuario nao encontrado"));
        return new UsuarioDetails(usuario);
    }

    private String recoveryToken(HttpServletRequest request) {
        String token = request.getHeader("Authorization");
        if(token != null) return token.replace("Bearer ", "");
        return null;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if(!uri.contains("/usuario/login") && !uri.contains("/usuario/registro")) {
            String token = recoveryToken(request);
            if(token != null) {
                String subject = jwtTokenService.getSubjectFromToken(token);
                UsuarioDetails usuarioDetails = getUsuarioDetails(subject);

                Authentication authentication = new UsernamePasswordAuthenticationToken(
                        usuarioDetails.getUsername(),
                        null,
                        usuarioDetails.getAuthorities());

                SecurityContextHolder.getContext().setAuthentication(authentication);
            } else {
                throw new ServletException("Token invalido");
            }
        }
        filterChain.doFilter(request, response);
    }
}
