import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Board game = new Board();
        Scanner read = new Scanner(System.in);
        
        // 0 = red, 1 = blue
        int playerTurn = 0;

        //to see if the game should end
        boolean end = false;

        //which column user wants to put piece in
        String input = "";

        while(end == false){
            // checks which player to ask
            if(playerTurn == 0){
                System.out.println("Which column would you like to drop you piece player red?");
                input = read.nextLine();
            }
            else{
                System.out.println("Which column would you like to drop you piece player blue?");
                input = read.nextLine();
            }
            
            while(!notALetter(input) || Integer.parseInt(input) < 0 || Integer.parseInt(input) > 6){
                
                System.out.println("\nThat is invalid.");
                if(playerTurn == 0){
                    System.out.println("Which column would you like to drop you piece player red?");
                    input = read.nextLine();
                }
                else{
                    System.out.println("Which column would you like to drop you piece player blue?");
                    input = read.nextLine();
                }
                // checking specifically
                int intInput = Integer.parseInt(input);
                while(!game.columnEmpty(intInput)){
                    if(playerTurn == 0){
                        System.out.println("Which column would you like to drop you piece player red?");
                        input = read.nextLine();
                    }
                    else{
                        System.out.println("Which column would you like to drop you piece player blue?");
                        input = read.nextLine();
                    }
                }
            }
        

            int intInput = Integer.parseInt(input);
            game.addPiece(intInput, playerTurn);
            
            


            if(playerTurn == 1){
                playerTurn--;
            }
            else{
                playerTurn++;
            }
            
        }

    }

    public static boolean notALetter(String input){
        try{
            int temp = Integer.parseInt(input);
            return true;
        }
        catch(Exception e){
            return false;
        }
    }
}
