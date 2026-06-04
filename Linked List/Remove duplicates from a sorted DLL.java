class Solution {
    Node removeDuplicates(Node head) {
      Node dummy = new Node(-1);
      Node fwd = head.next, pre = head, d= dummy;
      d.next = head;
      
      while(fwd!=null){
          if(fwd.data==pre.data){
              fwd = fwd.next;
          }
          else{
              d.next = pre;
              
              d = d.next;
              pre = fwd;
          }
      }
      return head;
        
    }
}
