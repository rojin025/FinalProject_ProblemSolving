import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        String[][] board = {{"_", "_", "_"},
                            {"_", "_", "_"},
                            {"_", "_", "_"}};
        char player;
        int row, col;

        Scanner input = new Scanner(System.in);

        System.out.println("X is going to be a first player. ");
        for (int i = 0; i < 9; i++) { //9
            printBoard(board); //Printing board
            if (i % 2 == 0) {
                //Player X inputs
                System.out.println("Player \"X\" Turn.\n");
                player = 'X';
            } else {
                //Player O inputs
                System.out.println("Player \"O\" Turn.\n");
                player = 'O';
            }
            row = getRow();//0
            col = getCol();//1
            if (userInputChecker(board, row, col)) {
                updateBoard(board, row, col, player);
            } else {
                getCorrectInput(board, player);
            }
            //Checking Winner
            if (i > 3 && winningPattern(board)) { //We need atleast 5 move's to get winning patter //Break
                System.out.printf("Congratulaions!!! Player \"" + player + "\" Won!! \n");
                break;
            }
        }

        printBoard(board);//Printing Board last time
        System.out.println("Game Over");
    }

    //Game Board
    public static void printBoard(String[][] board) {//Prints board
        //  String[][] board =       {{"_", "_", "_"},
        //                            {"_", "_", "_"},
        //                            {"_", "_", "_"}};

        int row = board.length;//{{0},{1},{2}}
        int col = board[0].length;//{"_", "_", "_"},
        System.out.printf("\n****Tic Tac Toe****\n");
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (j < 2) System.out.printf(board[i][j] + " | " + " \t");// c0 | c1 | c2
                else System.out.printf(board[i][j] + "  " + " \t");//Printing matrix point [0,3]
            }
            System.out.printf("\n");
            if (i < 2) System.out.printf("__________________\n");//Printing Middle lines in board r0----r1---r2
            else System.out.printf("******************\n");//Printing Last lines in board    *******
        }
    }

    public static int getRow() {
        Scanner input = new Scanner(System.in);
        System.out.print("Please enter your row : ");
        int row = input.nextInt();
        return row;//0
    }

    //input Checks if there is available space in the current board
    public static boolean userInputChecker(String[][] board, int row, int col) {//"_" == "_" >>>>>>  0
        if ((row >= 0 && row < board.length) && (col >= 0 && col < board[0].length)) { // Check boundary
            if ( board[row][col].compareToIgnoreCase("_") == 0){//"a" == "A" >>>>> Ture //     0 == 0 >>>> True
                return true;
            }else {
                System.out.println("\n#######################################################################");
                System.out.println("Please enter correct slot. The value you entered is  already taken!!!");
                System.out.println("#######################################################################\n");
                return false;
            }
        } else {
            System.out.println("\n###################################################################");
            System.out.println("Out of boundary, Please enter number from 0 to 2 only. Thank you.");
            System.out.println("###################################################################\n");
            return false;//-1 or 1
        }
    }
    //Update board with X or O.
    public static void updateBoard(String[][] board, int row, int col, char player) {// player = "X" or "O"
        board[row][col] = String.valueOf(player);//Make it moduler for X or O. // board[1][1] = "X" // value before "_"
    }


    public static void getCorrectInput(String[][] board, char player) {//X or O
        int row, col;
        row = getRow();//1
        col = getCol();//1
        while (userInputChecker(board, row, col) != true) {
            getCorrectInput(board, player);
        }
        updateBoard(board, row, col, player);
    }
    public static boolean winningPattern(String[][] board) {

//        String[][] board = {{"_", "_", "_"},
//                            {"_", "_", "_"},
//                            {"_", "_", "_"}};
        //Rows
        for (int i = 0; i < board.length; i++) {
            if ((board[i][0].equals(board[i][1])) && (board[i][0].equals(board[i][2])) && (!board[i][0].equals("_")))
                return true;
        }

        //Columns
        for (int i = 0; i < board[0].length; i++) {
            if ((board[0][i].equals(board[1][i])) && (board[0][i].equals(board[2][i])) && (!board[0][i].equals("_")))
                return true;
        }

        //Diagoanls
        if ((board[0][0].equals(board[1][1])) && (board[0][0].equals(board[2][2])) && (!board[0][0].equals("_")))
            return true;

        if ((board[0][2].equals(board[1][1])) && (board[0][2].equals(board[2][0])) && (!board[0][2].equals("_")))
            return true;

        //Last Case
        return false;
    }

    public static int getCol() {
        Scanner input = new Scanner(System.in);
        System.out.print("Please enter your Colume : ");
        int col = input.nextInt();//1
        System.out.print("\n");
        return col;//1
    }
    //Main
}