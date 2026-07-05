/*
Given the root of a binary tree and an integer s, print all paths starting from the root such that the sum of the node values along each path equals s.
A path does not necessarily have to end at a leaf node.

Examples:
Input : s = 8, root[] = [1, 20, 3, N, N, 4, 15, 6, N, N, N, N, N]
Output : [[1, 3, 4]]
Explanation : Sum of path 1, 3, 4 = 8. 
      
Input : s = 38, root[] = [10, 28, 13, N, N, 14, 15, 21, 22, 23, 24, N, N, N, N, N, N, N, N]
Output : [[10, 28], [10, 13, 15]] 
Explanation : Sum of path 10, 28 = 38 and Sum of path 10, 13, 15 = 38.
        
Constraints :
1 ≤ n ≤ 2*103, where n is the number of nodes in the binary tree
-103 ≤ s ≤ 103
-103 ≤ Node.value ≤ 103
*/

//      SOLUTION      //


class Solution{
    public ArrayList<ArrayList<Integer>> printPaths(Node root, int sum) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        ArrayList<Integer> arr =  new ArrayList<>();

        if(root==null) return ans;
        dfs(root, arr, ans, sum);
        return ans;

    }

    void dfs(Node root, ArrayList<Integer> arr, ArrayList<ArrayList<Integer>> ans, int sum) {
        arr.add(root.key);
      
        if(sum==root.key) ans.add(new ArrayList<>(arr));
        
        if(root.left != null) dfs(root.left, arr, ans, sum-root.key);
        if(root.right != null) dfs(root.right, arr, ans, sum-root.key);
        
        arr.removeLast();
    }
}




        
       
