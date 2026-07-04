/*
Given a binary tree with n nodes and two node values a and b, find the minimum distance between them. The distance is defined as the minimum number of edges
between the two nodes. It is guaranteed that both nodes exist in the binary tree and all node values are unique.

Examples :
Input : a = 2, b = 3
Output : 2
Explanation : The path between node 2 and node 3 is: 2 -> 1 -> 3.The number of edges in this path is 2, so the minimum distance is 2. 

Input : a = 4, b = 7
Output : 4
Explanation : The path between node 4 and node 7 is: 4 -> 2 -> 1 -> 3 -> 7.The number of edges in this path is 4, so the minimum distance is 4.

Constraints : 2 <= number of nodes <= 105
*/

//        SOLUTION        //

class Solution {
    public int findDist(Node root, int a, int b) {
        Node LCA = lca(root, a, b);
        int[] dist = {0,0};
        dfs(LCA, a, b, 0, dist);
        return dist[0] + dist[1];
        
    }
    Node lca(Node root, int p, int q) {
        if(root==null) return null;
        if(root.data==p || root.data==q) return root;
        
        Node l = lca(root.left, p, q);
        Node r = lca(root.right, p, q);
        
        if(l!=null && r!=null) return root;
        return (l==null) ? r : l;
        
    }
    
    void dfs(Node root, int a, int b, int depth, int[] dist){
        if(root == null) return;
        if(root.data==a) dist[0] = depth;
        if(root.data==b) dist[1] = depth;
        
        dfs(root.left, a, b, depth+1, dist);
        dfs(root.right, a, b, depth+1, dist);
    }
    
    
}
