class Solution {
    int countNonLeafNodes(Node root) {
        if(root==null) return 0;
        if(root.left==null && root.right==null) return 0;
        int leftCount = countNonLeafNodes(root.left);
        int rightCount = countNonLeafNodes(root.right);
        
        return 1 + leftCount + rightCount;
        
    }
}
