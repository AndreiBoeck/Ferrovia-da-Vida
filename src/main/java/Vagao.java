import java.util.ArrayList;
import java.util.Random;

public class Vagao {
    Random rn = new Random();
    public boolean availability = true;
    GaragemVagoes garagemVagoes = new GaragemVagoes();

    public ArrayList<String> train(){
        int ID = rn.nextInt(10000000, 99999999);
        double capacity = 150.0;
        ArrayList<String> atributes = new ArrayList<>();
        atributes.add(String.valueOf(availability));
        atributes.add("V"+ID);
        atributes.add(String.valueOf(capacity));
        return atributes;
    }

    public ArrayList<String> addTrain(){
        garagemVagoes.allTrains(train());
        return train();
    }

    public void setFalse(String id){
        garagemVagoes.setFalse(id);
    }

    public ArrayList<ArrayList<String>> getAll(){
        return garagemVagoes.getAll();
    }


    public String getOne(){
        return addTrain().get(1);
    }

}
