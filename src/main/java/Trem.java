import java.util.ArrayList;
import static java.lang.Boolean.parseBoolean;

public class Trem {
    Vagao vagao = new Vagao();
    Locomotiva locomotiva = new Locomotiva();
    ArrayList<String> composicao = new ArrayList<>();

    PatioTrem patio = new PatioTrem();

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
    public boolean engatarLocomotivas(){
        sizeL++;
        locomotiva.addLocomotiva();
        for (String a: composicao) {

            if(a.startsWith("V")){
                System.out.println("Vagoes ja engatados, desengate e tente novamente");
                return false;
            }
        }
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
    public boolean desengatarVagoes(String id){
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
    public boolean addTremtoPatio(){
        composicao.add(0, idTrem());
        patio.addTrain();
        return true;
    }

    public void removeTremfromPatio(String id){
        if(patio.removeTrem(id)){
            System.out.println("Trem removido com sucesso");
        }
        else {
            System.out.println("Id não cadastrado em nosso sistema");
        }
    }

    public void getTremfromPatio(String id){
        composicao = patio.getTrem(id);
        System.out.println("O trem ja foi recuperado do patio");
    }

    public ArrayList<ArrayList<String>> alltrens (){
        return patio.allTrem;

    }

    public void gerarLeV(){
        for (int i = 0; i<10000; i++){
            vagao.addTrain();
            locomotiva.addLocomotiva();
        }
    }
}