import java.util.ArrayList;

public class GaragemLocomotivas
{
    ArrayList <Locomotiva> garagemLocomotivas = new ArrayList <Locomotiva>();
    
    public void addLocomotiva(Locomotiva locomotiva)
    {
        garagemLocomotivas.add(locomotiva);
    }
    
    public void removeLocomotiva(Locomotiva locomotiva)
    {
        garagemLocomotivas.remove(locomotiva);
    }
    
    public int getLocomotivasNaGaragem()
    {
        return garagemLocomotivas.size();
    }
}
