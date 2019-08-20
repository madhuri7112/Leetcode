public class NumberOfIslands {

    public int numIslands(char[][] grid) {
        int numRows = grid.length;
        if (numRows == 0) {
            return 0;
        }
        int numColumns = grid[0].length;
        int numIslands = 0;
        for (int i=0; i< numRows; i++) {
            for (int j=0; j< numColumns; j++) {
                if (grid[i][j] == '1') {
                    numIslands++;
                    dfs(grid, i, j);
                }
            }
        }

        return  numIslands;
    }

    public void dfs(char[][] grid, int row, int column) {

        if (!isValidGrid(row, column, grid)
                || grid[row][column] == '2'
        || grid[row][column] == '0') {
            return;
        }

        grid[row][column] = '2';

        dfs(grid, row+1, column);
        dfs(grid, row, column+1);
        dfs(grid, row, column-1);
        dfs(grid, row-1, column);

    }

    public boolean isValidGrid(int row, int column, char[][] grid) {
        int numRows = grid.length;

        if (numRows == 0) {
            return false;
        }

        int numColumns = grid[0].length;

        return row < numRows && row >=0 && column < numColumns && column >= 0;
    }

}
