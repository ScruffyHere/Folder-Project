  //Library imports for folder creation('*' means import all library) and keyboard input.
import java.io.*;
import java.util.Scanner;

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
        File f = new File("C:\\Users\\ScruffyHere\\Desktop\\" + mainFolder + "\\"); //Future goal is to make it global on Desktop or let user pick where the folder should be saved.
        
          //if the file doesn't exist, then make directory.
        if(!f.exists()) {
        
          f.mkdir();
        }

        else  {

          System.err.println ("Directory already exists.");
           System.exit(0); //Since directory already exists, I want to repromt folder name question instead of existing program.
        }

          //Prompting second question and saving it in subFolder, and according to user input create that many folders inside our mainFolder.
        System.out.print ("\nEnter the number of classes you're taking: ");

        int subFolder = input.nextInt();  //Saving everything inside an array.

        input.nextLine(); //Cleaning the buffer.

          //Creating the array to save the subFolder names.
        String[] sFolder = new String[subFolder];

         //creating array to use variable instead the loop.
        String[] classDays = {"first", "second", "third", "fourth", "fifth", "sixth", "seventh", "eighth", "ninth", "tenth"};

        for(int i=0; i < subFolder; i++)   {

          System.out.println ("Enter a name for your " + classDays[i] + " class: ");
            
          sFolder[i] = input.next();

          File s = new File("C:\\Users\\ScruffyHere\\Desktop\\" + mainFolder + "\\" + sFolder[i]);

           if(!s.exists())

            s.mkdir();

          else {

          System.err.println ("Directory already exists.");
            System.exit(0); //Since directory already exists, I want to repromt folder name question instead of existing program.
          }
        }

            int semFolder;

              //Creating a switch statement and calling in menu function to choose which semester are they taking the class and each semester will have the months folder in them to be created inside the subFolder of each class.
            do {
              menu();

              semFolder = input.nextInt();

                //Hard coding the months of the semester.
              String[] monthFall = {"August", "September", "October", "November", "December"};

              String[] monthSpring = {"January", "February", "March", "April", "May"};

              String[] monthSummer = {"June", "July"};


              switch(semFolder) {

                case 1:   //Fall-August, September, October, November, December.

                    for(int i=0; i < subFolder; i++) {
                     
                     for(int h=0; h < monthFall.length; h++)   {

                      File v = new File("C:\\Users\\ScruffyHere\\Desktop\\" + mainFolder + "\\" + sFolder[i] + "\\" + monthFall[h]);

                      v.mkdir();  
                     }                
                    }    
                      break;

                case 2:   //Spring-January, February, March, April, May.
                    for(int i=0; i < subFolder; i++) {
                     
                     for(int h=0; h < monthSpring.length; h++)   {

                      File v = new File("C:\\Users\\ScruffyHere\\Desktop\\" + mainFolder + "\\" + sFolder[i] + "\\" + monthSpring[h]);

                      v.mkdir();  
                     }                
                    }
                      break;

                case 3:   //Summer-June, July. 
                    for(int i=0; i < subFolder; i++) {
                     
                     for(int h=0; h < monthSummer.length; h++)   {

                      File v = new File("C:\\Users\\ScruffyHere\\Desktop\\" + mainFolder + "\\" + sFolder[i] + "\\" + monthSummer[h]);

                      v.mkdir();  
                     }                
                    }
                      break;
                    
                case 4:   //Exit program.
                    System.out.println ("Thank you for using my program!");
                      System.exit(0);

              default:
                    System.out.println ("Unknown Selection, please try a different input: ");
              }
            } while(semFolder < 1 || semFolder > 3);

     System.out.println ("\nThank you for using my program!");
   }
   
    //My menu
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