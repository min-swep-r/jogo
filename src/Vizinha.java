public class Vizinha extends Celula {
    private int minaAoRedor; //vizinha

    //construtor
    public Vizinha() {
        super(); // Chama o construtor da classe pai
        this.minaAoRedor = 0;
    }

    public int getMinaAoRedor() {
        return minaAoRedor;
    }

    public void setMinaAoRedor(int minaAoRedor) {
        this.minaAoRedor = minaAoRedor;
    }
}