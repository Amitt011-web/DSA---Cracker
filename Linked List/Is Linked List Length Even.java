class Solution {
    public boolean isEven(Node head) {
        int count = 0;
        Node temp = head;
        while(temp!=null){
            count++;
            temp = temp.next;
        }
        return (count%2==0) ? true : false;
        
    }
}
