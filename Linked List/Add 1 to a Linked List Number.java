class Solution {
    Node reverse(Node head){
        Node curr = head, prev = null, fwd = null;
        while(curr!=null){
            fwd = curr.next;
            curr.next = prev;
            prev = curr;
            curr = fwd;
        }
        return prev;
    }
    public Node addOne(Node head) {
        head = reverse(head);
        
        Node dummy = new Node(0);
        Node temp = dummy, temp1 = head;
        int carry = 1;
        
        while(temp1!=null || carry!=0){
            int sum = carry;
            if(temp1!=null){
                sum += temp1.data;
                temp1 = temp1.next;
            }
            carry = sum/10;
            temp.next = new Node(sum%10);
            temp = temp.next;
        }
        
        return reverse(dummy.next);
    }
}
