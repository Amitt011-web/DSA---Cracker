/*
Given a node del_node of a singly linked list. Delete this node from the list without access to the head pointer.

After deletion:

The number of nodes in the linked list should decrease by one.
The relative order of the remaining nodes should remain unchanged.
Note: It is guaranteed that del_node is not the last node of the linked list.

Examples:

Input: Linked List = 1 -> 2, del_node = 1

Output: 2
Explanation: After deleting 1 from the linked list, we have remaining nodes as 2.

Input: Linked List = 10 -> 20 -> 4 -> 30, del_node = 20

Output: 10->4->30
Explanation: After deleting 20 from the linked list, we have remaining nodes as 10, 4, 30.

Constraints:
2 ≤ number of nodes ≤ 106  
1 ≤ node->data ≤ 106
*/

//      SOLUTION    //


/* Structure of linked list Node
class Node
{
    int data ;
    Node next;
    Node(int d)
    {
        data = d;
        next = null;
    }
}
*/
class Solution {
    public void deleteNode(Node del_node) {
        if(del_node==null || del_node.next==null) return;
        
        del_node.data = del_node.next.data;
        del_node.next = del_node.next.next;
       
    }
}
