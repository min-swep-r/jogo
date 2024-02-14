public class RegistroRanking implements Comparable<RegistroRanking> {
    private String nomeUsuario;
    private int numeroJogadas;

    public RegistroRanking(String nomeUsuario, int numeroJogadas) {
        this.nomeUsuario = nomeUsuario;
        this.numeroJogadas = numeroJogadas;
    }

    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public int getNumeroJogadas() {
        return numeroJogadas;
    }

    @Override
    public int compareTo(RegistroRanking outroRegistro) {
        // Ordena pelo número de jogadas (do menor para o maior)
        return Integer.compare(this.numeroJogadas, outroRegistro.numeroJogadas);
    }
}
