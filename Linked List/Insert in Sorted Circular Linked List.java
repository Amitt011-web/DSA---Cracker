class Solution {
    public Node sortedInsert(Node head, int data) {
        Node newNode = new Node(data);
        if(head==null){
            newNode.next = newNode;
            return newNode;
        }
        
        Node temp = head;
        
        if(data<head.data){
            while(temp.next!=head) temp = temp.next;
            newNode.next = head;
            temp.next = newNode;
            return newNode;
        }
        
        Node curr = head;
        while(curr.next!=head && curr.next.data<data) curr = curr.next;
        
        newNode.next = curr.next;
        curr.next = newNode;
        return head;
      
        
        
        
    
        
    }
}
