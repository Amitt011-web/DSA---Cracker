class Solution {
    public int majorityElement(int[] arr) {
        int majorEle = 0;
        int count = 0;
        
        for (int num : arr) {
            if (count == 0) {
                majorEle = num;
            }
            
            if (num == majorEle) {
                count++;
            } else {
                count--;
            }
        }
        
        return majorEle;
    }
}
