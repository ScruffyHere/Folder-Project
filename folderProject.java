import java.io.*;
import java.util.Scanner;

public class folderProject {

public static void menu(){
    System.out.println("1. Fall");
    System.out.println("2. Spring");
    System.out.println("3. Summer");
    System.out.println("Choose your semester's number: ");
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

     System.out.print ("Type amount of subfolders needed within your base folder: ");
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

           do {
             menu();
              int semesterNumber = input.nextInt();

             switch( semesterNumber ){
             case 1:
                 System.out.println("Exiting...");
                 break;

             case 2:
                 include();
                 break;

             case 3:
                 change();
                 break;

             default:
                 System.out.println("Unknown selection.");
               }
           } while (semesterNumber < 1 || semesterNumber > 3);

      System.out.println("Thank you for using my program.");

    }
}