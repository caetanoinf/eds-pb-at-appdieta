package br.edu.infnet.appdieta.model.controller;

import br.edu.infnet.appdieta.model.domain.Usuario;
import br.edu.infnet.appdieta.model.service.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/endereco")
public class EnderecoController {
    @Autowired
    private EnderecoService enderecoService;

    @PostMapping(value = "/cep")
    public String obterCep(@RequestParam String cep) {
        return enderecoService.obterCep(cep).toString();
    }

}
