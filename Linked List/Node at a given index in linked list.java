class Solution {
    public int GetNth(Node head, int index) {
        if(head==null || index <=0 ) return -1;
        Node temp = head;
        int count = 1;
        while(temp!=null){
            if(count==index){
                return temp.data;
            }
            count++;
            temp = temp.next;
            
        }
        return -1;
        
    }
}
