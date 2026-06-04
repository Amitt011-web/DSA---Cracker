class Solution {
    // Function to count pairs in two linked lists whose sum is equal to x
    public int countPairs(Node head1, Node head2, int x) {
        int count = 0;
        Node temp1 = head1, temp2 = head2;
        HashSet<Integer> set = new HashSet<>();
        
        while(temp1!=null){
            set.add(temp1.data);
            temp1 = temp1.next;
        }
        
        while(temp2!=null){
            int sum = x-temp2.data;
            if(set.contains(sum)) count++;
            temp2 = temp2.next;
        }
        return count;
    }
}
