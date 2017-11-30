/**
 * Sina Karimi
 *Folder-Project
 *December 30/11/2017
 *time worked: 5pm-10pm
 *Windows 10/Linux
 *This program helps you to be more organized during your school years.
 */
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextInputDialog;
import javafx.scene.control.DialogPane;
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
import javafx.event.EventHandler;
import javafx.scene.shape.Circle;
import javafx.event.ActionEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.StageStyle;
import javafx.stage.Modality;
import javafx.scene.image.*;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.util.Optional;
import java.util.Scanner;
import javafx.geometry.*;
import java.io.*;

public class foldProject extends Application { 

		//Declaring my textfields and setting up an array with 2 variables set as String
		//Setting a limit to 10 classes only per semester
	private TextField semesternumberField = new TextField();
	private TextField semesterTextfield = new TextField();
	private TextField[] classDays = new TextField[10];
	String[] folderNames = new String[10];
	String semesterName;

		//Hard coding all my months for each month of the school year
	String[] monthFall = {"1 - August", "2 - September", "3 - October", "4 - November", "5 - December"};
	String[] monthSpring = {"1 - January", "2 - February", "3 - March", "4 - April", "5 - May"};
	String[] monthWeek = {"Week 1", "Week 2", "Week 3", "Week 4"};
    String[] homeworkClasswork = {"Homework", "Classwork"};
    String[] monthSummer = {"1 - June", "2 - July"};

    	//This variable will be used in for loop to know how big the window should be
    	//according to how many classes the user is taking.
	private int semestermakeNumber;

   @Override 
   public void start (Stage primaryStage)	{

   			//Gridpane object is created and set position to center
   			//First Window
   		GridPane pane = new GridPane();
   		pane.setAlignment(Pos.CENTER);

   			//Setting the padding, gap, and styles of pane
   		pane.setPadding(new Insets(11.5, 12.5, 13.5, 14.5));
   		pane.setHgap(5.5);
   		pane.setVgap(5.5);
      	pane.getStylesheets().add("darkButton.css");

   			//creating the Label to go in the first window
   			//First asking for a name for root folder
   		Label semesterLabel = new Label("Type a name for your semester's folder: ");

   			//Using Label.css file to set up the styles of Label variables
   			//Like size, color, effects
      	semesterLabel.getStylesheets().add("Label.css");

      		//Creating the Label to go in the first window and prompt second question
   		Label semesterNumber = new Label("Enter the number of classes you're taking");

   			//Using Label.css file to set up the styles of Label variables
   			//Like size, color, effects
      	semesterNumber.getStylesheets().add("Label.css");

   			//Creating cancel button
   		Button cnclButton = new Button("Cancel");

   			//Creating ok button
   		Button okButton = new Button("Ok");

   			//Creating cancel handler class and saying when cancel button is clicked
   			//Use this cancel handler class
   		CancelHandlerClass buttonCncl = new CancelHandlerClass();
   		cnclButton.setOnAction(buttonCncl);

   			//Aligning everything using pane.add
   		pane.add(semesterLabel, 0, 0);
   		pane.add(semesterTextfield, 1, 0);
   		pane.add(semesterNumber, 0, 1);
   		pane.add(semesternumberField, 1, 1);
   		pane.add(cnclButton, 14/4, 2);
   		pane.add(okButton, 2, 2);

   			//Aligning buttons
   		pane.setHalignment(cnclButton, HPos.CENTER);
   		pane.setHalignment(okButton, HPos.RIGHT);

   			//Creating a scene and adding pane in
   		Scene firstWindow = new Scene(pane);

   			//Creating the stage
   		Stage myFirstwindow = new Stage();

   			//Setting up the icon of the window
   		myFirstwindow.getIcons().add(new Image("blank.png"));

   			//Setting the title message
   		myFirstwindow.setTitle("Type your information in order to create your folder");

   			//Setting the scene object to scene
   		myFirstwindow.setScene(firstWindow);

   			//Using main.css as the style of firstwindow
      	firstWindow.getStylesheets().add("main.css");

      		//Setting it to be transparent
      	myFirstwindow.initStyle(StageStyle.TRANSPARENT);

      		//Creating a loading progress
      	ProgressIndicator loadProgress1 = new ProgressIndicator();

      		//Removing the skin
      	loadProgress1.setSkin(null);

      		//Setting the width
      	loadProgress1.setPrefWidth(50);

      		//Creating VBox to be used for loading progress
      	VBox box1 = new VBox();

      		//Adding loading progress to children of VBox
      	box1.getChildren().add(loadProgress1);

      		//When ok button has been clicked, go to makeFolder method on line 486
   		okButton.setOnAction(e -> makeFolder(myFirstwindow));

   			//show the first window and wait for response
   		myFirstwindow.showAndWait();

   			//Creating a second window
   		Stage secondWindow = new Stage();

   			//Setting the icons of the window
   		secondWindow.getIcons().add(new Image("blank.png"));

   			//Creating a GridPane to set up alignments
   		GridPane pane2 = new GridPane();

   			//Setting GridPane position
   		pane2.setAlignment(Pos.CENTER);

   			//Creating cancel button
   		Button cncl1Button = new Button("Cancel");

   			//Creating ok button
   		Button ok1Button = new Button("Ok");

   			//Setting the padding, gap, and styles(using css file to set the styles)
   		pane2.setPadding(new Insets(11.5, 12.5, 13.5, 14.5));
   		pane2.setHgap(5.5);
   		pane2.setVgap(5.5);
      	pane2.getStylesheets().add("darkButton.css");

      		//Creating an array of 10 classLabels
   		Label[] classLabels = new Label[10];

   			//For-loop, according to how many classes the user is taking the for-loop will
   			//ask you for a class name input
   		for (int i = 0; i < semestermakeNumber; i++ ) {
   			
   			classLabels[i] = new Label("Type your class' name: ");
        	classLabels[i].getStylesheets().add("Label.css");
   			classDays[i] = new TextField();
   			pane2.add(classLabels[i], 0, i);
   			pane2.add(classDays[i], 1, i);
   		}

   			//Auto adjusts the window according to how many classes are being taken
		pane2.add(ok1Button, 2, semestermakeNumber + 1);
   		pane2.add(cncl1Button, 14/4, semestermakeNumber + 1);

   			//When clicked on ok button go to makesubFolders method on line 515
		ok1Button.setOnAction(e -> makesubFolders(secondWindow));

			//If cancel button is clicked, exit the system
   		cncl1Button.setOnAction(buttonCncl);

   			//Creating a new scene and adding pane
   		Scene mysecondWindow = new Scene(pane2);

   			//Setting the title of the window
   		secondWindow.setTitle("What classes are you taking?");

   			//Setting secondWindow scene
   		secondWindow.setScene(mysecondWindow);

   			//Using css file to set styles
      	mysecondWindow.getStylesheets().add("main.css");

      		//Setting the styles to be transparent
      	secondWindow.initStyle(StageStyle.TRANSPARENT);

      		//Creating a loading progress
      	ProgressIndicator loadProgress2 = new ProgressIndicator();

      		//Removing the skin of loading progress
      	loadProgress2.setSkin(null);

      		//Setting the width
      	loadProgress2.setPrefWidth(50);

      		//Creating a VBox and add loading progress to the children of VBox
      	VBox box2 = new VBox();
      	box2.getChildren().add(loadProgress2);

      		//Show second window and wait for response
   		secondWindow.showAndWait();

   			//Creating an alert dialog and setting its style to be confirmation
   		Alert alert = new Alert(AlertType.CONFIRMATION);

   			//Removing the title
		alert.setTitle(null);

			//Removing the header text
		alert.setHeaderText(null);

			//Adding a text message
		alert.setContentText("Click on the semester you're currently enrolled in from the following:");

			//creating 4 buttons: Spring, Fall, Summer, Cancel
		ButtonType springButton = new ButtonType("Spring");
		ButtonType fallButton = new ButtonType("Fall");
		ButtonType summerButton = new ButtonType("Summer");
		ButtonType cancelButton = new ButtonType("Cancel", ButtonData.CANCEL_CLOSE);

			//Adding the buttons to alert dialog window
		alert.getButtonTypes().setAll(springButton, fallButton, summerButton, cancelButton);

			//Creating dialogPane and making alert a dialogPane
    	DialogPane dialogPane = alert.getDialogPane();

    		//Setting css file for the styles of dialogPane
    	dialogPane.getStylesheets().add(
    	getClass().getResource("myDialog.css").toExternalForm());
    	dialogPane.getStyleClass().add("myDialog");
      
      		//Alert styles are transparent
      	alert.initStyle(StageStyle.TRANSPARENT);

      		//Creating a loading progress
      	ProgressIndicator loadProgress3 = new ProgressIndicator();

      		//Removing the skin
      	loadProgress3.setSkin(null);

      		//Setting the width to 50
      	loadProgress3.setPrefWidth(50);

      		//Creating a VBox and adding the loading progress to its children
      	VBox box3 = new VBox();
      	box3.getChildren().add(loadProgress3);

      		//Creating the stage and adding the alert window to it
		Stage stage3 = (Stage) alert.getDialogPane().getScene().getWindow();

			//Setting the icon of the stage
		stage3.getIcons().add(new Image("blank.png"));

			//Show window and wait for response
		Optional<ButtonType> result = alert.showAndWait();

			//Getting the home directory location for the user
		File desktop = new File(System.getProperty("user.home"), "Desktop");

			//Create Spring month folders if Spring button was clicked
		if (result.get() == springButton){
		    
			for(int i = 0; i < semestermakeNumber; i++) {
                       
            	for(int h = 0; h < monthSpring.length; h++)   {

             	File v = new File(desktop + "/" + semesterName + "/" + folderNames[i] + "/" + monthSpring[h]);
                	v.mkdir();  
            	}                
           	}

           	for (int p = 0; p < semestermakeNumber; p++) {

             	for (int r = 0; r < monthSpring.length; r++)  {

               		for (int b = 0; b < monthWeek.length; b++)  {

                 		File c = new File(desktop + "/" + semesterName + "/" + folderNames[p] + "/" + monthSpring[r] + "/" + monthWeek[b]);
               			c.mkdir();
               		}
             	}
           	}

           	for (int p = 0; p < semestermakeNumber; p++) {

             	for (int r = 0; r < monthSpring.length; r++)  {

               		for (int b = 0; b < monthWeek.length; b++)  {

                 		for (int g = 0; g < homeworkClasswork.length; g++)  {

                   			File d = new File(desktop + "/" + semesterName + "/" + folderNames[p] + "/" + monthSpring[r] + "/" + monthWeek[b] + "/" + homeworkClasswork[g]);
                    		d.mkdir();
                 		}
               		}
             	}
           	}
        }

			//Creating Fall semester folders if fall button was clicked		
		else if (result.get() == fallButton) {

			for(int i = 0; i < semestermakeNumber; i++) {
                       
            	for(int h = 0; h < monthFall.length; h++)   {

             	File v = new File(desktop + "/" + semesterName + "/" + folderNames[i] + "/" + monthFall[h]);
                	v.mkdir();  
            	}                
           	}

           	for (int p = 0; p < semestermakeNumber; p++) {

             	for (int r = 0; r < monthFall.length; r++)  {

               		for (int b = 0; b < monthWeek.length; b++)  {

                 		File c = new File(desktop + "/" + semesterName + "/" + folderNames[p] + "/" + monthFall[r] + "/" + monthWeek[b]);
               			c.mkdir();
               		}
             	}
           	}

           	for (int p = 0; p < semestermakeNumber; p++) {

             	for (int r = 0; r < monthFall.length; r++)  {

               		for (int b = 0; b < monthWeek.length; b++)  {

                 		for (int g = 0; g < homeworkClasswork.length; g++)  {

                   			File d = new File(desktop + "/" + semesterName + "/" + folderNames[p] + "/" + monthFall[r] + "/" + monthWeek[b] + "/" + homeworkClasswork[g]);
                    		d.mkdir();
                 		}
               		}
             	}
           	}
		}
			
			//Create summer semester folders if summer button was clicked		
		else if (result.get() == summerButton) {
			
			for(int i = 0; i < semestermakeNumber; i++) {
                       
            	for(int h = 0; h < monthSummer.length; h++)   {

             	File v = new File(desktop + "/" + semesterName + "/" + folderNames[i] + "/" + monthSummer[h]);
                	v.mkdir();  
            	}                
           	}

           	for (int p = 0; p < semestermakeNumber; p++) {

             	for (int r = 0; r < monthSummer.length; r++)  {

               		for (int b = 0; b < monthWeek.length; b++)  {

                 		File c = new File(desktop + "/" + semesterName + "/" + folderNames[p] + "/" + monthSummer[r] + "/" + monthWeek[b]);
               			c.mkdir();
               		}
             	}
           	}

           	for (int p = 0; p < semestermakeNumber; p++) {

             	for (int r = 0; r < monthSummer.length; r++)  {

               		for (int b = 0; b < monthWeek.length; b++)  {

                 		for (int g = 0; g < homeworkClasswork.length; g++)  {

                   			File d = new File(desktop + "/" + semesterName + "/" + folderNames[p] + "/" + monthSummer[r] + "/" + monthWeek[b] + "/" + homeworkClasswork[g]);
                    		d.mkdir();
                 		}
               		}
             	}
           	}
		}
		else {		    
			System.exit(0);
		}
			
			//Creating last window as GridPane and aligning it to center of screen
  		GridPane finalPane = new GridPane();
   		finalPane.setAlignment(Pos.CENTER);

   			//setting the padding, amd gap
   		finalPane.setPadding(new Insets(11.5, 12.5, 13.5, 14.5));
   		finalPane.setHgap(5.5);
   		finalPane.setVgap(5.5);

   			//Creating a finish button
   		Button finishButton = new Button("Finish!");

   			//Setting its style using css file
      	finishButton.getStylesheets().add("darkButton.css");

      		//Creating a a message label
   		Label finalMessage = new Label("\n\n\n\t\t\t\t\tThank you for using my program..\n\t\t\t\tYour folder has been saved on your desktop!");

   			//Setting its style using css file
      	finalMessage.getStylesheets().add("finalLabel.css");

   			//Aligning everything using pane.add
   		finalPane.add(finalMessage, 0, 0);
   		finalPane.add(finishButton, 2, 3);
   		finalPane.setAlignment(Pos.CENTER);
      	finalPane.getStylesheets().add("darkButton.css");

   			//Adding all pane into the scene object
   		Scene lastWindow = new Scene(finalPane);

   			//Creating the stage
   		Stage mylastWindow = new Stage();

   			//Making the style of stage to be transparent
   		mylastWindow.initStyle(StageStyle.TRANSPARENT);

   			//Creating a loading progress
   		ProgressIndicator loadProgress = new ProgressIndicator();

   			//Removing its skin
   		loadProgress.setSkin(null);

   			//Setting its width
   		loadProgress.setPrefWidth(50);

   			//Creating a VBox and adding loading progress to its children
   		VBox box = new VBox();
   		box.getChildren().add(loadProgress);

   			//Setting up icon on stage
   		mylastWindow.getIcons().add(new Image("blank.png"));

   			//Removing the title message
   		mylastWindow.setTitle(null);

   			//Setting the scene object to scene
   		mylastWindow.setScene(lastWindow);

   			//Setting the styles using a css file
      	lastWindow.getStylesheets().add("thankyou.css");

      		//When clicked on finish button exit the program
   		finishButton.setOnAction(e -> System.exit(0));

   			//show the last window and wait for response
   		mylastWindow.showAndWait();
   }

   		/**
   		 * This method creates folder name given from user on desktop
   		 * if folder already exists then prompt an error message
   		 */
   private void makeFolder(Stage stage)	{

   	semesterName = semesterTextfield.getText();
   	semestermakeNumber = Integer.parseInt(semesternumberField.getText());
   	File desktop = new File(System.getProperty("user.home"), "Desktop");
	File f = new File(desktop + "/" + semesterName + "/");

		//If directory does not exist then create the folders
	if (!f.exists()) {
		f.mkdir();
	}

		//Else create a warning window popup saying directory already exists
	else  {
		Alert errorMessage = new Alert(AlertType.WARNING);
		errorMessage.setTitle("ERROR!");
		errorMessage.setHeaderText(null);
		errorMessage.setContentText("Directory already exists!");
		errorMessage.showAndWait();
	}

		//Close the window when done
	stage.close();
  }

  		/**
  		 * This method creates your classes within your root folder
  		 * if the directory already exists then create a popup warning message
  		 */
  private void makesubFolders(Stage stage)	{

  	File desktop = new File(System.getProperty("user.home"), "Desktop");

  	for(int i = 0; i < semestermakeNumber; i++)   {

  		folderNames[i] = classDays[i].getText();

   		File s = new File(desktop + "/" + semesterName + "/" + folderNames[i]);

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

		//This method exits the program when the user clicks on the cancel button
class CancelHandlerClass implements EventHandler<ActionEvent>	{

   	@Override
   	public void handle(ActionEvent e)	{
   		System.exit(0);
   	}
}