import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class LastPage extends MainFile {

    MathPuzzleHomePage mainpage = new MathPuzzleHomePage();

    public void start(Stage primaryStage) {
        // Create the main layout
        BorderPane root = new BorderPane();
        
        setRoot(root);

        
        Text thankYou = new Text("Thank You for Playing!");
        setTextt(thankYou);

        Button space0 = new Button();
        space0.setStyle("-fx-background-color: #6e6e6e; -fx-border-color: #6e6e6e;");
        space0.setPrefWidth(200);  
        space0.setDisable(true);      


        Button playAgain = mainpage.createButton("Restart?"); setShadow(playAgain);

        playAgain.setOnAction(e -> {
            showPopUp(primaryStage);
        });
        
        Button exitButton = mainpage.createButton("\u2613 Exit"); setShadow(exitButton);
        exitButton.setOnAction(e -> {
            System.exit(0);
        });

        // Just to create a space between thank you and exit button
        TextField space = new TextField();
        space.setPrefSize(20, 40);
        space.setStyle("-fx-background-Color: #6e6e6e");
        space.setEditable(false);

        VBox vBox = new VBox();
        vBox.getChildren().add(thankYou);
        vBox.getChildren().add(space);
        vBox.getChildren().add(playAgain);
        vBox.getChildren().add(space0);
        vBox.getChildren().add(exitButton);
        vBox.setAlignment(Pos.CENTER);

        // Create and style the author label
        Text author = new Text("\t\t\t\tMade By: Sarib Khan");
        setTextt(author);
        author.setFont(new Font("Arial Black", 25));

        
        root.setCenter(vBox);

        root.setTop(author);

        // Create the scene
        Scene scene = new Scene(root, 600, 900);
        
        // Set the scene to the stage
        primaryStage.setScene(scene);
        primaryStage.setTitle("Last Page");
        new Level1Page().setPrimarystage(primaryStage);
        primaryStage.show();
    }
    public void setTextt(Text text) {
        text.setFont(new Font("Arial Black", 35));
        text.setFill(Color.web("#303030"));
        text.setTextAlignment(TextAlignment.CENTER);

    }
    public void showPopUp(Stage ownerStage) {
        Stage popupStage = new Stage();
        popupStage.initModality(Modality.APPLICATION_MODAL);
        popupStage.initOwner(ownerStage);

        VBox popupRoot = new VBox(20);
        popupRoot.setAlignment(Pos.CENTER);
        popupRoot.setPadding(new Insets(20));
        popupRoot.setBackground(new Background(new BackgroundFill(Color.web("#666666"), null, null)));

        Text popupText = new Text("Restart from level 1?");
        popupText.setFont(Font.font("Arial", FontWeight.BOLD, 32));
        popupText.setFill(Color.web("#303030"));

        Button confirmButton = new Button("Confirm");
        setShadow(confirmButton);
        confirmButton.setStyle("-fx-background-color: #303030; -fx-text-fill: grey; -fx-border-color: black;");
        confirmButton.setFont(Font.font("Arial", FontWeight.BOLD, 20));
        confirmButton.setPrefSize(200, 50);
        confirmButton.setOnMouseExited(e -> confirmButton.setStyle("-fx-background-color: #303030; -fx-text-fill: grey;"));
        confirmButton.setOnMouseEntered(e -> confirmButton.setStyle("-fx-background-color: #262626; -fx-text-fill: grey;"));
        confirmButton.setOnAction(e -> {

            MathPuzzleLevelPage.setHighestUnlockedLevel(1);
            popupStage.close();
            Level1Page level1 = new Level1Page();
            level1.start(ownerStage);});


        Button backButton = new Button("Back");
        setShadow(backButton);
        backButton.setStyle("-fx-background-color: #303030; -fx-text-fill: grey; -fx-border-color: black;");
        backButton.setFont(Font.font("Arial", FontWeight.BOLD, 20));
        backButton.setPrefSize(200, 50);
        backButton.setOnMouseExited(e -> backButton.setStyle("-fx-background-color: #303030; -fx-text-fill: grey;"));
        backButton.setOnMouseEntered(e -> backButton.setStyle("-fx-background-color: #262626; -fx-text-fill: grey;"));
        backButton.setOnAction(e -> {popupStage.close();});
        

        popupRoot.getChildren().add(confirmButton);
        popupRoot.getChildren().add(backButton);

        Scene popupScene = new Scene(popupRoot, 500, 400);
        popupStage.setScene(popupScene);
        popupStage.setTitle("Confirm");
        popupStage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
}
