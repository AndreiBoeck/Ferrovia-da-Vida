import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;

import static java.lang.Boolean.parseBoolean;
import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;

public class GaragemVagoes {
    private final ArrayList<ArrayList<String>> all = new ArrayList<>();

    private ArrayList<ArrayList<Integer>> idComposition = new ArrayList<>();
    public int size = 0;

    public ArrayList<ArrayList<String>> allTrains(ArrayList<String> train){
        all.add(train);
        size++;
        return all;
    }

    public ArrayList<ArrayList<String>> getAll(){
        return all;
    }

    public boolean checkId(int ID ){
        ArrayList<String> hold = new ArrayList<>();
        for (ArrayList<String> i : all) {
            if(ID == parseInt(i.get(1))){
            hold = i;
            }
        }
        return parseBoolean(hold.get(0));
    }

    public int getID( int index ){
        return parseInt(all.get(index).get(1));
    }

    public double getCapacity( int index ){
        return parseDouble(all.get(index).get(2));
    }

    public void setIdComposition(ArrayList<Integer> idComposition) {
        this.idComposition.add(idComposition);
    }

    public ArrayList<Integer> getIdComposition(int index) {
        return idComposition.get(index);
    }

    public ArrayList<ArrayList<Integer>> getAllIdComposition(){
        return idComposition;
    }

    public void saveAll() throws IOException {
        PrintStream fl = new PrintStream("src/main/bin");
        for (ArrayList<String> write : all) {
            fl.println(write);
        }
        fl.close();
    }
}
