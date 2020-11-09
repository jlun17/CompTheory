package lambdacalcapp;

/**
 *
 * @author john
 */
public interface LambdaExpr {
   public LambdaExpr copy();
   public LambdaExpr substitute(Variable var, LambdaExpr value);
   public ExprKind type();
}
