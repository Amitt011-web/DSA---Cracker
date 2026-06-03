class Solution {
    public int sumDiffPairs(int[] arr, int k) {
        Arrays.sort(arr);
        int n = arr.length;
        
        int maxSum = 0, i = n-1;
        while(i>0){
            if(arr[i]-arr[i-1] < k){
                maxSum += arr[i] + arr[i-1];
                i -= 2;
            }
            else i--;
        }
        return maxSum;
    }
}
