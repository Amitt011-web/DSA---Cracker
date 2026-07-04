/*
Given the root of a Binary Search Tree, find the maximum element in this given BST.

Examples
Input: root = [5, 4, 6, 3, N, N, 7, 1]
ex - 1
Output: 7
Explanation: The maximum element in the given BST is 7.
Input: root = [10, 5, 20, 2]
ex-2
Output: 20
Explanation: The minimum element in the given BST is 20.

Input: root = []
Output: -1
Explanation: The root of the BST is NULL.
*/

//        SOLUTION        //
class Solution {
    public int maxValue(Node root) {
        if(root==null) return -1;
        Node temp = root;
        while(temp.right!=null) temp = temp.right;
        return temp.data;
        
    }
}
