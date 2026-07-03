/*
You are given an m x n binary matrix grid and an integer health.
You start on the upper-left corner (0, 0) and would like to get to the lower-right corner (m - 1, n - 1).
You can move up, down, left, or right from one cell to another adjacent cell as long as your health remains positive.
Cells (i, j) with grid[i][j] = 1 are considered unsafe and reduce your health by 1.
Return true if you can reach the final cell with a health value of 1 or more, and false otherwise.

Example 1 :
Input : grid = [[0,1,0,0,0],[0,1,0,1,0],[0,0,0,1,0]], health = 1
Output : true
Explanation : The final cell can be reached safely by walking along the gray cells below.


Example 2 :
Input : grid = [[0,1,1,0,0,0],[1,0,1,0,0,0],[0,1,1,1,0,1],[0,0,1,0,1,0]], health = 3
Output : false
Explanation :A minimum of 4 health points is needed to reach the final cell safely.


Example 3 :
Input : grid = [[1,1,1],[1,0,1],[1,1,1]], health = 5
Output : true
Explanation : The final cell can be reached safely by walking along the gray cells below.

Any path that does not go through the cell (1, 1) is unsafe since your health will drop to 0 when reaching the final cell.

Constraints:
m == grid.length
n == grid[i].length
1 <= m, n <= 50
2 <= m * n
1 <= health <= m + n
grid[i][j] is either 0 or 1.

*/

//      SOLUTION      //              "Modified Dijkstra's Algorithm + PriorityQueue (to maximize remaining health on a 2D Grid)"

class Solution {
    public boolean findSafeWalk(List<List<Integer>> grid, int health) {
        int m = grid.size();
        int n = grid.get(0).size();

        int[][] maxHealth = new int[m][n];
        for (int i = 0; i < m; i++) {
            Arrays.fill(maxHealth[i], -1);
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        
        int startHealth = health - grid.get(0).get(0);
        if (startHealth <= 0) return false;

        maxHealth[0][0] = startHealth;
        pq.offer(new int[]{startHealth, 0, 0});
        
        int[] da = {0, 0, -1, 1};
        int[] db = {1, -1, 0, 0};

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int currHealth = curr[0];
            int r = curr[1];
            int c = curr[2];
            
            if (r == m - 1 && c == n - 1 && currHealth > 0) return true;
            if (currHealth < maxHealth[r][c]) continue;
            
            for (int t = 0; t < 4; t++) {
                int nr = r + da[t];
                int nc = c + db[t];

                if (nr >= 0 && nr < m && nc >= 0 && nc < n) {
                    int nextHealth = currHealth - grid.get(nr).get(nc);
                    
                    if (nextHealth > 0 && nextHealth > maxHealth[nr][nc]) {
                        maxHealth[nr][nc] = nextHealth;
                        pq.offer(new int[]{nextHealth, nr, nc});
                    }
                }
            }
        }
        return false;
    }
}
