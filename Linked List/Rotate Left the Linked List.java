/*
You are given the head of a singly linked list, you have to left rotate the linked list k times. Return the head of the modified linked list.

Examples:

Input: k = 4,
   
Output: 50 -> 10 -> 20 -> 30 -> 40
Explanation:
Rotate 1: 20 -> 30 -> 40 -> 50 -> 10
Rotate 2: 30 -> 40 -> 50 -> 10 -> 20
Rotate 3: 40 -> 50 -> 10 -> 20 -> 30
Rotate 4: 50 -> 10 -> 20 -> 30 -> 40
   
Input: k = 6,
Output: 30 -> 40 -> 10 -> 20 
  
Constraints:
1 ≤ number of nodes ≤ 105
0 ≤ k ≤ 109
0 ≤ node.data ≤ 109

*/


//        SOLUTION      //

class Solution {
     int length(Node head){
        Node temp = head; int length = 0;
        while (temp != null) {
            temp = temp.next;
            length++;
        }
        return length;
    }
    public Node rotate(Node head, int k) {
        if(head==null || head.next==null) return head;
        int n = length(head);
        k %= n;
        if(k==0) return head;

        Node curr = head;
        for(int i=1; i<k; i++){
            curr = curr.next;
        }

        Node temp = curr.next;
        curr.next = null;

        Node tail = temp;
        while(tail.next != null){
            tail = tail.next;
        }

        tail.next = head;
        return temp;
        
    }
}
