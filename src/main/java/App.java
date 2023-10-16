import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringJoiner;
import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;

public class App {

    /**
     * Lê e retorna todas as Locomotivas criadas
     * @return ArrayList<Locomotiva>
     * @throws FileNotFoundException caso não ache o arquivo
     */
    public static ArrayList<Locomotiva> inicializarLocomotiva() throws FileNotFoundException {
        ArrayList<Locomotiva> locomotivas = new ArrayList<>();
        Scanner fl = new Scanner(new FileReader("src/main/resources/GaragemLocomotivas.csv"));
        String[] aux;
        String temp;
        while (fl.hasNext()){
            temp=fl.next();
            aux = temp.split(";");
            Locomotiva locomotiva = new Locomotiva(aux[0].substring(aux[0].indexOf("=")+1),
                    parseDouble(aux[1].substring(aux[1].indexOf("=")+1)), parseInt(aux[2].substring(aux[2].indexOf("=")+1)));
            locomotivas.add(locomotiva);
        }

        return locomotivas;
    }
    /**
     * Lê e retorna todas os vagões criados
     * @return ArrayList<Vagao>
     * @throws FileNotFoundException caso não ache o arquivo
     */
    public static ArrayList<Vagao> inicializarVagao() throws FileNotFoundException {
        ArrayList<Vagao> vagao = new ArrayList<>();
        Scanner fl = new Scanner(new FileReader("src/main/resources/GaragemVagoes.csv"));
        String[] aux;
        String temp;
        while (fl.hasNext()){
            temp=fl.next();
            aux = temp.split(";");
            Vagao vag = new Vagao(aux[0].substring(aux[0].indexOf("=")+1),
                    parseDouble(aux[1].substring(aux[1].indexOf("=")+1)));
            vagao.add(vag);

        }
        return vagao;
    }



    /**
     * Lê e retorna todas as composições criadas
     * @return ArrayList<Composicao>
     * @throws FileNotFoundException caso não ache o arquivo
     */
    public static ArrayList<Composicao> inicializarComp() throws FileNotFoundException {
        ArrayList<Composicao> comp = new ArrayList<>();
        Scanner fl = new Scanner(new FileReader("src/main/resources/GaragemComposicao.csv"));
        String[] aux;
        String temp;
        while (fl.hasNext()){
            temp=fl.next();
            aux = temp.split(";");
            ArrayList<Vagao> vagoes = new ArrayList<>();
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
                    vagoes.add(vagao);
                }
            }
            Composicao composicao = new Composicao(aux[0], locomotivas, vagoes);
            comp.add(composicao);
        }


        return comp;
    }

    /**
     * Edita/Cria composições
     * @param composicao composição a ser editada
     * @param locomotivas locomotivas ja criadas
     * @param vagoes vagões ja criados
     */
    public static void editarComposicao(Composicao composicao,ArrayList<Locomotiva> locomotivas, ArrayList<Vagao> vagoes) throws PexoMaxExcedidoException, MaxVagoesException {
        Scanner in = new Scanner(System.in);
        System.out.println("Aviso: Para a criação de trens, você apenas poderá engatar locomotivas atrás de " +
                "locomotivas, nunca intercalá-las com os vagões.");
        System.out.println("Você gostaria de:");
        int escolha;
        do {
            System.out.println("1 - Engatar Locomotiva;");
            System.out.println("2 - Engatar Vagão;");
            System.out.println("3 - Desengatar Locomotiva;");
            System.out.println("4 - Desengatar Vagão;");
            System.out.println("5 - Terminar composição");

            escolha = in.nextInt();

            switch (escolha) {
                case 1 -> {
                    for (Locomotiva x :
                            locomotivas) {
                        String hold = new StringJoiner(", ", Vagao.class.getSimpleName() + "[", "]")
                                .add("identificador=" + x.getIdentificador())
                                .add("peso maxima=" + x.getPesoMax())
                                .add("quantidade maxima de vagoes=" + x.getQtdadeMaxVagoes())
                                .toString();
                        System.out.println(hold + ", ");
                    }
                    System.out.println();
                    System.out.println("Quantas locomotivas gostaria de adicionar?");
                    int quantidadeLocomotiva = in.nextInt();
                    for (int i = 0; i < quantidadeLocomotiva; i++) {
                        System.out.println("Qual locomotiva?");
                        String z = in.next();
                        for (Locomotiva x :
                                locomotivas) {
                            if (x.getIdentificador().equals(z)) {
                                composicao.engataLocomotiva(x);
                            }
                        }
                    }
                }
                case 2 -> {
                    for (Vagao x :
                            vagoes) {
                        String hold = new StringJoiner(", ", Vagao.class.getSimpleName() + "[", "]")
                            .add("identificador=" + x.getIdentificador())
                            .add("carga maxima=" + x.getCargaMax())
                            .toString();

                        System.out.printf(hold+ ", ");
                    }
                    System.out.println();
                    System.out.println("Quantos vagoes gostaria de adicionar?");
                    int quantidadeLocomotiva = in.nextInt();
                    for (int i = 0; i < quantidadeLocomotiva; i++) {
                        System.out.println("Qual vagao?");
                        String z = in.next();
                        for (Vagao x :
                                vagoes) {
                            if (x.getIdentificador().equals(z)) {
                                composicao.engataVagao(x);
                            }
                        }
                    }
                }
                case 3 -> {
                    composicao.desengataLocomotiva();
                }
                case 4 -> {
                    composicao.desengataVagao();
                }
                case 5 -> {
                    composicao.setComposition();
                    return;
                }

            }
        }while (escolha != 0);
    }

    public static void main(String[] args) throws FileNotFoundException, PexoMaxExcedidoException, MaxVagoesException {
        Scanner in = new Scanner(System.in);
        ArrayList<Composicao> comp = inicializarComp();
        ArrayList<Vagao> vagoes = inicializarVagao();
        ArrayList<Locomotiva> locomotivas = inicializarLocomotiva();
        int escolha;
        do{
            System.out.println("Bem vindo!");
            System.out.println("o que gostaria de fazer?");
            System.out.println("1 - Compor um trem;");
            System.out.println("2 - Listar Identificadores dos trens;");
            System.out.println("3 - Editar trem;");
            System.out.println("4 - Acessar informações de trens;");
            System.out.println("5 - Criar Locomotiva");
            System.out.println("6 - Criar Vagão");
            System.out.println("0 - Sair");
            escolha = in.nextInt();

            switch (escolha) {
                case 1 -> {
                    System.out.println("~~Composição de trens~~");
                    Composicao composicao = new Composicao();
                    editarComposicao(composicao, locomotivas, vagoes);
                    if (composicao.getQtdadeLocomotivas() != 0) {
                        comp.add(composicao);
                    }
                }
                case 2 -> {
                    System.out.println("~~Listagem de Identificador de trens~~");
                    for (Composicao f :
                            comp) {
                        System.out.println(f.getIdentificador());
                    }
                }
                case 3 -> {
                    System.out.println("~~Edição de trens~~");
                    System.out.println("Qual trem gostaria de modificar?(Confira a aba Listagem para obter os identificadores)");
                    String choice = in.next();
                    for (Composicao f :
                            comp) {
                        if (f.getIdentificador().equals(choice)) {
                            editarComposicao(f, locomotivas, vagoes);
                        }
                    }
                }
                case 4 -> {
                    System.out.println("~~Acessar informação de trens~~");
                    System.out.println("Qual trem você gostaria de se informar?");
                    for (Composicao g : comp) {
                        System.out.println(g.getIdentificador());
                    }
                    String idTrem = in.next();
                    System.out.println("Você gostaria de:");
                    System.out.println("1 - Acessar Id de locomotivas e Vagões;");
                    System.out.println("2 - Ver quantidade de Locomotivas e Vagões;");
                    System.out.println("3 - Ver capacidade total de peso do Trem;");
                    escolha = in.nextInt();
                    Composicao composicao1 = new Composicao();
                    for (Composicao g :
                            comp) {
                        if (g.getIdentificador().equals(idTrem)) {
                            composicao1 = g;
                        }
                    }
                    switch (escolha) {
                        case 1 -> {
                            System.out.println("Identificadores de locomotivas:");
                            for (Locomotiva g :
                                    composicao1.getLocomotivas()) {
                                System.out.printf("%s, ", g.getIdentificador());
                            }
                            for (Vagao g :
                                    composicao1.getVagoes()) {
                                System.out.printf("%s, ", g.getIdentificador());
                            }
                        }
                        case 2 -> System.out.println("Quantidade de locomotivas: "
                                + composicao1.getQtdadeLocomotivas() +
                                "   Quantidade de Vagões: " + composicao1.getQtdadeVagoes());
                        case 3 -> System.out.println(composicao1.getPesoMax());
                    }
                }
                case 5 -> {
                    System.out.print("Defina o peso maximo suportado pela Locomotiva: ");
                    double a = in.nextDouble();
                    System.out.println("Defina a quantidade de vagões que a Locomotiva pode engatar");
                    int b = in.nextInt();
                    Locomotiva temp = new Locomotiva(a, b);
                    locomotivas.add(temp);
                    System.out.printf("Locomotiva: %s adicionado a lista de vagões\n", temp.getIdentificador());
                }
                case 6 -> {
                    System.out.print("Defina a carga maxima do vagão: ");
                    double c = in.nextDouble();
                    Vagao cria = new Vagao(c);
                    vagoes.add(cria);
                    System.out.printf("Vagao: %s adicionado a lista de vagões\n", cria.getIdentificador());
                }

                default -> {
                    System.out.println("Opção não encontrada, tente novamente!");
                }
            }

        }while(escolha != 0);
        for (Vagao a:
             vagoes) {
            a.saveVagoes();
        }
        for (Locomotiva a:
             locomotivas) {
            a.saveLocomotivas();
        }
        for (Composicao a:
             comp) {
            a.saveComposicao();
        }
    }
}
