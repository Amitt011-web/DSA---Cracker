class Solution {
    public boolean isPower(int x, int y) {
       if(x<=1) return x==y;
       while(y%x==0){
           y/=x;
       }
       return y==1;
        
    }
}
