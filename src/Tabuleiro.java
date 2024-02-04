public class Tabuleiro {
    // Atributos
    private Celula[][] minas;
    private int tempo;

    // Construtor
    public Tabuleiro(int tamanhoX, int tamanhoY) {
        this.minas = new Celula[tamanhoX][tamanhoY];
        this.tempo = 0;

        // Inicializa as células do tabuleiro
        for (int i = 0; i < tamanhoX; i++) {
            for (int j = 0; j < tamanhoY; j++) {
                this.minas[i][j] = new Celula(); // Instancia uma nova célula
            }
        }
    }

    // Métodos
    public void iniciaTab() {
        // Implementação do método
    }

    // Método para lidar com o clique do usuário em uma célula

    public boolean getMina(int linha, int coluna){
        return minas[linha][coluna].minaAqui;
    }

    public void clicarCelula(int linha, int coluna) {
        Celula celulaClicada = minas[linha][coluna];

        // Verificar se a célula já foi revelada ou marcada
        if (!celulaClicada.getRevelado()) {
            // Lógica para revelar a célula ou marcar
            celulaClicada.revelarCelula(); // Método que você precisará implementar na classe Celula
        } else {
            System.out.println("Célula já revelada ou marcada. Escolha outra célula.");
        }
    }

}
