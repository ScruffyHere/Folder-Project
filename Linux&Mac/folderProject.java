/*
  Sina Karimi
  Programmed on Windows 10,
  This program creates a main folder and contains all your classes within it and is organized upon the semester you're taking your classes.
  Linux/Mac version
*/
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
      System.out.println("\nType a name for your current semester: ");
        
          //Semester's name is stored here.
        String mainFolder = input.nextLine();
        
        	//setting the variable desktop to be users location to their desktop.
        File desktop = new File(System.getProperty("user.home"), "Desktop");

          //Creating folder on Desktop with user's typed file name and if it exists, prompt an error.
        File f = new File(desktop + "/" + mainFolder + "/");

            //if the file doesn't exist, then make directory.
          if(!f.exists()) {

           f.mkdir();
          }

            //prompt error and exit the program.
          else  {

            System.err.println("Directory already exists.");
            System.exit(0);
          }

          //Prompting second question and saving it in subFolder, and according to user input create that many folders inside our mainFolder.
        System.out.print("\nEnter the number of classes you're taking: ");

        int subFolder = input.nextInt();  //Saving everything inside an array.

          //Creating the array to save the subFolder names.
        String[] sFolder = new String[subFolder];

         //creating array to use variable instead the loop.
        String[] classDays = {"first", "second", "third", "fourth", "fifth", "sixth", "seventh", "eighth", "ninth", "tenth"};

        input.nextLine(); //Cleaning the buffer.

          //getting name input for each class you're taking, and creating it.
        for(int i=0; i < subFolder; i++)   {

          System.out.println("\nEnter a name for your " + classDays[i] + " class: ");
            
          sFolder[i] = input.nextLine();

          File s = new File(desktop + "/" + mainFolder + "/" + sFolder[i]);

           if(!s.exists())
            s.mkdir();

            //if name already exists, prompt error and exit the program.
          else {

          System.err.println("Directory already exists.");
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

                //Hard coding the weeks 1-4.
              String[] monthWeek = {"Week 1", "Week 2", "Week 3", "Week 4"};

                //Hard coding home/classwork folders.
              String[] homeworkClasswork = {"Homework", "Classwork"};

                //switch statement with each case dedicated for (Time of the year user is taking their classes)
              switch(semFolder) {
                case 1:   //Fall-August, September, October, November, December.

                    for(int i=0; i < subFolder; i++) {
                     
                     for(int h=0; h < monthFall.length; h++)   {

                      File v = new File(desktop + "/" + mainFolder + "/" + sFolder[i] + "/" + monthFall[h]);
                       v.mkdir();  
                     }                
                    }

                    for (int p = 0; p < subFolder; p++) {

                      for (int r = 0; r < monthFall.length; r++)  {

                        for (int b = 0; b < monthWeek.length; b++)  {

                          File c = new File(desktop + "/" + mainFolder + "/" + sFolder[p] + "/" + monthFall[r] + "/" + monthWeek[b]);
                           c.mkdir();
                        }
                      }
                    }

                    for (int p = 0; p < subFolder; p++) {

                      for (int r = 0; r < monthFall.length; r++)  {

                        for (int b = 0; b < monthWeek.length; b++)  {

                          for (int g = 0; g < homeworkClasswork.length; g++)  {

                            File d = new File(desktop + "/" + mainFolder + "/" + sFolder[p] + "/" + monthFall[r] + "/" + monthWeek[b] + "/" + homeworkClasswork[g]);
                             d.mkdir();
                          }
                        }
                      }
                    }
                      break;

                case 2:   //Spring-January, February, March, April, May.
                    for(int i = 0; i < subFolder; i++) {
                     
                     for(int h = 0; h < monthSpring.length; h++)   {

                      File v = new File(desktop + "/" + mainFolder + "/" + sFolder[i] + "/" + monthSpring[h]);
                       v.mkdir();  
                     }                
                    }

                    for (int p = 0; p < subFolder; p++) {

                      for (int r = 0; r < monthSpring.length; r++)  {

                        for (int b = 0; b < monthWeek.length; b++)  {

                          File c = new File(desktop + "/" + mainFolder + "/" + sFolder[p] + "/" + monthSpring[r] + "/" + monthWeek[b]);
                           c.mkdir();
                        }
                      }
                    }

                    for (int p = 0; p < subFolder; p++) {

                      for (int r = 0; r < monthSpring.length; r++)  {

                        for (int b = 0; b < monthWeek.length; b++)  {

                          for (int g = 0; g < homeworkClasswork.length; g++)  {

                            File d = new File(desktop + "/" + mainFolder + "/" + sFolder[p] + "/" + monthSpring[r] + "/" + monthWeek[b] + "/" + homeworkClasswork[g]);
                             d.mkdir();
                          }
                        }
                      }
                    }
                      break;

                case 3:   //Summer-June, July. 
                    for(int i = 0; i < subFolder; i++) {
                     
                     for(int h = 0; h < monthSummer.length; h++)   {

                      File v = new File(desktop + "/" + mainFolder + "/" + sFolder[i] + "/" + monthSummer[h]);
                       v.mkdir();  
                     }                
                    }

                    for (int p = 0; p < subFolder; p++) {

                      for (int r = 0; r < monthSummer.length; r++)  {

                        for (int b = 0; b < monthWeek.length; b++)  {

                          File c = new File(desktop + "/" + mainFolder + "/" + sFolder[p] + "/" + monthSummer[r] + "/" + monthWeek[b]);
                           c.mkdir();
                        }
                      }
                    }

                    for (int p = 0; p < subFolder; p++) {

                      for (int r = 0; r < monthSummer.length; r++)  {

                        for (int b = 0; b < monthWeek.length; b++)  {

                          for (int g = 0; g < homeworkClasswork.length; g++)  {

                            File d = new File(desktop + "/" + mainFolder + "/" + sFolder[p] + "/" + monthSummer[r] + "/" + monthWeek[b] + "/" + homeworkClasswork[g]);
                             d.mkdir();
                          }
                        }
                      }
                    }
                      break;
                    
                case 4:   //Exit program.
                    System.out.println ("Thank you for using my program!");
                    System.exit(0);

                //Prompting this message if unknown selection.
              default:
                    System.out.println ("Unknown Selection, please try a different input: ");
              }
            } while(semFolder < 1 || semFolder > 3);

     input.nextLine(); //Cleaning the buffer.

        //End of program message to user.
    System.out.println ("\n\nYour folder has been created and is located on your Desktop.");
    System.out.println ("\n-----------------------------------");
    System.out.println ("| Thank you for using my program! |");
    System.out.print   ("-----------------------------------");
    System.out.println ("\n\nPress ENTER key to exit the program...");
      
        //Press Enter to exit the program
      try {

        System.in.read();
      }

      catch(Exception e)
      {}
   }
   
    //My menu
  public static void menu(){

    System.out.println ("\n");
    System.out.println ("-----------------------------------------------------");
    System.out.println ("| Choose your semester's number from the following: |");
    System.out.println ("-----------------------------------------------------");
    System.out.println ("1. \tFall.");
    System.out.println ("2. \tSpring.");
    System.out.println ("3. \tSummer.");
    System.out.println ("4. \tExit.");
  }
}