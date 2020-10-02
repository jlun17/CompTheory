package topic4;

import java.util.Deque;

/**
 *
 * @author john
 */
public class Pair {
   private String toState;
   private Deque<String> stack;

   public Pair(String toState, Deque<String> stack) {
      this.toState = toState;
      this.stack = stack;
   }

   public String getToState() {
      return toState;
   }

   public void setToState(String toState) {
      this.toState = toState;
   }

   public Deque<String> getStack() {
      return stack;
   }

   public void setStack(Deque<String> stack) {
      this.stack = stack;
   }
}
