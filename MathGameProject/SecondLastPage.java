import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class SecondLastPage extends MainFile {

    @Override
    public void start(Stage primaryStage) {

        // Create VBox layout
        VBox root = new VBox(20);
        root.setAlignment(Pos.CENTER);
        root.setStyle("-fx-background-color: #6e6e6e;");
        root.setBorder(new Border(new BorderStroke(Color.web("#303030"), BorderStrokeStyle.SOLID, CornerRadii.EMPTY, new BorderWidths(20))));
        
        // Text "Tick Symbol"
        Text tickSymbol = new Text("✔");
        tickSymbol.setFont(Font.font("Arial Black", 170));
        tickSymbol.setStyle("-fx-fill: #303030;");

        // Text "CORRECT"
        Text correctText = new Text("CORRECT");
        correctText.setFont(Font.font("Arial Black", 60));
        correctText.setStyle("-fx-fill: #303030;");

        // Text "Referring to the next level"
        Text referringText = new Text("You are a Genius\n\n");
        referringText.setFont(Font.font("Arial Black", 20));
        referringText.setStyle("-fx-fill: #303030;");

        // Button "Next Level"
        Button nextLevelButton = new Button();
        setShadow(nextLevelButton);

        Text playSymbol = new Text("\u25B7"); // Unicode for play symbol
        playSymbol.setFont(Font.font("Arial", FontWeight.BOLD, 55)); // Set size to 30
        playSymbol.setFill(Color.web("#6e6e6e"));

        // Create the Next Level text
        Text nextLevelText = new Text(" Continue");
        nextLevelText.setFont(Font.font("Arial", FontWeight.BOLD, 30)); // Set size to 20
        nextLevelText.setFill(Color.web("#6e6e6e")); // Set color


        // Create HBox to combine play symbol and text
        HBox buttonContent = new HBox(playSymbol, nextLevelText);
        buttonContent.setAlignment(Pos.CENTER);
        buttonContent.setStyle("-fx-background-color: #303030; -fx-fill: #6e6e6e;");

        nextLevelButton.setPrefSize(250, 70);
        nextLevelButton.setStyle("-fx-background-color: #303030;");
        nextLevelButton.setGraphic(buttonContent);
        nextLevelButton.setOnMouseExited(e -> nextLevelButton.setStyle("-fx-background-color: #303030; -fx-text-fill: grey;"));        
        nextLevelButton.setOnMouseEntered(e -> nextLevelButton.setStyle("-fx-background-color: #262626; -fx-text-fill: grey;"));
        nextLevelButton.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.ENTER) {
                nextLevelButton.fire(); // Simulate button click
            }
        });

        nextLevelButton.setOnAction(e -> {new LastPage().start(primaryStage);
            MathPuzzleLevelPage.setHighestUnlockedLevel(30);
        });

        // Add components to the root layout
        root.getChildren().addAll(tickSymbol, correctText, referringText, nextLevelButton);

        // Create scene
        Scene scene = new Scene(root, 600, 900);

        // Set scene to stage
        primaryStage.setScene(scene);
        primaryStage.setTitle("Continue Page");
        new Level1Page().setPrimarystage(primaryStage);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
