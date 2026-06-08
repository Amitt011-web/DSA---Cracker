class Solution {
    Node reverse(Node head) {
        Node prev = null;
        Node temp = head;
        Node next = null;
        
        while (temp != null) {
            next = temp.next;
            temp.next = prev;
            prev = temp;
            temp = next;
        }
        return prev;
    }

    public Node compute(Node head) {
        if (head == null || head.next == null) {
            return head;
        }

        head = reverse(head);

        Node temp = head;
        Node maxNode = head;

        while (temp != null && temp.next != null) {
            if (temp.next.data < maxNode.data) {
                temp.next = temp.next.next;
            }
            else {
                temp = temp.next;
                maxNode = temp;
            }
        }

        return reverse(head);
    }
}
