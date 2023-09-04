import java.util.ArrayList;

public class GaragemLocomotivas
{

    private int v = 0;
    private int atual = 0;

    ArrayList<ArrayList<String>> all = new ArrayList<>();
    ArrayList <Locomotiva> garagemLocomotivas = new ArrayList <Locomotiva>();

    //mudar capacidade maxima dependendo da capacidade


    public ArrayList<ArrayList<String>> allTrains(ArrayList<String> train){
        all.add(train);
        atual++;
        return all;
    }
    public ArrayList<ArrayList<String>> getAll(){
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
    public void removeLocomotiva(Locomotiva locomotiva)
    {
        garagemLocomotivas.remove(atual);
    }
    
    public int getLocomotivasNaGaragem()
    {
        return garagemLocomotivas.size();
    }
}
