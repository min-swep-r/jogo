//Agora é Com o user, ranking em .txt ou um arquivo não editável/protegido, criar os pontos, talvez a thread de tempo, e o gameover
public class User {
    // Atributos
    private String nomeDoUser;

    // Construtor
    public User(String nomeQueSeraInputado) {
        this.nomeDoUser = nomeQueSeraInputado;
    }

    // Métodos, getters e setters, para checkagem / conferencia
    public String getNome() {
        return nomeDoUser;
    }

    public void setNome(String novoNome){
        this.nomeDoUser = novoNome;
    }
}