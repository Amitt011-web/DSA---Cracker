class Solution {
    public int rowWithMax1s(int arr[][]) {
        int maxCount = 0, row = -1;
        for(int i=0; i<arr.length; i++){
            int count = 0;
            for(int j = 0; j<arr[0].length; j++){
                if(arr[i][j]==1) count++;
            }
            if(count>maxCount){
                maxCount = count;
                row = i;
            } 
        }
        return row;
    }
}
