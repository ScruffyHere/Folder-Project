import java.io.*;
import java.util.Scanner;

public class folderProject {

public static void menu(){
  System.out.println ("----------------------------------");
  System.out.println ("| Choose your semester's number: |");
  System.out.println ("----------------------------------");
  System.out.println ("1. \tFall");
  System.out.println ("2. \tSpring");
  System.out.println ("3. \tSummer");
  System.out.println ("4. \tExit");

}
   public static void main(String[] args) {
     Scanner input = new Scanner(System.in);
     

    System.out.print ("Type your folders base name: ");
      String mainFolder = input.nextLine();

      File f = new File("C:\\Users\\ScruffyHere\\Desktop\\" + mainFolder + "\\");
        if(!f.exists())	{
        f.mkdir();
        }

        else	{
          System.err.println("Directory already exists.");
            System.exit(0);
        }

      System.out.print ("\nType amount of subfolders needed within your base folder: ");
        int subFolder = input.nextInt();

      input.nextLine();

      String[] sFolder = new String[subFolder];

        for(int i=0; i < subFolder; i++)   {
          System.out.print ("Enter your subfolders name: ");
            sFolder[i] = input.next();

          File s = new File("C:\\Users\\ScruffyHere\\Desktop\\" + mainFolder + "\\" + sFolder[i]);
    		   if(!s.exists())
    			   s.mkdir();

           else	{
    			  System.err.println("Directory already exists.");
             System.exit(0);
            }
        }

            int semFolder;

            do {
              menu();
                semFolder = input.nextInt();

            switch(semFolder){
              case 1:   //August, September, October, November, December
                System.out.println("Case 1 was selected");
                  break;

              case 2:   //January, February, March, April, May
                System.out.println("Case 2 was selected");
                  break;

              case 3:   //June, July, 
                System.out.println("Case 3 was selected");
                  break;
                  
              case 4:   //Exit program
               System.out.println ("Thank you for using my program!");
               System.exit(0);

            default:
                System.out.println("Unknown Selection, please try again.");
              }
            } while (semFolder < 1 || semFolder > 3);
     System.out.println("\nThank you for using my program!");
   }
 }