import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class MathPuzzleHomePage extends MainFile {

    BorderPane root;
    public MathPuzzleHomePage(){
        root = new BorderPane();
        Label label = new Label();
        root.setCenter(label);
        }


    @Override
    public void start(Stage primaryStage) {
        BorderPane root = new BorderPane();
        setRoot(root);

        // Title
        Text title = new Text("\n\n\n\nMATH GAME");
        title.setFont(Font.font("Arial black", FontWeight.BOLD, 48));
        title.setFill(Color.web("#303030"));
        BorderPane.setAlignment(title, Pos.CENTER);
        root.setTop(title);
        
        // Buttons
        Button playButton = createButton("\u25B7 Play"); setShadow(playButton);
        playButton.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.ENTER) {
                playButton.fire(); 
            }
        });
        Button levelsButton = createButton("    \u2B1C Levels"); setShadow(levelsButton);
        levelsButton.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.ENTER) {
                levelsButton.fire(); 
            }
        });
        Button exitButton = createButton("\u2613 Exit"); setShadow(exitButton);
        exitButton.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.ENTER) {
                exitButton.fire(); 
            }
        });

        playButton.setOnAction(e ->{
            int highest = MathPuzzleLevelPage.getHighestUnlockedLevel();
            if (highest >= 1 && highest <= 30) {
                try {
                    // Use reflection to dynamically create and start the appropriate level page class
                    Class<?> clazz = Class.forName("Level" + highest + "Page");
                    Application levelPage = (Application) clazz.getDeclaredConstructor().newInstance();
                    levelPage.start(primaryStage);
                } catch (Exception ex) {
                    ex.printStackTrace();
                    // Handle exceptions, such as class not found, instantiation issues, etc.
                }
            }
        });
        
        levelsButton.setOnAction(e -> {

            MathPuzzleLevelPage levels = new MathPuzzleLevelPage();
            levels.start(primaryStage);

        });

        exitButton.setOnAction(e -> {
            System.exit(0);
        });
        

        VBox buttonBox = new VBox(20, playButton, levelsButton, exitButton);
        buttonBox.setAlignment(Pos.CENTER);
        root.setCenter(buttonBox);

        Scene scene = new Scene(root, APPLENGTH, APPWIDTH);
        
        primaryStage.setTitle("Math Puzzle");
        primaryStage.setScene(scene);
        new Level1Page().setPrimarystage(primaryStage);
        primaryStage.show();
    }
    
    Button createButton(String text) {
        Button button = new Button(text);
        button.setStyle("-fx-border-color: black;");
        button.setFont(Font.font("Arial", FontWeight.NORMAL, 24));
        button.setTextFill(Color.GRAY);
        button.setPrefWidth(200);
        button.setStyle("-fx-background-color: #303030;");
        button.setOnMouseExited(e -> button.setStyle("-fx-background-color: #303030; -fx-text-fill: grey;"));        
        button.setOnMouseEntered(e -> button.setStyle("-fx-background-color: #262626; -fx-text-fill: grey;"));
        return button;
    }
    public Parent getRoot() {
        return root;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
