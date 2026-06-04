class Solution {
    public int[] nextLargerNodes(ListNode head) {
        Stack<Integer> st = new Stack<>();
        ArrayList<Integer> list = new ArrayList<>();

        ListNode temp = head;
        while (temp != null) {
            list.add(temp.val);
            temp = temp.next;
        }

        int n = list.size();
        int[] ans = new int[n];
        ans[n-1] = 0;
        st.push(list.get(n-1));
        
        for(int i=n-2;i>=0;i--){
            int curr = list.get(i);
            while(!st.isEmpty() && st.peek() <= curr) st.pop();
            if(!st.isEmpty()) ans[i] = st.peek();
            else ans[i] = 0;
            st.push(list.get(i));
        }
        return ans;




    }
}
