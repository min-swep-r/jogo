public class Jogo {
    // Atributos
    private Tabuleiro tableObj;
    private User usuarioObj;
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
    public void iniciaJogo() {
        // Colocar o user e o...
        System.out.println("Jogo Iniciado");
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
