/*
Given a singly linked list. Modify the Linked list as follows:

Modify the value of the first half nodes such that 1st node's new value is equal to the value of the last node minus the first node's current value, 2nd node's new value is equal to the second last nodes value minus 2nd nodes current value, likewise for first half nodes.
Replace the second half of nodes with the initial values of the first half of nodes (values before modifying the nodes).
If size of it is odd then the value of the middle node remains unchanged.
Examples:

Input: Linked list: 10 -> 4 -> 5 -> 3 -> 6
Output: -4 -> -1 -> 5 -> 4 -> 10
Explanation: For first half nodes modified list will be: -4 -> -1 -> 5 -> 3 -> 6
For second half nodes modified list will be: -4 -> -1 -> 5 -> 4 -> 10

Input: Linked list: 2 -> 9 -> 8 -> 12 -> 7 -> 10
Output: 8 -> -2 -> 4 -> 8 -> 9 -> 2
Explanation: After modifying the linked list as required, we have a new linked list containing the elements as 8 -> -2 -> 4 -> 8 -> 9 -> 2.

Constraints:
1 <= size of linked list <= 106
-105 <= data of nodes <= 106

*/

// SOLUTION //
class Solution {
  public Node reverse(Node head) {
        Node curr = head, prev = null, fwd = null;
        while (curr != null) {
            fwd = curr.next;
            curr.next = prev;
            prev = curr;
            curr = fwd;
        }
        return prev;
    }

    public Node modifyTheList(Node head) {
        if (head == null || head.next == null) return head;
        

        Node slow = head, fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        Node head1 = reverse(slow.next);
        slow.next = null;

        Node temp1 = head, temp2 = head1;
        while (temp1 != null && temp2 != null) {
            int val = temp1.data;
            
            temp1.data = temp2.data - temp1.data;
            temp2.data = val;

            temp1 = temp1.next;
            temp2 = temp2.next;
        }

        slow.next = reverse(head1);
        return head;
    }
}
