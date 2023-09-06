import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import static java.lang.Integer.parseInt;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(System.in);
        Trem trem = new Trem();
        Vagao vagao = new Vagao();
        Locomotiva locomotiva = new Locomotiva();

        int escolha;
        int escolha2;
        int escolha3;
        int escolha4;
        do {
            System.out.println("Bem vindo!");
            System.out.println("o que gostaria de fazer?");
            System.out.println("1 - Compor um trem;");
            System.out.println("2 - Editar trem;");
            System.out.println("3 - Acessar informações de trens;");
            escolha = input.nextInt();

            switch (escolha) {
                case 1:
                    do {
                        System.out.println("~~~Composição de trens~~~");
                        System.out.println("Aviso: Para a criação de trens, você apenas poderá engatar locomotivas atrás de " +
                                "locomotivas, nunca intercalá-las com os vagões.");
                        System.out.println("Você gostaria de:");
                        System.out.println("1 - Engatar Locomotiva;");
                        System.out.println("2 - Engatar Vagão;");
                        System.out.println("0 - Voltar ao menu principal;");
                        escolha2 = input.nextInt();
                        switch (escolha2) {
                            case 1:
                                System.out.println("Quantas locomotivas gostaria de adicionar?");
                                int qL = input.nextInt();

                                for (int i = 0; i < qL; i++) {
                                    trem.engatarLocomotivas();
                                }
                                System.out.println(qL + " locomotivas adicionadas.");
                                break;

                            case 2:
                                System.out.println("Quantos vagões gostaria de adicionar?");
                                int qV = input.nextInt();

                                for (int i = 0; i < qV; i++) {
                                    trem.engatarVagoes();
                                }
                                System.out.println(qV + " vagões adicionados.");
                                break;

                        }
                    }while (escolha2 != 0);
                case 2:
                   do{ System.out.println("~~~Edição de trens~~~");
                    System.out.println("Qual trem você gostaria de editar?");

                    String idtrem = input.nextLine();

                    System.out.println("Você gostaria de:");
                    System.out.println("1 - Engatar Locomotiva;");
                    System.out.println("2 - Engatar Vagão;");
                    System.out.println("3 - Desengatar Locomotiva;");
                    System.out.println("4 - Desengatar Vagão;");
                    escolha3 = input.nextInt();
                    switch (escolha3) {
                        case 1:
                            trem.engatarLocomotivas();
                            break;

                        case 2:
                            trem.engatarVagoes();
                            break;

                        case 3:
                            trem.desengatarLocomotiva(idtrem);
                            break;

                        case 4:
                            trem.desengatarVagoes(idtrem);
                    }
            } while (escolha3 != 0);

                case 3:
                    do {
                        System.out.println("~~~Acessar informação de trens~~~");
                        System.out.println("Qual trem você gostaria de se informar?");
                        for (ArrayList<String> a : trem.alltrens()) {
                            System.out.println(a);
                        }

                        int idTrem = input.nextInt();

                        System.out.println("Você gostaria de:");
                        System.out.println("1 - Acessar Id de locomotivas e Vagões;");
                        System.out.println("2 - Ver quantidade de Locomotivas e Vagões;");
                        System.out.println("3 - Ver capacidade total de peso do Trem;");

                        escolha4 = input.nextInt();
                        switch (escolha4) {
                            case 1:
                                trem.getIdLeV();
                                break;

                            case 2:
                                trem.getQuantidadeLeV();
                                break;

                            case 3:
                                trem.getWeightCapacity();
                                break;

                        }


                    } while (escolha4 != 0);
            }

        }while (escolha != 0) ;
    }
}