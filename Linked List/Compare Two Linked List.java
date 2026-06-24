/*
Compare two linked lists
Difficulty: EasyAccuracy: 54.29%Submissions: 28K+Points: 2
Given two strings, head1 and head2, represented as linked lists where each character is stored in a node's data field, complete the function compare() 
that mimics the behavior of strcmp(). Specifically, the function should return:

0 if both strings are identical,
1 if the first linked list is lexicographically greater, and
-1 if the second linked list is lexicographically greater.

Examples:
Input: head1 = a->b->a->b->a , head2 = a->b->a->a
Output: 1
Explanation: String consisting of nodes of first linked list is lexicographically greater than the second one. So, the result is 1.
Input: head1 = a->a->b , head2 = a->a->b

Output: 0
Explanation: String consisting of nodes of first linked list is same as the second one. So, the result is 0.
Input: head1 = a->b->c->d , head2 = a->b->c->e
Output: -1
Explanation: String consisting of nodes of second linked list is lexicographically greater than the first one. So, the result is -1.

Constraints:
1 <= no. of nodes in head1 and head2 <= 100
*/

//        SOLUTION        //

class Solution {
    int compare(Node head1, Node head2) {
        Node temp1 = head1, temp2 = head2;
        
        while(temp1!=null && temp2!=null){
            if(temp1.data!=temp2.data){
              if(temp1.data>temp2.data) return 1;
              else return -1;
            }
            temp1 = temp1.next;
            temp2 = temp2.next;
        }
        
        if(temp1!=null) return 1;
        if(temp2!=null) return -1;
        
        return 0;
    }
}
              
                
            
      
        
        
        
