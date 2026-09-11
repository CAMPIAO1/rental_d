package com.rental.db.eventos.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rental.db.eventos.models.Usuario;
import com.rental.db.eventos.repositories.UsuarioRepository;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository; 

    public Long contarUsuarios() {
        return usuarioRepository.count();
    }

    public Usuario buscarUsuario(Integer id) {
        return usuarioRepository.findById(id).orElse(null);
    }

    public List<Usuario> listarUsuarios() {
        return usuarioRepository.findAll();
    }

    public Boolean deletarUsuario(Integer id) {
        if (usuarioRepository.existsById(id)) {
            usuarioRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public Usuario cadastrarUsuario(Usuario usuario) {
        return usuarioRepository.save(usuario);
    } 

    public Usuario atualizarUsuario(Integer id, Usuario usuario) {
        Usuario usuarioRecuperado = buscarUsuario(id);
        
        if (usuarioRecuperado != null) {
            usuarioRecuperado.setId(id);

            if (usuario.getNome() != null) {
                usuarioRecuperado.setNome(usuario.getNome());
            }
            if (usuario.getDataNascimento() != null) {
                usuarioRecuperado.setDataNascimento(usuario.getDataNascimento());
            }
            if (usuario.getEmail() != null) {
                usuarioRecuperado.setEmail(usuario.getEmail());
            }
            if (usuario.getCpf() != null) {
                usuarioRecuperado.setCpf(usuario.getCpf());
            }

            return usuarioRepository.save(usuarioRecuperado);
        }
        return null;
    }
}