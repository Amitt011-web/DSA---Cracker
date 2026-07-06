/*
Given the root of a binary tree, your task is to return its Preorder traversal.
Note: A preorder traversal first visits the node, then visits the left child (including its entire subtree), and finally visits
the right child (including its entire subtree).

Examples:
Input: root = [1, 4, N, 4, 2]
Output: [1, 4, 4, 2]
Explanation: The preorder traversal of the given binary tree is [1, 4, 4, 2]

Input: root = [6, 3, 2, N, 1, 2, N]
Output: [6, 3, 1, 2, 2] 
Explanation: The preorder traversal of the given binary tree is [6, 3, 1, 2, 2] 

Constraints:
1 ≤ number of nodes ≤ 3*104
0 ≤ node->data ≤ 105
*/

    //        SOLUTION GFG        //

class Solution {

          //  ITERATIVE    //
    public ArrayList<Integer> preOrder(Node root){
        ArrayList<Integer> ans = new ArrayList<Integer>();
        Stack<Node> st = new Stack<Node>();
        st.push(root);

        while(!st.isEmpty()){
            Node top = st.pop();
            ans.add(top.data);

            if(top.right != null) st.push(top.right);
            if(top.left != null) st.push(top.left);
        }
        return ans;
    }
    

          //  RECURSIVELY    //
   public ArrayList<Integer> preOrder(Node root) {
        ArrayList<Integer> ans = new ArrayList<>();
        print(root, ans);
        return ans;
    }
    void print(Node root, ArrayList<Integer> ans){
        if(root==null) return;
        ans.add(root.data);
        print(root.left, ans);
        print(root.right, ans);
    }


//        SOLUTION LEETCODE        //
  
class Solution {
             //  ITERATIVE    //
   public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if(root==null) return ans;

        Stack<TreeNode> st = new Stack<TreeNode>();
        st.push(root);

        while(!st.isEmpty()){
            TreeNode top = st.pop();
            ans.add(top.val);

            if(top.right != null) st.push(top.right);
            if(top.left != null) st.push(top.left);
        }
        return ans;
    }

             //  RECURSIVELY    //
 public List<Integer> preorderTraversal(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        solve(root, list);
        return list;
        
    }
    private void solve(TreeNode root, ArrayList<Integer> list) {
        if (root == null) return;
        list.add(root.val);
        solve(root.left, list);
        solve(root.right, list);
    }

