package topic4;

/**
 *
 * @author john
 */
public class Transition {
   private String fromState;
   private String label;
   private String stackTop;
   private String stackPush;
   private String toState;
   
   public String toString() {
      String str = label + " " + stackTop + " " + stackPush;
      return fromState + " (" + str + ") " +toState;
   }

   public Transition() {
      fromState = null;
      label = null;
      stackTop = null;
      stackPush = null;
      toState = null;
   }

   public Transition(String fromState, String label, String stackTop, String stackPush, String toState) {
      this.fromState = fromState;
      this.label = label;
      this.stackTop = stackTop;
      this.stackPush = stackPush;
      this.toState = toState;
   }

   public String getFromState() {
      return fromState;
   }

   public void setFromState(String fromState) {
      this.fromState = fromState;
   }
   
   public String getLabel() {
      return label;
   }
   
   public void setLabel(String label) {
      this.label = label;
   }

   public String getStackTop() {
      return stackTop;
   }

   public void setStackTop(String stackTop) {
      this.stackTop = stackTop;
   }

   public String getStackPush() {
      return stackPush;
   }

   public void setStackPush(String stackPush) {
      this.stackPush = stackPush;
   }

   public String getToState() {
      return toState;
   }

   public void setToState(String toState) {
      this.toState = toState;
   }
   
   
   
   
}
