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
}