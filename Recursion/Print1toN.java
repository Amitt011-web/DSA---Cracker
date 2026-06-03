class Print1ToN {
          // METHOD 1  //
    static int n;
    static void print1(int x){
        if(x>n) return;
        System.out.print(x + " ");
        print1(x+1);

    }
         // METHOD 2   //
    static void print2(int n){
        if(n==0) return;
        print2(n-1);
        System.out.print(n + " ");

    }

         // METHOD 3  //
    static void print3(int x, int n){
        if(x>n) return;
        System.out.print(x + " ");
        print3(x+1, n);
    }
}
