import java.io.IOException;

import static java.lang.Integer.parseInt;

public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println("Este é um teste");
        Vagao vagao = new Vagao();
        GaragemVagoes garemVagoes = new GaragemVagoes();
        System.out.println(parseInt(vagao.train().get(1)));
        for (int i = 0; i < 10; i++) {
            System.out.println(garemVagoes.allTrains(vagao.train()));
        }
        garemVagoes.saveAll();
    }
}
