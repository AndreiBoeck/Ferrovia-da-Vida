import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(System.in);
        Trem trem = new Trem();

        int escolha;
        int escolha2;
        int escolha3;
        int escolha4;
        do {
            System.out.println("Bem vindo!");
            System.out.println("o que gostaria de fazer?");
            System.out.println("1 - Compor trem;");
            System.out.println("2 - Listar Identificadores dos trens;");
            System.out.println("3 - Editar trem;");
            System.out.println("4 - Acessar informações de trens;");
            escolha = input.nextInt();

            switch (escolha) {
                case 1 -> {
                    do {
                        System.out.println("~~~Composição de trens~~~");
                        System.out.println("Aviso: Para a composição de trens, você apenas poderá engatar locomotivas atrás de " +
                                "locomotivas, nunca intercalá-las com os vagões.");

                        System.out.println("Você gostaria de:");
                        System.out.println("1 - Engatar Locomotiva;");
                        System.out.println("2 - Engatar Vagão;");
                        System.out.println("3 - Enviar trem ao pátio;");
                        System.out.println("0 - Voltar ao menu principal;");
                        escolha2 = input.nextInt();
                        switch (escolha2) {
                            case 1 -> {
                                System.out.println("Quantas locomotivas gostaria de adicionar?");
                                int quantidadeLocomotiva = input.nextInt();
                                for (int i = 0; i < quantidadeLocomotiva; i++) {

                                    trem.engatarLocomotivas();
                                }
                            }
                            case 2 -> {
                                System.out.println("Quantos vagões gostaria de adicionar?");
                                int qV = input.nextInt();
                                for (int i = 0; i < qV; i++) {
                                    trem.engatarVagoes();
                                }
                            }
                            case 3 -> {
                                trem.addTremtoPatio();
                                System.out.println("Trem enviado ao pátio!");
                            }
                        }
                    } while (escolha2 != 0);
                }
                case 2 -> {
                    System.out.println("~~~Listagem de Identificador de trens~~~");
                    if (trem.alltrens().size() <= 1) {
                        System.out.println("Nenhum trem criado");
                    }
                    for (ArrayList<String> a : trem.alltrens()) {
                        System.out.println(a);
                    }
                }
                case 3 -> {
                    System.out.println("~~~Edição de trens~~~");
                    System.out.println("Qual trem você gostaria de editar?");
                    if (trem.alltrens().size() <= 1) {
                        System.out.println("Nenhum trem criado! Crie um trem!");
                        break;
                    }
                    for (ArrayList<String> a : trem.alltrens()) {
                        System.out.println(a);
                    }
                    System.out.print("ID: ");
                    System.out.println("\nVocê gostaria de:");
                    System.out.println("1 - Engatar Locomotiva;");
                    System.out.println("2 - Engatar Vagão;");
                    System.out.println("3 - Desengatar Locomotiva;");
                    System.out.println("4 - Desengatar Vagão;");
                    escolha3 = input.nextInt();
                    switch (escolha3) {
                        case 1 -> trem.engatarLocomotivas();
                        case 2 -> trem.engatarVagoes();
                        case 3 -> trem.desengatarLocomotiva();
                        case 4 -> trem.desengatarVagoes();
                    }
                }
                case 4 -> {
                    System.out.println("~~~Acessar informação de trens~~~");
                    System.out.println("Qual trem você gostaria de se informar?");
                    for (ArrayList<String> a : trem.alltrens()) {
                        System.out.println(a);
                    }
                    System.out.println("Você gostaria de:");
                    System.out.println("1 - Acessar Id de locomotivas e Vagões;");
                    System.out.println("2 - Ver quantidade de Locomotivas e Vagões;");
                    System.out.println("3 - Ver capacidade total de peso do Trem;");
                    escolha4 = input.nextInt();
                    switch (escolha4) {
                        case 1 -> System.out.println(trem.getIdLeV());
                        case 2 -> System.out.println(trem.getQuantidadeLeV());
                        case 3 -> System.out.println(trem.getWeightCapacity());
                    }
                }
            }
        }while(escolha != 0);
    }
}
