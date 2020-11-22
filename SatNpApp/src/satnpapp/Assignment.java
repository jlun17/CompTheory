package satnpapp;

import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author john
 */
public class Assignment {
   private HashMap<String, Boolean> assignments;
   
   public Assignment(CnfFormula formula) {
      assignments = new HashMap<String, Boolean>();
      for(Clause c: formula.getClauses()) {
         for(Literal l: c.getLiterals()) {
            if(assignments.get(l.getName()) == null) {
               setValue(l.getName(), false);
            }
         }
      }
   }
   
   public boolean getValue(String var) {
      return assignments.get(var);
   }
   
   public void setValue(String var, boolean val) {
      assignments.put(var, val);
   }
   
   public String[] variables() {
      String[] sol = new String[assignments.size()];
      int i = 0;
      for (String j: assignments.keySet()) {
         sol[i] = j;
         i++;
      }
      return sol;
   }

   @Override
   public String toString() {
      return assignments.toString();
   }
   
}
