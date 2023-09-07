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
        int escolha5;
        do {
            System.out.println("Bem vindo!");
            System.out.println("o que gostaria de fazer?");
            System.out.println("1 - Compor um trem;");
            System.out.println("2 - Listar Identificadores dos trens;");
            System.out.println("3 - Editar trem;");
            System.out.println("4 - Acessar informações de trens;");
            System.out.println("5 - Opções relacionadas a Vagões");
            System.out.println("6 - Opções relacionadas as Locomotivas");
            escolha = input.nextInt();

            switch(escolha) {
                case 1:
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
                            case 1:
                                System.out.println("Quantas locomotivas gostaria de adicionar?");
                                int quantidadeLocomotiva = input.nextInt();

                                for (int i = 0; i < quantidadeLocomotiva; i++) {

                                    trem.engatarLocomotivas();
                                }
                                break;

                            case 2:
                                System.out.println("Quantos vagões gostaria de adicionar?");
                                int qV = input.nextInt();

                                for (int i = 0; i < qV; i++) {
                                    trem.engatarVagoes();
                                }
                                break;
                            case 3:
                                trem.addTremtoPatio();
                                System.out.println("Trem enviado ao pátio!");
                                break;
                        }
                    } while (escolha2 != 0);
                    break;

                case 2:
                    System.out.println("~~~Listagem de Identificador de trens~~~");
                    if(trem.alltrens().size() <= 1){
                        System.out.println("Nenhum trem criado");
                    }
                    for (ArrayList<String> a : trem.alltrens()) {
                        System.out.println(a);
                    }
                    break;
                case 3:
                    System.out.println("~~~Edição de trens~~~");
                    System.out.println("Qual trem você gostaria de editar?");
                    if(trem.alltrens().size() <= 1){
                        System.out.println("Nenhum trem criado! Crie um trem!");
                        break;
                    }  for (ArrayList<String> a : trem.alltrens()) {
                    System.out.println(a);
                }
                    System.out.print("ID: ");
                    String idtrem = input.next();

                    System.out.println("\nVocê gostaria de:");
                    System.out.println("1 - Engatar Locomotiva;");
                    System.out.println("2 - Engatar Vagão;");
                    System.out.println("3 - Desengatar Locomotiva;");
                    System.out.println("4 - Desengatar Vagão;");

                    escolha3 = input.nextInt();
                    switch (escolha3){
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
                            break;
                    }
                    break;
                case 4:
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
                    switch (escolha4){
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
                    break;
                case 5:
                    System.out.println("~~~Opção relacionada a vagões~~~");
                    System.out.println("O que gostaria de fazer?");
                    System.out.println("1 - Criar vagões;");
                    System.out.println("2 - Ver vagões já cadastrados;");
                    System.out.println("3 - Ver capacidade de toneladas do vagão;");
                    System.out.println("4 -  Ver o ID de um vagão;");
                    System.out.println("5- Ver a disponibilidade de um vagão;");
                    System.out.println("6 - Criar composição de vagões;");
                    System.out.println("7 - Enviar composição de vagões para a garagem;");
                    System.out.println("8 - Retirar composição de vagões da garagem;");

                    escolha5 = input.nextInt();
                    switch (escolha5){
                        case 1:
                            System.out.println("Quantos vagões deseja criar?");
                            int quant = input.nextInt();
                            for (int i = 0; i < quant; i++) {
                                vagao.addTrain();
                            }
                            System.out.println(quant + " vagões criados!");
                            break;
                        case 2:
                            System.out.println("Cadastrados:");
                            vagao.getAll();
                            break;
                        case 3:
                            System.out.println(vagao.getAllid());

                            System.out.println("Qual dos vagões deseja ver o id");
                            int temp = vagao.getsize();
                            System.out.printf("Temos %d vagões/n", temp);
                            int index = input.nextInt();
                            vagao.getID(index);
                            break;
                        case 4:
                            System.out.printf("Vagões possuem %f toneladas de capacidade/n", vagao.getCapacity());
                            break;
                        case 5:
                            System.out.println("Insira o id para checar disponibilidade");
                            String id = input.next();
                            System.out.println("Disponibilidade do vagão " + id + ": " + vagao.getAvailability(id));
                            break;
                        case 6:
                            System.out.println("~~~Criar composição de vagões~~~");
                            vagao.createComposition();
                            System.out.println("Composição criada!");
                            break;
                        case 7:
                            vagao.setIdComposition();
                            System.out.println("Composiçao de vagões enviada para garagem!");
                            break;
                        case 8:
                            vagao.getAllIdComposition();
                            System.out.println("Composição retirada da garagem;");
                            break;
                    }
                    break;
                case 8:
                    System.out.println("Opções de Locomotiva");


            }
        }while(escolha != 0);
    }
}
