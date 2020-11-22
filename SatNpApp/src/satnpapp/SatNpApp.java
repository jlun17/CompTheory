package satnpapp;

import java.awt.Component;
import java.io.File;
import java.util.ArrayList;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author john
 */
public class SatNpApp {

   /**
    * @param args the command line arguments
    */
   public static void main(String[] args) {
      int ans = 0;
      File inFile = chooseExprLocation();
      AssignmentView view = new AssignmentView();
      
      CnfFormula formula = new CnfFormula(inFile);
      do {
         Assignment assignment = new Assignment(formula);
         view.setModel(assignment);
         view.setVisible(true);
         if(formula.verify(assignment)) {
            JOptionPane.showMessageDialog(null, "The assignment:\n" 
               + assignment.toString() 
               + "\nSatisfies the formula:\n" 
               + formula.toString());
         }
         else {
            JOptionPane.showMessageDialog(null, "The assignment:\n" 
               + assignment.toString() 
               + "\nDoes not satisfy the formula:\n" 
               + formula.toString());
         }
         if(satisfy(formula) != null) {
            JOptionPane.showMessageDialog(null, "Here is one assignment which will satisfy the formula:\n" 
               + satisfy(formula).toString());
         }
         else {
            JOptionPane.showMessageDialog(null, "The formula is not satisfiable");
         }
         ans = JOptionPane.showConfirmDialog(null, "Try another assignment?", "Continue?", JOptionPane.YES_NO_OPTION);
      } while(ans == JOptionPane.YES_OPTION);
      System.exit(0);
   }
   
   /**
    * This method returns an assignment that satifies a CNF, f, it is big O
    * O(2^n) because it is brute force
    * @param f
    * @return 
    */
   private static Assignment satisfy(CnfFormula f) {
      Assignment a = new Assignment(f);
      String[] vars = a.variables();
      int length = vars.length;
      for(int i = 0; i < Math.pow(2.0, ((double) length - 1)); i++) {
         ArrayList<Integer> config = new ArrayList<Integer>();
         toBinary(i, config);
         config = flip(config, length);
         for(int j = 0; j < length; j++) {
            a.setValue(vars[j], config.get(j).intValue() == 1);
         }
         if(f.verify(a)) {
            return a;
         }
      }
      return null;
   }
   
   private static ArrayList<Integer> toBinary(int n, ArrayList<Integer> s) {
      if(n == 0) {
         s.add(new Integer(0));
         return s;
      }
      s.add(n % 2);
      return toBinary(n/2, s);
   }
   
   private static ArrayList<Integer> flip(ArrayList<Integer> s, int length) {
      while(s.size() < length) {
         s.add(new Integer(0));
      }
      ArrayList<Integer> p = new ArrayList<Integer>();
      for(int i = s.size() - 1; i >= 0; i--) {
         p.add(s.get(i));
      }
      return p;
   }
   
   private static File chooseExprLocation() {
      JFileChooser chooser = new JFileChooser();
      Component parent = chooser.getComponent(1);
      int returnVal = chooser.showOpenDialog(parent);
      File inFile = null;
      if(returnVal == JFileChooser.APPROVE_OPTION) {
         inFile = chooser.getSelectedFile();
      }
      return inFile;
   }
}
