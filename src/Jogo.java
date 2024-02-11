import java.util.Scanner;
import Suplement.Suply;

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

    // Construtor sobrecarregado para receber o nome do usuário com base no estado de dificuldade
    public Jogo(Tabuleiro tableInput, int stateDificuldade, int tamXInput, int tamYInput) {
        this.tableObj = tableInput;
        this.usuarioObj = new User(stateDificuldade == 1 ? "Default Facil" : "Default Dificil");
        this.tamXObj = tamXInput;
        this.tamYObj = tamYInput;
    }

    // Métodos
    public void iniciaJogo(Jogo jg) {
        System.out.println("Debug 4");
        // Colocar o user e o...
        Suply.cls();
        System.out.println("Jogo Iniciado para " + jg.usuarioObj.getNome() + "!!! Aperte um botão");
        //Promptar.legenda(); tirei daqui e lancei no check
        boolean bound = true;
        //Loop do game
        do {
            Suply.cls();
            Promptar.printMina(jg);
            Promptar.legenda();
            jg.tableObj.jogadas();

            Scanner scr = new Scanner(System.in);
            char var = scr.next().charAt(0);
            bound = Promptar.check(var, jg); //na option que dá false, o loop termina, volta mas nem inicia

            jg.tableObj.incrmenTime();
        }while (bound);

    }

    public int getTamXObj() {
        return tamXObj;
    }

    public int getTamYObj() {
        return tamYObj;
    }

}
