public class Logic {

    /**
     * This method is used to initialize initial grid with space so that based on user input we will rewrite the values
     */
    public char[][] initializeBoard(char[][] grid){
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[0].length; col++) {
                grid[row][col] = ' ';
            }
        }
        return grid;
    }

    /**
     *
     * This method is used to display the grid when user enters the value
     */
    public void displayBoard(char[][] grid) {
        System.out.println();
        System.out.println(" 0 1 2 3 4 5 6");
        System.out.println("---------------");
        for (int row = 0; row < grid.length; row++) {
            System.out.print("|");
            for (int col = 0; col < grid[0].length; col++) {
                System.out.print(grid[row][col]);
                System.out.print("|");
            }
            System.out.println();
            System.out.println("---------------");
        }
        System.out.println(" 0 1 2 3 4 5 6");
        System.out.println();
    }

    /**
     *
     * This method used to validate where given column is valid or not
     */
    public boolean validatePlay(int column, char[][] grid) {
        //Where given column is between 0 - 6
        if (column < 0 || column > grid[0].length) {
            return false;
        }

        //Verifying whether given column is full
        if (grid[0][column] != ' ') {
            System.out.println();
            System.out.println("Entered column is already full.. Kindly enter the other column");
            return false;
        }

        return true;
    }

    /**
     *
     * @param player: Which player is playing either player red or player blue
     * @param grid: The board where it verifies this player is places the pawns 4 in a row
     * @return: it returns either true or false. True when player wins
     */
    public boolean checkWinner(char player, char[][] grid) {
        //check for 4 across
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[0].length - 3; col++) {
                if (grid[row][col] == player &&
                        grid[row][col + 1] == player &&
                        grid[row][col + 2] == player &&
                        grid[row][col + 3] == player) {
                    return true;
                }
            }
        }
        //check for 4 up and down
        for (int row = 0; row < grid.length - 3; row++) {
            for (int col = 0; col < grid[0].length; col++) {
                if (grid[row][col] == player &&
                        grid[row + 1][col] == player &&
                        grid[row + 2][col] == player &&
                        grid[row + 3][col] == player) {
                    return true;
                }
            }
        }
        //check upward diagonal
        for (int row = 3; row < grid.length; row++) {
            for (int col = 0; col < grid[0].length - 3; col++) {
                if (grid[row][col] == player &&
                        grid[row - 1][col + 1] == player &&
                        grid[row - 2][col + 2] == player &&
                        grid[row - 3][col + 3] == player) {
                    return true;
                }
            }
        }
        //check downward diagonal
        for (int row = 0; row < grid.length - 3; row++) {
            for (int col = 0; col < grid[0].length - 3; col++) {
                if (grid[row][col] == player &&
                        grid[row + 1][col + 1] == player &&
                        grid[row + 2][col + 2] == player &&
                        grid[row + 3][col + 3] == player) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     *
     * Used to verify the value to the column
     */
    public void verifyAndAssignColumn(char [][]grid,int play,char player){
        for (int row = grid.length - 1; row >= 0; row--) {
            if (grid[row][play] == ' ') {
                grid[row][play] = player;
                break;
            }
        }
    }
}
