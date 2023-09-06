import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Vagao {
    Random rn = new Random();
    public boolean availability = true;
    GaragemVagoes garagemVagoes = new GaragemVagoes();

    public ArrayList<String> train(){
        int ID = rn.nextInt(10000000, 99999999);
        double capacity = 150.0;
        ArrayList<String> atributes = new ArrayList<>();
        atributes.add(String.valueOf(availability));
        atributes.add("V"+String.valueOf(ID));
        atributes.add(String.valueOf(capacity));
        return atributes;
    }

    public void addTrain(){
        garagemVagoes.allTrains(train());
    }

    public void setFalse(String id){
        garagemVagoes.setFalse(id);
    }

    public ArrayList<ArrayList<String>> getAll(){
        return garagemVagoes.getAll();
    }

    public String getID(int index) {
        return garagemVagoes.getID(index);
    }

    public double getCapacity() {
        return 150.0;
    }
    public boolean getAvailability(String id){
        return garagemVagoes.checkId(id);
    }
    public ArrayList<String> getComposition(int index){
        ArrayList<String> composition = new ArrayList<>();
        return garagemVagoes.getIdComposition(index);
    }

    public int getsize(){
        return garagemVagoes.size;
    }

    public ArrayList<String> getAllid(){
        ArrayList<String> hold = new ArrayList<>();
        for (ArrayList<String> a:garagemVagoes.getAll()) {
            hold.add(a.get(1));
        }
        return hold;
    }

    public ArrayList<ArrayList<String>> getAllIdComposition(){
        return garagemVagoes.getAllIdComposition();
    }

    private ArrayList<String> idComposition = new ArrayList<>();

    public void createComposition(){
        Scanner in = new Scanner(System.in);
        String id;
        do {
            System.out.println("Digite um ID para adcionar na composição ou '0' para sair");
            id = in.next();
            if (garagemVagoes.checkId(id))
                idComposition.add(id);
            else {
                throw new RuntimeException("ID inserido não consta no sistema");
            }
        }
        while (id.equals("0"));
    }
    public void setIdComposition(){
        garagemVagoes.setIdComposition(idComposition);
        idComposition.clear();
    }
}
