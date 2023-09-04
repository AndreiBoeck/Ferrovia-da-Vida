import java.util.Random;

public class Locomotiva {
    Random rn = new Random();

    private int id;
    public double pesoMaximo = 100; //torque

    private int nVagoes;
    private boolean ocuopado;

    private String nome;

    private void setId() {
        id = rn.nextInt(10000000, 99999999);
    }
    public void setNome(int v) {
        nome = "L" + v;
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
}