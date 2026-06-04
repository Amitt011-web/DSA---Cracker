/* A Binary Tree node
class Node
{
    int data;
    Node left, right;
}*/

class Solution {
    int countLeaves(Node root) {
        if(root==null) return 0;
        if(root.left==null && root.right==null) return 1;
        
        int leftCount = countLeaves(root.left);
        int rightCount = countLeaves(root.right);
        
        
        return leftCount + rightCount;
    }
    
}
