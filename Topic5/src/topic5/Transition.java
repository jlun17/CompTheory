package topic5;

/**
 *
 * @author john
 */
public class Transition {
   private String fromState;
   private String inputSymbol;
   private String writeSymbol;
   private String direction;
   private String toState;
   
   public String toString() {
      String str = fromState + " (" + inputSymbol + " -> " + writeSymbol + ", "
         + direction + ") " + toState + "\n";
      return str;
   }

   public Transition() {
      fromState = null;
      inputSymbol = null;
      writeSymbol = null;
      direction = null;
      toState = null;
   }

   public Transition(String fromState, String inputSymbol, String writeSymbol, String direction, String toState) {
      this.fromState = fromState;
      this.inputSymbol = inputSymbol;
      this.writeSymbol = writeSymbol;
      this.direction = direction;
      this.toState = toState;
   }

   public String getFromState() {
      return fromState;
   }

   public void setFromState(String fromState) {
      this.fromState = fromState;
   }

   public String getInputSymbol() {
      return inputSymbol;
   }

   public void setInputSymbol(String inputSymbol) {
      this.inputSymbol = inputSymbol;
   }

   public String getWriteSymbol() {
      return writeSymbol;
   }

   public void setWriteSymbol(String writeSymbol) {
      this.writeSymbol = writeSymbol;
   }

   public String getDirection() {
      return direction;
   }

   public void setDirection(String direction) {
      this.direction = direction;
   }

   public String getToState() {
      return toState;
   }

   public void setToState(String toState) {
      this.toState = toState;
   }
   
   
}
