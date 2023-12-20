package br.edu.infnet.appdieta.model.service;

import br.edu.infnet.appdieta.model.domain.Endereco;
import br.edu.infnet.appdieta.model.domain.Usuario;
import br.edu.infnet.appdieta.model.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private EnderecoService enderecoService;

    public void incluir(Usuario usuario) {
        String cep = usuario.getEndereco().getCep();
        Endereco endereco = enderecoService.obterCep(cep);

        usuario.setEndereco(endereco);
        usuarioRepository.save(usuario);
    }

    public Collection<Usuario> obterUsuarios() {
        return (Collection<Usuario>) usuarioRepository.findAll();
    }
}
