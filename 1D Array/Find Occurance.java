 int countOccurence(int[] arr, int target){
        int count = 0;
        for(int i : arr){
            if(i == target){
                count++;
            }
        }
        return count;
 }
