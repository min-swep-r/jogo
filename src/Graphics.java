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

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.util.Duration;

import javafx.application.Platform;

import javafx.scene.layout.GridPane;





//não focar somente nos graphs, mas pegar a manha.
public class Graphics extends Application {

    // Variável para armazenar o estado de dificuldade
    private int stateDificuldade;

    // Método para definir o estado de dificuldade
    public void setStateDificuldade(int dificuldade) {
        this.stateDificuldade = dificuldade;
    }

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
            iniciarJogo(primaryStage);
        });

        Button configButton = new Button("Config");
        configButton.setOnAction(e -> {
            // Chama o método para definir a dificuldade
            defineDif(primaryStage);
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

    // Método getter para stateDificuldade
    public int getStateDificuldade() {
        return this.stateDificuldade;
    }

    private void defineDif(Stage primaryStage) {
        // Layout para a tela de configuração
        VBox configLayout = new VBox(10);
        configLayout.setAlignment(Pos.CENTER);

        // Botões para escolher a dificuldade
        Button easyButton = new Button("Fácil");
        easyButton.setOnAction(e -> {
            setStateDificuldade(1);
            segundoFrame(primaryStage, primaryStage.getScene());
            exibirMensagemDificuldade(primaryStage, "Fácil");
        });

        Button intermediateButton = new Button("Intermediário");
        intermediateButton.setOnAction(e -> {
            setStateDificuldade(2);
            segundoFrame(primaryStage, primaryStage.getScene());
            exibirMensagemDificuldade(primaryStage, "Intermediário");
        });

        Button hardButton = new Button("Difícil");
        hardButton.setOnAction(e -> {
            setStateDificuldade(3);
            segundoFrame(primaryStage, primaryStage.getScene());
            exibirMensagemDificuldade(primaryStage, "Difícil");
        });

        Button crazyButton = new Button("Maluko");
        crazyButton.setOnAction(e -> {
            setStateDificuldade(4);
            segundoFrame(primaryStage, primaryStage.getScene());
            exibirMensagemDificuldade(primaryStage, "Maluko");
        });

        // Botão para voltar
        Button backButton = new Button("Voltar");
        backButton.setOnAction(e -> segundoFrame(primaryStage, primaryStage.getScene()));

        // Adicionando os botões ao layout
        configLayout.getChildren().addAll(
                new Label("Escolha a dificuldade:"), easyButton, intermediateButton, hardButton, crazyButton, backButton
        );

        // Configurando a cena da tela de configuração
        Scene configScene = new Scene(configLayout, 300, 200);
        primaryStage.setScene(configScene);
    }

    private void exibirMensagemDificuldade(Stage primaryStage, String dificuldade) {
        // Criando uma mensagem para exibir a dificuldade escolhida
        VBox mensagemLayout = new VBox(10);
        mensagemLayout.setAlignment(Pos.CENTER);
        Label mensagemLabel = new Label("Dificuldade escolhida: " + dificuldade);
        mensagemLayout.getChildren().addAll(mensagemLabel);

        // Configurando a cena para exibir a mensagem
        Scene mensagemScene = new Scene(mensagemLayout, 300, 200);
        primaryStage.setScene(mensagemScene);

        // Agendar uma ação para voltar ao menu inicial após 3 segundos (3000 milissegundos)
        Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(3), event -> segundoFrame(primaryStage, primaryStage.getScene())));
        timeline.play();
    }

    private void iniciarJogo(Stage primaryStage) {
        int tamMatrix = 0;
        int numBombas = 0;

        switch (this.stateDificuldade) {
            case 1:
                tamMatrix = 5;
                numBombas = 5;
                break;
            case 2:
                tamMatrix = 7;
                numBombas = 10;
                break;
            case 3:
                tamMatrix = 10;
                numBombas = 13;
                break;
            case 4:
                tamMatrix = 7;
                numBombas = 10;
                break;
            default:
                tamMatrix = 5;
                numBombas = 5;
                break;
        }

        // Instanciando o jogo com os parâmetros configurados
        JogoGUI jg = new JogoGUI(new Tabuleiro(tamMatrix, tamMatrix, numBombas), new User(this.stateDificuldade == 1 ? "Default Fácil" : this.stateDificuldade == 2 ? "Default Intermediário" : this.stateDificuldade == 3 ? "Default Difícil" : this.stateDificuldade == 4 ? "Default Maluko" : "No one"/*um ternário de 2 options, pra... definir o nome*/), tamMatrix, tamMatrix, this.stateDificuldade == 4 ? true : false);
        jg.iniciaJogo(jg);
    }

    // Exibição ------------------------------------------------------------------------------------------------------------------------

    public static void printButtonMatrix(Jogo jg) {
        // Criar uma nova janela

        System.out.println("Jogo iniciado na GUI");
        Stage primaryStage = new Stage();
        primaryStage.setTitle("Jogo");

        // Criar um novo GridPane para organizar os botões
        GridPane gridPane = new GridPane();

        // Iterar sobre todas as células do tabuleiro
        for (int i = 0; i < jg.getTamXObj(); i++) {
            for (int j = 0; j < jg.getTamYObj(); j++) {
                // Acessar a célula atual
                Celula celula = jg.tableObj.getMinaFull(i, j);

                // Criar um novo botão para exibir o conteúdo da célula
                Button button = new Button();

                // Configurar o texto do botão de acordo com o status da célula
                if (celula.getBaneira()) { // Se tiver bandeira
                    button.setText("P");
                } else if (celula.celRevelado()) { // Se já tiver sido revelada
                    if (celula.getRevelado()) { // Se tiver bomba
                        button.setText("X");
                    } else if (celula.getSide() > 0) { // Se tiver número de bombas ao redor
                        button.setText(Integer.toString(celula.getSide()));
                    } else { // Se for vazia
                        button.setText(".");
                    }
                } else { // Se não tiver sido revelada
                    button.setText(" ");
                }

                // Adicionar o botão à grade na posição (i, j)
                gridPane.add(button, i, j);

                // Adicionar um evento de clique ao botão
                int linha = i;
                int coluna = j;
                button.setOnAction(event -> {
                    // Lógica para manipular o clique do botão
                    // Você pode implementar aqui o que acontece quando o botão é clicado
                    // Por exemplo, revelar a célula correspondente (linha, coluna)
                    // ou marcar com uma bandeira, etc.
                });
            }
        }

        // Criar uma cena e adicionar o GridPane a ela
        Scene scene = new Scene(gridPane, 400, 400);

        // Configurar a cena na janela principal
        primaryStage.setScene(scene);

        // Exibir a janela
        Platform.runLater(primaryStage::show);
    }
    // Chamada ------------------------------------------------------------------------------------------------------------------------
    public static void openWindow() {
        new Thread(() -> launch(Graphics.class)).start(); // Iniciado como uma função à parte!!!
    }

    public static void main(String[] args) {
        launch(args);
    }
}

