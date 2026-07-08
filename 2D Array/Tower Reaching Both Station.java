/**
* Given a matrix mat[][] of size n x m, where mat[i][j] represents the signal strength of a communication tower. Two control stations
* monitor the network:
* 
* Station P covers the top and left boundaries of the grid.
* Station Q covers the bottom and right boundaries of the grid.
* A signal can propagate from a tower to one of its neighbouring towers in the four directions (North, South, East, and West) only if 
* the neighbouring tower has a signal strength less than or equal to that of the current tower.
* 
* Determine the number of towers (x, y) from which a signal can eventually reach both Station P and Station Q. Any tower located on a
* boundary covered by a station can transmit directly to that station.
* 
* Examples:
* Input: mat[][] = [[1, 2, 2, 3, 5], [3, 2, 3, 4, 4], [2, 4, 5, 3, 1], [6, 7, 1, 4, 5], [5, 1, 1, 2, 4]]
* Output: 7
* Explanation: 
* (0, 4) & (4, 0) are part of both P & Q 
* (1, 3) reaches P using (1,3)->(0,3) and Q using (1,3)->(1,4)
* (1, 4) reaches P using (1,4)->(1,3)->(1,2)->(0,2) and it is on Q
* (2, 2) reaches P using (2,2)->(2,1)->(2,0) and Q using (2,2)->(2,3)->(2,4)
* (3, 0) is on P and reaches Q using (3,0)->(4,0)
* (3, 1) reaches P using (3,1)->(3,0) and Q using (3,1)->(4,1)
*
* Input: mat[][] = [[2, 2], [2, 2]]
* Output: 4
* Explanation: In the following example, all cells allow signals to propagate to both the stations.
* 
* Constraints:
* 1 ≤ n, m ≤ 103
* 1 ≤ mat[i][j] ≤ 103 
**/

        //      SOLUTION        //

class Solution {
   
    private final int[] dis = {0, 1, 0, -1, 0};

    public int countCoordinates(int[][] mat) {
        if (mat == null || mat.length == 0 || mat[0].length == 0)  return 0;

        int n = mat.length;
        int m = mat[0].length;

        boolean[][] stationP = new boolean[n][m];
        boolean[][] stationQ = new boolean[n][m];

      
        for (int j = 0; j < m; j++) {
            if (!stationP[0][j]) {
                dfs(0, j, mat, stationP);
            }
            if (!stationQ[n - 1][j]) {
                dfs(n - 1, j, mat, stationQ);
            }
        }

        for (int i = 0; i < n; i++) {
            if (!stationP[i][0]) {
                dfs(i, 0, mat, stationP);
            }
            if (!stationQ[i][m - 1]) {
                dfs(i, m - 1, mat, stationQ);
            }
        }

     
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (stationP[i][j] && stationQ[i][j]) {
                    ans++;
                }
            }
        }

        return ans;
    }

    private void dfs(int i, int j, int[][] mat, boolean[][] vis) {
        vis[i][j] = true;
        int n = mat.length;
        int m = mat[0].length;

        for (int d = 0; d < 4; d++) {
            int ni = i + dis[d];
            int nj = j + dis[d + 1];

        
            if (ni < 0 || nj < 0 || ni >= n || nj >= m)  continue;
            if (vis[ni][nj])  continue;
            if (mat[ni][nj] >= mat[i][j])  dfs(ni, nj, mat, vis);
            
        }
    }
}
