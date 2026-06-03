  static void bubble (int[] arr){
        for(int i = 0; i<arr.length-1; i++){
            int swp = 0;
            for(int j = 0; j<arr.length-1-i; j++){
                if(arr[j]>arr[j+1]){
                    swap(arr, j, j+1);
                    swp++;
                }
            } if(swp == 0) break;
        }
    }
