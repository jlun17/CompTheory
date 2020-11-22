package satnpapp;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author john
 */
public class CnfFormula {
   private ArrayList<Clause> clauses;

   /**
    * This method verifies an assignment satisfies the CNF formula. It is big O
    * O(n).
    * @param a
    * @return 
    */
   public boolean verify(Assignment a) {
      boolean soln = true;
      for(Clause c: clauses) {
         if(!c.verify(a)) {
            soln = false;
         }
      }
      return soln;
   }
   
   public CnfFormula(File file) {
      Scanner fileReader = null;
      clauses = new ArrayList<Clause>();
      try {
         fileReader = new Scanner(file);
      }
      catch (IOException ioe) {
         System.out.println(ioe.getMessage());
         System.out.println("Program exiting");
         System.exit(1);
      }
      
      String cnf = fileReader.nextLine();
      String[] clses = cnf.split(" \\^ ");
      for(String c: clses) {
         Clause cl = new Clause(c);
         clauses.add(cl);
      }
   }

   public ArrayList<Clause> getClauses() {
      return clauses;
   }

   @Override
   public String toString() {
      String str = "";
      boolean isFirst = true;
      for(Clause c: clauses) {
         if(isFirst) {
            str += "(" + c.toString() + ")";
            isFirst = false;
         }
         else {
            str += " ^ " + "(" + c.toString() + ")";
         }
      }
      return str;
   }
   
   
   
   
}
