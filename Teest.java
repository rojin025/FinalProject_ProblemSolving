import java.util.Objects;

public class Teest {
        public static void main(String[] args) {
            String[][] arr  = { {"_","_","X"},
                                {"X","X","X"},
                                {"_","X","_"}};

            String player = "X";
//            System.out.println(winningPattern(arr));
//
//            if (winningPattern(arr)) {
//
//                System.out.printf("Congratulaions!!! Player " + player + " Won!! ");
////                break;
//            }
            System.out.println(userChecker(arr,0,0));

        }

//    public static boolean winningPattern(String[][] board) {
//        //Rows
//        for (int i = 0; i < board.length; i++) {
//            if ((board[i][0].equals(board[i][1])) && (board[i][0].equals(board[i][2])) && (!board[i][0].equals("_")))
//                return true;
//        }
//
//        //Columns
//        for (int i = 0; i < board[0].length; i++) {
//            if ((board[0][i].equals(board[1][i])) && (board[0][i].equals(board[2][i])) && (!board[0][i].equals("_")))
//                return true;
//        }
//
//        //Diagoanls
//        if ((board[0][0].equals(board[1][1])) && (board[0][0].equals(board[2][2])) && (!board[0][0].equals("_")))
//            return true;
//
//        if ((board[0][2].equals(board[1][1])) && (board[0][2].equals(board[2][0])) && (!board[0][2].equals("_")))
//            return true;
//
//        //Last Case
//        return false;
//    }

    public static boolean userChecker(String[][] board, int row, int col) {//"_" == "_" >>>>>>  0
        if ((row >= 0 && row < board.length) && (col >= 0 && col < board[0].length)) { //"a" == "A" >>>>> Ture //     0 == 0 >>>> True
            if ( board[row][col].compareToIgnoreCase("_") == 0){
                return true;
            }else {
                System.out.println("\n###################################################################");
                System.out.println("Please enter correct slot. The value you entered is  already taken!!!");
                System.out.println("###################################################################\n");
                return false;
            }
        } else {
            System.out.println("\n###################################################################");
            System.out.println("Out of boundary, Please enter number from 0 to 2 only. Thank you.");
            System.out.println("###################################################################\n");
            return false;//-1 or 1
        }
    }
//    public static boolean userChecker(String[][] board, int row, int col) {//"_" == "_" >>>>>>  0
//        if (((row >= 0 && row < board.length) && (col >= 0 && col < board[0].length)) && board[row][col].compareToIgnoreCase("_") == 0) { //"a" == "A" >>>>> Ture //     0 == 0 >>>> True
//            return true;//?? >>>> 0
//        } else {
//            return false;//-1 or 1
//        }
//    }

//((row >= 0 && row < board.length) || (col >= 0 && col < board[0].length)) &&

    //&& board[row][col].compareToIgnoreCase("_") == 0
    }
