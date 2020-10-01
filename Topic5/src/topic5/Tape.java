package topic5;

import java.util.ArrayList;

/**
 *
 * @author john
 */
public class Tape {
   ArrayList<Character> cells;
   int headPosition;
   
   public Tape(String input) {
      this.cells = new ArrayList<Character>();
      for (int i = 0; i < input.length(); i++) {
         cells.add(input.charAt(i));
      }
      headPosition = 0;
   }
   
   public String config(String currentState) {
      String str = "";
      for(int i = 0; i < cells.size(); i++) {
         if(i == headPosition) {
            str += currentState;
         }
         if(cells.get(i) == ' ') {
            str += "_";
         }
         else {
            str += cells.get(i).toString();
         }
      }
      return str;
   }

   public ArrayList<Character> getCells() {
      return cells;
   }

   public void writeCell(Character writeSymbol) {
      cells.set(this.headPosition, writeSymbol);
   }

   public Character currentSymbol() {
      return cells.get(headPosition);
   }

   public void moveLeft() {
      if(this.headPosition != 0) {
         this.headPosition -= 1;
      }
   }
   
   public void moveRight() {
      if(this.headPosition < cells.size()-1) {
         this.headPosition += 1;
      }
      else {
         cells.add(' ');
         this.headPosition += 1;
      }
   }
   
   
}
