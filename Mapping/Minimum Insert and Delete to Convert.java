/*
Given two arrays a[] and b[] of size n and m respectively, find the minimum insertions and deletions on the array a[], required to make both the 
arrays identical.

The array b[] is sorted and all its elements are distinct.
The array a[] may or may not be sorted and may have duplicates.
Operations can be performed at any index in a[] not necessarily at the end.

Examples :
Input: a[] = [1, 2, 5, 3, 1], b[] = [1, 3, 5]
Output: 4
Explanation: Delete 2 from a: a[] = [1, 5, 3, 1]
Insert 3 after 1: a[] = [1, 3, 5, 3, 1]
Delete the last two elements: a[] = [1, 3, 5]
Total operations = 1 + 1 + 2 = 4.

Input: a[] = [1, 4], b[] = [1, 4]
Output : 0
Explanation: Both the Arrays are already identical.

Constraints:
1 ≤ n, m ≤ 105
1 ≤ a[i], b[i] ≤ 105


*/

//      SOLUTION      //

class Solution {
      public int minInsAndDel(int[] a, int[] b) {
        int n = a.length, m = b.length;
       HashMap<Integer, Integer> map = new HashMap<>();
       for(int i = 0; i < m; i++){
           map.put(b[i], i);
       }
       
       ArrayList<Integer> list = new ArrayList<>();
       for(int i = 0; i < n; i++){
           if(map.containsKey(a[i])){
               list.add(map.get(a[i]));
           }
       }
       
       int lcs = getLIS(list);
       return n + m - 2 * lcs;
    }

    private int getLIS(ArrayList<Integer> list) {
        if(list.isEmpty()) return 0;
        
        ArrayList<Integer> ans = new ArrayList<>();
        ans.add(list.get(0));
        for(int i = 1; i < list.size(); i++){
            int value = list.get(i);
            if(value > ans.get(ans.size()-1)) ans.add(value);
            else{
                int idx = Collections.binarySearch(ans, value);
                if(idx < 0) idx = -idx - 1;
                ans.set(idx, value);
            }
        }
        return ans.size();
    }
}
