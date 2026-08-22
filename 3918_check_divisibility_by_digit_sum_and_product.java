class Solution {
    public boolean checkDivisibility(int n) {
        int sumofdigits=0;
        int productofdigits=1;
        int m=n;
        while(m!=0){
            int temp=m%10;
            m=m/10;
            sumofdigits+=temp;
            productofdigits*=temp;
            
        }
        int totalsum=sumofdigits+productofdigits;
        return n%totalsum==0;
    }
}