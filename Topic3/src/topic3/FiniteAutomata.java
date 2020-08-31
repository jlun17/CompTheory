/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package topic3;

import java.util.ArrayList;

/**
 *
 * @author john
 */
public class FiniteAutomata {
   private String startState;
   private ArrayList<String> acceptStates;
   private ArrayList<String> states;
   private ArrayList<Transition> transitions;
   
   public boolean accept(String input) {
      return true;
   }
   
   public ArrayList<String> getAcceptStates() {
      return acceptStates;
   }
   
   public ArrayList<Character> alphabet() {
      return null;
   }
   
   public ArrayList<String> getStates() {
      return states;
   }

   public ArrayList<Transition> getTransitions() {
      return transitions;
   }
   
}
