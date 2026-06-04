class Solution {
    Node reverse(Node root){
        Node curr = root, prev = null, fwd = null;
        while(curr!=null){
            fwd = curr.next;
            curr.next = prev;
            prev = curr;
            curr = fwd;
        }
        return prev;
    }
    Node merge( Node root1,  Node root2) {
        if(root1 == null) return root2;
        if(root2 == null) return root1;
        Node dummy = new  Node(0);
        Node d = dummy;
        while(root1 != null && root2 != null){
            d.next = root1;
            d = d.next;
            root1 = root1.next;
            d.next = root2;
            d = d.next;
            root2 = root2.next;
        }
        if(root1 != null) d.next = root1;
        if(root2 != null) d.next = root2;
        return dummy.next;

    }
            
    
    public Node inPlace(Node root) {
        Node slow = root, fast = root;
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        Node root2 = reverse(slow.next);
        slow.next = null;
        return merge(root, root2);
    }
    
 
    
}
