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

    public Vagao(String identificador, double cargaMax) {
        this.identificador = identificador;
        this.cargaMax = cargaMax;
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
        return new StringJoiner("; ", Vagao.class.getSimpleName() + "[", "]")
                .add("identificador=" + getIdentificador())
                .add("pesoMaximo=" + getCargaMax())
                .toString();
    }

    public void saveVagoes() throws FileNotFoundException {
        PrintStream out = new PrintStream(new FileOutputStream( "src/main/resources/GaragemVagoes.csv", true));
        String vagao = getIdentificador() + ";" + getCargaMax();
        out.println(vagao);
        out.close();
    }
}
