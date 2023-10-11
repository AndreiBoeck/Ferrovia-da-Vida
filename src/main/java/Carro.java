import java.util.StringJoiner;

abstract class Carro {
    private int identificador;
//    private double pesoMax;
    private Composicao composicao;


    public Carro(){
    }

    public void setComposicao(Composicao composicao) {
        //if (composicao == null) {
        //    throw new IllegalArgumentException();
        //}
        this.composicao = composicao;
    }

    abstract String getIdentificador();

//    public double getPesoMax(){return pesoMax;}

    public Composicao getComposicao(){return composicao;}
}
