/**
* Given a binary matrix mat[][] of size n × m containing values 0 and 1, and four integers xs, ys, xd, and yd representing the source 
* cell (xs, ys) and destination cell (xd, yd), find the length of the longest possible path from the source cell to the destination cell.
* From any cell, you can move to its adjacent cells in the up, down, left, and right directions.
*
* 1 represents a traversable cell.
* 0 represents a blocked cell that cannot be visited.
* A cell can be visited at most once in a path.
* If the destination cannot be reached from the source, return -1.
*
* Examples:
* Input: mat[][] = [[1, 1, 1, 1, 1, 1, 1, 1, 1, 1], [1, 1, 0, 1, 1, 0, 1, 1, 0, 1],[1, 1, 1, 1, 1, 1, 1, 1, 1, 1]], xs = 0, ys = 0, xd = 1, yd = 7
* Output: 24 
* Explanation: The longest valid path from (0, 0) to (1, 7) without revisiting any cell has length 24. 
* 
* Input: mat[][] = [[1, 0, 0, 1, 0],[0, 0, 0, 1, 0],[0, 1, 1, 0, 0]], xs = 0, ys = 3, xd = 2, yd = 2
* Output: -1
* Explanation: The destination cell (2, 2) cannot be reached from the source cell (0, 3), so the answer is -1.
*  
* Constraints:
* 1 ≤ n, m ≤ 10
* mat[i][j] == 0 or mat[i][j] == 1
* The source and destination cells are always inside the matrix.
**/


        //      SOLUTION      //

class Solution {
    int n, m;
    boolean[][] visited;
    int[] dr = {-1, 1, 0, 0};
    int[] dc = {0, 0, -1, 1};
    
    public int longestPath(int[][] mat, int xs, int ys, int xd, int yd) {
        n = mat.length;
        m = mat[0].length;
        
        if(mat[xs][ys] == 0 || mat[xd][yd] == 0){
            return -1;
        }
        visited = new boolean[n][m];
        return dfs(mat, xs, ys, xd, yd);
    }
    
    private int dfs(int[][] mat, int r, int c, int xd, int yd){
        if(r == xd && c == yd){
            return 0;
        }
        visited[r][c] = true;
        int maxLen = -1;
        
        for(int k=0;k<4;k++){
            int nr = r+dr[k];
            int nc = c+dc[k];
            
            if(isSafe(mat, nr, nc)){
                int path = dfs(mat, nr, nc, xd, yd);
                if(path != -1){
                    maxLen = Math.max(maxLen, path+1);
                }
            }
        }
        visited[r][c] = false;
        return maxLen;
    }
    
    private boolean isSafe(int[][] mat, int r, int c){
        return r>=0 && r<n && c>=0 && c<m && mat[r][c] == 1 && !visited[r][c];
    }
}
