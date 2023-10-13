import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.StringJoiner;

/**
 * A classe Composicao representa um trem com ao menos uma locomotiva.
 *
 * @author marco.mangan@pucrs.br
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
    private final ArrayList<Vagao> vagoes = new ArrayList<>();

    /**
     * A lista de locomotivas da composição.
     */
    private final ArrayList<Locomotiva> locomotivas = new ArrayList<>();

    public ArrayList<Carro> trem = new ArrayList();

    /**
     * Cria uma nova composição.
     * A composição necessita de uma locomotiva livre.
     */
    public Composicao(){
        identificador = "C" + NEXT_ID;
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
     * @param posicao a posição da locomotiva na composição, iniciando em 1
     * @return a locomotiva na posição indicada
     */
    public Carro getLocomotiva(int posicao) {
        return locomotivas.get(posicao - 1);
    }

    /**
     * @return a quantidade de vagões desta composição
     */
    public int getQtdadeVagoes() {
        return vagoes.size();
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
            System.out.println("Locomotiva está em outra composição");
        }
        if (!vagoes.isEmpty()) {
            System.out.println("Locomotiva após vagão não é permitido!");
        }
        counterL++;
        locomotivas.add(locomotiva);
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
            System.out.println("Vagão em outra composição");
        }
        int total = 0;
        for (Locomotiva locomotiva : locomotivas) {
            total += locomotiva.getQtdadeMaxVagoes();
        }
        if (total <= vagoes.size()) {
            System.out.println("Maximo de vagões excedido");
        }

        double pesoMax = 0;
        for (Locomotiva locomotiva : locomotivas) {
            pesoMax += locomotiva.getPesoMax() - (((10* locomotiva.getPesoMax())/100)*counterL);
        }
        double peso = 0;
        for (Vagao v : vagoes) {
            peso += v.getCargaMax();
        }
        if (pesoMax <= peso) {
            System.out.println("Peso maximo excedido");
        }

        vagoes.add(vagao);
    }

    /**
     * Desengata a locomotiva ao final da composição.
     * A locomotiva retorna para sua garagem, se puder ser desengatada.
     */
    public void desengataLocomotiva() {
        if (!vagoes.isEmpty()) {
            System.out.println("Vagão após a locomotiva");
        }
        if (locomotivas.size() <= 1) {
            System.out.println("Primeira Locomotiva não pode ser removida");
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
            System.out.println("Nenhum vagão na composição");
        }
        Vagao vagao = vagoes.remove(vagoes.size() - 1);
        vagao.setComposicao(null);
    }

    /**
     * Desengata o último elemento da composição.
     * O elemento pode ser um vagão ou uma locomotiva. O elemento retorna para sua garagem se
     * puder ser removido.
     * Se a composição for formada somente por uma locomotiva, uma exceção será lançada.
     */
    public void desengataUltimoElemento(){
        if (vagoes.isEmpty()) {
            desengataLocomotiva();
        } else {
            desengataVagao();
        }
    }

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

    public void saveComposicao() throws FileNotFoundException {
        PrintStream out = new PrintStream(new FileOutputStream( "src/main/resources/GaragemComposicao.csv", true));
        String vagao = (identificador + ";" +
                locomotivas.toString().replaceAll(",", ";").replaceAll("]", "").replace('[', ' ').replaceAll("Locomotiva", "") + ";" +
                vagoes.toString().replaceAll(",", ";").replaceAll("]", "").replace('[', ' ').replaceAll("Vagao", "")).replaceAll(" ", "");
        out.println(vagao);
        out.close();
    }
}