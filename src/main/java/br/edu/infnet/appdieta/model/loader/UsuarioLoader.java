package br.edu.infnet.appdieta.model.loader;

import br.edu.infnet.appdieta.model.domain.*;
import br.edu.infnet.appdieta.model.service.ReceitaService;
import br.edu.infnet.appdieta.model.service.RefeicaoService;
import br.edu.infnet.appdieta.model.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.FileReader;
import java.time.LocalDateTime;

@Order(5)
@Component
public class UsuarioLoader implements ApplicationRunner {
    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private RefeicaoService refeicaoService;

    @Autowired
    private ReceitaService receitaService;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        FileReader fileReader = new FileReader("files/usuarios.txt");
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        bufferedReader.readLine(); // Pular 1 linha

        String linha = bufferedReader.readLine();
        String[] campos = null;

        while (linha != null) {
            campos = linha.split(";");

            Usuario usuario = new Usuario();
            usuario.setId(Integer.parseInt(campos[0]));
            usuario.setNome(campos[1]);
            usuario.setEmail(campos[2]);

            MetaConsumo metaConsumo = new MetaConsumo();
            metaConsumo.setTipo(campos[3]);
            metaConsumo.setValor(Double.parseDouble(campos[4]));
            usuario.setMetaConsumo(metaConsumo);

            usuario.adicionarPeso(new Peso(LocalDateTime.now(), Double.parseDouble(campos[5])));
            usuario.adicionarPeso(new Peso(LocalDateTime.now().minusMonths(1), Double.parseDouble(campos[6])));

            Refeicao refeicao = refeicaoService.obterRefeicao(Integer.parseInt(campos[7]));
            usuario.adicionarRefeicao(refeicao);

            Receita receita = receitaService.obterReceita(Integer.parseInt(campos[8]));
            usuario.adicionarReceita(receita);

            usuarioService.incluir(usuario);

            linha = bufferedReader.readLine();
        }

        for (Usuario usuario : usuarioService.obterUsuarios()) {
            System.out.println("[USUARIO] " + usuario.toString());
        }

        bufferedReader.close();
    }
}
