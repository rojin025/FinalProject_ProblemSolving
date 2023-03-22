import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        boolean isGameOn = true;
        String board[][] = {{"_","_","_"},
                            {"_","_","_"},
                            {"_","_","_"}};
        char player;
        int row,col;
        //Tictactoe Game List

        Scanner input = new Scanner(System.in);
            //know the winning pattern


            //While the game is not ended
//            while (isGameOn == true){
//
//                System.out.printf("Inside while loop");
//                //isGameOn = gameOn();
//                System.out.println("\n\nEnter a position:");
//                int x = input.nextInt();
//
//                if (x >= 1)
//                    isGameOn= true;
//                else
//                    isGameOn= false;
//            }

        for (int i = 0; i < 9; i++) {
            printBoard(board); //Printing board
            if(i%2 == 0){
                System.out.printf("Player \" X \" Turn.\n");
                System.out.printf("\n");
                player = 'X';
                row = getRow();
                col = getCol();
                if(userChecker(board,row,col))
                    updateBoard(board,row,col,player);
                else {
                    getCorrectInput(board,player);
                }
            }
            else {
                System.out.printf("Player \" O \" Turn.\n");
                System.out.printf("\n");
                player = 'O';
                row = getRow();
                col = getCol();
                if(userChecker(board,row,col))
                    updateBoard(board,row,col,player);
                else
                    getCorrectInput(board,player);
            }
            //Checking Winner
            boolean x = winningPattern(board);
                if (x == true) {
                    System.out.printf("Congratulaions!!! " + player + "Won!! ");
                    break;
                }
            System.out.printf("i is " + i);
        }

        printBoard(board);

    }

    public static boolean winningPattern(String[][] board){
        //Rows
        for (int i = 0; i < board.length; i++) {
            if ((board[i][0] == board[i][1]) && (board[i][0] == board[i][2]) && (board[i][0] != "_"))
                return true;
        }

        //Columns
        for (int i = 0; i < board[0].length; i++) {
            if ((board[0][i] == board[1][i]) && (board[0][i] == board[2][i]) && (board[0][i] != "_"))
                return true;
        }

        //Diagoanls
        if((board[0][0] == board[1][1]) && (board[0][0] == board[2][2]) && (board[0][0] != "_"))
            return true;

        if((board[0][2] == board[1][1]) && (board[0][2] == board[2][0]) && (board[0][2] != "_"))
            return true;

        //Last Case
        return false;
    }

    public static void getCorrectInput(String [][] board,char player){
        int row, col;
        System.out.printf("\n\n\n############Please Enter correct Value!############\n\n\n");
        row = getRow();
        col = getCol();
        while (userChecker(board,row,col)!=true){
            getCorrectInput(board,player);
        }
        updateBoard(board,row,col,player);
    }

    public static int getRow(){
        Scanner input = new Scanner(System.in);
        System.out.printf("Please enter your row : ");
        int row = input.nextInt();
        return row;
    }
    public static int getCol(){
        Scanner input = new Scanner(System.in);
        System.out.printf("Please enter your Colume : ");
        int col = input.nextInt();
        System.out.printf("\n");
        return col;
    }
    //Inside Game
//    public static boolean gameOn (){
//        //System input = new Scanner(System.in);
//
//        System input = new System(System.in);
//
//        System.out.printf("Enter a position");
//        int x = input.nextInt();
//
//        if (x >= 1)
//            return true;
//        else
//            return false;

//    }
//    //Current Board
//    public static void currentBoard(){//int [] x, int [] y // where x and y are given by user
////        int row = new int [4];
////        int col = new int [4];
//
//        int [][] board = {{0,1,2},{0,1,2},{0,1,2}};
//        int row = board.length;
//        int col = board[0].length;
////        int [] col = {0,1,2,3};
//
//        for (int i = 0; i < row; i++) {
//            for (int j = 0; j < col; j++) {
//                System.out.printf(i + " " + j +" \t");
//            }
//            System.out.printf("\n");
//        }
//
//    }

    //Print Board
    public static void printBoard(String [][] board){//Prints board
        int row = board.length;
        int col = board[0].length;
        System.out.printf("******************\n");
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if(j<2)
                    System.out.printf(board[i][j] + " | " +" \t");//Printing matrix point [0,1] and [0,2]
                else
                    System.out.printf(board[i][j] + "  " +" \t");//Printing matrix point [0,3]
            }
            System.out.printf("\n");
            if(i<2)
                System.out.printf("__________________\n");//Printing Middle lines in board
            else
                System.out.printf("******************\n");//Printing Last lines in board
        }
    }
    //Game Board

    //input Checks if there is available space in the current board
    public static boolean userChecker(String [][] board, int row, int col){
        if(board[row][col].compareToIgnoreCase("_") == 0){
            return true;
        } else {
            return false;
        }
    }
    //Repalce "_" to X or O
    public static String[][] updateBoard(String[][] board, int row, int col,char player){
        board[row][col] = String.valueOf(player);//Make it moduler for X or O.
        return board;
    }

    //Winning Pattern

    public static String [][] gameBoard(){//int [] x, int [] y // where x and y are given by user
        String [][] board = {{"_","_","_"},{"_","_","_"},{"_","_","_"}};
        int row = board.length;
        int col = board[0].length;
        System.out.printf("******************\n");
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if(j<2)
                    System.out.printf(board[i][j] + " | " +" \t");//Printing matrix point [0,1] and [0,2]
                else
                    System.out.printf(board[i][j] + "  " +" \t");//Printing matrix point [0,3]

//                System.out.printf(i + " " + j +" \t");
            }

            System.out.printf("\n");
            if(i<2)
                System.out.printf("__________________\n");//Printing Middle lines in board
            else
                System.out.printf("******************\n");//Printing Last lines in board
        }

        return board;
    }
}