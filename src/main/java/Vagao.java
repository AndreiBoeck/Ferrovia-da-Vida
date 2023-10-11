import java.io.*;
import java.util.Scanner;
import java.util.StringJoiner;

public class Vagao extends Carro{

    private final double cargaMax;

    private final String identificador;

    /**
     * O identificador da próxima instância de composição.
     */
    private static int NEXT_ID = 1;


    /**
     *
     * @param cargaMax
     */
    public Vagao(double cargaMax) {
        this.cargaMax = cargaMax;
        identificador = "V" + NEXT_ID;
        NEXT_ID++;
    }


    public String getIdentificador(){
        return identificador;
    }

    /**
     * @return double
     */
    public double getCargaMax(){return cargaMax;}

    @Override
    public String toString() {
        return new StringJoiner(", ", Locomotiva.class.getSimpleName() + "[", "]")
                .add("identificador=" + getIdentificador())
                .add("pesoMaximo=" + getCargaMax())
                //.add("composicao=" + composicao)
                .toString();
    }

    public void saveVagoes() throws FileNotFoundException {
        File file = new File("src/main/resources/GaragemVagoes.csv");
        PrintStream fl = new PrintStream(file);
        String vagao = getIdentificador() + ";" + getCargaMax();
        fl.print(vagao + "\n");
    }
}
