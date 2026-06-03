 int singleNumber(int[] arr){
       int ans = 0;
       for(int i : arr){
           ans = ans ^ i;
       }
       return ans;

    }
