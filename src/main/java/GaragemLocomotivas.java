import java.util.ArrayList;

public class GaragemLocomotivas
{

    private int v = 0;
    private int atual = 0;
    ArrayList <Locomotiva> garagemLocomotivas = new ArrayList <Locomotiva>();

    //mudar capacidade maxima dependendo da capacidade

    public void addLocomotiva(Locomotiva locomotiva)
    {
        garagemLocomotivas.add(locomotiva);
        garagemLocomotivas.get(atual).setNome(v);
        v++;
        atual++;

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
