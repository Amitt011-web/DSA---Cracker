 ArrayList<Integer> countEvemOdd(int[] arr){
        ArrayList<Integer> list = new ArrayList<>(2);
        int evenCount = 0, oddCount = 0;
        for(int i : arr){
            if(i%2==0){
                evenCount++;
            }
            else oddCount++;

        }
        list.add(evenCount);
        list.add(oddCount);
        return list;
 }
