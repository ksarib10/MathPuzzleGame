import java.util.function.UnaryOperator;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Level19Page extends MainFile {

    final private String bBText = "<\t\t     LEVEL 19";
    final private String imgURL = "pics/level19Image.jpg";
    final private String hintURL = "pics/hint19.jpg";
    final private String level3Ans = "2329";
    final private String level3Title = "Math Puzzle - Level 19";
    
    final private int nextLvlCount = 20;

    @Override
    public void start(Stage primaryStage) {

    // Setting up Structure
        BorderPane root = new BorderPane();
        setRoot(root);

    // Top Back Button
        Button backButton = createBacButton(root, bBText);
        backButton.setOnAction(e -> setBckButAction(primaryStage));

    // Setting up Image
        ImageView imageView = new ImageView(new Image(imgURL));
        setShadow(imageView);
        setImage(root, imageView);
        
    // Setting up Main bottom grid
        GridPane bottomGridMain = new GridPane();
        setMainBottomgrid(bottomGridMain);

    // Setting up Grid1 (Wrong Answer Try Again wali grid)
        GridPane grid1 = new GridPane();
        setGrid1(grid1);

    // Setting up Grid1 TextField(jahan popup ayega)
        TextField textField = new TextField();
        setGrid1TextField(grid1, textField);

    // Adding Grid1 to the Main Grid at postion --> col 1, row 0
        bottomGridMain.add(grid1, 1, 0);
 
       
/*  Setting up Grid 2 that includes answer text area, messageLabel, clear button,
    hint button and enter button and a filter variable for specified input(text formatting)
*/
        GridPane grid2 = new GridPane();
        TextField answerTextArea = new TextField(); 
        
        // Specifying the text to integer and max lenght of 7
        UnaryOperator<TextFormatter.Change> filter = change -> {
            String newText = change.getControlNewText();
            if (newText.matches("\\d*") && newText.length() <= 7) {return change;}
            return null;
        };

    // Creating Hint Button
        Button hintButton = new Button("💡");  

    // Creating Clear Button
        Button clearButton = new Button("\u2613");
        
    // Creating Enter Button
        Button enterButton = new Button("ENTER");
        
    // Setting up Grid 2 of the Main Grid that includes Answer area and clear, hint and enter button
    setGrid2(primaryStage, grid2, textField, answerTextArea, clearButton, 
    hintButton, enterButton, filter, hintURL, level3Ans, nextLvlCount);

    grid2.add(answerTextArea, 1, 0);
    grid2.add(clearButton, 2, 0);
    grid2.add(hintButton, 3, 0);
    grid2.add(enterButton, 4, 0);

    bottomGridMain.add(grid2, 1, 1);

    // Bottom Section (10 Buttons and Numeric Buttons)
    GridPane grid3 = new GridPane();
    
    setGrid3(grid3, answerTextArea);

    bottomGridMain.add(grid3, 1, 2);

    root.setBottom(bottomGridMain);
    // Create the scene
    Scene scene = new Scene(root, 600, 900);

    // Set the scene to the stage
    primaryStage.setScene(scene);
    primaryStage.setTitle(level3Title);
    new Level1Page().setPrimarystage(primaryStage);
    primaryStage.show();

    // To be used without selecting it.
    answerTextArea.requestFocus();
}
    public static void main(String[] args) {
        launch(args);
    }
}

