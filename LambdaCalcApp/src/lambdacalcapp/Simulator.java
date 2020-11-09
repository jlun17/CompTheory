package lambdacalcapp;

/**
 *
 * @author john
 */
public class Simulator {

   public Simulator() {
   }
   
   /**
    * This method runs at a Big O(n) with n being the depth of the LambdaExpr
    * parse tree.
    * @param expr
    * @return
    * @throws DivergentException 
    */
   public LambdaExpr betaReduce(LambdaExpr expr) throws DivergentException{
      if(expr.type().compareTo(ExprKind.VARIABLE) == 0) {
         return expr;
      }
      else if(expr.type().compareTo(ExprKind.APPLICATION) == 0) {
         Application app = (Application) expr.copy();
         if(app.getOperand1().type().compareTo(ExprKind.VARIABLE) == 0) {
            return new Application(app.getOperand1(), betaReduce(app.getOperand2()));
         }
         if(app.getOperand1().type().compareTo(ExprKind.ABSTRACTION) == 0) {
            return app.getOperand1().substitute(new Variable(' '), app.getOperand2());
         }
         else {
            return new Application(betaReduce(app.getOperand1()), betaReduce(app.getOperand2()));
         }
      }
      else if(expr.type().compareTo(ExprKind.ABSTRACTION) == 0) {
         Abstraction abs = (Abstraction) expr.copy();
         return new Abstraction(abs.getBoundVar(), betaReduce(abs.getBody()));
      }
      return expr;
   }
}
