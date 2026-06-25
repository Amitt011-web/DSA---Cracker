/*
Given two linked lists head1 and head2, insert nodes of the second list into the first list at alternate positions. If all nodes cannot be inserted, keep the 
remaining nodes unchanged.

Return an array containing the heads of the modified lists in their original order.

Examples:
Input: head1: 10 -> 9, head2: 6 -> 1 -> 2 -> 3 -> 4 -> 5
Output: head1: 10 -> 6 -> 9 -> 1, head2: 2 -> 3 -> 4 -> 5
  
Explanation: After inserting nodes of head2 alternately into head1, the modified lists become 10 -> 6 -> 9 -> 1 and 2 -> 3 -> 4 -> 5, as the remaining 
nodes of head2 cannot be inserted.

Input: head1: 1 -> 2 -> 3, head2: 4 -> 5 -> 6
Output: head1: 1 -> 4 -> 2 -> 5 -> 3 -> 6, head2: <empty>

Explanation: After inserting nodes of head2 alternately into head1, the merged list becomes 1 -> 4 -> 2 -> 5 -> 3 -> 6, and head2 becomes empty as all its 
nodes are used.

Constraints:
0 ≤ number of nodes ≤ 100
1 ≤ node -> data ≤ 104
*/

//      SOLUTION      //
class Solution {
    public Node[] mergeList(Node head1, Node head2) {
        Node[] ans = new Node[2];

        if (head1 == null) {
            ans[0] = null;
            ans[1] = head2;
            return ans;
        }
        if (head2 == null) {
            ans[0] = head1;
            ans[1] = null;
            return ans;
        }

        Node dummy = new Node(0);
        Node d = dummy;
        Node temp1 = head1;
        Node temp2 = head2;

        while (temp1 != null && temp2 != null) {
            d.next = temp1;
            temp1 = temp1.next;
            d = d.next;

            d.next = temp2;
            Node nextTemp2 = temp2.next;

            if (temp1 == null) {
                temp2.next = null;
                ans[0] = dummy.next;
                ans[1] = nextTemp2;
                return ans;
            }

            temp2 = nextTemp2;
            d = d.next;
        }

        if (temp1 != null) {
            d.next = temp1;
        }

        ans[0] = dummy.next;
        ans[1] = null;
        return ans;
    }
}
