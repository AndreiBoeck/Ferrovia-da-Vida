import java.util.ArrayList;

public class PatioTrem {
    Trem trem = new Trem();
    ArrayList<ArrayList<String>> allTrem = new ArrayList<>();
    public void addTrain(){
        allTrem.add(trem.composicao);
    }

    public boolean removeTrem(String id){
        for (ArrayList<String> a:allTrem) {
            if(a.get(0).equals(id)){
                allTrem.remove(a);
                return true;
            }
        }
        return false;
    }

    public ArrayList<String> getTrem(String id){
        for (ArrayList<String> a:allTrem) {
            if(a.get(0).equals(id)){
                return a;
            }
        }
        return new ArrayList<>();
    }
}
