 int findMin(int[] arr){
        int min = Integer.MAX_VALUE;
        for(int i : arr){
            if(i < min) min = i;
        }
        return min;
 }
