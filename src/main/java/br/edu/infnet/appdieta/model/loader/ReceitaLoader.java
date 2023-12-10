package br.edu.infnet.appdieta.model.loader;

import br.edu.infnet.appdieta.model.domain.AlimentoConsumo;
import br.edu.infnet.appdieta.model.domain.Receita;
import br.edu.infnet.appdieta.model.service.AlimentoConsumoService;
import br.edu.infnet.appdieta.model.service.AlimentoService;
import br.edu.infnet.appdieta.model.service.ReceitaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

@Order(4)
@Component
public class ReceitaLoader implements ApplicationRunner {
    @Autowired
    private ReceitaService receitaService;

    @Autowired
    private AlimentoConsumoService alimentoConsumoService;

    @Autowired
    private AlimentoService alimentoService;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        FileReader fileReader = new FileReader("files/receitas.txt");
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        bufferedReader.readLine(); // Pular 1 linha

        String linha = bufferedReader.readLine();
        String[] campos = null;

        while (linha != null) {
            campos = linha.split(";");

            Receita receita = new Receita();
            receita.setId(Integer.parseInt(campos[0]));
            receita.setNome(campos[1]);

            AlimentoConsumo alimento1 = criarAlimentoConsumo(campos[2], receita);
            AlimentoConsumo alimento2 = criarAlimentoConsumo(campos[3], receita);
            AlimentoConsumo alimento3 = criarAlimentoConsumo(campos[4], receita);

            receita.adicionarAlimento(alimento1);
            receita.adicionarAlimento(alimento2);
            receita.adicionarAlimento(alimento3);

            receita.setEhPublica(Boolean.parseBoolean(campos[5]));

            receitaService.incluir(receita);

            linha = bufferedReader.readLine();
        }

        for (Receita receita : receitaService.obterReceitas()) {
            System.out.println("[RECEITA] " + receita.toString());
        }

        bufferedReader.close();
    }

    private AlimentoConsumo criarAlimentoConsumo(String descricao, Receita receita) {
        String[] campos = descricao.split(",");
        int id = Integer.parseInt(campos[0]);
        int alimentoId = Integer.parseInt(campos[1]);
        double quantidade = Double.parseDouble(campos[2]);
        String unidade = campos[3];

        AlimentoConsumo alimentoConsumo = new AlimentoConsumo();
        alimentoConsumo.setId(id);
        alimentoConsumo.setAlimento(alimentoService.obterAlimento(alimentoId));
        alimentoConsumo.setQuantidade(quantidade);
        alimentoConsumo.setUnidade(unidade);

        alimentoConsumoService.incluir(alimentoConsumo);

        alimentoConsumo.getReceitas().add(receita);

        return alimentoConsumo;
    }
}
