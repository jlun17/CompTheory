package topic3;

import java.awt.Component;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author john
 */
public class Topic3 {

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
      FiniteAutomata dfa = new FiniteAutomata();
      String startState = fileReader.next();
      dfa.setStartState(startState);
      fileReader.nextLine();
      String acceptStates = fileReader.nextLine();
      for(String state : acceptStates.split(" ")) {
         dfa.addAcceptState(state);
      }
      
      while(fileReader.hasNextLine()) {
         String tStr = fileReader.nextLine();
         String tArr[] = tStr.split(" ");
         Transition t = new Transition();
         t.setFromState(tArr[0]);
         t.setLabel(tArr[1]);
         t.setToState(tArr[2]);
         dfa.addTransitions(t);
      }
      dfa.setAlphabet();
      dfa.setStates();
      System.out.println(dfa.toString());
      String inputValue = JOptionPane.showInputDialog("Please input a string");
      if(dfa.accept(inputValue)) {
         System.out.println("The string \"" + inputValue + "\" is accepted");
      }
      else {
         System.out.println("The string \"" + inputValue + "\" is not accepted");
      }
   }
}
