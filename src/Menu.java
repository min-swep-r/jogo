import Suplement.Suply;

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
        //System.out.println("Debug do compile");
        System.out.println("Menu");
        System.out.println("1. Jogar");
        System.out.println("2. Config");
        System.out.println("3. Ranking");
        System.out.println("4. Sair");

        System.out.print("Escolha uma option: ");
        this.iteraDoObj = scanner.nextInt();

        switch (this.iteraDoObj) {
            case 1:
                Suply.cls();
                System.out.println("Jogar!");
                //Daqui, vai ser iniciado um jogo, que terá seu user && que terá seu tabuleiro, que terá suas células

                if (this.stateDificuldade == 1) {
                    int tamMatrix = 5;
                    int numBombas = 5; // Número total de bombas para a dificuldade fácil

                    // Instâncias pra poder get/set
                    Jogo jg = new Jogo(new Tabuleiro(tamMatrix, tamMatrix, numBombas), new User(this.stateDificuldade == 1 ? "Default Fácil" : this.stateDificuldade == 2 ? "Default Intermediário" : this.stateDificuldade == 3 ? "Default Difícil" : this.stateDificuldade == 4 ? "Default Maluko" : "No one"/*um ternário de 2 options, pra... definir o nome*/), tamMatrix, tamMatrix, false);
                    jg.iniciaJogo(jg);
                } else if (this.stateDificuldade == 2) {
                    int tamMatrix = 7;
                    int numBombas = 10; // Número total de bombas para a dificuldade intermediário

                    // Instâncias, com as classes e subclasses e o novo atributo
                    Jogo jg = new Jogo(new Tabuleiro(tamMatrix, tamMatrix, numBombas), new User(this.stateDificuldade == 1 ? "Default Fácil" : this.stateDificuldade == 2 ? "Default Intermediário" : this.stateDificuldade == 3 ? "Default Difícil" : this.stateDificuldade == 4 ? "Default Maluko" : "No one"), tamMatrix, tamMatrix, false);
                    jg.iniciaJogo(jg);
                } else if (this.stateDificuldade == 3) {
                    int tamMatrix = 10;
                    int numBombas = 13; // Número total de bombas para a dificuldade difícil

                    // Instâncias, com as classes e subclasses e o novo atributo
                    Jogo jg = new Jogo(new Tabuleiro(tamMatrix, tamMatrix, numBombas), new User(this.stateDificuldade == 1 ? "Default Fácil" : this.stateDificuldade == 2 ? "Default Intermediário" : this.stateDificuldade == 3 ? "Default Difícil" : this.stateDificuldade == 4 ? "Default Maluko" : "No one"), tamMatrix, tamMatrix, false);
                    jg.iniciaJogo(jg);
                } else if (this.stateDificuldade == 4) {
                    int tamMatrix = 7;
                    int numBombas = 10; // Número total de bombas para a dificuldade Maluka

                    // Instâncias, com as classes e subclasses e o novo atributo
                    Jogo jg = new Jogo(new Tabuleiro(tamMatrix, tamMatrix, numBombas), new User(this.stateDificuldade == 1 ? "Default Fácil" : this.stateDificuldade == 2 ? "Default Intermediário" : this.stateDificuldade == 3 ? "Default Difícil" : this.stateDificuldade == 4 ? "Default Maluko" : "No one"), tamMatrix, tamMatrix, true);
                    jg.iniciaJogo(jg);
                }

                Suply.cls();
                System.out.println("Jogue Novamente!");
                options();


                break;
            case 2:
                Suply.cls();
                System.out.println("Config!"); //Um método do proprio menu
                defineDif();

                break;
            case 3:
                Suply.cls();
                System.out.println("Ranking!");
                Ranking rk = new Ranking();
                rk.call();

                System.out.println("\nPressione Enter para voltar tecla para continuar!");
                Scanner scn = new Scanner(System.in);
                scn.nextLine();
                Suply.cls();
                options(); //GoTo o menu

                break;
            case 4:
                Suply.cls();
                System.out.println("Saindo do Game. Ateh logo!\n");
                System.exit(0);
                break;
            default:
                Suply.cls();
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
        System.out.println("1. Facil");
        System.out.println("2. Intermediário");
        System.out.println("3. Dificil");
        System.out.println("4. CAMPO MINADO MALUCO!");
        System.out.println("5. Voltar");

        System.out.print("Escolha uma option: ");

        Scanner scr = new Scanner(System.in);
        int escolhaDificuldade = scr.nextInt();

        switch (escolhaDificuldade) {
            case 1:
                this.stateDificuldade = 1;
                Suply.cls();
                System.out.println("Dificuldade definida como Fácil.");
                options();
                break;
            case 2:
                this.stateDificuldade = 2;
                Suply.cls();
                System.out.println("Dificuldade definida como Intermediário.");
                options();
                break;
            case 3:
                this.stateDificuldade = 3;
                Suply.cls();
                System.out.println("Dificuldade definida como Difícil.");
                options();
                break;
            case 4:
                this.stateDificuldade = 4;
                Suply.cls();
                System.out.println("Dificuldade definida como MALUKA!");
                options();
                break;
            case 5:
                Suply.cls();
                System.out.println("Wellcome back!");
                options();
            default:
                Suply.cls();
                System.out.println("inválido. Aqui vem o try catch do erro");
                defineDif();
                break;
        }

        scr.close();
    }
}
