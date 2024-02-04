import java.util.Scanner;

public class Jogo {
    // Atributos
    public Tabuleiro tableObj;
    public User usuarioObj;
    private int tamXObj;
    private int tamYObj;

    // Construtor
    public Jogo(Tabuleiro tableInput, User usuarioInput, int tamXInput, int tamYInput) {
        this.tableObj = tableInput;
        this.usuarioObj = usuarioInput;
        this.tamXObj = tamXInput;
        this.tamYObj = tamYInput;
    }

    // Métodos
    public void iniciaJogo(Jogo jg) {
        // Colocar o user e o...
        Promptar.cls();
        System.out.println("Jogo Iniciado!!!");

        boolean bound = true;
        //Loop do game
        while (bound) {
            Scanner scr = new Scanner(System.in);
            char var = scr.next().charAt(0);
            bound = Promptar.check(var, jg); //na option que dá false, o loop termina, volta mas nem inicia
        }

    }

    public void verificaJogo() {
        System.out.println("Verificado");
    }

    public void revelaCel() {
        // Impl
    }

    public void marcaCel() {
        // Impl
    }

}
