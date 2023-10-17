package application;
	
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import java.util.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;

public class Main extends Application {
	
	Random random = new Random();
	int number = random.nextInt(1, 101);
    int chances = 2;
	@Override
	public void start(Stage primaryStage) {
		primaryStage.setTitle("Guessing Game");
		
		Label Tittle = new Label("Number Guessing Game");
		Tittle.setId("ttle");
		
		Button gen = new Button("START");
		gen.getStyleClass().add("btn");
		gen.setOnAction(e -> generate());
		
		VBox f = new VBox(20);
		f.setAlignment(Pos.CENTER);
		f.getChildren().addAll(Tittle,gen);
		
		Scene rootScene = new Scene(f,400,200);
		rootScene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		primaryStage.setScene(rootScene);
		primaryStage.show();
	}
	
	public void generate() 
	{

        Stage tempStage = new Stage();
        VBox tempLayout = new VBox(10);

        Label numberLabel = new Label("Enter the Guessed Number (1-100)");
        TextField inputField = new TextField();
        numberLabel.setId("Lbl");
        
        Button checkButton = new Button("Check");
        checkButton.getStyleClass().add("btn");
        checkButton.setOnAction(e -> checkGuess(inputField.getText(), tempStage, tempLayout));

        tempLayout.getChildren().addAll(numberLabel, inputField, checkButton);
        tempLayout.setAlignment(Pos.CENTER);
        Scene tempScene = new Scene(tempLayout, 500, 300);
        tempScene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
        tempStage.setScene(tempScene);
        tempStage.show();
    }

    public void checkGuess(String input, Stage tempStage, VBox tempLayout) 
    {
        if (chances > 0) 
        {
            try
            {
                int guess = Integer.parseInt(input);

                Label resultLabel = new Label("");
                resultLabel.getStyleClass().add("RES");
                
                if (guess == number) 
                {
                	resultLabel.getStyleClass().add("RES");
                    resultLabel = new Label("Congratulations! Your guess is correct. The number is: " + number);
                    tempLayout.getChildren().add(resultLabel);
                    chances = 0;
                }
                else if (guess < number) 
                {
                	resultLabel.getStyleClass().add("RES");
                    resultLabel = new Label("Try a higher number.");
                } 
                else
                {
                	resultLabel.getStyleClass().add("RES");
                    resultLabel = new Label("Try a lower number.");
                }
                tempLayout.getChildren().add(resultLabel);
                chances--;
            } 
            catch (NumberFormatException e) {
                Label errorLabel = new Label("Invalid input. Please enter a valid number.");
                errorLabel.getStyleClass().add("RES");
                tempLayout.getChildren().add(errorLabel);
            }
        }
        else
        {
        	Label FinalLabel = new Label("The Number is: "+number+"\nTRY HARDER!!!");
            FinalLabel.getStyleClass().add("RES");
        	tempLayout.getChildren().add(FinalLabel);
        }
        if(chances < 0)
        {
            tempStage.close();
        }
    }
	public static void main(String[] args) {
		launch(args);
	}
}
