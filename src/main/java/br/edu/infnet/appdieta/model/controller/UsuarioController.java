package br.edu.infnet.appdieta.model.controller;

import br.edu.infnet.appdieta.model.domain.Usuario;
import br.edu.infnet.appdieta.model.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/usuario")
public class UsuarioController {
    @Autowired
    private UsuarioService usuarioService;

    @GetMapping(value = "/listar")
    public List<Usuario> obterLista() {
        return (List<Usuario>) usuarioService.obterUsuarios();
    }

    @PostMapping(value = "/incluir")
    public void incluir(@RequestBody Usuario usuario) {
        usuarioService.incluir(usuario);
    }

    @DeleteMapping(value = "/{id}/excluir")
    public void excluir(@PathVariable Integer id) {
        usuarioService.excluir(id);
    }
}
