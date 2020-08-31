/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package topic3;

/**
 *
 * @author john
 */
public class Transition {
   private String fromState;
   private char label;
   private String toState;

   public Transition(String fromState, char label, String toState) {
      this.fromState = fromState;
      this.label = label;
      this.toState = toState;
   }
   
}
