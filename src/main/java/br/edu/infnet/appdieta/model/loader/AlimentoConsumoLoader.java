package br.edu.infnet.appdieta.model.loader;

import br.edu.infnet.appdieta.model.domain.Alimento;
import br.edu.infnet.appdieta.model.domain.AlimentoConsumo;

import br.edu.infnet.appdieta.model.service.AlimentoConsumoService;
import br.edu.infnet.appdieta.model.service.AlimentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.FileReader;

@Order(2)
@Component
public class AlimentoConsumoLoader implements ApplicationRunner {
    @Autowired
    private AlimentoConsumoService alimentoConsumoService;

    @Autowired
    private AlimentoService alimentoService;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        FileReader fileReader = new FileReader("files/alimentos-consumo.txt");
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        bufferedReader.readLine(); // Pular 1 linha

        String linha = bufferedReader.readLine();
        String[] campos = null;

        while (linha != null) {
            campos = linha.split(";");

            AlimentoConsumo alimentoConsumo = new AlimentoConsumo();
            Alimento alimento = alimentoService.obterAlimento(Integer.parseInt(campos[1]));

            alimentoConsumo.setAlimento(alimento);
            alimentoConsumo.setId(Integer.parseInt(campos[0]));
            alimentoConsumo.setQuantidade(Double.parseDouble(campos[2]));
            alimentoConsumo.setUnidade(campos[3]);

            alimentoConsumoService.incluir(alimentoConsumo);

            linha = bufferedReader.readLine();
        }

        for (Alimento alimento : alimentoService.obterAlimentos()) {
            System.out.println("[ALIMENTO CONSUMO] " + alimento.toString());
        }

        bufferedReader.close();
    }
}
