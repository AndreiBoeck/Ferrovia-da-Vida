import java.io.*;
import java.util.StringJoiner;

/**
 * A classe Vagao estende a classe Carro sendo movimentada em uma composição.
 *
 * @author adrei.boeck@edu.pucrs.br
 * @author luisa.scolari@edu.pucrs.br
 * @author marcela.zarichta@edu.pucrs.br
 * @author rafael.roth@edu.pucrs.br
 */
public class Vagao extends Carro{

    private final double cargaMax;

    private final String identificador;

    /**
     * O identificador da próxima instância de composição.
     */
    private static int NEXT_ID = 1;


    /**
     *
     * @param cargaMax carga maxima suportada pelo vagão
     */
    public Vagao(double cargaMax) {
        this.cargaMax = cargaMax;
        identificador = "V" + NEXT_ID;
        NEXT_ID++;
    }

    /**
     * Construtor de Vagoes salvos nos arquivos csv
     * @param identificador identificador do vagão
     * @param cargaMax carga maxima suportada pelo vagão
     */

    public Vagao(String identificador, double cargaMax) {
        this.identificador = identificador;
        this.cargaMax = cargaMax;
        NEXT_ID++;
    }

    /**
     * @return identificador
     */
    public String getIdentificador(){
        return identificador;
    }

    /**
     * @return carga maxima
     */
    public double getCargaMax(){return cargaMax;}


    /**
     *
     * @return String do Vagao
     */

    @Override
    public String toString() {
        return new StringJoiner("; ", Vagao.class.getSimpleName() + "[", "]")
                .add("identificador=" + getIdentificador())
                .add("pesoMaximo=" + getCargaMax())
                .toString();
    }

    /**
     * Salva Vagoes
     * @throws FileNotFoundException caso não ache o arquivo
     */
    public void saveVagoes() throws FileNotFoundException {
        PrintStream out = new PrintStream(new FileOutputStream( "src/main/resources/GaragemVagoes.csv", true));
        String vagao = getIdentificador() + ";" + getCargaMax();
        out.println(vagao);
        out.close();
    }
}
