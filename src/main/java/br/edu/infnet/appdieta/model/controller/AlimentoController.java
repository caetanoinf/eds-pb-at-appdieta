package br.edu.infnet.appdieta.model.controller;

import br.edu.infnet.appdieta.model.domain.Alimento;
import br.edu.infnet.appdieta.model.service.AlimentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/alimento")
public class AlimentoController {
    @Autowired
    private AlimentoService alimentoService;

    @GetMapping(value = "/listar")
    public List<Alimento> obterLista() {
        return (List<Alimento>) alimentoService.obterAlimentos();
    }

    @PostMapping(value = "/incluir")
    public void incluir(@RequestBody Alimento alimento) {
        alimentoService.incluir(alimento);
    }

    @DeleteMapping(value = "/{id}/excluir")
    public void excluir(@PathVariable Integer id) {
        alimentoService.excluir(id);
    }
}
