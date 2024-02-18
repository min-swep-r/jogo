import Suplement.Suply;
import java.util.Scanner;
import java.util.Random;
import java.util.ArrayList;
import java.util.List;

public class Jogo {
    // Atributos
    public Tabuleiro tableObj;
    public User usuarioObj;
    private int tamXObj;
    private int tamYObj;
    private boolean vitoria;
    private boolean malukice;

    // Construtor
    public Jogo(Tabuleiro tableInput, User usuarioInput, int tamXInput, int tamYInput, boolean malukiceInput) {
        this.tableObj = tableInput;
        this.usuarioObj = usuarioInput;
        this.tamXObj = tamXInput;
        this.tamYObj = tamYInput;
        this.vitoria = false;
        this.malukice = malukiceInput;
    }

    // Métodos
    public void iniciaJogo(Jogo jg) {
        //System.out.println("Debug 4");
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

            if (jg.getMalukice()){
                System.out.println("\nOlha a malukice...\n");
                mudarBomba(jg);
            }

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
        Suply.pause(1.8);
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
            System.out.println("Continue jogando. Faltam " + celulasNaoEscavadas + " células, " + bombas + " bombas! e " + bandeira + " bandeiras.");
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

    public boolean getMalukice(){return this.malukice;}

    public void mudarBomba(Jogo jg) {
        Random random = new Random();
        int chance = random.nextInt(2); // pra gerar um número aleatório entre 0 e 1 (inclusive)
        if (chance == 0) {
            System.out.println("A Malukice começou");

            // Lista de pares pa armzenar as bombas
            List<int[]> celulasNaoReveladas = new ArrayList<>(); //não consegui fazer array do typedef Celula
            List<int[]> bombaEBandeira = new ArrayList<>();
            //vou mapear as que são bombas, as que são bombas e estão marcadas e as que são celulas e n foram reveladas.
            for (int i = 0; i < jg.getTamXObj(); i++) {
                for (int j = 0; j < jg.getTamYObj(); j++) {
                    Celula celula = jg.tableObj.getMinaFull(i, j);
                    // captura as coord das não
                    if (!celula.getRevelado()) {
                        celulasNaoReveladas.add(new int[]{i, j});
                    }
                    // Verificar se a célula é uma bomba && tem bandeira
                    if (celula.getRevelado() && celula.getBaneira()) { /*Pra debug, basta comentar as bandeias e sair printando*/
                        bombaEBandeira.add(new int[]{i, j});
                    }
                }
            }

            if (!celulasNaoReveladas.isEmpty() && !bombaEBandeira.isEmpty()) { // Verificar se as listastem coisa
                // Selecionar aleatoriamente uma coordenada de célula não revelada (ao puxar um par ord (vetor) do array)
                int[] celulaNaoRevelada = celulasNaoReveladas.get(random.nextInt(celulasNaoReveladas.size()));
                int[] celulaBombaBandeira = bombaEBandeira.get(random.nextInt(bombaEBandeira.size()));

                // Alterar a célula não revelada para ter uma bomba e a baneiada pra não.
                jg.tableObj.getMinaFull(celulaNaoRevelada[0], celulaNaoRevelada[1]).changeBomba(true);
                jg.tableObj.getMinaFull(celulaBombaBandeira[0], celulaBombaBandeira[1]).changeBomba(false);

                System.out.println("\nUma bomba marcada foi mudada de lugar!\n");
            } else {
                System.out.println("\nMalukice não deu certo\n"); //Não há células não reveladas ou células com bomba e bandeira para mudar.
            }
        }
    }



}
