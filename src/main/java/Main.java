import java.io.IOException;
import java.util.Scanner;

import static java.lang.Integer.parseInt;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(System.in);
        int escolha;
        int escolha2;
        int escolha3;
        int escolha4;
        do {
            System.out.println("Bem vindo!");
            System.out.println("o que gostaria de fazer?!");
            System.out.println("1 - Criar trem;");
            System.out.println("2 - Listar Identificadores dos trens;");
            System.out.println("3 - Editar trem;");
            System.out.println("4 - Acessar informações de trens;");
            escolha = input.nextInt();

            switch(escolha) {
                case 1:
                    System.out.println("~~~Criação de trens~~~");
                    System.out.println("Aviso: Para a criação de trens, você apenas poderá engatar locomotivas atrás de " +
                            "locomotivas, nunca intercalá-las com os vagões.");
                    System.out.println("Você gostaria de:");
                    System.out.println("1 - Engatar Locomotiva;!");
                    System.out.println("2 - Engatar Vagão;!");
                    escolha2 = input.nextInt();
                    switch (escolha2) {
                        case 1:
                            //adicionar locomotivas
                            break;

                case 2:
                    //adiconar vagoes
                    break;
            }
                case 2:
                    System.out.println("~~~Listagem de Identificador de trens~~~");
                    // metodo de id de trens;
                    break;

                case 3:
                    System.out.println("~~~Edição de trens~~~");
                    System.out.println("Qual trem você gostaria de editar?");
                    // listagem dos trens com seus ids (posicao deles);
                    int idtrem = input.nextInt();
                    System.out.println("Você gostaria de:");
                    System.out.println("1 - Engatar Locomotiva;!");
                    System.out.println("2 - Engatar Vagão;!");
                    System.out.println("3 - Desengatar Locomotiva;!");
                    System.out.println("4 - Desengatar Vagão;!");
                    escolha3 = input.nextInt();
                    switch (escolha3){
                    case 1:
                        //adicionar locomotivas
                        break;

                        case 2:
                            //adiconar vagoes
                            break;

                        case 3:
                            //desengatar locomotiva
                        break;

                        case 4:
                            // desengatar vagao
                    }

                case 4:
                    System.out.println("~~~Acessar informação de trens~~~");
                    System.out.println("Qual trem você gostaria de editar?");
                    // listagem dos trens com seus ids (posicao deles);
                    int idTrem = input.nextInt();

                    System.out.println("Você gostaria de:");
                    System.out.println("1 - Acessar Id de locomotivas e Vagões;!");
                    System.out.println("2 - Ver quantidade de Locomotivas e Vagões;!");
                    System.out.println("3 - Ver capacidade de peso do Trem;!");
                    escolha4 = input.nextInt();
                    switch (escolha4){
                        case 1:
                            //adicionar locomotivas
                            break;

                        case 2:
                            //adiconar vagoes
                            break;

                        case 3:
                            //desengatar locomotiva
                            break;

                        case 4:
                            // desengatar vagao
                    }


            }
        }while(escolha != 0);
    }
}
