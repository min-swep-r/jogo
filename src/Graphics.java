import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.geometry.Pos;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;
import javafx.scene.layout.StackPane;

import javafx.scene.image.Image;


public class Graphics extends Application {

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Janela Personalizada");

        // Definindo o ícone da janela
        Image icon = new Image(getClass().getResourceAsStream("icon.png"));
        primaryStage.getIcons().add(icon);

        // Definindo a cor de fundo da janela
        StackPane root = new StackPane();
        root.setStyle("-fx-background-color: lightblue;"); // Cor de fundo da janela
        primaryStage.setScene(new Scene(root, 300, 200));

        // Adicionando um label
        Label label = new Label("Em breve, implementação gráfica");
        root.getChildren().add(label);
        StackPane.setAlignment(label, Pos.CENTER);

        // Criando botão "Iniciar"
        Button button = new Button("Iniciar");

        // Criando layout para o primeiro frame
        VBox vbox1 = new VBox(10);
        vbox1.setAlignment(Pos.CENTER);
        vbox1.getChildren().addAll(label, button);
        root.getChildren().add(vbox1);

        // Eventos do botão ----------------------------------
        button.setOnAction(e -> {
            // Chama o método para exibir o segundo frame, passando a cena do primeiro frame
            segundoFrame(primaryStage, primaryStage.getScene());
        });


        primaryStage.show();
    }

    private void segundoFrame(Stage primaryStage, Scene firstScene) {
        // Criando botão "Voltar"
        Button backButton = new Button("Voltar");
        backButton.setOnAction(e -> {
            // Volta para o primeiro frame
            primaryStage.setScene(firstScene);
        });

        // Criando layout para o segundo frame
        VBox waitFrame = new VBox(10);
        waitFrame.setAlignment(Pos.CENTER);
        waitFrame.getChildren().addAll(new Label("Espere, kkk"), backButton);

        primaryStage.setScene(new Scene(waitFrame, 300, 200));
    }


    public static void openWindow() {
        new Thread(() -> launch(Graphics.class)).start(); // Iniciado como uma função à parte!!!
    }

    public static void main(String[] args) {
        launch(args);
    }
}

