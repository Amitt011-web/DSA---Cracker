class Solution {
    public ArrayList<Integer> verticalSum(Node root) {
        ArrayList<Integer> result = new ArrayList<>();
        if (root == null) return result;

        TreeMap<Integer, Integer> map = new TreeMap<>();
        calcSum(root, 0, map);

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            result.add(entry.getValue());
        }

        return result;
        
    }
    private void calcSum(Node node, int line, TreeMap<Integer, Integer> map) {
        if (node == null) return;

        map.put(line, map.getOrDefault(line, 0) + node.data);
        calcSum(node.left, line - 1, map);
        calcSum(node.right, line + 1, map);
        

      

      
    }
}
      
