import Suplement.Suply;
import java.util.Scanner;

public class Jogo {
    // Atributos
    public Tabuleiro tableObj;
    public User usuarioObj;
    private int tamXObj;
    private int tamYObj;
    private boolean vitoria;

    // Construtor
    public Jogo(Tabuleiro tableInput, User usuarioInput, int tamXInput, int tamYInput) {
        this.tableObj = tableInput;
        this.usuarioObj = usuarioInput;
        this.tamXObj = tamXInput;
        this.tamYObj = tamYInput;
        this.vitoria = false;
    }

    // Métodos
    public void iniciaJogo(Jogo jg) {
        //1System.out.println("Debug 4");
        // Colocar o user e o...
        Suply.cls();
        System.out.println("Jogo Iniciado para " + jg.usuarioObj.getNome() + "!!! Aperte um botão");
        //Promptar.legenda(); tirei daqui e lancei no check
        boolean bound = true;
        boolean bound2 = false;
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

            if (jg.todasCelulasEscavadas()) {
                jg.setVitoria(true); // Define a vitória como verdadeira
                System.out.println("VICTORY!!!!!!!");
                jg.gameOver();
                Ranking.salvarRanking(jg.usuarioObj.getNome(), jg.tableObj.getTempo()); // Chama a função para salvar o ranking
                break; // Sai do loop
            }
        } while (bound && !jg.getVictory());

    }

    public int getTamXObj() {
        return tamXObj;
    }

    public int getTamYObj() {
        return tamYObj;
    }

    public void gameOver2(){
        Suply.cls();
        System.out.println("Acabou! Jogue dnv!!!");
        Suply.pause(5.8);
        Suply.cls();
    }
    public void gameOver() {
        Suply.cls(); // Limpa a tela
        System.out.println("Game Over, voce venceu!!!!!!"); // Exibe a mensagem de "Game Over"
        System.out.println("Pontuação: " + tableObj.getTempo() + "(jogadas)");
        System.out.println("Digite seu nome:");
        Scanner scr = new Scanner(System.in);
        String nomeDoPlayer = scr.nextLine();
        //setar pra depois pegar
        usuarioObj.setNome(nomeDoPlayer);
        Suply.pause(1);

        Suply.cls();
        // Chama o método para salvar o ranking
        Ranking.salvarRanking(usuarioObj.getNome(), tableObj.getTempo());
    }

    public boolean todasCelulasEscavadas() {
        int celulasNaoEscavadas = 0; // Contador para células não escavadas
        int bombas = 0;
        int bandeira = 0;

        // Itera sobre todas as células do tabuleiro
        for (int i = 0; i < tamXObj; i++) {
            for (int j = 0; j < tamYObj; j++) {
                Celula celula = tableObj.getMinaFull(i, j);

                // Verifica se a célula é normal e se foi revelada
                if (celula.temCelula() && !celula.celRevelado() && !celula.getRevelado()) {
                    celulasNaoEscavadas++; // Incrementa o contador
                } else if (celula.temCelula() && celula.getRevelado()) {
                    bombas++;
                } else if (celula.getRevelado() && celula.getBaneira()) {
                    bandeira++;
                }

            }
        }

        // Se houver células não escavadas, mostra a mensagem e retorna falso
        if (celulasNaoEscavadas > 0) {
            System.out.println("Continue jogando. Faltam " + celulasNaoEscavadas + " células e " + bombas + "bombas! e " + bandeira + "bandeiras.");
            return false;
        } else if (bandeira >= 3){
            System.out.println("Pegou " + bandeira + ", acabou!");
            return true;
        } else {return true;}

        // Se todas as células normais estiverem escavadas, retorna verdadeiro

    }

    public boolean getVictory(){
        return this.vitoria;
    }
    public void setVitoria(boolean newStats){
        this.vitoria = newStats;
    }

}
