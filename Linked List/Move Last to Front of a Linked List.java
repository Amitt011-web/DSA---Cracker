class Solution {
    public static Node moveToFront(Node head) {
        Node temp = head, prev = head;
        while(temp.next!=null){
            prev = temp;
            temp = temp.next;
        }
        Node n = new Node(temp.data);
        prev.next = null;
        n.next = head;
        return n;
        
    }
}
