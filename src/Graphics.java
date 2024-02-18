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

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//não focar somente nos graphs, mas pegar a manha.
public class Graphics extends Application {

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("2º EE em LPOO");

        // Definindo o ícone da janela
        Image icon = new Image(getClass().getResourceAsStream("icon.png"));
        primaryStage.getIcons().add(icon);

        // Definindo a cor de fundo da janela
        StackPane root = new StackPane();
        root.setStyle("-fx-background-color: lightblue;"); // Cor de fundo da janela
        primaryStage.setScene(new Scene(root, 300, 200));

        // Adicionando um label
        Label label = new Label("Implementação gráfica");
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

        //botões e ações

        Button jogarButton = new Button("Jogar");
        jogarButton.setOnAction(e -> {
            //nesse espaço, aparentemente, vc pode dizer qual a função de chamada do buton
        });

        Button configButton = new Button("Config");
        configButton.setOnAction(e -> {
            // Impl
        });

        Button rankingButton = new Button("Ranking");
        rankingButton.setOnAction(e -> {
            exibirRanking(primaryStage, firstScene);
        });

        Button backButton = new Button("Voltar");
        backButton.setOnAction(e -> {
            // Volta para o primeiro frame
            primaryStage.setScene(firstScene);
        });

        // Criando layout para o segundo frame
        VBox waitFrame = new VBox(10);
        waitFrame.setAlignment(Pos.CENTER);
        waitFrame.getChildren().addAll(new Label("Campo Minado!"), jogarButton, configButton, rankingButton, backButton);

        primaryStage.setScene(new Scene(waitFrame, 300, 200));
    }


    private void exibirRanking(Stage primaryStage, Scene firstScene) {
        // Criando um layout para exibir o ranking
        VBox rankingLayout = new VBox(10);
        rankingLayout.setAlignment(Pos.CENTER);
        rankingLayout.setStyle("-fx-background-color: #FFC0CB;"); // Definindo o background como vermelho

        //----------------------------
        // Definindo as dimensões da cena do ranking
        Scene rankingScene = new Scene(rankingLayout, 300, 400); // Aumentando a altura para 400 pixels

        // Adicionando um título ao layout
        Label titleLabel = new Label("Top 10 do Ranking:");
        rankingLayout.getChildren().add(titleLabel);
        //----------------------------


        // Obtendo os registros do ranking
        List<RegistroRanking> registros = Ranking.lerRanking();

        // Exibindo os registros no layout
        for (int i = 0; i < Math.min(registros.size(), 10); i++) {
            RegistroRanking registro = registros.get(i);
            Label recordLabel = new Label((i + 1) + ". " + registro.getNomeUsuario() + " - " + registro.getNumeroJogadas() + " jogadas");
            rankingLayout.getChildren().add(recordLabel);
        }

        // Criando um botão "Voltar"
        Button backButton = new Button("Voltar");
        backButton.setOnAction(event -> {
            // Volta para a segunda cena (primeira cena do segundo frame)
            segundoFrame(primaryStage, firstScene); // Passando a primeira cena do segundo frame como parâmetro
        });
        rankingLayout.getChildren().add(backButton);

        // Configurando a cena atual para exibir o ranking
        primaryStage.setScene(rankingScene);
    }




    // Chamada ------------------------------------------------------------------------------------------------------------------------
    public static void openWindow() {
        new Thread(() -> launch(Graphics.class)).start(); // Iniciado como uma função à parte!!!
    }

    public static void main(String[] args) {
        launch(args);
    }
}

