import java.util.ArrayList;
import static java.lang.Boolean.parseBoolean;

public class Trem {
    Vagao vagao = new Vagao();
    Locomotiva locomotiva = new Locomotiva();
    ArrayList<String> composicao = new ArrayList<>();

    PatioTrem patio = new PatioTrem();

    private int sizeL = 0;
    private int sizeV = 0;
    public void engatarVagoes(){
        sizeV++;
        composicao.add(vagao.getOne());
        vagao.setFalse(vagao.getOne());
    }
    public void engatarLocomotivas(){
        sizeL++;
        locomotiva.addLocomotiva();
        for (String a: composicao) {

            if(a.startsWith("V")){
                System.out.println("Vagoes ja engatados, desengate e tente novamente");
            }
        }
        for (ArrayList<String> a: locomotiva.garagemLocomotivas.getAll()) {
            if (parseBoolean(a.get(0))){

                composicao.add(a.get(1));
                vagao.setFalse(a.get(1));
            }
        }
    }
    private int count = 0;
    public String idTrem(){
        count++;
        return "T" + count;
    }
    public void desengatarVagoes(){
        sizeV--;
    }
    public void desengatarLocomotiva(){
        sizeL--;
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
    public void addTremtoPatio(){
        composicao.add(0, idTrem());
        patio.addTrain(composicao);
    }

    public ArrayList<ArrayList<String>> alltrens (){
        return patio.allTrem;

    }

}