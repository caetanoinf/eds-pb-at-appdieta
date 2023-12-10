package br.edu.infnet.appdieta.model.loader;


import br.edu.infnet.appdieta.model.domain.AlimentoConsumo;
import br.edu.infnet.appdieta.model.domain.Refeicao;
import br.edu.infnet.appdieta.model.service.AlimentoConsumoService;
import br.edu.infnet.appdieta.model.service.RefeicaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.FileReader;
import java.time.LocalDateTime;
import java.util.ArrayList;

@Order(3)
@Component
public class RefeicaoLoader implements ApplicationRunner {
    @Autowired
    private RefeicaoService refeicaoService;

    @Autowired
    private AlimentoConsumoService alimentoConsumoService;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        FileReader fileReader = new FileReader("files/refeicoes.txt");
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        bufferedReader.readLine(); // Pular 1 linha

        String linha = bufferedReader.readLine();
        String[] campos = null;

        while (linha != null) {
            campos = linha.split(";");

            Refeicao refeicao = new Refeicao();

            refeicao.setId(Integer.parseInt(campos[0]));
            refeicao.setSessao(campos[1]);
            refeicao.setDataConsumo(!campos[3].equals("null") ? LocalDateTime.now() : null);
            refeicao.setAlimentos(new ArrayList<>());

            String[] alimentosIds = campos[2].split(",");

            for (String alimentoId : alimentosIds) {
                AlimentoConsumo alimentoConsumo = alimentoConsumoService.obterAlimento(Integer.parseInt(alimentoId));
                alimentoConsumo.getRefeicoes().add(refeicao);
                refeicao.getAlimentos().add(alimentoConsumo);
            }

            refeicaoService.incluir(refeicao);

            linha = bufferedReader.readLine();
        }

        for (Refeicao refeicao : refeicaoService.obterRefeicoes()) {
            System.out.println("[REFEICAO] " + refeicao.toString());
        }

        bufferedReader.close();
    }
}
