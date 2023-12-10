package br.edu.infnet.appdieta.model.service;

import br.edu.infnet.appdieta.model.domain.Usuario;
import br.edu.infnet.appdieta.model.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;

    public void incluir(Usuario usuario) {
        usuarioRepository.save(usuario);
    }

    public Collection<Usuario> obterUsuarios() {
        return (Collection<Usuario>) usuarioRepository.findAll();
    }
}
