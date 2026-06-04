class Solution {
    public ArrayList<Integer> levelOrder(Node root) {
        ArrayList<Integer> list = new ArrayList<>();
        if(root==null) return list;
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            Node front = q.remove();
            list.add(front.data);
            
            if(front.left!=null) q.add(front.left);
            if(front.right!=null) q.add(front.right);
            
            
        }
        return list;
        
    }
}
