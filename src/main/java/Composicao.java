import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.StringJoiner;

/**
 * A classe Composicao representa um trem com ao menos uma locomotiva.
 *
 * @author adrei.boeck@edu.pucrs.br
 * @author luisa.scolari@edu.pucrs.br
 * @author marcela.zarichta@edu.pucrs.br
 * @author rafael.roth@edu.pucrs.br
 */
public class Composicao {

    /**
     * O identificador da próxima instância de composição.
     */
    private static int NEXT_ID = 1;

    /**
     * O identificador desta composição.
     */
    private final String identificador;

    /**
     * A lista de vagões da composição.
     */
    private ArrayList<Vagao> vagoes = new ArrayList<>();

    /**
     * A lista de locomotivas da composição.
     */
    private ArrayList<Locomotiva> locomotivas = new ArrayList<>();

    public ArrayList<Carro> trem = new ArrayList<>();

    /**
     * Cria uma nova composição.
     * A composição necessita de uma locomotiva livre.
     */
    public Composicao(){
        identificador = "C" + NEXT_ID;
        NEXT_ID++;
    }

    /**
     * Cria uma composição guardada na memória
     * @param identificador identificador da composição
     * @param locomotivas locomotiva guardada
     * @param vagoes vagão guardado
     */
    public Composicao(String identificador, ArrayList<Locomotiva> locomotivas, ArrayList<Vagao> vagoes){
        this.identificador = identificador;
        this.locomotivas = locomotivas;
        this.vagoes = vagoes;
        NEXT_ID++;
    }

    /**
     * @return o identificador da composição
     */
    public String getIdentificador() {
        return identificador;
    }

    /**
     * @return a quantidade de locomotivas desta composição
     */
    public int getQtdadeLocomotivas() {
        return locomotivas.size();
    }

    /**
     *
     * @return as locomotivas engatadas
     */
    public ArrayList<Locomotiva> getLocomotivas() {
        return locomotivas;}

    /**
     * @return a quantidade de vagões desta composição
     */
    public int getQtdadeVagoes() {
        return vagoes.size();
    }


    /**
     *
     * @return os vagões engatados
     */
    public ArrayList<Vagao> getVagoes(){
        return vagoes;
    }

    /**
     *
     */
    private int counterL = 0;

    /**
     * Engata locomotiva ao final da composição.
     * Caso a locomotiva pertença a uma outra compsição, uma exceção será lançada.
     * Caso um vagão esteja conectado, uma exceção será lançada.
     *
     * @param locomotiva a locomotiva a ser engatada.
     */
    public void engataLocomotiva(Locomotiva locomotiva){
        if (locomotiva == null) {
            throw new IllegalArgumentException();
        }
        if (locomotiva.getComposicao() != null) {
            throw new RuntimeException("Locomotiva está em outra composição");
        }
        if (!vagoes.isEmpty()) {
            throw new RuntimeException("Locomotiva após vagão não é permitido!");
        }
        counterL++;
        locomotivas.add(locomotiva);
        locomotiva.setComposicao(this);
    }

    /**
     *
     * @return double de peso maximo
     */
    public double getPesoMax(){
        double pesoMax = 0;
        for (Locomotiva locomotiva : locomotivas) {
            pesoMax += locomotiva.getPesoMax() - (((10* locomotiva.getPesoMax())/100)*counterL);
        }
        return pesoMax;
    }

    /**
     * Engata vagão ao final da composição.
     *
     * @param vagao o vagão a ser engatado
     */
    public void engataVagao(Vagao vagao){
        if (vagao == null) {
            throw new IllegalArgumentException();
        }
        if (vagao.getComposicao() != null) {
            throw new RuntimeException("Vagao está em outra composição");
        }
        int total = 0;
        for (Locomotiva locomotiva : locomotivas) {
            total += locomotiva.getQtdadeMaxVagoes();
        }
        if (total <= vagoes.size()) {
            System.out.println("Maximo de vagões excedido");
            return;
        }

        double pesoMax = getPesoMax();
        double peso = 0;
        for (Vagao v : vagoes) {
            peso += v.getCargaMax();
        }
        if (pesoMax <= peso) {
            System.out.println("Peso maximo excedido");
            return;
        }
        vagao.setComposicao(this);
        vagoes.add(vagao);
    }

    /**
     * Desengata a locomotiva ao final da composição.
     * A locomotiva retorna para sua garagem, se puder ser desengatada.
     */
    public void desengataLocomotiva() {
        if (!vagoes.isEmpty()) {
            throw new RuntimeException("Vagão após a locomotiva");
        }
        if (locomotivas.size() <= 1) {
            throw new RuntimeException("Primeira Locomotiva não pode ser removida");
        }

        Locomotiva locomotiva = locomotivas.remove(locomotivas.size() - 1);
        locomotiva.setComposicao(null);
    }

    /**
     * Desengata o vagão ao final da composição.
     * O vagão retorna para sua garagem, se puder ser desengatado.
     * Caso não existe vagão para desengatar, uma exceção será lançada.
     */
    public void desengataVagao(){
        if (vagoes.isEmpty()) {
            throw new RuntimeException("Nenhum vagão na composição");
        }
        Vagao vagao = vagoes.remove(vagoes.size() - 1);
        vagao.setComposicao(null);
    }

    /**
     * Efetua a criação da composição
     */

    public void setComposition(){
        for (Locomotiva locomotiva:
             locomotivas) {
            trem.add(locomotiva);
            locomotiva.setComposicao(this);
        }
        for (Vagao vagao:
             vagoes) {
            trem.add(vagao);
            vagao.setComposicao(this);
        }
    }

    /**
     * @return dados da composição em uma string
     */
    @Override
    public String toString() {
        return new StringJoiner(", ", Composicao.class.getSimpleName() + "[", "]")
                .add("identificador=" + identificador)
                .add("locomotivas=" + locomotivas)
                .add("vagoes=" + vagoes)
                .toString();
    }

    /**
     * Salva a composição
     * @throws FileNotFoundException caso o arquivo não seja encontrado
     */
    public void saveComposicao() throws FileNotFoundException {
        PrintStream out = new PrintStream(new FileOutputStream( "src/main/resources/GaragemComposicao.csv", true));
        String vagao = (identificador + ";" +
                locomotivas.toString().replaceAll(",", ";")
                        .replaceAll("]", "")
                        .replace('[', ' ')
                        .replaceAll("Locomotiva", "") + ";" +
                vagoes.toString().replaceAll(",", ";")
                        .replaceAll("]", "")
                        .replace('[', ' ')
                        .replaceAll("Vagao", ""))
                        .replaceAll(" ", "");
        out.println(vagao);
        out.close();
    }
}