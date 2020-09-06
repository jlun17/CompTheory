package topic3;

/**
 *
 * @author john
 */
public class Transition {
   private String fromState;
   private String label;
   private String toState;

   public String toString() {
      String str = fromState + "->" + label + "->" + toState;
      return str;
   }
   public Transition() {
      fromState = null;
      label = null;
      toState = null;
   }
   
   public Transition(String fromState, String label, String toState) {
      this.fromState = fromState;
      this.label = label;
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

   public String getToState() {
      return toState;
   }

   public void setToState(String toState) {
      this.toState = toState;
   }
   
   
}
