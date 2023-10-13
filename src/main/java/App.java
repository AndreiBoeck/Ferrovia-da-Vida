import java.io.FileNotFoundException;

public class App {


    public static void main(String[] args) throws FileNotFoundException {
        Vagao vagao = new Vagao(42.0);
        Locomotiva locomotiva = new Locomotiva(48.0, 5);
        Vagao vagao2 = new Vagao(78010.0);
        Composicao aaa = new Composicao();
        System.out.println(vagao.getIdentificador());
        System.out.println(locomotiva.getIdentificador());
        System.out.println(vagao2.getIdentificador());
        aaa.engataLocomotiva(locomotiva);
        aaa.engataVagao(vagao);
        System.out.println(aaa.toString());
        vagao.saveVagoes();
        vagao2.saveVagoes();
        locomotiva.saveLocomotivas();
        aaa.saveComposicao();
    }
}
