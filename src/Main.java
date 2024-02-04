// Import de packages
//import java.util

//Primeira chamada
public class Main {
    public static void main(String[] args) {
        System.out.println("Abriu"); //Onde há um " no IntelliJ é pq deu clear no Prompt/ Powershell.
        Promptar.cls();

        System.out.println("Bem vindo!");
        Menu aliasMn = new Menu(0, 0); // Passe um valor inicial para iteraDoObj. o intelliJ já diz qual é o input
        aliasMn.options(); // Chama o método options da instância da classe Menu

    }
}

