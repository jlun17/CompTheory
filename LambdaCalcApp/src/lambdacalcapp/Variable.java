package lambdacalcapp;

/**
 *
 * @author john
 */
public class Variable implements LambdaExpr {

   private char name;

   public Variable(char name) {
      this.name = name;
   }

   public char getName() {
      return name;
   }
   
   @Override
   public LambdaExpr copy() {
      return new Variable(this.name);
   }

   @Override
   public LambdaExpr substitute(Variable var, LambdaExpr value) {
      if(this.name == var.getName()) {
         return value;
      }
      else {
         return this.copy();
      }
   }

   @Override
   public ExprKind type() {
      return ExprKind.VARIABLE;
   }

   @Override
   public int hashCode() {
      int hash = 5;
      hash = 23 * hash + this.name;
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
      final Variable other = (Variable) obj;
      if (this.name != other.name) {
         return false;
      }
      return true;
   }

   @Override
   public String toString() {
      return Character.toString(name);
   }
   
}
