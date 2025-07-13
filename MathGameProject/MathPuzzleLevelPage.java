import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class MathPuzzleLevelPage extends MainFile {

    private static final String FILE_NAME = "highestLevel.txt";

    public static int getHighestUnlockedLevel() {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            return Integer.parseInt(reader.readLine());
        } catch (IOException | NumberFormatException e) {
            return 1; // Default to level 1 if file is not found or corrupt
        }
    }

    public static void setHighestUnlockedLevel(int level) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {
            writer.append(Integer.toString(level));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void start(Stage primaryStage) {
        BorderPane root = new BorderPane();
        setRoot(root);

        // Top Left Button
        Button backButton = createBacButton(root, "<\t\t      LEVELS");
        backButton.setOnAction(e -> {
            MathPuzzleHomePage mainpage = new MathPuzzleHomePage();
            mainpage.start(primaryStage);
        });

        // Grid for Level Buttons
        GridPane gridPane = new GridPane();
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setHgap(10); gridPane.setVgap(10);
        gridPane.setPadding(new Insets(50));

        int highestUnlockedLevel = MathPuzzleLevelPage.getHighestUnlockedLevel();

        // Adding Level Buttons
        for (int i = 1; i <= 30; i++) {
            Button levelButton = new Button(String.valueOf(i));
            setShadow(levelButton);
            levelButton.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.ENTER) {
                levelButton.fire(); 
            }
            });
            levelButton.setStyle("-fx-background-color: #303030; -fx-text-fill: grey; -fx-border-color: #303030;");
            levelButton.setPrefSize(120, 120);
            levelButton.setFont(Font.font("Arial", FontWeight.BOLD, 30));
            levelButton.setOnMouseExited(e -> levelButton.setStyle("-fx-background-color: #303030; -fx-text-fill: grey;"));
            levelButton.setOnMouseEntered(e -> levelButton.setStyle("-fx-background-color: #262626; -fx-text-fill: grey;"));
            gridPane.add(levelButton, (i-1) % 5, (i-1) / 5);
            setDirection(levelButton, i, primaryStage);

            if (i > highestUnlockedLevel) {
                levelButton.setDisable(true);
            }
        }

        root.setCenter(gridPane);

        Scene scene = new Scene(root, 600, 900);
        primaryStage.setTitle("Math Puzzle - Levels");
        primaryStage.setScene(scene);
        new Level1Page().setPrimarystage(primaryStage);
        primaryStage.show();
    }

    // Setting their directions to their specific levels
    public static void setDirection(Button button, int level, Stage primaryStage) {
        button.setOnAction(event -> {
            try {
                String className = "Level" + level + "Page";
                Class<?> levelClass = Class.forName(className);
                Application levelPage = (Application) levelClass.getDeclaredConstructor().newInstance();
                levelPage.start(primaryStage);
            }
            catch (Exception e){
                e.printStackTrace();
                throw new IllegalStateException("Unexpected Level");
            }
        });
    }
    public static void main(String[] args) {
        launch(args);
    }
}
