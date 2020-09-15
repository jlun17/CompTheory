package topic4;

import java.awt.Component;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author john
 */
public class Topic4 {

   /**
    * For file input, the runtime complexity is O(n)
    * @param args the command line arguments
    */
   public static void main(String[] args) {
      JFileChooser chooser = new JFileChooser();
      Component parent = chooser.getComponent(1);
      int returnVal = chooser.showOpenDialog(parent);
      File inFile = null;
      if(returnVal == JFileChooser.APPROVE_OPTION) {
         inFile = chooser.getSelectedFile();
      }
      
      Scanner fileReader = null;
      try {
         fileReader = new Scanner(inFile);
      }
      catch (IOException ioe) {
         System.out.println(ioe.getMessage());
         System.out.println("Program exiting");
         System.exit(1);
      }
      PushdownAutomata pda = new PushdownAutomata();
      
      // Set start state
      String startState = fileReader.next();
      pda.setStartState(startState);
      
      // Set accept states
      fileReader.nextLine();
      String acceptStates = fileReader.nextLine();
      for(String state : acceptStates.split(" ")) {
         pda.addAcceptState(state);
      }
      
      // Set transitions
      while(fileReader.hasNextLine()) {
         String tStr = fileReader.nextLine();
         String tArr[] = tStr.split(" ");
         Transition t = new Transition();
         t.setFromState(tArr[0]);
         t.setLabel(tArr[1].substring(1));
         t.setStackTop(tArr[2]);
         t.setStackPush(tArr[3].substring(0, 1));
         t.setToState(tArr[4]);
         pda.addTransitions(t);
      }
      pda.setInputAlphabet();
      pda.setStackAlphabet();
      pda.setStates();
      
      JFrame f = new JFrame();
      JOptionPane.showMessageDialog(f, pda.toString(), "PDA", JOptionPane.INFORMATION_MESSAGE);
      
      String inputValue = JOptionPane.showInputDialog("Please input a string");
      do {
         if(pda.accept("e" + inputValue + "e")) {
            JOptionPane.showMessageDialog(f, "The string \"" + inputValue + "\" is accepted");
         }
         else {
            JOptionPane.showMessageDialog(f, "The string \"" + inputValue + "\" is not accepted");
         }
         inputValue = JOptionPane.showInputDialog("Please input a string");
      } while(inputValue != null);
      System.exit(0);
   }
   
}
