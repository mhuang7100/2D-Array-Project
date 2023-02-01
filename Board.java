public class Board{
    //creates a new board 
    String[][] array = new String[6][7];
    // stores the Row/Column location of the last piece placed (for purposes of checking if the player won)
    int prevC;
    int prevR;
    
    
    // makes the board empty
    public Board(){
        for (int i = 0; i < 6; i++){
            for (int j = 0; j < 7; j++){
                array[i][j] = "[ ]";
            }
        }
        prevC = 1;
        prevR = 5;
    } 

    //returns the board
    public String[][] getBoard(){
        return array;
    }

    // prints the current state of the board
    public void printBoard(){
        System.out.print("\033[2J\033[H");
        // prints column numbers
        for (int i = 1; i <= 7; i++){
            System.out.print(" " + i + "  ");
        }
        System.out.println();
        // prints board
        for (String[] list : array){
            for (String a : list){
                System.out.print(a + " ");
            }
            System.out.println();
        }
    }

    // adds the corresponding piece to the lowest open slot in the column
    public void addPiece(int column, int player){
        // makes player input line up with the actual indexes
        column -= 1;
        
        for (int i = 5; i >= 0; i--){
            if (array[i][column].equals("[ ]")){
                if (player == 0){
                    array[i][column] = " 🔴";
                    prevC = column;
                    prevR = i;
                    break;
                } else {
                    array[i][column] = " 🔵";
                    prevC = column;
                    prevR = i;
                    break;
                }
            }
        }
    }

    // checks if the column is empty. returns true if it is, false if the entire column is filled with pieces
    public boolean columnEmpty(int column){
        if (array[0][column].equals("[ ]")){
            return true;
        } else {
            return false;
        }
    }

    // FINISH THIS
    public boolean gameOver(){
        // this var indicates how many checkers are connected 
        int win = 1;
        // checks horizontally
        
        for (int i = 1; i <= Math.min(6 - prevC, 3); i++){
            if (array[prevR][prevC].equals(array[prevR][prevC + i])){
                win += 1;
            } else break;
        }
        for (int i = 1; i <= Math.min(prevC, 3); i++){
            if (array[prevR][prevC].equals(array[prevR][prevC - i])){
                win += 1;
            } else break;
        }
        if (win == 4){
            System.out.println("GAME OVER");
            return true;
        }
        win = 1;
        
        
        // checks vertically
        if (prevR <= 2){
            if (array[prevR][prevC].equals(array[prevR + 1][prevC]) && array[prevR][prevC].equals(array[prevR + 2][prevC]) && array[prevR][prevC].equals(array[prevR + 3][prevC])){
                System.out.println("GAME OVER"); 
                return true;
            }
        }
        
        // checks diagonally 
        
        for (int i = 1; i <= Math.min(6 - prevC, prevR); i++){
            if (array[prevR][prevC].equals(array[prevR - i][prevC + i])){
                win += 1;
            } else break;
        }
        for (int i = 1; i <= Math.min(prevC, 5 - prevR); i++){
            if (array[prevR][prevC].equals(array[prevR + i][prevC - i])){
                win += 1;
            } else break;
        }
        if (win == 4){
            System.out.println("GAME OVER"); 
            return true;
        }

        win = 1;
        for (int i = 1; i <= Math.min(prevC, prevR); i++){
            if (array[prevR][prevC].equals(array[prevR - i][prevC - i])){
                win += 1;
            } else break;
        }
        for (int i = 1; i <= Math.min(6 - prevC, 5 - prevR); i++){
            if (array[prevR][prevC].equals(array[prevR + i][prevC + i])){
                win += 1;
            } else break;
        }

        if (win == 4){
            System.out.println("GAME OVER"); 
            return true;
        }
        
        return false;
    }
}