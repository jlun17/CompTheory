package lambdacalcapp;

import java.util.Objects;

/**
 *
 * @author john
 */
public class Abstraction implements LambdaExpr{
   private Variable boundVar;
   private LambdaExpr body;

   public Abstraction() {
   }

   public Abstraction(Variable boundVar, LambdaExpr body) {
      this.boundVar = boundVar;
      this.body = body;
   }

   public Variable getBoundVar() {
      return boundVar;
   }

   public void setBoundVar(Variable boundVar) {
      this.boundVar = boundVar;
   }

   public LambdaExpr getBody() {
      return body;
   }

   public void setBody(LambdaExpr body) {
      this.body = body;
   }
   
   @Override
   public LambdaExpr copy() {
      Abstraction abs = new Abstraction();
      abs.setBody(this.body.copy());
      abs.setBoundVar((Variable) this.boundVar.copy());
      return abs;
   }
   
   @Override
   public LambdaExpr substitute(Variable var, LambdaExpr value) {
      if(this.boundVar.equals(this.body)) {
         return body.substitute(this.boundVar, value);
      }
      else {
         return body.substitute(this.boundVar, value);
      }
   }
   
   @Override
   public ExprKind type() {
      return ExprKind.ABSTRACTION;
   }

   @Override
   public int hashCode() {
      int hash = 7;
      hash = 43 * hash + Objects.hashCode(this.boundVar);
      hash = 43 * hash + Objects.hashCode(this.body);
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
      final Abstraction other = (Abstraction) obj;
      if (!Objects.equals(this.boundVar, other.boundVar)) {
         return false;
      }
      if (!Objects.equals(this.body, other.body)) {
         return false;
      }
      return true;
   }

   @Override
   public String toString() {
      return "(L" + boundVar + ". " + body + ')';
   }
   
}
