package satnpapp;

import java.util.ArrayList;

/**
 *
 * @author john
 */
public class Clause {
   private ArrayList<Literal> literals;

   public Clause(String clause) {
      literals = new ArrayList<Literal>();
      if(clause.charAt(0) == '(') {
         clause = clause.substring(1, clause.length() - 1);
      }
      String[] lit = clause.split(" v ");
      for(String l: lit) {
         Literal li = new Literal(l);
         literals.add(li);
      }
   }

   public ArrayList<Literal> getLiterals() {
      return literals;
   }
   
   public boolean verify(Assignment a) {
      boolean soln = false;
      for(Literal l: literals) {
         if(l.verify(a)) {
            soln = true;
         }
      }
      return soln;
   }
   
   @Override
   public String toString() {
      String str = "";
      boolean isFirst = true;
      for(Literal l: literals) {
         if(isFirst) {
            str += l.toString();
            isFirst = false;
         }
         else {
            str += " v " + l.toString();
         }
      }
      return str;
   }
   
}
