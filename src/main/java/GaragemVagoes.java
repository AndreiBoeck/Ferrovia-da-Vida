import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;
import static java.lang.Boolean.parseBoolean;
import static java.lang.Double.parseDouble;

public class GaragemVagoes {
    ArrayList<ArrayList<String>> all = new ArrayList<>();

    ArrayList<ArrayList<String>> idComposition = new ArrayList<>();
    public int size = 0;

    public ArrayList<ArrayList<String>> allTrains(ArrayList<String> train){
        all.add(train);
        size++;
        return all;
    }

    public void setFalse(String id){
        for (ArrayList<String> a : all) {
            if(a.get(1).equals(id)){
                a.remove(0);
                a.add(0, "false");
            }

        }
    }

    public ArrayList<ArrayList<String>> getAll(){
        return all;
    }

    public boolean checkId(String ID ){
        ArrayList<String> hold = new ArrayList<>();
        for (ArrayList<String> i : all) {
            if(ID.equals(i.get(1))){
            hold = i;
            }
        }
        return parseBoolean(hold.get(0));
    }

    public String getID( int index ){
        return all.get(index).get(1);
    }

    public double getCapacity( int index ){
        return parseDouble(all.get(index).get(2));
    }

    public void setIdComposition(ArrayList<String> idComposition) {
        this.idComposition.add(idComposition);
    }

    public ArrayList<String> getIdComposition(int index) {
        return idComposition.get(index);
    }

    public ArrayList<ArrayList<String>> getAllIdComposition(){
        return idComposition;
    }
    public void readSavedVagao() throws FileNotFoundException {
        File file = new File("src/main/resources/bin");
        Scanner fl = new Scanner(file);
        ArrayList<String[]> hold = new ArrayList<>();

        while (fl.hasNextLine()){
            hold.add(fl.nextLine().split(","));
        }
        for (String[] a : hold) {
            ArrayList<String> savedTrain = new ArrayList<>();
            savedTrain.add(a[0]);
            savedTrain.add(a[1]);
            savedTrain.add(a[2]);
            all.add(savedTrain);
            size++;
        }
        System.out.println(all);
    }

    public void saveAll() throws IOException {
        PrintStream fl = new PrintStream("src/main/resources/bin");
        for (ArrayList<String> write : all) {
            for (String a: write
                 ) {
                fl.print(a + ',');
            }
            fl.println();
        }
        fl.close();
    }
}
