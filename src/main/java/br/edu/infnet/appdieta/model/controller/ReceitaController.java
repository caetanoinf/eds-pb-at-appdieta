package br.edu.infnet.appdieta.model.controller;

import br.edu.infnet.appdieta.model.domain.Receita;
import br.edu.infnet.appdieta.model.service.ReceitaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/receita")
public class ReceitaController {
    @Autowired
    private ReceitaService receitaService;

    @GetMapping(value = "/listar")
    public List<Receita> obterLista() {
        return (List<Receita>) receitaService.obterReceitas();
    }

    @PostMapping(value = "/incluir")
    public void incluir(@RequestBody  Receita receita) {
        receitaService.incluir(receita);
    }

    @DeleteMapping(value = "/{id}/excluir")
    public void excluir(@PathVariable Integer id) {
        receitaService.excluir(id);
    }
}
