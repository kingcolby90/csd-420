//Colby king module 7 assignment//
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class Module7Assignment extends Application {

    public void start(Stage primaryStage) {

        Circle circle1 = new Circle(50);
        Circle circle2 = new Circle(50);
        Circle circle3 = new Circle(50);
        Circle circle4 = new Circle(50);

        circle1.getStyleClass().add("whiteFillBlackStroke");
        circle2.setId("redGreen");
        circle3.getStyleClass().add("whiteFillBlackStroke");
        circle4.setId("redGreen");

        HBox hbox = new HBox(20, circle1, circle2, circle3, circle4);
        hbox.setStyle("-fx-padding: 20; -fx-alignment: center; -fx-background-color: lightgray;");

        Scene scene = new Scene(hbox, 400, 200);
        scene.getStylesheets().add(getClass().getResource("mystyle.css").toExternalForm());

        primaryStage.setTitle("Styled Circles");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}