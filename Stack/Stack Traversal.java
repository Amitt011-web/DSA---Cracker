class StackTraversal{
  
    static void print(Stack<Integer> st) {
        Stack<Integer> st2 = new Stack<>();
            
        while(!st.isEmpty()) st2.push(st.pop());
        while(!st2.isEmpty()){
            int top = st2.pop();
            System.out.println(top);
            st.push(top);
        }
    }
}
