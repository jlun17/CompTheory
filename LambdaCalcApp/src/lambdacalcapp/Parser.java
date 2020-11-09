package lambdacalcapp;

/**
 *
 * @author john
 */
public class Parser {

   public Parser() {
   }
   
   public LambdaExpr parse(String term) throws ParseException {
      if(term.length() < 1) {
         throw new ParseException("Invalid Expression");
      }
      else if(term.length() == 1) {
         return parseVariable(term);
      }
      else if(term.charAt(0) == '(') {
         int endInd = findBalancedRightParenPos(term);
         if(endInd == -1) {
            throw new ParseException("Invalid Expression");
         }
         if(endInd + 1 == term.length()) {
            return parse(term.substring(1, endInd));
         }
         else {
            return parseApplication(term);
         }
      }
      else if(term.charAt(0) == 'L') {
         return parseAbstraction(term);
      }
      else {
         return parseApplication(term);
      }
   }
   
   private Abstraction parseAbstraction(String term) throws ParseException {
      Abstraction abs = new Abstraction();
      Variable boundVar;
      if(term.charAt(2) != '.') {
         throw new ParseException("Invalid Expression");
      }
      else {
         boundVar = parseVariable(Character.toString(term.charAt(1)));
      }
      abs.setBoundVar(boundVar);
      if(term.charAt(3) != ' ') {
         throw new ParseException("Invalid Expression");
      }
      else {
         abs.setBody(parse(term.substring(4)));
      }
      return abs;
   }
   
   private Application parseApplication(String term) throws ParseException {
      Application app = new Application();
      if(term.endsWith(")")) {
         int separation = -1;
         for(int i = 0; i < term.length(); i++) {
            if(term.charAt(i) == '(') {
               int pos = findBalancedRightParenPos(term.substring(i));
               pos += i;
               if(pos == term.length() - 1) {
                  separation = i;
               }
            }
         }
         if(separation == -1) {
            throw new ParseException("Invalid Expression");
         }
         else{
            app.setOperand1(parse(term.substring(0, separation - 1)));
            app.setOperand2(parse(term.substring(separation)));
         }
      }
      else {
         app.setOperand1(parse(term.substring(0, term.length() - 2)));
         app.setOperand2(parse(term.substring(term.length() - 1)));
      }
      
      return app;
   }
   
   private Variable parseVariable(String term) throws ParseException {
      if(term.length() != 1) {
         throw new ParseException("Invalid Expression");
      }
      else {
         return new Variable(term.charAt(0));
      }
   }
   
   private int findBalancedRightParenPos(String term) throws ParseException {
      int counter = 0;
      for(int i = 0; i < term.length(); i++) {
         if(term.charAt(i) == '(') {
            counter++;
         }
         if(term.charAt(i) == ')') {
            counter --;
            if(counter == 0) {
               return i;
            }
         }
      }
      return -1;
   }
}
