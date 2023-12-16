import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.stage.Stage;

public class Main extends Application {

    private static final double INITIAL_START_ANGLE = 30; // Starting angle for mouth
    private static final double INITIAL_LENGTH = 300; // Length of the arc for mouth closed

    @Override
    public void start(Stage primaryStage) {
        // Create the Arc shape for Pac-Man
        Arc pacMan = new Arc(150, 150, 50, 50, INITIAL_START_ANGLE, INITIAL_LENGTH);
        pacMan.setType(ArcType.ROUND);
        pacMan.setFill(Color.YELLOW);

        // Buttons to increase and decrease the mouth opening of Pac-Man
        Button btnIncrease = new Button("+");
        Button btnDecrease = new Button("-");

        // Increase the mouth opening of Pac-Man
        btnIncrease.setOnAction(e -> {
            double currentLength = pacMan.getLength();
            double newLength = Math.min(360, currentLength + 10);
            pacMan.setLength(newLength);
            pacMan.setStartAngle((360 - newLength) / 2);
        });
        
        // Decrease the mouth opening of Pac-Man
        btnDecrease.setOnAction(e -> {
            double currentLength = pacMan.getLength();
            double newLength = Math.max(0, currentLength - 10);
            pacMan.setLength(newLength);
            pacMan.setStartAngle((360 - newLength) / 2);
        });

        // Container for buttons
        HBox buttonsContainer = new HBox(10, btnIncrease, btnDecrease);
        buttonsContainer.setAlignment(Pos.CENTER);

        // Layout for the entire application (Pac-Man and buttons)
        VBox appLayout = new VBox(20);
        appLayout.setAlignment(Pos.CENTER);
        appLayout.getChildren().addAll(pacMan, buttonsContainer);

        Scene scene = new Scene(appLayout, 300, 300);
        
        primaryStage.setTitle("Pac in Wonderland");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
