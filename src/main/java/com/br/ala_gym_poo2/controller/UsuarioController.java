package com.br.ala_gym_poo2.controller;

import com.br.ala_gym_poo2.model.Usuario;
import com.br.ala_gym_poo2.repository.UsuarioRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {
    private final UsuarioRepository usuarioRepository;

    public UsuarioController(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @GetMapping
    public List<Usuario> getUsuario(){
        return this.usuarioRepository.findAll();
    }

    @PostMapping
    public Usuario createUsuario(@RequestBody UsuarioDTO dto){
        Usuario usuario = new Usuario();
        usuario.setNome(dto.nome());
        usuario.setEmail(dto.email());
        usuario.setSenha(dto.senha());
        usuario.setEndereco(dto.endereco());
        usuario.setTelefone(dto.telefone());
        usuario.setPermissao(dto.permissao());
        usuario.setIdade(dto.idade());
        usuario.setSexo(dto.sexo());
        usuario.setCref(dto.cref());
        usuario.setPeso(dto.peso());
        usuario.setAltura(dto.altura());
        usuario.setStatusPagamento(dto.statusPagamento());
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
        usuario.setSenha(dto.senha());
        usuario.setEndereco(dto.endereco());
        usuario.setTelefone(dto.telefone());
        usuario.setPermissao(dto.permissao());
        usuario.setIdade(dto.idade());
        usuario.setSexo(dto.sexo());
        usuario.setCref(dto.cref());
        usuario.setPeso(dto.peso());
        usuario.setAltura(dto.altura());
        usuario.setStatusPagamento(dto.statusPagamento());
        return this.usuarioRepository.save(usuario);
    }
}
