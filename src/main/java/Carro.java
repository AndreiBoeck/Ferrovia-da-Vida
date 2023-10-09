abstract class Carro {
    private int identificador;
//    private double pesoMax;
    private Composicao composicao;

    public Carro(int identificador /**double pesoMax*/, Composicao composicao){
        this.identificador = identificador;
//        this.pesoMax = pesoMax;
        this.composicao = composicao;
    }

    public void setComposicao(Composicao composicao) {
        //if (composicao == null) {
        //    throw new IllegalArgumentException();
        //}
        this.composicao = composicao;
    }

    public int getIdentificador(){return identificador;}

//    public double getPesoMax(){return pesoMax;}

    public Composicao getComposicao(){return composicao;}
}
