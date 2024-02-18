import java.util.Random; //importado com atalho alt+shift+ ENTER
import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class Tabuleiro {
    // Atributos
    private Celula[][] minas;
    private int tempo;
    //Tudo foi removido de jogo e posto no tabuleiro, que é onde as celulas são construidas
    // Certo, esse é o checkpoint, pois daqui tentarei criar a mecanica de bomba e deixar o jogo funcional.
    private int numBombas; // número total de bombas

    // Construtor
    public Tabuleiro(int tamanhoX, int tamanhoY, int numBombas) {
        this.minas = new Celula[tamanhoX][tamanhoY];
        this.tempo = 0;
        this.numBombas = numBombas; // Atribui o número total de bombas

        // Inicializa as células do tabuleiro
        for (int i = 0; i < tamanhoX; i++) {
            for (int j = 0; j < tamanhoY; j++) {
                this.minas[i][j] = new Celula(); // Instancia uma nova célula
            }
        }

        // Uma vez criada, distribui as bombas aleatoriamente
        pingaBomb();
    }

    // Métodos
    public void iniciaTab() {
        // Implementação do método
    }

    // Método para lidar com o clique do usuário em uma célula

    public boolean getMina(int linha, int coluna){
        return minas[linha][coluna].getRevelado();
    }

    public boolean getCelula(int linha, int coluna){
        return minas[linha][coluna].temCelula();
    }

    public boolean setMina(int linha, int coluna) {
        Celula substituta = minas[linha][coluna];
        substituta.mudarCelula(); // Chama a função setMina na Celula
        return true; // Retorna true para indicar que a operação foi bem-sucedida
    }

    // acho que não precisa do get/set do num de bomba
    // Método para distribuir as bombas aleatoriamente
    private void pingaBomb() {
        Random random = new Random();

        int bombasRestantes = numBombas;
        while (bombasRestantes > 0) {
            //pega valores aleatorios, pro par ordenado,a partir do tamanho
            int linha = random.nextInt(minas.length);
            int coluna = random.nextInt(minas[0].length);

            // Verifica se a célula já possui uma bomba
            if (!minas[linha][coluna].minaAqui) {
                minas[linha][coluna].mudarCelula(); // Define a célula como uma bomba, passando pra true
                bombasRestantes--;
                atualizarMinasAoRedor(linha, coluna); // Atualiza as células vizinhas
            }


        }
    }

    private void atualizarMinasAoRedor(int linha, int coluna) {
        for (int i = linha - 1; i <= linha + 1; i++) {
            for (int j = coluna - 1; j <= coluna + 1; j++) {
                // Verifica se as coordenadas estão dentro dos limites do tabuleiro
                if (i >= 0 && i < minas.length && j >= 0 && j < minas[0].length) {
                    // Acessa a célula vizinha
                    Celula vizinha = minas[i][j];
                    // Incrementa o atributo minaAoRedor se a célula não for uma bomba
                    if (!vizinha.minaAqui) {
                        vizinha.putSide();
                    }
                }
            }
        }
    }

    public void zeraSide(Jogo jg) {
        for (int i = 0; i < jg.getTamXObj(); i++) {
            for (int j = 0; j < jg.getTamYObj(); j++) {
                jg.tableObj.minas[i][j].setSide(0);
            }
        }
    }


    public void atualizaAposLoucura(Jogo jg) {
        // Zera o atributo minaAoRedor de todas as células do tabuleiro
        jg.tableObj.zeraSide(jg);

        // Lista para armazenar coordenadas com bombas
        List<int[]> bombCoords = new ArrayList<>();

        // Itera sobre todas as células do tabuleiro para encontrar as coordenadas com bombas
        for (int i = 0; i < jg.tableObj.minas.length; i++) {
            for (int j = 0; j < jg.tableObj.minas[0].length; j++) {
                if (jg.tableObj.minas[i][j].minaAqui) {
                    bombCoords.add(new int[]{i, j});
                }
            }
        }

        // Zera o atributo minaAoRedor de todas as células do tabuleiro
        for (int[] coord : bombCoords) {
            int linha = coord[0];
            int coluna = coord[1];
            jg.tableObj.minas[linha][coluna].setSide(0);
        }

        // Atualiza as células vizinhas das novas bombas
        for (int[] coord : bombCoords) {
            int linha = coord[0];
            int coluna = coord[1];
            jg.tableObj.atualizarMinasAoRedor(linha, coluna);
        }
    }

    public Celula getMinaFull(int linha, int coluna) {
        //ele vai clonar a celula. vou instanciar aqui como um tipo de celula
        return minas[linha][coluna];
    }

    public void incrmenTime(){
        this.tempo += 1;
    }
    public void jogadas(){
        System.out.println("Suas Jogadas: "+this.tempo);
    }

    public int getTempo(){return this.tempo;}
//Para Tabuleiro
}
