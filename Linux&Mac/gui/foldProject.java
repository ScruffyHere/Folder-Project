import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextInputDialog;
import javafx.scene.control.ButtonType;
import javafx.application.Application;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.GridPane;
import javafx.scene.control.Button;
import javafx.scene.control.Dialog;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.Alert;
import javafx.event.EventHandler;
import javafx.scene.shape.Circle;
import javafx.event.ActionEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.scene.image.*;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.util.Optional;
import java.util.Scanner;
import javafx.geometry.*;
import java.io.*;

public class foldProject extends Application { 

		//making textfields global so any class can use them and get input
	private TextField semesternumberField = new TextField();
	private TextField semesterTextfield = new TextField();
	private TextField[] classDays = new TextField[10];
	String[] folderNames = new String[10];
	String semesterName;

	String[] monthFall = {"1 - August", "2 - September", "3 - October", "4 - November", "5 - December"};
	String[] monthSpring = {"1 - January", "2 - February", "3 - March", "4 - April", "5 - May"};
	String[] monthWeek = {"Week 1", "Week 2", "Week 3", "Week 4"};
    String[] homeworkClasswork = {"Homework", "Classwork"};
    String[] monthSummer = {"1 - June", "2 - July"};

	private int semestermakeNumber;

   @Override 
   public void start (Stage primaryStage)	{

   			//setting the grid of my stage to the center of the stage(window)
   		GridPane pane = new GridPane();
   		pane.setAlignment(Pos.CENTER);

   			//setting the padding, size between the stage and scene
   		pane.setPadding(new Insets(11.5, 12.5, 13.5, 14.5));
   		pane.setHgap(5.5);
   		pane.setVgap(5.5);

   			//creating the objects to go in the first window
   			//First asking for semesters folder name
   		Label semesterLabel = new Label("Type a name for your semester's folder: ");

   			//asking for number of classes taken
   		Label semesterNumber = new Label("Enter the number of classes you're taking");

   			//creating cancel button
   		Button cnclButton = new Button("Cancel");

   			//creating ok button
   		Button okButton = new Button("Ok");

   		CancelHandlerClass buttonCncl = new CancelHandlerClass();
   		cnclButton.setOnAction(buttonCncl);

   			//aligning everything using pane.add
   		pane.add(semesterLabel, 0, 0);
   		pane.add(semesterTextfield, 1, 0);
   		pane.add(semesterNumber, 0, 1);
   		pane.add(semesternumberField, 1, 1);
   		pane.add(cnclButton, 14/4, 2);
   		pane.add(okButton, 2, 2);

   			//aligning buttons
   		pane.setHalignment(cnclButton, HPos.CENTER);
   		pane.setHalignment(okButton, HPos.RIGHT);

   			//adding all pane into the scene object
   		Scene firstWindow = new Scene(pane);

   			//creating the stage
   		Stage myFirstwindow = new Stage();

   		myFirstwindow.getIcons().add(new Image("blank.png"));

   			//setting title message
   		myFirstwindow.setTitle("Type your information in order to create your folder");

   			//setting the scene object to scene
   		myFirstwindow.setScene(firstWindow);

   		okButton.setOnAction(e -> makeFolder(myFirstwindow));

   			//show the stage
   		myFirstwindow.showAndWait();


////////////////////////////////////////////////////////////

   			//Second stage
   		Stage secondWindow = new Stage();

   		secondWindow.getIcons().add(new Image("blank.png"));

   		GridPane pane2 = new GridPane();

   		pane2.setAlignment(Pos.CENTER);

   			//creating cancel button
   		Button cncl1Button = new Button("Cancel");

   			//creating ok button
   		Button ok1Button = new Button("Ok");

   			//setting the padding, size between the stage and scene
   		pane2.setPadding(new Insets(11.5, 12.5, 13.5, 14.5));
   		pane2.setHgap(5.5);
   		pane2.setVgap(5.5);

   		Label[] classLabels = new Label[10];

   		for (int i = 0; i < semestermakeNumber; i++ ) {
   			
   			classLabels[i] = new Label("Type your class' name: ");

   			classDays[i] = new TextField();

   			pane2.add(classLabels[i], 0, i);

   			pane2.add(classDays[i], 1, i);
   		}

		pane2.add(ok1Button, 2, semestermakeNumber + 1);

   		pane2.add(cncl1Button, 14/4, semestermakeNumber + 1);

		ok1Button.setOnAction(e -> makesubFolders(secondWindow));

   		cncl1Button.setOnAction(buttonCncl);

   		Scene mysecondWindow = new Scene(pane2);

   		secondWindow.setTitle("What classes are you taking?");

   		secondWindow.setScene(mysecondWindow);

   		secondWindow.showAndWait();

////////////////////////////////////////////////////////////

   			//third window
   			
   		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setTitle(null);
		alert.setHeaderText(null);
		alert.setContentText("Click on the semester you're currently enrolled in from the following.");

		ButtonType springButton = new ButtonType("Spring");
		ButtonType fallButton = new ButtonType("Fall");
		ButtonType summerButton = new ButtonType("Summer");
		ButtonType cancelButton = new ButtonType("Cancel", ButtonData.CANCEL_CLOSE);

		alert.getButtonTypes().setAll(springButton, fallButton, summerButton, cancelButton);

		Stage stage3 = (Stage) alert.getDialogPane().getScene().getWindow(); 

		stage3.getIcons().add(new Image("blank.png"));

		Optional<ButtonType> result = alert.showAndWait();

		File desktop = new File(System.getProperty("user.home"), "Desktop");

		if (result.get() == springButton){
		    
			for(int i = 0; i < semestermakeNumber; i++) {
                       
            	for(int h = 0; h < monthSpring.length; h++)   {

             	File v = new File(desktop + / + semesterName + / + folderNames[i] + / + monthSpring[h]);
                	v.mkdir();  
            	}                
           	}

           	for (int p = 0; p < semestermakeNumber; p++) {

             	for (int r = 0; r < monthSpring.length; r++)  {

               		for (int b = 0; b < monthWeek.length; b++)  {

                 		File c = new File(desktop + / + semesterName + / + folderNames[p] + / + monthSpring[r] + / + monthWeek[b]);
               			c.mkdir();
               		}
             	}
           	}

           	for (int p = 0; p < semestermakeNumber; p++) {

             	for (int r = 0; r < monthSpring.length; r++)  {

               		for (int b = 0; b < monthWeek.length; b++)  {

                 		for (int g = 0; g < homeworkClasswork.length; g++)  {

                   			File d = new File(desktop + / + semesterName + / + folderNames[p] + / + monthSpring[r] + / + monthWeek[b] + / + homeworkClasswork[g]);
                    		d.mkdir();
                 		}
               		}
             	}
           	}
        }
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		else if (result.get() == fallButton) {

			for(int i = 0; i < semestermakeNumber; i++) {
                       
            	for(int h = 0; h < monthFall.length; h++)   {

             	File v = new File(desktop + / + semesterName + / + folderNames[i] + / + monthFall[h]);
                	v.mkdir();  
            	}                
           	}

           	for (int p = 0; p < semestermakeNumber; p++) {

             	for (int r = 0; r < monthFall.length; r++)  {

               		for (int b = 0; b < monthWeek.length; b++)  {

                 		File c = new File(desktop + / + semesterName + / + folderNames[p] + / + monthFall[r] + / + monthWeek[b]);
               			c.mkdir();
               		}
             	}
           	}

           	for (int p = 0; p < semestermakeNumber; p++) {

             	for (int r = 0; r < monthFall.length; r++)  {

               		for (int b = 0; b < monthWeek.length; b++)  {

                 		for (int g = 0; g < homeworkClasswork.length; g++)  {

                   			File d = new File(desktop + / + semesterName + / + folderNames[p] + / + monthFall[r] + / + monthWeek[b] + / + homeworkClasswork[g]);
                    		d.mkdir();
                 		}
               		}
             	}
           	}
		}
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		else if (result.get() == summerButton) {
			
			for(int i = 0; i < semestermakeNumber; i++) {
                       
            	for(int h = 0; h < monthSummer.length; h++)   {

             	File v = new File(desktop + / + semesterName + / + folderNames[i] + / + monthSummer[h]);
                	v.mkdir();  
            	}                
           	}

           	for (int p = 0; p < semestermakeNumber; p++) {

             	for (int r = 0; r < monthSummer.length; r++)  {

               		for (int b = 0; b < monthWeek.length; b++)  {

                 		File c = new File(desktop + / + semesterName + / + folderNames[p] + / + monthSummer[r] + / + monthWeek[b]);
               			c.mkdir();
               		}
             	}
           	}

           	for (int p = 0; p < semestermakeNumber; p++) {

             	for (int r = 0; r < monthSummer.length; r++)  {

               		for (int b = 0; b < monthWeek.length; b++)  {

                 		for (int g = 0; g < homeworkClasswork.length; g++)  {

                   			File d = new File(desktop + / + semesterName + / + folderNames[p] + / + monthSummer[r] + / + monthWeek[b] + / + homeworkClasswork[g]);
                    		d.mkdir();
                 		}
               		}
             	}
           	}
		}
		else {		    
			System.exit(0);
		}

		GridPane finalPane = new GridPane();
   		finalPane.setAlignment(Pos.CENTER);

   			//setting the padding, size between the stage and scene
   		finalPane.setPadding(new Insets(11.5, 12.5, 13.5, 14.5));
   		finalPane.setHgap(5.5);
   		finalPane.setVgap(5.5);

   		Button finishButton = new Button("Finish!");

   		Label finalMessage = new Label("Thank you for using my program!\nYour folder is ready, and has been saved to your desktop.");

   			//aligning everything using pane.add
   		finalPane.add(finalMessage, 0, 0);
   		finalPane.add(finishButton, 1, 4);
   		finalPane.setAlignment(Pos.CENTER);

   			//adding all pane into the scene object
   		Scene lastWindow = new Scene(finalPane);

   			//creating the stage
   		Stage mylastWindow = new Stage();

   		mylastWindow.getIcons().add(new Image("blank.png"));

   			//setting title message
   		mylastWindow.setTitle(null);

   			//setting the scene object to scene
   		mylastWindow.setScene(lastWindow);

   		finishButton.setOnAction(e -> System.exit(0));

   			//show the stage
   		mylastWindow.showAndWait();




   }

   private void makeFolder(Stage stage)	{

   	semesterName = semesterTextfield.getText();

   	semestermakeNumber = Integer.parseInt(semesternumberField.getText());

   	File desktop = new File(System.getProperty("user.home"), "Desktop");

	File f = new File(desktop + / + semesterName + /);

	if (!f.exists()) {
		f.mkdir();
	}

	else  {
		Alert errorMessage = new Alert(AlertType.WARNING);
		errorMessage.setTitle("ERROR!");
		errorMessage.setHeaderText(null);
		errorMessage.setContentText("Directory already exists!");
		errorMessage.showAndWait();
	}

	stage.close();
  }

  private void makesubFolders(Stage stage)	{

  	File desktop = new File(System.getProperty("user.home"), "Desktop");

  	for(int i = 0; i < semestermakeNumber; i++)   {

  		folderNames[i] = classDays[i].getText();

   		File s = new File(desktop + / + semesterName + / + folderNames[i]);

        if(!s.exists())
        	s.mkdir();

        else {
        	Alert errorMessage = new Alert(AlertType.WARNING);
			errorMessage.setTitle("ERROR!");
			errorMessage.setHeaderText(null);
			errorMessage.setContentText("Directory already exists!");
			errorMessage.showAndWait();
        }
    }

  	stage.close();
  }
}

class CancelHandlerClass implements EventHandler<ActionEvent>	{

   	@Override
   	public void handle(ActionEvent e)	{
   		System.exit(0);
   	}
}