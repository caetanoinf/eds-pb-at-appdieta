package br.edu.infnet.appdieta.model.loader;

import br.edu.infnet.appdieta.model.domain.Alimento;
import br.edu.infnet.appdieta.model.domain.TabelaNutricional;
import br.edu.infnet.appdieta.model.service.AlimentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.FileReader;

@Order(1)
@Component
public class AlimentoLoader implements ApplicationRunner {
    @Autowired
    private AlimentoService alimentoService;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        FileReader fileReader = new FileReader("files/alimentos.txt");
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        bufferedReader.readLine(); // Pular 1 linha

        String linha = bufferedReader.readLine();
        String[] campos = null;

        while (linha != null) {
            campos = linha.split(";");

            Alimento alimento = new Alimento();
            alimento.setId(Integer.parseInt(campos[0]));
            alimento.setNome(campos[1]);
            alimento.setCategoria(campos[2]);

            TabelaNutricional tabelaNutricional = new TabelaNutricional();
            tabelaNutricional.setUnidade(campos[3]);
            tabelaNutricional.setCalorias(Double.parseDouble(campos[4]));
            tabelaNutricional.setProteinas(Double.parseDouble(campos[5]));

            alimento.setTabelaNutricional(tabelaNutricional);

            alimentoService.incluir(alimento);

            linha = bufferedReader.readLine();
        }

        for (Alimento alimento : alimentoService.obterAlimentos()) {
            System.out.println("[ALIMENTO] " + alimento.toString());
        }

        bufferedReader.close();
    }
}
