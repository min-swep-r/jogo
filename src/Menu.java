import java.util.Scanner;

public class Menu {
    private int iteraDoObj; //atributo usado pra iterar o switch

    // Construtor
    public Menu(int varQueSerahInputado) {
        this.iteraDoObj = varQueSerahInputado;  // Inicializando itera com um valor padrão, se necessário
    }

    // Método para exibir e processar as opções do menu
    public void options() {

        Scanner scanner = new Scanner(System.in);

        Promptar.cls();

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
                System.out.println("Config!");
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
                System.out.println("Option invalida. Por favor, escolha uma option valida.");
        }
        // Next logica, caso precise
        scanner.close();
    }
}
