import java.util.Scanner;
public class TicTacToe {
    private static int moveCnt = 0;
    private static final int ROW = 3;
    private static final int COL = 3;
    private static String board [][] = new String[ROW][COL];

    public static void main(String[] args) {
        int xRow = 0;
        int xCol = 0;
        boolean gameOver = false;
        Scanner in = new Scanner(System.in);
        String currentPlayer = "X";
        clearBoard();
        display();
        do {
            do {
                xRow = SafeInput.getRangedInt(in, "Player " + currentPlayer + " Enter row", 1, 3)-1;
                xCol = SafeInput.getRangedInt(in, "Player " + currentPlayer + " Enter column", 1, 3)-1;
            } while (!isValidMove(xRow, xCol));
            board[xRow][xCol] = currentPlayer;
            moveCnt++;
            display();

            if(moveCnt > 4){
                if (isWin(currentPlayer)){
                    System.out.println(currentPlayer + " wins!");
                    clearBoard();
                    gameOver = !SafeInput.getYNConfirm(in, "Do you want to play again?");
                    currentPlayer = "O"; // so player resets to X for next game
                    display();
                }
                if(isTie()){
                    System.out.println("It's a tie!");
                    clearBoard();
                    gameOver = !SafeInput.getYNConfirm(in, "Do you want to play again?");
                    currentPlayer = "O"; // so player resets to X for next game
                    display();
                }

            }
            if(currentPlayer == "X"){
                currentPlayer = "O";
            }else{
                currentPlayer = "X";
            }

        }while(!gameOver);

    }
    private static void clearBoard(){
        for(int row=0; row < ROW; row++)
        {
            for(int col=0; col < COL; col++)
            {
                board[row][col] = " ";
            }
        }
        moveCnt = 0;
    }
    private static void display(){
        for(int row=0; row < ROW; row++)
        {
            for(int col=0; col < COL; col++)
            {
                System.out.print(board[row][col]);
                if(col == 0 || col == 1) {
                    System.out.print("|");
                }
            }
            System.out.println();
        }
    }
    private static boolean isValidMove(int row, int col){
        boolean retVal = false;
        if(board[row][col].equals(" "))
            retVal = true;
        return retVal;
    }
    private static boolean isWin(String player){
        if(isColWin(player) || isRowWin(player) || isDiagnalWin(player))
        {
            return true;
        }
        return false;
    }
    private static boolean isColWin(String player){
        for(int col=0; col < COL; col++)
        {
            if(board[0][col].equals(player) && board[1][col].equals(player) && board[2][col].equals(player))
            {
                return true;
            }
        }
        return false;
    }
    private static boolean isRowWin(String player){
        for(int row=0; row < ROW; row++)
        {
            if(board[row][0].equals(player) && board[row][1].equals(player) && board[row][2].equals(player))
            {
                return true;
            }
        }
        return false; // no row win
    }
    private static boolean isDiagnalWin(String player){
        if(board[0][0].equals(player) && board[1][1].equals(player) && board[2][2].equals(player))
        {
            return true;
        }
        if(board[2][0].equals(player) && board[1][1].equals(player) && board[0][2].equals(player))
        {
            return true;
        }
        return false;
    }
    private static boolean isTie(){
        if(moveCnt == 9 && !isWin("X") && !isWin("O")){
            return true;
        }
        return false;
    }
}