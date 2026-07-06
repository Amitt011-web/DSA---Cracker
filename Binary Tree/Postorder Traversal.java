/*
Given the root of a Binary Tree, your task is to return its Postorder Traversal.

Note: A postorder traversal first visits the left child (including its entire subtree), then visits the right child (including its entire
subtree), and finally visits the node itself.

Examples:
Input: root = [19, 10, 8, 11, 13]
Output: [11, 13, 10, 8, 19]
Explanation: The postorder traversal of the given binary tree is [11, 13, 10, 8, 19].

Input: root = [11, 15, N, 7]
Output: [7, 15, 11]
Explanation: The postorder traversal of the given binary tree is [7, 15, 11].

Constraints:
1 ≤ number of nodes ≤ 3*104
0 ≤ node->data ≤ 105
*/

      //      SOLUTION  GFG    //
class Solution {
              /*  ITERATIVE  */
    public ArrayList<Integer> postOrder(Node root){
        ArrayList<Integer> ans = new ArrayList<Integer>();
        Stack<Node> st = new Stack<Node>();
        st.push(root);

        while(!st.isEmpty()){
            Node top = st.pop();
            ans.add(top.data);

            if(top.left != null) st.push(top.left);
            if(top.right != null) st.push(top.right);

        }

        Collections.reverse(ans);
        return ans;
    }

              /*  RECURSION  */
    public ArrayList<Integer> postOrder(Node root) {
        ArrayList<Integer> ans = new ArrayList<>();
        print(root, ans);
        return ans;
        
    }
     void print(Node root, ArrayList<Integer> ans){
        if(root==null) return;
        print(root.left, ans);
        print(root.right, ans);
        ans.add(root.data);
    }
}



     //      SOLUTION  LEETCODE   //
class Solution {
                /*  ITERATIVE  */
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if (root == null) return ans;
        
        Stack<TreeNode> st = new Stack<TreeNode>();
        st.push(root);

        while(!st.isEmpty()){
            TreeNode top = st.pop();
            ans.add(top.val);

            if(top.left != null) st.push(top.left);
            if(top.right != null) st.push(top.right);

        }

        Collections.reverse(ans);
        return ans;
    }

                /*  RECURSION  */
    public List<Integer> postorderTraversal(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        solve(root, list);
        return list;
    }
    private void solve(TreeNode root, ArrayList<Integer> list) {
        if (root == null) return;
        solve(root.left, list);
        solve(root.right, list);
        list.add(root.val);
    }
}
       
        
      
        
        
        
        
