import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Vagao {
    Random rn = new Random();
    public boolean availability = true;
    GaragemVagoes garagemVagoes = new GaragemVagoes();

    public ArrayList<String> train(){
        int ID = rn.nextInt(10000000, 99999999);
        double capacity = rn.nextDouble(100.0, 150.0);
        ArrayList<String> atributes = new ArrayList<>();
        atributes.add(String.valueOf(availability));
        atributes.add(String.valueOf(ID));
        atributes.add(String.valueOf(capacity));
        return atributes;
    }

    public void addTrain(){
        garagemVagoes.allTrains(train());
    }

    public int getID(int index) {
        return garagemVagoes.getID(index);
    }

    public double getCapacity(int index) {
        return garagemVagoes.getCapacity(index);
    }
    public boolean getAvailability(int index){
        return garagemVagoes.checkId(getID(index));
    }
    public ArrayList<Integer> getComposition(int index){
        ArrayList<Integer> composition = new ArrayList<>();
        return garagemVagoes.getIdComposition(index);
    }

    public ArrayList<ArrayList<Integer>> getAllIdComposition(){
        return garagemVagoes.getAllIdComposition();
    }

    private ArrayList<Integer> idComposition = new ArrayList<>();

    public void createComposition(){
        Scanner in = new Scanner(System.in);
        int id;
        do {
            System.out.println("Digite um ID para adcionar na composição ou '0' para sair");
            id = in.nextInt();
            if (garagemVagoes.checkId(id))
                idComposition.add(id);
            else {
                throw new RuntimeException("ID inserido não consta no sistema");
            }
        }
        while (id != 0);
    }
    public void setIdComposition(){
        garagemVagoes.setIdComposition(idComposition);
        idComposition.clear();
    }
    public void readSavedTrain() throws FileNotFoundException {
        garagemVagoes.readSavedVagao();
    }

    public void saveVagao() throws IOException {
        garagemVagoes.saveAll();
    }
}
