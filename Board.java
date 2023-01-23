public class Board{
    //creates a new board 
    String[][] array = new String[6][7];
    // clears the board
    public static void main(String[] args){
        Board game = new Board();
        game.addPiece(0, 1);
        game.printBoard();
    }

    // makes the board empty
    public Board(){
        for (int i = 0; i < 6; i++){
            for (int j = 0; j < 7; j++){
                array[i][j] = "[ ]";
            }
        }
    } 

    //returns the board
    public String[][] getBoard(){
        return array;
    }

    // prints the current state of the board
    public void printBoard(){
        for (String[] list : array){
            for (String a : list){
                System.out.print(a + " ");
            }
            System.out.println();
        }
    }

    // adds the corresponding piece to the lowest open slot in the column
    public void addPiece(int column, int player){
        for (int i = 5; i >= 0; i--){
            if (array[i][column].equals("[ ]")){
                if (player == 0){
                    array[i][column] = " 🔴";
                    break;
                } else {
                    array[i][column] = " 🔵";
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
        
        return false;
    }
}