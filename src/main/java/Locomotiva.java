import java.util.StringJoiner;

/**
 * A classe Locomotiva representa o veículo que movimenta uma composição.
 *
 * @author marco.mangan@pucrs.br
 */
public class Locomotiva extends Carro{

    /**
     * O identificador da próxima instância de locomotiva.
     */
    private static int NEXT_ID = 1;

    /**
     * O identificador desta composição.
     */
    private final int qtdadeMaxVagoes;

    private final String identificador;

    /**
     *
     */
    private Composicao composicao;

    /**
     *
     */
    private double pesoMax;

    /**
     * @param pesoMaximo
     * @param qtdadeMaxVagoes
     */
    public Locomotiva(double pesoMaximo, int qtdadeMaxVagoes) {
        this.qtdadeMaxVagoes = qtdadeMaxVagoes;
        this.pesoMax = pesoMaximo;
        identificador = "L" + NEXT_ID;
        NEXT_ID++;
    }


    public String getIdentificador(){
        return identificador;
    }

    /**
     * @param pesoMaximo
     */
    public void setPesoMax(double pesoMaximo){
        this.pesoMax = pesoMaximo;
    }

    /**
     * @return double
     */
    public double getPesoMax(){return pesoMax;}

    /**
     *
     * @return int
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
        return new StringJoiner(", ", Locomotiva.class.getSimpleName() + "[", "]")
                .add("identificador=" + getIdentificador())
                .add("pesoMaximo=" + getPesoMax())
                .add("qtdadeMaxVagoes=" + qtdadeMaxVagoes)
                //.add("composicao=" + composicao)
                .toString();
    }
}