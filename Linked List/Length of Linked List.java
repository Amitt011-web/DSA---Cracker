class Solution {
    public int getCount(Node head) {
        int length = 0;
        Node temp = head;
        while(temp!=null){
            length++;
            temp = temp.next;
        }
        return length;
        
    }
}
