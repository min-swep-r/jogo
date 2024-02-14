import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Ranking {
    public static void salvarRanking(String nomeUsuario, int numeroJogadas) {
        try (FileWriter fileWriter = new FileWriter("ranking.txt", true);
             PrintWriter printWriter = new PrintWriter(fileWriter)) {
            printWriter.println(nomeUsuario + "," + numeroJogadas);
        } catch (IOException e) {
            System.out.println("Erro ao salvar o ranking: " + e.getMessage());
        }
    }

    public void call() {
        System.out.println("Top 10 do Ranking:");
        List<RegistroRanking> ranking = lerRanking();

        // Ordena o ranking pelo número de jogadas (do menor para o maior)
        Collections.sort(ranking);

        // Exibe os 10 primeiros registros do ranking
        int contador = 0;
        for (RegistroRanking registro : ranking) {
            System.out.println((contador + 1) + ". " + registro.getNomeUsuario() + " - " + registro.getNumeroJogadas() + " jogadas");
            contador++;
            if (contador >= 10) {
                break;
            }
        }
    }

    private List<RegistroRanking> lerRanking() {
        List<RegistroRanking> ranking = new ArrayList<>();

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("ranking.txt"))) {
            String linha;
            while ((linha = bufferedReader.readLine()) != null) {
                String[] partes = linha.split(",");
                if (partes.length == 2) {
                    String nomeUsuario = partes[0];
                    int numeroJogadas = Integer.parseInt(partes[1]);
                    ranking.add(new RegistroRanking(nomeUsuario, numeroJogadas));
                }
            }
        } catch (IOException e) {
            System.out.println("Erro ao ler o ranking: " + e.getMessage());
        }

        return ranking;
    }
}
