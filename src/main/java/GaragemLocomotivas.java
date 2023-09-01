import java.util.ArrayList;

public class GaragemLocomotivas
{
    ArrayList <Locomotivas> garagemLocomotivas = new ArrayList <Locomotivas>();
    
    public void addLocomotiva(Locomotivas locomotiva)
    {
        garagemLocomotivas.add(locomotiva);
    }
    
    public void removeLocomotiva(Locomotivas locomotiva)
    {
        garagemLocomotivas.remove(locomotiva);
    }
    
    public int getLocomotivasNaGaragem()
    {
        return garagemLocomotivas.size();
    }
}
