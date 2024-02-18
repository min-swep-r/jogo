import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextInputDialog;

import java.util.Optional;

public class JogoGUI extends Jogo {

    public JogoGUI(Tabuleiro tableInput, User usuarioInput, int tamXInput, int tamYInput, boolean malukiceInput) {
        super(tableInput, usuarioInput, tamXInput, tamYInput, malukiceInput);
    }

    @Override
    public void iniciaJogo(Jogo jg) {
        // Exibindo uma mensagem de diálogo para iniciar o jogo
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Jogo Iniciado");
        alert.setHeaderText(null);
        alert.setContentText("Jogo Iniciado para " + jg.usuarioObj.getNome() + "!!! Aperte OK para continuar.");
        alert.showAndWait();

        boolean gameOver = false;

        Graphics.printButtonMatrix(jg);
//        do {
//será que n precisa de loop?
//        } while (!gameOver);
    }

}
