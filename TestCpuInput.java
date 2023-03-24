//import java.util.Random;
//
//public class TestCpuInput {
//
//    public static void main(String[] args) {
//        String[][] arr  = { {"_","_","X"},
//                            {"X","X","X"},
//                             {"_","X","_"}};
//
//        String player = "X";
//        getCpuCorrectInput(arr,'X');
//
//    }
//
//    public static void getCpuCorrectInput(String[][] board, char player) {//X or O
//        Random random = new Random();
//        int row, col;
//        row = random.nextInt(3);
//        col = random.nextInt(3);
//        while (cpuChecker(board, row, col) != true) {
//            getCpuCorrectInput(board, player);
//        }
//        updateBoard(board, row, col, player);
//    }
//    public static String[][] updateBoard(String[][] board, int row, int col, char player) {// player = "X" or "O"
//        board[row][col] = String.valueOf(player);//Make it moduler for X or O. // board[1][1] = "X" // value before "_"
//        return board;
//    }
//    public static boolean cpuChecker(String[][] board, int row, int col) {//"_" == "_" >>>>>>  0
//        if ((row >= 0 && row < board.length) && (col >= 0 && col < board[0].length)) { //"a" == "A" >>>>> Ture //     0 == 0 >>>> True
//            if ( board[row][col].compareToIgnoreCase("_") == 0){
//                return true;
//            }else {
//                return false;
//            }
//        } else {
//            return false;//-1 or 1
//        }
//    }
//
//
//    //Main
//}
