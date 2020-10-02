package topic4;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

/**
 *
 * @author john
 */
public class PushdownAutomata {
   private ArrayList<String> states;
   private ArrayList<String> inputAlphabet;
   private ArrayList<String> stackAlphabet;
   private ArrayList<Transition> transitions;
   private String startState;
   private ArrayList<String> acceptStates;

   public PushdownAutomata() {
      states = new ArrayList<String>();
      inputAlphabet = new ArrayList<String>();
      stackAlphabet = new ArrayList<String>();
      transitions = new ArrayList<Transition>();
      startState = null;
      acceptStates = new ArrayList<String>();
   }
   
   public String toString() {
      String str = "states: " + states.toString() + "\n";
      str += "input alphabet: " + inputAlphabet.toString() + "\n";
      str += "stack alphabet: " + stackAlphabet.toString() + "\n";
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
   
   public ArrayList<String> getInputAlphabet() {
      return inputAlphabet;
   }

   public boolean addToInputAlphabet(String c) {
      if(!inputAlphabet.contains(c) && (c.compareTo("e") != 0)) {
         inputAlphabet.add(c);
         return true;
      }
      return false;
   }
   
   public void setInputAlphabet() {
      for(Transition t : transitions) {
         addToInputAlphabet(t.getLabel());
      }
   }
   
   public ArrayList<String> getStackAlphabet() {
      return stackAlphabet;
   }

   public boolean addToStackAlphabet(String c) {
      if(!stackAlphabet.contains(c)) {
         stackAlphabet.add(c);
         return true;
      }
      return false;
   }
   
   public void setStackAlphabet() {
      for(Transition t : transitions) {
         addToStackAlphabet(t.getStackTop());
         addToStackAlphabet(t.getStackPush());
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
    * This method takes in a string of length n, and returns if the pda accepts.
    * It is worst case O(n^2).
    * @param input
    * @return accept
    */
   public boolean accept(String input) {
      Deque<String> stack = new ArrayDeque<String>();
      int n = input.length();
      String currentState = startState;
      Pair returnValue = null;
      for(int i = 0; i < n; i++) {
         returnValue = delta(currentState, String.valueOf(input.charAt(i)), stack);
         if(returnValue == null) {
            return false;
         }
         currentState = returnValue.getToState();
         stack = returnValue.getStack();
      }
      return acceptStates.contains(currentState);
   }
   
   public Pair delta(String currentState, String input, Deque<String> stack) {
      for(Transition t : transitions) {
         boolean check1 = t.getFromState().compareTo(currentState) == 0;
         if(check1) {
            // delta(q, e, e)
            if((input.compareTo("e") == 0) && (t.getStackTop().compareTo("e") == 0)) {
               if(t.getStackPush().compareTo("e") != 0) {
                  stack.push(t.getStackPush());
               }
               return new Pair(t.getToState(), stack);
            }
            // delta(q, e, x)
            else if((input.compareTo("e") == 0) && (stack.peek().compareTo(t.getStackTop()) == 0)) {
               stack.pop();
               if(t.getStackPush().compareTo("e") != 0) {
                  stack.push(t.getStackPush());
               }
               return new Pair(t.getToState(), stack);
            }
            // delta(q, a, x)
            else if((input.compareTo(t.getLabel()) == 0) && (stack.peek().compareTo(t.getStackTop()) == 0)){
               stack.pop();
               if(t.getStackPush().compareTo("e") != 0) {
                  stack.push(t.getStackPush());
               }
               return new Pair(t.getToState(), stack);
            }
            // delta(q, a, e)
            else if(input.compareTo(t.getLabel()) == 0) {
               if(t.getStackPush().compareTo("e") != 0) {
                  stack.push(t.getStackPush());
               }
               return new Pair(t.getToState(), stack);
            }
         }
      }
      return null;
   }
   
}
