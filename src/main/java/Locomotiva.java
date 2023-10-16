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

    /**
     * A quantidade máxima de vagões que a locomotiva suporta
     */
    private final int qtdadeMaxVagoes;

    /**
     * O identificador da locomotiva
     */
    private final String identificador;

    /**
     * o peso máximo que a locomotiva suporta
     */
    private final double pesoMax;

    /**
     * Construtor das locomotivas criadas pelo usuário
     * @param pesoMaximo peso maximo suportado pela locomotiva
     * @param qtdadeMaxVagoes quantidade máxima de vagoes suportada pela locomotiva
     */
    public Locomotiva(double pesoMaximo, int qtdadeMaxVagoes) {
        this.qtdadeMaxVagoes = qtdadeMaxVagoes;
        this.pesoMax = pesoMaximo;
        identificador = "L" + NEXT_ID;
        NEXT_ID++;
    }

    /**
     * Construtor das locomotiva criadas e salvas na memória
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
     * Retorna o peso máximo da locomotiva
     * @return double
     */
    public double getPesoMax(){return pesoMax;}

    /**
     * Retorna a quantidade máxima de vagões estabelecida
     * @return quantidade maxima de vagões
     */
    public int getQtdadeMaxVagoes() {
        return qtdadeMaxVagoes;
    }

    /**
     * Retorna informações da locomotiva
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