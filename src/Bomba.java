public class Bomba extends Celula {
    private boolean minaAqui;

    // Construtor
    public Bomba() {
        super(); // Chama o construtor da classe pai (Celula)
        this.minaAqui = true;
    }

    public boolean getRevelado(){
        return minaAqui;
    } //bomba

}