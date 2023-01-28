import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner read = new Scanner(System.in);
        // 0 = red, 1 = blue
        int playerTurn = 0;

        boolean end = false;
        boolean finalEnd = false;

        //which column user wants to put piece in
        String input = "";
        while (finalEnd == false){
            Board game = new Board();
            game.printBoard();
            while(end == false){
                // creates the board and prints it
                
                // checks which player to ask
                if(playerTurn == 0){
                    System.out.println("Which column would you like to drop your piece player red🔴?");
                    input = read.nextLine();

                    //checks for valid input
                    while(!validInput(input)){
                        System.out.println("\nThat is invalid.");
                        System.out.println("Which column would you like to drop your piece player red🔴?");
                        input = read.nextLine();
                    }

                    game.addPiece(Integer.valueOf(input), 0);
                }
                else{
                    System.out.println("Which column would you like to drop your piece player blue🔵?");
                    input = read.nextLine();

                    //checks for valid input
                    while(!validInput(input)){
                        System.out.println("\nThat is invalid.");
                        System.out.println("Which column would you like to drop your piece player blue🔵?");
                        input = read.nextLine();
                    }

                    game.addPiece(Integer.valueOf(input), 1);
                }
                
                /* 
                while(!notALetter(input) || Integer.parseInt(input) < 1 || Integer.parseInt(input) > 7){
                    
                    System.out.println("\nThat is invalid.");
                    if(playerTurn == 0){
                        System.out.println("Which column would you like to drop your piece player red🔴?");
                        input = read.nextLine();
                        game.addPiece(Integer.valueOf(input), 0);
                    }
                    else{
                        System.out.println("Which column would you like to drop your piece player blue🔵?");
                        input = read.nextLine();
                        game.addPiece(Integer.valueOf(input), 1);
                    }
                    // checking specifically
                    int intInput = Integer.parseInt(input);
                    while(!game.columnEmpty(intInput)){
                        if(playerTurn == 0){
                            System.out.println("Which column would you like to drop your piece player red🔴?");
                            input = read.nextLine();
                            game.addPiece(Integer.valueOf(input), 0);
                        }
                        else{
                            System.out.println("Which column would you like to drop your piece player blue🔵?");
                            input = read.nextLine();
                            game.addPiece(Integer.valueOf(input), 1);
                        }
                    }
                }
                */
            

                //int intInput = Integer.parseInt(input);
                game.printBoard();

                if(playerTurn == 1){
                    playerTurn--;
                }
                else{
                    playerTurn++;
                }
                
                end = game.gameOver();
                
            }   
            System.out.println("Do you want to play again? [y]/[n]");
            if (read.nextLine().equals("n")){
                finalEnd = true;
            } else {
                finalEnd = false;
                end = false;
            }
        }

    }

    /* 
    public static boolean notALetter(String input){
        try{
            int temp = Integer.parseInt(input);
            return true;
        }
        catch(Exception e){
            return false;
        }
    }
    */

    public static boolean validInput(String input){
        int temp = 0;
        //checking so it's a number
        try{
            temp = Integer.parseInt(input);
        }
        catch(Exception e){
            return false;
        }
        //checking so number is in range
        if(temp < 1 || temp > 7){
            return false;
        }
        return true;
    }
}
