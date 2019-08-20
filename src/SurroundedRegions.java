public class SurroundedRegions {

    public void solve(char[][] board) {
        int numRows = board.length;
        if (numRows == 0) {
            return;
        }
        int numColumns = board[0].length;

        for (int row = 0; row < numRows; row++) {
            for (int column = 0; column < numColumns; column++) {
                if (board[row][column] == 'X') {
                    dfs(board, row, column);
                }
            }
        }

        if (numRows > 2) {
            for (int col = 0; col < numColumns; col ++) {
                if (board[0][col] == 'O' && board[1][col] == 'C') {
                    board[1][col] = 'O';
                }

                if (board[numRows-1][col]  == 'O' && board[numRows-2][col] == 'C') {
                    board[numRows-2][col] = 'O';
                }
            }
        }

        if (numColumns > 2) {
            for (int row = 0; row < numRows; row++) {
                if (board[row][0] == 'O' && board[row][1] == 'C') {
                    board[row][1] = 'O';
                }

                if (board[row][numColumns-1] == 'O' && board[row][numColumns-2] == 'C') {
                    board[row][numColumns-2] = 'O';
                }
            }
        }

        for (int row = 0; row < numRows; row++) {
            for (int column = 0; column < numColumns; column++) {
                if (board[row][column] == 'C' || board[row][column] == 'V') {
                    board[row][column] = 'X';
                }
            }
        }

    }

    public void dfs(char[][] board, int row, int column) {
        if (!isValidCell(board, row, column) || board[row][column] == 'V' || board[row][column] == 'C') {
            return;
        }

        if (board[row][column] == 'O' ) {
            if (!isCellOnEdgeOrConnectedToEdge(board, row, column)) {
                board[row][column] = 'C';
            }
            return;
        }

        board[row][column] = 'V';
        dfs(board, row+1, column);
        dfs(board, row-1, column);
        dfs(board, row, column+1);
        dfs(board, row, column-1);
    }

    public boolean isValidCell(char[][] board, int row, int column) {
        int numRows = board.length;
        if (numRows == 0) {
            return false;
        }
        int numColumns = board[0].length;

        return row >=0 && row < numRows && column >= 0 && column < numColumns;
    }

    public boolean isCellOnEdgeOrConnectedToEdge(char[][] board, int row, int column) {
        int numRows = board.length;
        if (numRows == 0) {
            return false;
        }
        int numColumns = board[0].length;

        return row == 0 || column == 0 || row == numRows - 1 || column == numColumns - 1 ;
    }

    public static void main(String[] args) {
        char[][] board = {{'X','O','X'},{'X','O','X'},{'X','O','X'}};
        new SurroundedRegions().solve(board);
    }

}
