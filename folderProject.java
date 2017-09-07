import java.io.*;
import java.util.Scanner;

public class folderProject {

public static void menu(){
  System.out.println("1. Fall");
  System.out.println("2. Spring");
  System.out.println("3. Summer");
  System.out.println("\nChoose your semester's number: ");
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

      String[] sFolder = new String[subFolder];

        for(int i=0; i<subFolder; i++)   {
          System.out.print ("Enter your subfolders name: ");
            sFolder[i] = input.next();

          File s = new File("C:\\Users\\ScruffyHere\\Desktop\\" + mainFolder + "\\" + sFolder[i]);
    		   if(!s.exists())
    			   s.mkdir();

           else	{
    			  System.err.println("Directory already exists.");
             System.exit(0);
            }

        /*  do {
              menu();
                int numSemester = input.nextInt();

            switch(numSemester){
              case 1:
                System.out.println("Case 1");
                  break;

              case 2:
                System.out.println("Case 2");
                  break;

              case 3:
                System.out.println("Case 3");
                  break;

              default:
                System.out.println("unknown selection.");
              }
            } while(numSemester < 1 || numSemester > 3); */
       }
     System.out.println("\nThank you for using my program.");
   }
 }