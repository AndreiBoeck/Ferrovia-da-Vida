import java.util.ArrayList;
import static java.lang.Boolean.parseBoolean;

public class Trem {
    Vagao vagao = new Vagao();
    Locomotiva locomotiva = new Locomotiva();
    ArrayList<String> composicao = new ArrayList<>();

    private int sizeL = 0;
    private int sizeV = 0;
    public boolean engatarVagoes(){
        sizeV++;
        for (ArrayList<String> a: vagao.getAll()) {
            if (parseBoolean(a.get(0))){
                composicao.add(a.get(1));
                vagao.setFalse(a.get(1));
                return true;
            }
        }
        return false;
    }
    public boolean engatarLovomotivas(){
        sizeL++;
        for (ArrayList<String> a: locomotiva.garagemLocomotivas.getAll()) {
            if (parseBoolean(a.get(0))){
                composicao.add(a.get(1));
                vagao.setFalse(a.get(1));
                return true;
            }
        }
        return false;
    }
    private int count = 0;
    public String idTrem(){
        count++;
        return "T" + String.valueOf(count);
    }
    public boolean desegatarVagoes(String id){
        sizeV--;
        return !vagao.getAvailability(id);
    }
    public boolean desengatarLocomotiva(String id){
        sizeL--;
        return !locomotiva.getAvailability(id);
    }
    public ArrayList<String> getIdLeV(){
        return composicao;
    }
    public ArrayList<Integer> getQuantidadeLeV(){
        ArrayList<Integer> quant = new ArrayList<>();
        quant.add(sizeL);
        quant.add(sizeV);
        return quant;
    }
    public double getWeightCapacity(){
        // a cada nova locomotiva a capacidade diminui 10%
        double capacity = 0;
        int counterL = 0;
        for (String a: composicao) {
            if(a.startsWith("L")){
                capacity += locomotiva.getPesoMaximo() - (((10* locomotiva.getPesoMaximo())/100)*counterL);
                counterL++;
            }
        }
        return capacity;
    }
}