package satnpapp;

/**
 *
 * @author john
 */
public class Literal {
   private String name;
   private boolean isNegated;

   public Literal(String literal) {
      if(literal.charAt(0) == 'n') {
         isNegated = true;
         name = literal.substring(1);
      }
      else {
         isNegated = false;
         name = literal;
      }
   }

   public boolean verify(Assignment a) {
      boolean soln = a.getValue(name);
      if(isNegated) {
         soln = !soln;
      }
      return soln;
   }
   
   public String getName() {
      return name;
   }

   public void setName(String name) {
      this.name = name;
   }

   public boolean isIsNegated() {
      return isNegated;
   }

   public void setIsNegated(boolean isNegated) {
      this.isNegated = isNegated;
   }

   @Override
   public String toString() {
      if(isNegated) {
         return "n" + name;
      }
      else {
         return name;
      }
   }
   
   
}
