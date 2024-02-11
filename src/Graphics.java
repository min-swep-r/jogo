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

public class Graphics extends Application {

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Janela JavaFX");
        Label label = new Label("Em breve, implementação gráfica");
        StackPane root = new StackPane();
        root.getChildren().add(label);
        primaryStage.setScene(new Scene(root, 300, 200));
        primaryStage.show();
    }

    public static void openWindow() {
        new Thread(() -> launch(Graphics.class)).start(); //Iniciado como uma função Á parte!!!
    }

    public static void main(String[] args) {
        launch(args);
    }
}