package br.edu.infnet.appdieta.model.service;

import br.edu.infnet.appdieta.model.domain.Usuario;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Service
public class UsuarioService {
    private Map<Integer, Usuario> usuarios = new HashMap<Integer, Usuario>();

    public void incluir(Usuario usuario) {
        usuarios.put(usuario.getId(), usuario);
    }

    public Collection<Usuario> obterUsuarios() {
        return usuarios.values();
    }
}
