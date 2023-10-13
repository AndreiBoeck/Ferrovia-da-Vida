import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;

public class App {
    public static ArrayList<Composicao> inicializarComp() throws FileNotFoundException {
        ArrayList<Composicao> comp = new ArrayList<>();
        Scanner fl = new Scanner(new FileReader("src/main/resources/GaragemComposicao.csv"));
        String[] aux;
        String temp;
        while (fl.hasNext()){
            temp=fl.next();
            aux = temp.split(";");
            ArrayList<Vagao> vagaos = new ArrayList<>();
            ArrayList<Locomotiva> locomotivas = new ArrayList<>();
            for (int i = 0; i<aux.length; i++) {
                String hold = aux[i].substring(aux[i].indexOf("=")+1);
                if (hold.startsWith("L")) {
                    Locomotiva locomotiva = new Locomotiva(aux[i].substring(aux[i].indexOf("=")+1),
                            parseDouble(aux[i+1].substring(aux[i+1].indexOf("=")+1)), parseInt(aux[i+2].substring(aux[i+2].indexOf("=")+1)));
                            locomotivas.add(locomotiva);
                }
                else if(hold.startsWith("V")){
                    Vagao vagao = new Vagao(aux[i].substring(aux[i].indexOf("=")+1),
                            parseDouble(aux[i+1].substring(aux[i+1].indexOf("=")+1)));
                    vagaos.add(vagao);
                }
            }
            Composicao composicao = new Composicao(aux[0], locomotivas, vagaos);
            comp.add(composicao);
        }


        return comp;
    }

    public static void main(String[] args) throws FileNotFoundException {
        ArrayList<Composicao> comp = inicializarComp();
        for (Composicao a:
             comp) {
            System.out.println(a.toString());
        }
        Vagao vagao = new Vagao(42.0);
        Locomotiva locomotiva = new Locomotiva(48.0, 5);
        Vagao vagao2 = new Vagao(78010.0);
        Composicao aaa = new Composicao();
        System.out.println(vagao.getIdentificador());
        System.out.println(locomotiva.getIdentificador());
        System.out.println(vagao2.getIdentificador());
        aaa.engataLocomotiva(locomotiva);
        aaa.engataVagao(vagao);
        aaa.engataVagao(vagao2);
        System.out.println(aaa.toString());
        vagao.saveVagoes();
        vagao2.saveVagoes();
        locomotiva.saveLocomotivas();
        aaa.saveComposicao();
    }
}
