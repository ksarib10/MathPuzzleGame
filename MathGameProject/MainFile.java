import java.util.function.UnaryOperator;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import javafx.scene.effect.DropShadow;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.util.Duration;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class MainFile extends Application {

    int APPLENGTH = 600;
    int APPWIDTH = 900;

    // Setting up root(Border and background)
    public void setRoot(BorderPane root){
        root.setBackground(new Background(new BackgroundFill(Color.web("#6e6e6e"), null, null)));
        root.setBorder(new javafx.scene.layout.Border(
            new javafx.scene.layout.BorderStroke(
                Color.web("#303030"), // Border Color
                javafx.scene.layout.BorderStrokeStyle.SOLID, // Border Style
                null, // Corner Curve
                new javafx.scene.layout.BorderWidths(20) // Border Width
            )
        ));
    }

    // Setting up Back Button
    public Button createBacButton(BorderPane root, String text){
        Button backButton = new Button(text);
        backButton.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.BACK_SPACE) {
                backButton.fire(); // Simulate button click (For Keyboard)
            }
        });
        backButton.setStyle("-fx-background-color: #303030; -fx-text-fill: grey; -fx-border-color: #303030;");
        backButton.setFont(Font.font("Arial", FontWeight.BOLD, 30));
        backButton.setPrefSize(540, 70);
        backButton.setAlignment(Pos.CENTER_LEFT);
        backButton.setOnMouseExited(e -> backButton.setStyle("-fx-background-color: #303030; -fx-text-fill: grey;"));        
        backButton.setOnMouseEntered(e -> backButton.setStyle("-fx-background-color: #262626; -fx-text-fill: grey;"));
        root.setTop(backButton);
        BorderPane.setAlignment(backButton, Pos.TOP_LEFT);
        BorderPane.setMargin(backButton, new Insets(10));
        setShadow(backButton);

        return backButton;
        }
    

    // Adding a shadow effect to the Button
    public static void setShadow(Button button){
        DropShadow shadow = new DropShadow();
            shadow.setColor(Color.rgb(0, 0, 0, 0.8));
            shadow.setRadius(10);
            shadow.setOffsetX(3);
            shadow.setOffsetY(3);
            button.setEffect(shadow);
    }
    // Adding a shadow effect to the ImageView
    public static void setShadow(ImageView image) {
        DropShadow shadow = new DropShadow();
            shadow.setColor(Color.rgb(0, 0, 0, 0.8));
            shadow.setRadius(10);
            shadow.setOffsetX(0);
            shadow.setOffsetY(0);
            image.setEffect(shadow);
    }
    // Adding a shadow effect to the TextField
    public static void setShadow(TextField textField){
        DropShadow shadow = new DropShadow();
            shadow.setColor(Color.rgb(0, 0, 0, 0.8));
            shadow.setRadius(10);
            shadow.setOffsetX(3);
            shadow.setOffsetY(3);
            textField.setEffect(shadow);
    }

    public void setBckButAction(Stage ownerStage){
        MathPuzzleLevelPage page = new MathPuzzleLevelPage(); page.start(ownerStage);
    }

    // Setting up image to the center of the page
    public void setImage(BorderPane root, ImageView imageView) {
        imageView.setFitHeight(375); imageView.setFitWidth(390);
        root.setCenter(imageView);}

    // Setting up Main bottom grid
    public void setMainBottomgrid(GridPane mainGrid){
        mainGrid.setVgap(0);
        mainGrid.setHgap(0);
        mainGrid.setPadding(new Insets(10));
    }


    // Setting up Grid1 (Wrong Answer Try Again wali grid)
    public void setGrid1(GridPane grid1){
        grid1.setHgap(10);
        grid1.setVgap(10);
        grid1.setAlignment(Pos.CENTER);
        grid1.setPadding(new javafx.geometry.Insets(0, 175, 0, 175));
    }
    
    // Setting up Grid1 TextField(jahan popup ayega)
    public void setGrid1TextField(GridPane grid1, TextField textField){
        textField.setPrefHeight(70); textField.setPrefWidth(560);
        textField.setStyle("-fx-text-fill: #303030;-fx-control-inner-background: #6e6e6e; -fx-border-color: #6e6e6e; -fx-text-alignment: center;");
        textField.setEditable(false);
        grid1.add(textField, 0, 0);
    }

    
    // Setting up Grid 2 of the Main Grid that includes Answer area and clear, hint and enter button
    public void setGrid2(Stage ownerStage, GridPane grid2, TextField textField ,TextField answerTextArea, 
     Button clearButton, Button hintButton, Button enterButton, UnaryOperator<TextFormatter.Change> filter,
     String hinturl, String levelAns, int nextcount){


        grid2.setHgap(10);
        grid2.setVgap(10);
    
        answerTextArea.setPromptText("Answer");
        answerTextArea.setStyle("-fx-text-alignment: bottom;");
        answerTextArea.setPrefHeight(70); answerTextArea.setPrefWidth(250);
        answerTextArea.setStyle("-fx-prompt-text-fill: grey; -fx-control-inner-background: #303030; -fx-text-fill: #ababab; -fx-border-color: transparent;");
        answerTextArea.setFont(Font.font("Arial", FontWeight.BOLD, 25));
        TextFormatter<Integer> textFormatter = new TextFormatter<Integer>(filter);
        answerTextArea.setTextFormatter(textFormatter);
        answerTextArea.setOnMouseExited(e -> answerTextArea.setStyle("-fx-background-color: #303030; -fx-text-fill: grey;"));        
        answerTextArea.setOnMouseEntered(e -> answerTextArea.setStyle("-fx-background-color: #262626; -fx-text-fill: grey;"));
        setShadow(answerTextArea);
        answerTextArea.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.ENTER) {
                enterButton.fire(); // Simulate button click (For Keyboard)
            }
        });


        setShadow(hintButton);
        hintButton.setPrefHeight(70); hintButton.setPrefWidth(80);
        hintButton.setStyle("-fx-background-color: #303030; -fx-text-fill: grey; -fx-border-color: #303030;");
        hintButton.setOnMouseExited(e -> hintButton.setStyle("-fx-background-color: #303030; -fx-text-fill: grey;"));
        hintButton.setOnMouseEntered(e -> hintButton.setStyle("-fx-background-color: #262626; -fx-text-fill: grey;"));
        hintButton.setFont(Font.font("Arial", FontWeight.BOLD, 25));
        hintButton.setOnAction(e -> {showPopup(ownerStage, hinturl);});
        hintButton.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.ENTER) {
                hintButton.fire(); // Simulate button click (For Keyboard)
            }
            });

        setShadow(clearButton);
        
        clearButton.setPrefHeight(70); clearButton.setPrefWidth(80);
        clearButton.setStyle("-fx-background-color: #303030; -fx-text-fill: grey; -fx-border-color: #303030;");
        clearButton.setOnMouseExited(e -> clearButton.setStyle("-fx-background-color: #303030; -fx-text-fill: grey;"));
        clearButton.setOnMouseEntered(e -> clearButton.setStyle("-fx-background-color: #262626; -fx-text-fill: grey;"));
        clearButton.setFont(Font.font("Arial", FontWeight.BOLD, 25));
        clearButton.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.ENTER) {
                clearButton.fire(); // Simulate button click (For Keyboard)
            }
            });
        clearButton.setOnAction(event -> {
            try {
                String className = "Level" + (nextcount-1) + "Page";
                Class<?> curClass = Class.forName(className);
                Application level = (Application) curClass.getDeclaredConstructor().newInstance();
                level.start(ownerStage);
            } catch (Exception e) {
                e.printStackTrace();
                throw new IllegalStateException("Unexpected value: " + nextcount);
            }
        });

        setShadow(enterButton);
        enterButton.setPrefHeight(70); enterButton.setPrefWidth(150);
        enterButton.setStyle("-fx-background-color: #303030; -fx-text-fill: grey; -fx-border-color: #303030;");
        enterButton.setOnMouseExited(e -> enterButton.setStyle("-fx-background-color: #303030; -fx-text-fill: grey;"));
        enterButton.setOnMouseEntered(e -> enterButton.setStyle("-fx-background-color: #262626; -fx-text-fill: grey;"));
        enterButton.setFont(Font.font("Arial", FontWeight.BOLD, 25));
        
        enterButton.setOnAction(event -> {
            String answer = String.valueOf(answerTextArea.getText()); 
            if (!answer.equals(levelAns)) {
                textField.setText("Wrong answer! Try again!");
                Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(1), e -> textField.clear()));
                timeline.play();
        
                Timeline timeline2 = new Timeline(new KeyFrame(Duration.seconds(1), e -> {
                    try {
                        String className = "Level" + (nextcount-1) + "Page";
                        Class<?> clazz = Class.forName(className);
                        Application levelPage = (Application) clazz.getDeclaredConstructor().newInstance();
                        levelPage.start(ownerStage);
                    } catch (Exception ex) {
                        ex.printStackTrace();
                        throw new IllegalStateException("Unexpected value: " + nextcount, ex);
                }
                }));
                timeline2.play();
                }
        else{
            completeLevel(ownerStage, nextcount);
            if (nextcount > 1 && nextcount < 31) {
                ContinuePage continuepage = new ContinuePage(nextcount);
                continuepage.start(ownerStage);}
            else {new SecondLastPage().start(ownerStage);}
        }
            }
        );
    }
    public void completeLevel(Stage primaryStage, int nextcount) {
        // Call this method when the player completes the level
        MathPuzzleLevelPage.setHighestUnlockedLevel(nextcount);
        // Optionally, navigate back to the levels page or go to the next level
        new MathPuzzleLevelPage().start(primaryStage);
    }

    // Setting of Grid 3 of Main Grid that consist of 0 to 9 number buttons 
    public void setGrid3(GridPane grid3, TextField answerTextArea){

        grid3.setHgap(10);
        grid3.setVgap(10);

        // Add Numeric Buttons
        String text;
        for (int i = 0; i < 10; i++) {
            if (i < 9){text = String.valueOf(i+1);}
            else{text = "0";}
            
            Button button = new Button(text);
            setShadow(button);
            button.setStyle("-fx-background-color: #303030; -fx-text-fill: grey; -fx-border-color: #303030;");
            button.setOnMouseExited(e -> button.setStyle("-fx-background-color: #303030; -fx-text-fill: grey;"));
            button.setOnMouseEntered(e -> button.setStyle("-fx-background-color: #262626; -fx-text-fill: grey;"));
            button.setPrefSize(100, 100);
            button.setFont(Font.font("Arial", FontWeight.BOLD, 30));
            grid3.add(button, (i+5) % 5, (i+5) / 5);
            button.setOnKeyPressed(event -> {
                if (event.getCode() == KeyCode.ENTER) {
                    button.fire(); 
                }
            });
            button.setOnAction(event -> {
                String currentText = answerTextArea.getText();
                if (currentText.length() <= 7) {
                    answerTextArea.appendText(button.getText());
                }
            });
        }
    }
    
    public void setPrimarystage(Stage ownerStage) {
        ownerStage.setMinWidth(600);
        ownerStage.setMaxWidth(620);
        ownerStage.setMinHeight(900);
        ownerStage.setMaxHeight(930);
        ownerStage.setResizable(false);
        ownerStage.setMaximized(false);

    }

    public void showPopup(Stage ownerStage, String hintUrl) {
        Stage popupStage = new Stage();
        popupStage.initModality(Modality.APPLICATION_MODAL);
        popupStage.initOwner(ownerStage);

        VBox popupRoot = new VBox(20);
        popupRoot.setAlignment(Pos.CENTER);
        popupRoot.setPadding(new Insets(20));
        popupRoot.setBackground(new Background(new BackgroundFill(Color.web("#6e6e6e"), null, null)));

        Text popupText = new Text("Need Help?");
        popupText.setFont(Font.font("Arial", FontWeight.BOLD, 32));
        popupText.setFill(Color.web("#303030"));

        ImageView popupImageView = new ImageView(new Image(hintUrl));
        setShadow(popupImageView);
        popupImageView.setFitHeight(200);
        popupImageView.setFitWidth(200);

        Button backButton = new Button("Back");
        setShadow(backButton);
        backButton.setStyle("-fx-background-color: #303030; -fx-text-fill: grey; -fx-border-color: #303030;");
        backButton.setFont(Font.font("Arial", FontWeight.BOLD, 20));
        backButton.setPrefSize(100, 50);
        backButton.setOnMouseExited(e -> backButton.setStyle("-fx-background-color: #303030; -fx-text-fill: grey;"));
        backButton.setOnMouseEntered(e -> backButton.setStyle("-fx-background-color: #262626; -fx-text-fill: grey;"));
        backButton.setOnAction(e -> popupStage.close());
        backButton.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.BACK_SPACE) {
                backButton.fire(); 
            }
        });

        popupRoot.getChildren().addAll(popupText, popupImageView, backButton);

        Scene popupScene = new Scene(popupRoot, 400, 400);
        popupStage.setScene(popupScene);
        popupStage.setTitle("Hint");
        popupStage.show();
    }
        // Just for the application
        
    public void start(Stage primaryStage) {}
    public static void main(String[] args) {
        launch(args);
    }
}
