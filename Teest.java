public class Teest {
        public static void main(String[] args) {
            String[][] arr  = { {"X","_","X"},
                                {"X","X","X"},
                                {"_","X","O"}};

            String player = "X";
            System.out.println(winningPattern(arr));

            if (winningPattern(arr)) {

                System.out.printf("Congratulaions!!! Player " + player + " Won!! ");
//                break;
            }
        }

        public static boolean winningPattern(String[][] board) {
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





    }
