package topic5;

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
public class Topic5 {

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
      
      TuringMachine tm = new TuringMachine();
      
      // Set start state
      String startState = fileReader.next();
      tm.setStartState(startState);
      
      // Set accept state
      fileReader.nextLine();
      String acceptState = fileReader.nextLine();
      tm.setAcceptState(acceptState);
      
      // Set reject state
      String rejectState = fileReader.nextLine();
      tm.setRejectState(rejectState);
      
      // Set input alphabet
      String inputAlphabet = fileReader.nextLine();
      for(String symbol : inputAlphabet.split(" ")) {
         tm.addToInputAlphabet(symbol);
         tm.addToTapeAlphabet(symbol);
      }
      
      // Set transitions
      while(fileReader.hasNextLine()) {
         Transition t = new Transition();
         String tStr = fileReader.nextLine();
         String tArr[] = tStr.split("\\)");
         String toState = tArr[1].substring(1);
         t.setToState(toState);
         String subtArr[] = tArr[0].split("\\(");
         String fromState = subtArr[0].substring(0, subtArr[0].length() - 1);
         t.setFromState(fromState);
         String subsubtArr[] = subtArr[1].split(",");
         String inputSymbol = subsubtArr[0];
         t.setInputSymbol(inputSymbol);
         String writeSymbol = subsubtArr[1];
         t.setWriteSymbol(writeSymbol);
         String direction = subsubtArr[2];
         t.setDirection(direction);
         tm.addTransitions(t);
      }
      tm.setStates();
      tm.setTapeAlphabet();
      
      JFrame f = new JFrame();
      JOptionPane.showMessageDialog(f, tm.toString(), "Turing Machine", JOptionPane.INFORMATION_MESSAGE);
      
      String inputValue = JOptionPane.showInputDialog("Please input a string");
      do {
         if(tm.accept(inputValue)) {
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
