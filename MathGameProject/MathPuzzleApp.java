import javafx.application.Application;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class MathPuzzleApp extends Application {

    @Override
    public void start(Stage primaryStage) {

        primaryStage.getIcons().add(
            new Image("file:C:\\Users\\mkkha\\OneDrive\\Desktop\\MATH PUZZLE GAME\\MathGameProject\\applogo.png"));

        MathPuzzleHomePage homePage = new MathPuzzleHomePage();
        homePage.start(primaryStage);
    }

    public static void main(String[] args) {
        launch(args);
    }
}