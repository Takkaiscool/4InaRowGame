import java.util.Scanner;

public class Game {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Logic logic=new Logic();
        char[][] grid = new char[6][7];

        //initialize array
        grid=logic.initializeBoard(grid);

        int turn = 1;
        char player = 'A';
        boolean winner = false;

        //players turn
        while (winner == false && turn <= 42) {
            boolean validPlay;
            int play=-1;
            do {
                logic.displayBoard(grid);
               try {

                   System.out.print("Player " + player + ", choose a column: ");
                   play = in.nextInt();
                   while(play>6){
                       System.out.println();
                       System.out.println("Invalid column enter again");
                       play = in.nextInt();
                   }
               }catch (Exception e){
                   System.out.println();
                   System.out.println("!!!!!___Entered the invalid column character..!!!! Please play the game again");
                   System.exit(0);
               }

                //Validating the entered column
                validPlay = logic.validatePlay(play, grid);

            } while (validPlay == false);

            //Assigning the column value to the grid verifying whether
            logic.verifyAndAssignColumn(grid,play,player);

            //determine if there is a winner
            winner = logic.checkWinner(player, grid);

            //switch players
            if (player == 'A') {
                player = 'B';
            } else {
                player = 'A';
            }

            turn++;
        }
        logic.displayBoard(grid);//Used to display the grid after each player enter the values

        if (winner) {
            if (player == 'A') {
                System.out.println("Player B won");
            } else {
                System.out.println("Player A won");
            }
        } else {
            System.out.println("Tie game");
        }
    }






}
