import java.util.*;
import java.io.*;

public class DaeIDsAdvanced {
   public static void main(String[] args) throws FileNotFoundException {
      Scanner console = new Scanner(System.in);
      Scanner input = new Scanner(new File("inventory.txt"));
      
      String[] cardData = new String[4];
      List<String> nameExclude = new ArrayList<String>();
      List<String> eraExclude = new ArrayList<String>();
      String result = "";
      
      getExceptions(nameExclude, eraExclude, console);
      
      while (input.hasNextLine()) {
         cardData[0] = input.nextLine(); // [0] is GROUP + NAME
            cardData[0] = cardData[0].toLowerCase();
         cardData[1] = input.nextLine(); // [1] is ERA
            cardData[1] = cardData[1].toLowerCase();
         cardData[2] = input.nextLine(); // [2] is RANK
         cardData[3] = input.nextLine(); // [3] is ID
         
         result += returnNextID(input, cardData, nameExclude, eraExclude);
      }
      System.out.println(result);
   }
   
   public static void getExceptions(List<String> name, List<String> era, Scanner console) {
      /*System.out.println("NOTE: Input will exclude anything on the same line that includes that phrase");
      System.out.println("(ex: \"ive\" will exclude \"verivery\"; \"chan\" will exclude \"bang chan\").");
      System.out.println("Try to use the most specific filter possible (ex: \"eleven\" instead of \"ive\").");
      System.out.println("Filtering is not case sensitive.");
      System.out.println("Only enter one item at a time.");
      System.out.println("Enter \"Done\" EXACTLY when you have no more exclusions of the given type.");
      System.out.println();*/
      
      boolean end = false;
      while (!end) {
         System.out.print("Next Group/Idol to Exclude: ");
         String newExclusion = console.nextLine();
         name.add(newExclusion.toLowerCase());
         end = newExclusion.equals("Done");
      } 
      System.out.println();
      end = false;
      while (!end) {
         System.out.print("Next Era to Exclude: ");
         String newExclusion = console.nextLine();
         era.add(newExclusion.toLowerCase());
         end = newExclusion.equals("Done");
      } 
      System.out.println();
   }
   
   public static String returnNextID(Scanner input, String[] cardData, List<String> nameExclude, 
                                     List<String> eraExclude) throws FileNotFoundException {
      for (int i = 0; i < nameExclude.size(); i++) {
         if (cardData[0].indexOf(nameExclude.get(i)) >= 0) {
            return "";
         }
      }
      for (int i = 0; i < eraExclude.size(); i++) {
         if (cardData[1].indexOf(eraExclude.get(i)) >= 0) {
            return "";
         }
      }
      Scanner lineScan = new Scanner(cardData[3]);
      String throwaway = lineScan.next();
      String newID = lineScan.next();
      
      return newID + " ";
   }
}