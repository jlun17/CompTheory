package lambdacalcapp;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author john
 */
public class LambdaCalcApp {

   /**
    * NOTE: All applications must have a space between them For Example:
    *    N M is Accepted
    *    NM is Not Accepted
    *    (N) (M) is Accepted
    *    (N)(M) is Not Accepted
    * All abstractions must have explicit parenthesis For Example:
    *    (Lx. x y z) is Accepted
    *    Lx. x y z is Not Accepted
    * @param args the command line arguments
    */
   public static void main(String[] args) {
      while(true) {
         JFrame f;  
         f=new JFrame();  
         String inputValue = JOptionPane.showInputDialog("Please input a lambda expression");
         if(inputValue == null) {
            System.exit(0);
         }
         Parser parser = new Parser();
         Simulator sim = new Simulator();
         LambdaExpr exp;
         try {
            exp = parser.parse(inputValue);
            while(!sim.betaReduce(exp).equals(exp)) {
               exp = sim.betaReduce(exp);
            }
            JOptionPane.showMessageDialog(f, inputValue + " is a valid lambda expression\n" +
               "The expression Beta reduces to " + exp.toString()); 
         }
         catch (ParseException pe) {
            JOptionPane.showMessageDialog(f, "Invalid Expression. Please enter a valid expression."); 
            System.out.println(pe.getMessage());
         }
         catch (DivergentException de) {
            System.out.println(de.getMessage());
         }
      }
   }
   
}
