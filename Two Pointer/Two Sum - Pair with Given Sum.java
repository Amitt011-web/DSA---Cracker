class Solution {
    boolean twoSum(int arr[], int target) {
        Arrays.sort(arr);
        int  i = 0;
        int j = arr.length-1;
        while(i<j){
            if(arr[i]+arr[j]==target) return true;
            else if(arr[i]+arr[j]>target)  j--;
            else if(arr[i]+arr[j]<target)  i++;
        }
        return false;
    }
}
