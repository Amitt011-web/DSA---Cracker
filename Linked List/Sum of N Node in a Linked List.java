/*

*/
//       SOLTUION 1        //
class Solution{
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
    public int sumofNodes(Node head, int n) {
        if(head==null) return 0;

         head = reverse(head);
         int sum = 0;

         Node temp = head;
         for(int i = 1; i<=n && temp!=null; i++){
             sum += temp.data;
             temp = temp.next;
         }
         return sum;


    }
}

//       SOLTUION 2       //
class Solution {
     public int sumofNodes(Node head, int n) {
         if(head==null) return 0;
        int sum = 0;

        Node slow = head, fast = head;
        for(int i = 0; i<n && fast !=null; i++ ){
            sum += fast.data;
            fast = fast.next;
        }

        if(fast == null) return sum;

        while(fast!=null){
            sum -= slow.data;
            sum += fast.data;

            slow = slow.next;
            fast = fast.next;
        }
        return sum;
    }
}


