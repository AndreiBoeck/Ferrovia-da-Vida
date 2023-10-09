public class Vagao extends Carro{

    private final double cargaMax;

    /**
     *
     * @param identificador
     * @param cargaMax
     * @param composicao
     */
    public Vagao(int identificador, double cargaMax, Composicao composicao) {
        super(identificador, composicao);
        this.cargaMax = cargaMax;
    }

    /**
     * @return double
     */
    public double getCargaMax(){return cargaMax;}
}
