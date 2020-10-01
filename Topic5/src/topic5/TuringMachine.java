package topic5;

import java.util.ArrayList;

/**
 *
 * @author john
 */
public class TuringMachine {
   private ArrayList<String> states;
   private ArrayList<String> inputAlphabet;
   private ArrayList<String> tapeAlphabet;
   private ArrayList<Transition> transitions;
   private String startState;
   private String acceptState;
   private String rejectState;

   public TuringMachine() {
      states = new ArrayList<String>();
      inputAlphabet = new ArrayList<String>();
      tapeAlphabet = new ArrayList<String>();
      transitions = new ArrayList<Transition>();
      startState = null;
      acceptState = null;
      rejectState = null;
   }
   
   public String toString() {
      String str = "states: " + states.toString() + "\n";
      str += "input alphabet: " + inputAlphabet.toString() + "\n";
      str += "stack alphabet: " + tapeAlphabet.toString() + "\n";
      str += "transitions: " + transitions.toString() + "\n";
      str += "start state: " + startState + "\n";
      str += "accept state: " + acceptState + "\n";
      str += "reject state: " + rejectState + "\n";
      return str;
   }
   
   public ArrayList<String> getStates() {
      return states;
   }

   public boolean addState(String state) {
      if(!states.contains(state)) {
         states.add(state);
         return true;
      }
      return false;
   }
   
   public void setStates() {
      for(Transition t : transitions) {
         addState(t.getFromState());
         addState(t.getToState());
      }
   }
   
   public ArrayList<String> getInputAlphabet() {
      return inputAlphabet;
   }

   public boolean addToInputAlphabet(String c) {
      if(!inputAlphabet.contains(c)) {
         inputAlphabet.add(c);
         return true;
      }
      return false;
   }
   
   public ArrayList<String> getTapeAlphabet() {
      return tapeAlphabet;
   }

   public boolean addToTapeAlphabet(String c) {
      if(!tapeAlphabet.contains(c)) {
         tapeAlphabet.add(c);
         return true;
      }
      return false;
   }
   
   public void setTapeAlphabet() {
      addToTapeAlphabet(" ");
      for(Transition t : transitions) {
         addToTapeAlphabet(t.getWriteSymbol());
      }
   }
   
   public ArrayList<Transition> getTransitions() {
      return transitions;
   }

   public void addTransitions(Transition t) {
      transitions.add(t);
   }
   
   public String getStartState() {
      return startState;
   }

   public void setStartState(String startState) {
      this.startState = startState;
   }
   
   public String getAcceptState() {
      return acceptState;
   }

   public void setAcceptState(String accept) {
      this.acceptState = accept;
   }
   
   public String getRejectState() {
      return rejectState;
   }
   
   public void setRejectState(String reject) {
      this.rejectState = reject;
   }
   /**
    * This method takes in a string of length n, and returns if the tm accepts.
    * It is worst case O(n^2).
    * @param input
    * @return accept
    */
   public boolean accept(String input) {
      Tape tape = new Tape(input);
      String currentState = this.startState;
      String[] temp = new String[3];
      while(true) {
         temp = delta(currentState, tape.currentSymbol().toString());
         if(temp[0] == null) {
            return false;
         }
         currentState = temp[0];
         String writeSymbol = temp[1];
         if(writeSymbol.compareTo(" ") != 0) {
            tape.writeCell(writeSymbol.charAt(0));
         }
         String direction = temp[2];
         if(direction.compareTo("R") == 0) {
            tape.moveRight();
         }
         else if(direction.compareTo("L") == 0) {
            tape.moveLeft();
         }
         if(currentState.compareTo(this.acceptState) == 0) {
            return true;
         }
         else if(currentState.compareTo(this.rejectState) == 0) {
            return false;
         }
      }
   }
   
   public String[] delta(String fromState, String inputSymbol) {
      String[] result = new String[3];
      for(Transition t : transitions) {
         if(t.getFromState().compareTo(fromState) == 0) {
            if(t.getInputSymbol().compareTo(inputSymbol) == 0) {
               result[0] = t.getToState();
               result[1] = t.getWriteSymbol();
               result[2] = t.getDirection();
            }
         }
      }
      return result;
   }
}
