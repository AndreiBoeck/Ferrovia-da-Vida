import java.lang.reflect.Array;
import java.util.ArrayList;

import static java.lang.Boolean.parseBoolean;

public class Trem {
    Vagao vagao = new Vagao();
    Locomotiva locomotiva = new Locomotiva();
    ArrayList<String> composicao = new ArrayList<>();
    public boolean engatarVagoes(){
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
        for (ArrayList<String> a: locomotiva.()) {
            if (parseBoolean(a.get(0))){
                composicao.add(a.get(1));
                vagao.setFalse(a.get(1));
                return true;
            }
        }
        return false;
    }
    public ArrayList<Integer> listagemIdTrens(){
        ArrayList<Integer> a = new ArrayList<>();
        return a;
    }
    public boolean desegatarVagoes(){
        return false;
    }
    public boolean desengatarLocomotiva(){
        return false;
    }
    public int getIdLeV(){
        return 0;
    }
    public int getQuantidadeLeV(){
        return 0;
    }
    public double getWeightCapacity(){
        return 0.0;
    }
}