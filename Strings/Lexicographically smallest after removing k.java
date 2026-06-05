class Solution {
    public String lexicographicallySmallest(String s, int k) {
        int n = s.length();
        
        if((n & (n-1)) == 0) k /= 2;
        else k *= 2;
        
        if(k<=0) return s;
        if(k>=n || k<0) return "-1";
        
        Stack<Character> st = new Stack<>();
        int removeChar = 0;
         for(int i=0; i<n; i++){
             char ch = s.charAt(i);
             while(!st.isEmpty() && removeChar<k && st.peek()>ch){
                 st.pop();
                 removeChar++;
             }
             st.push(ch);
         }
         while (removeChar<k && !st.isEmpty()) {
            st.pop();
            removeChar++;
        }
        
        StringBuilder sb = new StringBuilder();
        while (!st.isEmpty()) {
            sb.append(st.pop());
        }
        
        return sb.reverse().toString();
    }
}
