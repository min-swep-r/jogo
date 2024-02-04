public class Celula {
    // Atributos da Struct heterogenea. novo typedef (em formato de classe, ainda. será manifestado como objeto)
    public boolean minaAqui;
    private boolean minaRevelada;
    private boolean minaMarcada;
    private int minaAoRedor;

    // Construtor
    public Celula() {
        this.minaAqui = false;
        this.minaRevelada = false;
        this.minaMarcada = false;
        this.minaAoRedor = 0;
    }

    // Métodos, getters e setters podem ser adicionados conforme necessário

    // Método para revelar a célula

    public boolean getRevelado(){
        return minaRevelada;
    }
    public void revelarCelula() {
        minaRevelada = true;
        // Lógica para o que acontece ao revelar a célula
    }

//    public boolean getMina(){
//        return minaAqui;
//    }
    public void setMina() {
        minaAqui = true;
    }
}
