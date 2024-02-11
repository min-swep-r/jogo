public class Bomba extends Celula {
    private boolean minaAqui;

    // Construtor
    public Bomba() {
        super(); // Chama o construtor da classe pai (Celula)
        this.minaAqui = false;
    }

    public boolean getRevelado(){
        return minaAqui;
    } //bomba

//    @Override
//    public boolean mudarCelula() {
//        super.mudarCelula();
//        this.minaAqui = true;
//        return minaRevelada;
//    }

}