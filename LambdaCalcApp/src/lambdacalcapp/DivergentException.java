/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lambdacalcapp;

/**
 *
 * @author john
 */
public class DivergentException extends Exception {

   /**
    * Creates a new instance of <code>DivergentException</code> without detail
    * message.
    */
   public DivergentException() {
   }

   /**
    * Constructs an instance of <code>DivergentException</code> with the
    * specified detail message.
    *
    * @param msg the detail message.
    */
   public DivergentException(String msg) {
      super(msg);
   }
}
