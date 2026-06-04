class Array1{
        //  METHOD 1  //
    int[] reverse(int[] arr){
        for(int i=0; i<arr.length/2;i++){
            int temp = arr[i];
            arr[i] = arr[arr.length-i-1];
            arr[arr.length-i-1] = temp;

        }
        return arr;
    }
  
         //  METHOD 2  //
    int[] reverse2(int[] arr){
        int n = arr.length;
        int[] ans = new int[n];
        for(int i = n-1; i>=0; i--){
            ans[ans.length-i-1] = arr[i];
        }
        return ans;
    }
}
