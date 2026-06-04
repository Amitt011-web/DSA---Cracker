class Solution {
     public  Node findIntersection(Node head1, Node head2) {
        Node temp1 = head1, temp2 = head2;
        HashSet<Integer> set = new HashSet<>();
        while (temp1 != null) {
            set.add(temp1.data);
            temp1 = temp1.next;
        }
        Node dummy = new Node(0), d = dummy;
        while (temp2 != null) {
            if(set.contains(temp2.data)){
                d.next = new Node(temp2.data);
                d = d.next;

            }
            temp2  = temp2.next;
        }
        return dummy.next;

    }
}
