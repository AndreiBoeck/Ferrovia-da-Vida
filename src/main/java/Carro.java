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
