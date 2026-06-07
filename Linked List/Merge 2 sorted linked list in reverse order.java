class Solution{
    Node sort(Node head1, Node head2) {
        Node temp1 = head1, temp2 = head2;
        Node ans = null;
        
        while (temp1 != null && temp2 != null) {
            if (temp1.data <= temp2.data) {
                Node dummy = temp1.next; 
                temp1.next = ans;           
                ans = temp1;               
                temp1 = dummy;           
            } else {
                Node dummy = temp2.next;
                temp2.next = ans;
                ans = temp2;
                temp2 = dummy;
            }
        }

       
        while (temp1 != null) {
            Node dummy = temp1.next;
            temp1.next = ans;
            ans = temp1;
            temp1 = dummy;
        }

        while (temp2 != null) {
            Node dummy = temp2.next;
            temp2.next = ans;
            ans = temp2;
            temp2 = dummy;
        }
        
        return ans;
    }

    Node mergeResult(Node node1, Node node2) {
        return sort(node1, node2);
    }
}
