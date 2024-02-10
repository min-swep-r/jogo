public class Celula {
    // Atributos da Struct heterogenea. novo typedef (em formato de classe, ainda. será manifestado como objeto)
    private boolean isCelula;
    public boolean minaAqui;
    private boolean minaRevelada;
    private boolean minaMarcada;
    private int minaAoRedor;

    // Construtor
    public Celula() {
        this.isCelula = true;
        this.minaAqui = false;
        this.minaRevelada = false;
        this.minaMarcada = false;
        this.minaAoRedor = 0;
    }

    // Métodos, getters e setters podem ser adicionados conforme necessário

    // Método para revelar a célula

    public boolean getRevelado(){
        return minaAqui;
    }
    public boolean mudarCelula() {
        //coloca true, transformando a celula em mina
        this.minaAqui = true;
        return minaRevelada;
    }

    public boolean temCelula() {return isCelula;}

}
