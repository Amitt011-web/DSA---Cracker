/*
You are given a square matrix of size n x n. Your task is to find the transpose of the given matrix.
The transpose of a matrix is obtained by converting all the rows to columns and all the columns to rows.

Examples :

Input: mat[][] = [[1, 1, 1, 1],
                [2, 2, 2, 2],
                [3, 3, 3, 3],
                [4, 4, 4, 4]]
Output: [[1, 2, 3, 4],
       [1, 2, 3, 4],
       [1, 2, 3, 4],
       [1, 2, 3, 4]]
Explanation: Converting rows into columns and columns into rows.

Input: mat[][] =  [[1, 2],
                 [9, -2]]
Output: [[1, 9],
        [2, -2]]
Explanation: Converting rows into columns and columns into rows.
Constraints:
1 ≤ n ≤ 103
-109 ≤ mat[i][j] ≤109


*/

//        SOLUTION 1    //

class Solution {
    public ArrayList<ArrayList<Integer>> transpose(int[][] arr) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        for(int i = 0; i<arr[0].length; i++){
            ArrayList<Integer> ans = new ArrayList<>();
            for(int j = 0; j<arr.length; j++){
               ans.add(arr[j][i]);
            }
            list.add(ans);
        }
        return list;
    }
}


//        SOLUTION 2    //    USING O(n) space
int[][] transpose(int[][] arr) {
     int[][] ans = new int[arr[0].length][arr.length];

     for(int i = 0; i < ans.length; i++){
         for(int j = 0; j < ans[0].length; j++){
            ans[i][j] = arr[j][i];
         }
     }
       return ans;
}

//        SOLUTION 3   // In Place and swaping int O(1) space

 void  transpose2(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr[0].length; j++) {
                int temp = arr[i][j];
                arr[i][j] = arr[j][i];
                arr[j][i] = temp;
            }
        }
    }

