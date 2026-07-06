/*
Given the root of a binary tree. Check whether it is a BST or not.
A BST is defined as follows:

The left subtree of a node contains only nodes with data less than the node's data.
The right subtree of a node contains only nodes with data greater than the node's data.
Both the left and right subtrees must also be binary search trees.
Examples:

Input: root = [2, 1, 3, N, N, N, 5]
Output: true 
Explanation: The left subtree of every node contains smaller data and right subtree of every node contains greater data. Hence, the tree is a BST.

Input: root = [2, N, 7, N, 6, N, 9] 
Output: false 
Explanation: Since the node to the right of node with data 7 has lesser value 6, hence it is not a valid BST.

Input: root = [10, 5, 20, N, N, 9, 25]
Output: false
Explanation: The node with data 9 present in the right subtree has lesser key value than root node 10.

Constraints:
1 ≤ number of nodes ≤ 105
1 ≤ node->data ≤ 109
*/

//      SOLUITON    //

class Twin{
    int max, min;
    Twin(int max, int min) {
        this.max = max;
        this.min = min;
    }
}


class Solution {
    boolean flag;
    public boolean isBST(Node root) {
        flag = true;
        maxMin(root);
        return flag;
    }
    
    Twin maxMin(Node root){
        if(root==null) return new Twin(Integer.MIN_VALUE, Integer.MAX_VALUE);
        Twin left = maxMin(root.left);
        Twin right = maxMin(root.right);
        
        if(root.data <= left.max) flag = false;
        if(root.data >= right.min) flag = false;
        
        int max = Math.max(root.data, Math.max(left.max, right.max));
        int min = Math.min(root.data, Math.min(left.min, right.min));
        
       
        return new Twin(max, min);
        
        
    }
}
