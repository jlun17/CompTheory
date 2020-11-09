package lambdacalcapp;

import java.util.Objects;

/**
 *
 * @author john
 */
public class Application implements LambdaExpr{

   private LambdaExpr operand1;
   private LambdaExpr operand2;

   public Application() {
   }

   public Application(LambdaExpr operand1, LambdaExpr operand2) {
      this.operand1 = operand1;
      this.operand2 = operand2;
   }

   public LambdaExpr getOperand1() {
      return operand1;
   }

   public void setOperand1(LambdaExpr operand1) {
      this.operand1 = operand1;
   }

   public LambdaExpr getOperand2() {
      return operand2;
   }

   public void setOperand2(LambdaExpr operand2) {
      this.operand2 = operand2;
   }
   
   @Override
   public LambdaExpr copy() {
      Application app = new Application();
      app.setOperand1(this.operand1.copy());
      app.setOperand2(this.operand2.copy());
      return app;
   }

   @Override
   public LambdaExpr substitute(Variable var, LambdaExpr value) {
      Application app = new Application();
      app.setOperand1(operand1.substitute(var, value));
      app.setOperand2(operand2.substitute(var, value));
      return app;
   }

   @Override
   public ExprKind type() {
      return ExprKind.APPLICATION;
   }

   @Override
   public int hashCode() {
      int hash = 5;
      hash = 31 * hash + Objects.hashCode(this.operand1);
      hash = 31 * hash + Objects.hashCode(this.operand2);
      return hash;
   }

   @Override
   public boolean equals(Object obj) {
      if (this == obj) {
         return true;
      }
      if (obj == null) {
         return false;
      }
      if (getClass() != obj.getClass()) {
         return false;
      }
      final Application other = (Application) obj;
      if (!Objects.equals(this.operand1, other.operand1)) {
         return false;
      }
      if (!Objects.equals(this.operand2, other.operand2)) {
         return false;
      }
      return true;
   }

   @Override
   public String toString() {
      return operand1 + " " + operand2;
   }
   
}
