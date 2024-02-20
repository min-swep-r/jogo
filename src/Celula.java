public class Celula {
    // Atributos da Struct heterogenea. novo typedef (em formato de classe, ainda. será manifestado como objeto)
    private boolean isCelula; //Cel
    public boolean minaAqui; //Bomba
    private boolean minaRevelada; //Acho que... de todas
    private boolean minaMarcada; //Cel
    private int minaAoRedor; //vizinha

    // Construtor
    public Celula() {
        this.isCelula = true;
        this.minaAqui = false;
        this.minaRevelada = false;
        this.minaMarcada = false;
        this.minaAoRedor = 0;
    }

    // Métodos, getters e setters podem serão adicionados conforme necessário

    // Método para revelar a célula

    public boolean getRevelado(){
        return minaAqui;
    } //bomba
    public boolean celRevelado(){
        return minaRevelada;
    } //Standard (todas)

    public boolean mudarCelula() {
        //coloca true, transformando a celula em mina
        this.minaAqui = true;
        return minaRevelada;
    } //bomba

    public boolean temCelula() {return isCelula;} //Standard (todas)

    public boolean revelaCelula() {
//        System.out.println("Antes era: "+ this.minaRevelada);
        this.minaRevelada = true;
//        System.out.println("agora é: "+ this.minaRevelada);
        return minaRevelada;
    } //Standard (todas)

    //Para bandeira

    public boolean getBaneira(){
        return minaMarcada;
    } //standard (todas)
    public boolean mudaBandeira() {
        //troca o estado
//        System.out.println("antes a bandeira tava: "+ this.minaMarcada);
        if (minaMarcada){this.minaMarcada = false;} else {this.minaMarcada = true;} //this.atibuto quer dizer "atributo do objeto itself. não de outro objeto"
//        System.out.println("agora a baneira é: "+ this.minaMarcada);
        return minaRevelada;
    } //Standard (todas)

    public void putSide(){this.minaAoRedor++;}
    public int getSide(){return this.minaAoRedor;}
    public void setSide(int newSet) {this.minaAoRedor = newSet;}

    public void changeBomba(boolean newState){this.minaAqui = newState;}
}
//Paara o ponto 1 do checkpoint 2, vou precisar, para TUDO, dizer se é de bomba, arround ou vazia.
//onde no jogo e no promptar tiver celula, vou ter que adequar
//Vamos separar! em: vizinha, bomba e vazio!!! com azio, eu acho que é standard