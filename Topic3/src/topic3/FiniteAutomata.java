package topic3;

import java.util.ArrayList;

/**
 *
 * @author john
 */
public class FiniteAutomata {
   private ArrayList<String> states;
   private ArrayList<String> alphabet;
   private ArrayList<Transition> transitions;
   private String startState;
   private ArrayList<String> acceptStates;

   public FiniteAutomata() {
      states = new ArrayList<String>();
      alphabet = new ArrayList<String>();
      transitions = new ArrayList<Transition>();
      startState = null;
      acceptStates = new ArrayList<String>();
   }
   
   public String toString() {
      String str = "states: " + states.toString() + "\n";
      str += "alphabet: " + alphabet.toString() + "\n";
      str += "transitions: " + transitions.toString() + "\n";
      str += "start state: " + startState + "\n";
      str += "accept states: " + acceptStates.toString() + "\n";
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

   public ArrayList<String> getAlphabet() {
      return alphabet;
   }

   public boolean addToAlphabet(String c) {
      if(!alphabet.contains(c)) {
         alphabet.add(c);
         return true;
      }
      return false;
   }
   
   public void setAlphabet() {
      for(Transition t : transitions) {
         addToAlphabet(t.getLabel());
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

   public ArrayList<String> getAcceptStates() {
      return acceptStates;
   }

   public void addAcceptState(String accept) {
      acceptStates.add(accept);
   }
   
   /**
    * This method takes in a string of length n, and returns if the dfa accepts.
    * It is worst case O(n^2).
    * @param input
    * @return 
    */
   public boolean accept(String input) {
      int n = input.length();
      String currentState = startState;
      for(int i = 0; i < n; i++) {
         currentState = delta(currentState, String.valueOf(input.charAt(i)));
         if(currentState == null) {
            return false;
         }
      }
      return acceptStates.contains(currentState);
   }
   
   public String delta(String currentState, String input) {
      for(Transition t : transitions) {
         boolean check1 = t.getFromState().compareTo(currentState) == 0;
         boolean check2 = t.getLabel().compareTo(input) == 0;
         if(check1 && check2) {
            return t.getToState();
         }
      }
      return null;
   }
}
