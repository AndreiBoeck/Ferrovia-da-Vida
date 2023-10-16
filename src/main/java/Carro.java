/**
 * A classe abstrata Carro contem métodos uteis para vagão e locomotiva.
 *
 * @author adrei.boeck@edu.pucrs.br
 * @author luisa.scolari@edu.pucrs.br
 * @author marcela.zarichta@edu.pucrs.br
 * @author rafael.roth@edu.pucrs.br
 */
abstract class Carro {
    private Composicao composicao;


    public Carro(){
    }

    public void setComposicao(Composicao composicao) {
        this.composicao = composicao;
    }

    abstract String getIdentificador();

//    public double getPesoMax(){return pesoMax;}

    public Composicao getComposicao(){return composicao;}
}
