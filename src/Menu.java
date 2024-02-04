import java.util.Scanner;

public class Menu {
    private int iteraDoObj; //atributo usado pra iterar o switch
    private int stateDificuldade; // Dif inicial. 0 => Facil, 1

    // Construtor
    public Menu(int varQueSerahInputado, int difInicial) {
        this.iteraDoObj = varQueSerahInputado;  // Inicializando itera com um valor padrão, se necessário
        this.stateDificuldade = difInicial;
    }

    // Método para exibir e processar as opções do menu
    public void options() {

        Scanner scanner = new Scanner(System.in);

        //Promptar.cls();

        System.out.println("Menu");
        System.out.println("1. Jogar");
        System.out.println("2. Config");
        System.out.println("3. Ranking");
        System.out.println("4. Sair");

        System.out.print("Escolha uma option: ");
        this.iteraDoObj = scanner.nextInt();

        switch (this.iteraDoObj) {
            case 1:
                Promptar.cls();
                System.out.println("Jogar!");
                //Daqui, vai ser iniciado um jogo, que terá seu user && que terá seu tabuleiro, que terá suas células

                break;
            case 2:
                Promptar.cls();
                System.out.println("Config!"); //Um método do proprio menu
                defineDif();

                break;
            case 3:
                Promptar.cls();
                System.out.println("Ranking!");

                break;
            case 4:
                Promptar.cls();
                System.out.println("Saindo do Game. Ateh logo!");
                System.exit(0);
                break;
            default:
                Promptar.cls();
                System.out.println("Option invalida. Por favor, escolha uma option valida.");
                options();
        }
        // Next logica, caso precise
        scanner.close();
    }

    public void defineDif() {
        //Promptar.cls();

        // I/O

        System.out.println("Escolha a dificuldade:");
        System.out.println("0. Fácil");
        System.out.println("1. Difícil");
        System.out.print("Digite 0 ou 1: ");

        Scanner scr = new Scanner(System.in);
        int escolhaDificuldade = scr.nextInt();

        switch (escolhaDificuldade) {
            case 0:
                this.stateDificuldade = 0;
                System.out.println("Dificuldade definida como Fácil.");
                break;
            case 1:
                this.stateDificuldade = 1;
                System.out.println("Dificuldade definida como Difícil.");
                break;
            default:
                Promptar.cls();
                System.out.println("inválido. Aqui vem o try catch do erro");
                defineDif();
                break;
        }

        // Next lógica, caso precise
        scr.close();
    }
}
