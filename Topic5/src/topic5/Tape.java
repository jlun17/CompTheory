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
