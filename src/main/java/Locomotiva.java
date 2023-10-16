import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.StringJoiner;

/**
 * A classe Locomotiva estende a classe Carro e movimenta uma composição.
 *
 * @author adrei.boeck@edu.pucrs.br
 * @author luisa.scolari@edu.pucrs.br
 * @author marcela.zarichta@edu.pucrs.br
 * @author rafael.roth@edu.pucrs.br
 */
public class Locomotiva extends Carro{

    /**
     * O identificador da próxima instância de locomotiva.
     */
    private static int NEXT_ID = 1;
    private final int qtdadeMaxVagoes;

    private final String identificador;

    /**
     *
     */
    private final double pesoMax;

    /**
     * @param pesoMaximo peso maximo suportado pela locomotiva
     * @param qtdadeMaxVagoes quantidade maxima de vagoes suportada pela locomotiva
     */
    public Locomotiva(double pesoMaximo, int qtdadeMaxVagoes) {
        this.qtdadeMaxVagoes = qtdadeMaxVagoes;
        this.pesoMax = pesoMaximo;
        identificador = "L" + NEXT_ID;
        NEXT_ID++;
    }

    /**
     * Cria a composição salva na memória
     * @param identificador identificador da locomotiva
     * @param pesoMaximo peso maximo suportado pela locomotiva
     * @param qtdadeMaxVagoes quantidade maxima de vagoes suportada pela locomotiva
     */
    public Locomotiva(String identificador, double pesoMaximo, int qtdadeMaxVagoes){
        this.qtdadeMaxVagoes = qtdadeMaxVagoes;
        this.pesoMax = pesoMaximo;
        this.identificador = identificador;
        NEXT_ID++;
    }

    /**
     * Retorna o identificador
     * @return String
     */

    public String getIdentificador(){
        return identificador;
    }

    /**
     * @return double
     */
    public double getPesoMax(){return pesoMax;}

    /**
     * @return quantidade maxima de vagões
     */
    public int getQtdadeMaxVagoes() {
        return qtdadeMaxVagoes;
    }

    /**
     *
     * @return dados da locomotiva em uma string
     */
    @Override
    public String toString() {
        return new StringJoiner(";", Locomotiva.class.getSimpleName() + "[", "]")
                .add("identificador=" + getIdentificador())
                .add("pesoMaximo=" + getPesoMax())
                .add("qtdadeMaxVagoes=" + qtdadeMaxVagoes)
                .toString();
    }


    /**
     * Salva locomotivas criadas
     * @throws FileNotFoundException caso o arquivo não seja encontrado
     */
    public void saveLocomotivas() throws FileNotFoundException {
        PrintStream out = new PrintStream(new FileOutputStream( "src/main/resources/GaragemLocomotivas.csv", true));
        String locomotiva = getIdentificador() + ";" + getPesoMax() + ";" + getQtdadeMaxVagoes();
        out.println(locomotiva);
        out.close();
    }
}