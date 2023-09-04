import java.io.IOException;

import static java.lang.Integer.parseInt;

public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println("Este é um teste");
        Vagao vagao = new Vagao();
        for (int i = 0; i < 10; i++) {
            vagao.createComposition();
        }
        vagao.saveVagao();

    }
}
