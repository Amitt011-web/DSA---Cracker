/*
Given the root of a binary tree, flatten the tree into a "linked list":

The "linked list" should use the same TreeNode class where the right child pointer points to the next node in the list and the left child pointer is always null.
The "linked list" should be in the same order as a pre-order traversal of the binary tree.

Input: root = [1,2,5,3,4,null,6]
Output: [1,null,2,null,3,null,4,null,5,null,6]
Example 2:

Input: root = []
Output: []
Example 3:

Input: root = [0]
Output: [0]
 
Constraints:

The number of nodes in the tree is in the range [0, 2000].
-100 <= Node.val <= 100
 
Follow up: Can you flatten the tree in-place (with O(1) extra space)?
*/


//            SOLUTION  1                //

class Solution {
    public void flatten(TreeNode root) {
       if(root == null) return;
    
       TreeNode lst = root.left;
       TreeNode rst = root.right;
    
       flatten(lst);
       flatten(rst);

       root.left = null;
    
       root.right = lst;
       TreeNode last = root;
    
       while(last.right != null) last = last.right;
       last.right = rst;
    }
 

//            SOLUTION  2                //

    public void flatten(TreeNode root) {
        if(root==null) return;

        ArrayList<TreeNode> arr = new ArrayList<>();
        dfs(root, arr);
        for(int i = 0; i < arr.size()-1; i++){
            TreeNode a = arr.get(i);
            TreeNode b = arr.get(i+1);
            a.right = b;
            a.left = null;
        
        }
        TreeNode last = arr.getLast();
        last.left = null;
        last.right = null;
    }
    void dfs(TreeNode root, ArrayList<TreeNode> arr){
        if(root == null) return;
        arr.add(root);
        dfs(root.left, arr);
        dfs(root.right, arr);

    }


//            SOLUTION  3                //

    public void flatten(TreeNode root) {
        TreeNode curr = root;
        while (curr != null) {
            if (curr.left != null) {
                TreeNode prev = curr.left;
                while (prev.right != null) {
                    prev = prev.right;
                }
                prev.right = curr.right;
                curr.right = curr.left;
                curr.left = null;
            }
            curr = curr.right;
        }

    }
}
