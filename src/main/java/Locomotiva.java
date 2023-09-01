import java.util.Random;

public class Locomotiva {
    Random rn = new Random();

    private int id;
    private double pesoMaximo= 500;
    private int nVagoes;
    private boolean ocuopado;

    private void setId() {
        id = rn.nextInt(10000000, 99999999);
    }
    public int getId() {
        setId();
        return id;
    }
    public double getPesoMaximo() {
        return pesoMaximo;
    }
    public int getnVagoes() {
        return nVagoes;
    }
    public int getComposicao() {
        return 0; //?????
    }
}