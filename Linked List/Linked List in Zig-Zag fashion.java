class Solution {
    public Node zigZag(Node head) {
        if (head == null || head.next == null) return head;
        
        Node temp = head;
        boolean flag = true;
        
        while (temp != null && temp.next != null) {
            if (flag) {

                if (temp.data > temp.next.data) {
                    int temp1 = temp.data;
                    temp.data = temp.next.data;
                    temp.next.data = temp1;
                }
            } else {
                if (temp.data < temp.next.data) {
                    int temp1 = temp.data;
                    temp.data = temp.next.data;
                    temp.next.data = temp1;
                }
            }
            flag = !flag;
            temp = temp.next;
        }

        return head;
    }
}
