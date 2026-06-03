class Traversal {
    static void print(Queue<Integer> q) {
        int size = q.size();
        for(int i = 0; i < size; i++){
            int element = q.remove();
            System.out.print(element + " ");
            q.add(element);
        }
    }
}
