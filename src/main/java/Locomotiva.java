import java.util.ArrayList;
import java.util.Random;

public class Locomotiva {
    Random rn = new Random();
    GaragemLocomotivas garagemLocomotivas = new GaragemLocomotivas();
    public boolean availability = true;

    private int id;
    public ArrayList<String> train(){
        int ID = rn.nextInt(10000000, 99999999);
        double capacity = 100;
        ArrayList<String> atributes = new ArrayList<>();
        atributes.add(String.valueOf(availability));
        atributes.add("L"+String.valueOf(ID));
        atributes.add(String.valueOf(capacity));
        return atributes;
    }
    public void addLocomotiva()
    {
        garagemLocomotivas.allTrains(train());
    }

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
        return 4500.0;
    }
    public boolean getAvailability(String id){
        return garagemLocomotivas.checkId(id);
    }

    public int getnVagoes() {
        return nVagoes;
    }
}