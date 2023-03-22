//
//
//    import java.util.Scanner;
//
//    public class TicTacToe {
//        private static final int BOARD_SIZE = 3;
//        private static final char PLAYER_X = 'X';
//        private static final char PLAYER_O = 'O';
//        private static final char EMPTY_CELL = '-';
//
//        private char[][] board;
//        private char currentPlayer;
//        private boolean gameWon;
//
//        public class TicTacToe_Chat_guide {
//            board = new char[BOARD_SIZE][BOARD_SIZE];
//            currentPlayer = PLAYER_X;
//            gameWon = false;
//            initializeBoard();
//        }
//
//        public void play() {
//            Scanner scanner = new Scanner(System.in);
//
//            while (!gameWon) {
//                printBoard();
//
//                System.out.printf("Player %c, please enter row and column (e.g. 1 2): ", currentPlayer);
//                int row = scanner.nextInt();
//                int col = scanner.nextInt();
//
//                if (isValidMove(row, col)) {
//                    makeMove(row, col);
//                    checkWin();
//                    switchPlayer();
//                } else {
//                    System.out.println("Invalid move, try again.");
//                }
//            }
//
//            printBoard();
//            System.out.printf("Player %c has won!", currentPlayer);
//        }
//
//        private void initializeBoard() {
//            for (int i = 0; i < BOARD_SIZE; i++) {
//                for (int j = 0; j < BOARD_SIZE; j++) {
//                    board[i][j] = EMPTY_CELL;
//                }
//            }
//        }
//
//        private void printBoard() {
//            System.out.println("-------------");
//            for (int i = 0; i < BOARD_SIZE; i++) {
//                System.out.print("| ");
//                for (int j = 0; j < BOARD_SIZE; j++) {
//                    System.out.printf("%c | ", board[i][j]);
//                }
//                System.out.println();
//                System.out.println("-------------");
//            }
//        }
//
//        private boolean isValidMove(int row, int col) {
//            if (row < 0 || row >= BOARD_SIZE || col < 0 || col >= BOARD_SIZE) {
//                return false;
//            }
//
//            return board[row][col] == EMPTY_CELL;
//        }
//
//        private void makeMove(int row, int col) {
//            board[row][col] = currentPlayer;
//        }
//
//        private void switchPlayer() {
//            currentPlayer = currentPlayer == PLAYER_X ? PLAYER_O : PLAYER_X;
//        }
//
//        private void checkWin() {
//            // Check rows
//            for (int i = 0; i < BOARD_SIZE; i++) {
//                if (board[i][0] != EMPTY_CELL && board[i][0] == board[i][1] && board[i][1] == board[i][2]) {
//                    gameWon = true;
//                    return;
//                }
//            }
//
//            // Check columns
//            for (int j = 0; j < BOARD_SIZE; j++) {
//                if (board[0][j] != EMPTY_CELL && board[0][j] == board[1][j] && board[1][j] == board[2][j]) {
//                    gameWon = true;
//                    return;
//                }
//            }
//
//            // Check diagonals
//            if (board[0][0] != EMPTY_CELL && board[0][0] == board[1][1] && board[1][1] == board[2][2]) {
//                gameWon = true;
//                return;
//            }
//
//            if (board[0][2] != EMPTY_CELL && board[0][2] == board[1][1] && board[1][1] == board[2][0]) {
//                gameWon = true;
//                return;
//            }
//        }
//    }
//
//}
