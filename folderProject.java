	//Library imports for folder creation('*' means import all library) and keyboard input.
import java.io.*;
import java.util.Scanner;

//testing
	//My Project class.
public class folderProject {

	//Main method.
   public static void main(String[] args) {
   
   		//Getting input from keyboard.
   	Scanner input = new Scanner(System.in);
     
     		//Interaction with user.
    	System.out.print ("Type a name for your current semester: ");
      	
      		//Semester's name is stored here.
      	String mainFolder = input.nextLine();

      		//Creating folder on Desktop with user's typed file name and if it exists, prompt an error.
      	File f = new File("C:\\Users\\ScruffyHere\\Desktop\\" + mainFolder + "\\");	//Future goal is to make it global on Desktop or let user pick where the folder should be saved.
        
        if(!f.exists())	{
        
        	f.mkdir();
        }

        else	{

          System.err.println ("Directory already exists.");

          System.exit(0);	//Since directory already exists, I want to repromt folder name question instead of existing program.
        }

        	//Prompting second question and saving it in subFolder, and according to user input create that many folders inside our mainFolder.
      	System.out.print ("\nEnter the number of classes you're taking: ");

        int subFolder = input.nextInt();	//Saving everything inside an array.

        input.nextLine();	//Cleaning the buffer.

        	//Creating the array to save the subFolder names.
      	String[] sFolder = new String[subFolder];

        for(int i=0; i < subFolder; i++)   {

          String[] classDays = {"first", "second", "third", "fourth", "fifth", "sixth", "seventh", "eighth", "ninth", "tenth"};

		  System.out.println ("Enter a name for your " + classDays[i] + " class: ");
            
          sFolder[i] = input.next();

          File s = new File("C:\\Users\\ScruffyHere\\Desktop\\" + mainFolder + "\\" + sFolder[i]);

    		   if(!s.exists())

    			s.mkdir();

           else	{

    			System.err.println ("Directory already exists.");

             	System.exit(0);	//Since directory already exists, I want to repromt folder name question instead of existing program.
            }
        }

            int semFolder;

            	//Creating a switch statement and calling in menu function to choose which semester are they taking the class and each semester will have the months folder in them to be created inside the subFolder of each class.
            do {

              menu();

              semFolder = input.nextInt();

	            switch(semFolder)	{

	              case 1:   //Fall-August, September, October, November, December.

	                	System.out.println ("Case 1 was selected");

	               		break;

	              case 2:   //Spring-January, February, March, April, May.

	                	System.out.println ("Case 2 was selected");

	                	break;

	              case 3:   //Summer-June, July. 

	                	System.out.println ("Case 3 was selected");

	                	break;
	                  
	              case 4:   //Exit program.

	               		System.out.println ("Thank you for using my program!");

	               		System.exit(0);

	            default:

	                	System.out.println ("Unknown Selection, please try a different input: ");

	            }
            }	while(semFolder < 1 || semFolder > 3);

     System.out.println ("\nThank you for using my program!");
   }
   
  	//My menu metho
  public static void menu(){

	  System.out.println ("-----------------------------------------------------");

	  System.out.println ("| Choose your semester's number from the following: |");

	  System.out.println ("-----------------------------------------------------");

	  System.out.println ("1. \tFall.");

	  System.out.println ("2. \tSpring.");

	  System.out.println ("3. \tSummer.");

	  System.out.println ("4. \tExit.");
   }
}
