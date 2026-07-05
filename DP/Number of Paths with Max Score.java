/*
You are given a square board of characters. You can move on the board starting at the bottom right square marked with the character 'S'.

You need to reach the top left square marked with the character 'E'. The rest of the squares are labeled either with a numeric character
1, 2, ..., 9 or with an obstacle 'X'. In one move you can go up, left or up-left (diagonally) only if there is no obstacle there.

Return a list of two integers: the first integer is the maximum sum of numeric characters you can collect, and the second is the number of such paths 
that you can take to get that maximum sum, taken modulo 10^9 + 7.

In case there is no path, return [0, 0].

Example 1:
Input: board = ["E23","2X2","12S"]
Output: [7,1]

Example 2:
Input: board = ["E12","1X1","21S"]
Output: [4,2]

Example 3:
Input: board = ["E11","XXX","11S"]
Output: [0,0]
 

Constraints:2 <= board.length == board[i].length <= 100
*/

//        SOLUTION      //

class Solution {
    int memoPath[][];
    int memoSum[][];
    int MOD = 1000000007;

    public int[] pathsWithMaxScore(List<String> board) {
        int n = board.size();
        memoPath = new int[n][n];
        memoSum = new int[n][n];
        
        for(int arr[] : memoPath) Arrays.fill(arr, -2);
        int result[] = solve(n-1, n-1, board);
        
        if(result[0] == -1) return new int[]{0, 0};
        return result;
    }

    public int[] solve(int row, int col, List<String> board){
        if(row < 0 || col < 0)  return new int[]{-1, 0};
        char ch = board.get(row).charAt(col);
        
        if(ch == 'X') return new int[]{-1, 0};
        if(row == 0 && col == 0) return new int[]{0, 1};
        if(memoPath[row][col] != -2) {
            return new int[]{memoSum[row][col], memoPath[row][col]};
        }

        int left[] = solve(row, col-1, board);
        int up[] = solve(row-1, col, board);
        int diag[] = solve(row-1, col-1, board);

        int max = Math.max(left[0], Math.max(up[0], diag[0]));
        
        if(max == -1){
            memoSum[row][col] = -1;
            memoPath[row][col] = 0;
            return new int[]{-1, 0};
        }
        
        int paths = 0;
        if(left[0] == max) paths = (paths + left[1]) % MOD;
        if(up[0] == max) paths = (paths + up[1]) % MOD;
        if(diag[0] == max)  paths = (paths + diag[1]) % MOD;
    
        int value = (ch == 'S') ? 0 : (ch - '0');
        
        memoPath[row][col] = paths;
        memoSum[row][col] = max + value;
        
        return new int[]{memoSum[row][col], memoPath[row][col]};
    }
}
