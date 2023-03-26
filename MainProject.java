import java.util.Random;
import java.util.Scanner;

public class MainProject {
    public static void main(String[] args) {

        Random random = new Random();
        Scanner input = new Scanner(System.in);

        String[][] board = {{"_", "_", "_"},
                            {"_", "_", "_"},
                            {"_", "_", "_"}};

        char player;
        int row, col;



        //printBoard(board); //Printing board
        for (int i = 0; i < 9; i++) { //9
            if (i % 2 == 0) {
                //Player X inputs
                System.out.println("CPU \"X\" Turn.\n");
                player = 'X';
                row = random.nextInt(3);
                col = random.nextInt(3);
                if (cpuChecker(board, row, col)) {
                    updateBoard(board, row, col, player);
                    printBoard(board);
                } else {
                    getCpuCorrectInput(board, player);
                }
            } else {
                //Player O inputs
                System.out.println("Player \"O\" Turn.\n");
                player = 'O';
                row = getRow();
                col = getCol();
                if (userInputChecker(board, row, col)) {
                    updateBoard(board, row, col, player);
                } else {
                    getCorrectInput(board, player);
                }
            }

            //Checking Winner
            if (i > 4 && winningPattern(board)) { //We need atleast 5 move's to get winning patter //Break
                System.out.println("%%%%%%%%%%%%%%%%%%%");
                System.out.printf("Congratulaions!!! Player \"" + player + "\" Won!! \n");
                System.out.println("%%%%%%%%%%%%%%%%%%%");
                break;
            }
        }

        printBoard(board);//Printing Board last time
        System.out.println("Game Over");

    }

    public static boolean winningPattern(String[][] board) {
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

    public static void getCpuCorrectInput(String[][] board, char player) {//X or O
        Random random = new Random();
        int row, col;
        row = random.nextInt(3);
        col = random.nextInt(3);
        while (cpuChecker(board, row, col) != true) {
            getCpuCorrectInput(board, player);
        }
        updateBoard(board, row, col, player);
    }
    public static boolean cpuChecker(String[][] board, int row, int col) {//"_" == "_" >>>>>>  0
        if ((row >= 0 && row < board.length) && (col >= 0 && col < board[0].length)) { //"a" == "A" >>>>> Ture //     0 == 0 >>>> True
            if ( board[row][col].compareToIgnoreCase("_") == 0){
                return true;
            }else {
                return false;
            }
        } else {
            return false;//-1 or 1
        }
    }

    public static void printBoard(String[][] board) {//Prints board
        int row = board.length;
        int col = board[0].length;
        System.out.printf("******************\n");
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (j < 2) System.out.printf(board[i][j] + " | " + " \t");//Printing matrix point [0,1] and [0,2]
                else System.out.printf(board[i][j] + "  " + " \t");//Printing matrix point [0,3]
            }
            System.out.printf("\n");
            if (i < 2) System.out.printf("__________________\n");//Printing Middle lines in board
            else System.out.printf("******************\n");//Printing Last lines in board
        }
    }

    //Game Board
    public static void getCorrectInput(String[][] board, char player) {//X or O
        int row, col;
        //System.out.print("\n\n\n############Please Enter correct Value!############\n\n\n");
        row = getRow();//0
        col = getCol();//1
        while (userInputChecker(board, row, col) != true) {
            getCorrectInput(board, player);
        }
        updateBoard(board, row, col, player);
    }

    public static int getCol() {
        Scanner input = new Scanner(System.in);
        System.out.print("Please enter your Colume : ");
        int col = input.nextInt();//1
        System.out.print("\n");
        return col;//1
    }


    public static boolean userInputChecker(String[][] board, int row, int col) {//"_" == "_" >>>>>>  0
        if ((row >= 0 && row < board.length) && (col >= 0 && col < board[0].length)) { //"a" == "A" >>>>> Ture //     0 == 0 >>>> True
            if ( board[row][col].compareToIgnoreCase("_") == 0){
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

    //input Checks if there is available space in the current board
    public static int getRow() {
        Scanner input = new Scanner(System.in);
        System.out.print("Please enter your row : ");
        int row = input.nextInt();
        return row;//0
    }

    public static String[][] updateBoard(String[][] board, int row, int col, char player) {// player = "X" or "O"
        board[row][col] = String.valueOf(player);//Make it moduler for X or O. // board[1][1] = "X" // value before "_"
        return board;
    }



}
