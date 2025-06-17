package com.br.ala_gym_poo2.controller;

import com.br.ala_gym_poo2.configurations.SecurityConfiguration;
import com.br.ala_gym_poo2.model.Usuario;
import com.br.ala_gym_poo2.model.UsuarioDetails;
import com.br.ala_gym_poo2.model.enums.Role;
import com.br.ala_gym_poo2.repository.UsuarioRepository;
import com.br.ala_gym_poo2.services.JwtTokenService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {
    private final UsuarioRepository usuarioRepository;
    private final SecurityConfiguration securityConfiguration;
    private final AuthenticationManager authenticationManager;
    private final JwtTokenService jwtTokenService;

    public UsuarioController(UsuarioRepository usuarioRepository, SecurityConfiguration securityConfiguration, AuthenticationManager authenticationManager, JwtTokenService jwtTokenService) {
        this.usuarioRepository = usuarioRepository;
        this.securityConfiguration = securityConfiguration;
        this.authenticationManager = authenticationManager;
        this.jwtTokenService = jwtTokenService;
    }

    @GetMapping
    public List<Usuario> getUsuario(){
        return this.usuarioRepository.findAll();
    }

    @GetMapping("/{id}")
    public Usuario getUsuario(@PathVariable Long id){
        return this.usuarioRepository.findById(id).get();
    }

    //@PreAuthorize("hasRole('FUNCIONARIO')")
    @PostMapping("/registro")
    public Usuario createUsuario(@RequestBody UsuarioDTO dto){
        Usuario usuario = new Usuario();
        usuario.setNome(dto.nome());
        usuario.setEmail(dto.email());
        usuario.setSenha(securityConfiguration.passwordEncoder().encode(dto.senha()));
        usuario.setEndereco(dto.endereco());
        usuario.setTelefone(dto.telefone());
        usuario.setPermissao(Role.valueOf(dto.permissao().toUpperCase()));
        usuario.setIdade(dto.idade());
        usuario.setSexo(dto.sexo());
        usuario.setCref(dto.cref());
        usuario.setPeso(dto.peso());
        usuario.setAltura(dto.altura());
        usuario.setStatusPagamento(dto.statusPagamento());
        usuario.setIdsTreino(dto.idsTreino());
        return this.usuarioRepository.save(usuario);
    }

    @DeleteMapping("/{id}")
    public void deleteUsuario(@PathVariable Long id){
        this.usuarioRepository.deleteById(id);
    }

    @PutMapping("/{id}")
    public Usuario updateUsuario(@PathVariable Long id, @RequestBody UsuarioDTO dto){
        Usuario usuario = this.usuarioRepository.findById(id).get();
        usuario.setNome(dto.nome());
        usuario.setEmail(dto.email());
        if (dto.senha() != null) usuario.setSenha(securityConfiguration.passwordEncoder().encode(dto.senha()));
        usuario.setEndereco(dto.endereco());
        usuario.setTelefone(dto.telefone());
        usuario.setPermissao(Role.valueOf(dto.permissao().toUpperCase()));
        usuario.setIdade(dto.idade());
        usuario.setSexo(dto.sexo());
        usuario.setCref(dto.cref());
        usuario.setPeso(dto.peso());
        usuario.setAltura(dto.altura());
        usuario.setStatusPagamento(dto.statusPagamento());
        return this.usuarioRepository.save(usuario);
    }

    @PostMapping("/login")
    public String loginUsuario(@RequestBody LoginUsuarioDTO dto){
        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(dto.email(), dto.senha());
        Authentication authentication = this.authenticationManager.authenticate(token);
        UsuarioDetails usuario = (UsuarioDetails) authentication.getPrincipal();
        return this.jwtTokenService.generateToken(usuario);
    }

    @GetMapping("/me")
    public ResponseEntity<UsuarioDTOOut> getMe(Authentication authentication) {
        String email = authentication.getName();

        Usuario usuario = usuarioRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        UsuarioDTOOut dto = new UsuarioDTOOut(
                usuario.getId(),
                usuario.getNome(),
                usuario.getEmail(),
                usuario.getPermissao().toString()
        );

        return ResponseEntity.ok(dto);
    }

}
