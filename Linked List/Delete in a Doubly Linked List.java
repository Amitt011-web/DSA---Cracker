class Solution {
     public Node delPos(Node head, int x) {
        if(head==null) return head;
        if(x==1){
            head = head.next;
            if(head!=null) head.prev = null;
            return head;
        }
        
        Node temp = head;
        for(int i=1;i<x-1 && temp!=null;i++) temp = temp.next;
        
        if(temp==null && temp.next==null) return head;
       

        if(temp.next.next==null) temp.next = null;
        else{
           temp.next = temp.next.next;
           temp.next.prev = temp;
        }
        return head;




    }
}
           
       
