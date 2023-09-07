
import java.util.ArrayList;
import static java.lang.Boolean.parseBoolean;

public class GaragemVagoes {
    ArrayList<ArrayList<String>> all = new ArrayList<>();
    public int size = 0;

    public void allTrains(ArrayList<String> train){
        all.add(train);
        size++;
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
}
