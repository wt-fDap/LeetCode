class Solution {
    public int[][] rotate(int[][] matrix) {
        int n=matrix.length;
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(i<j){
                    int temp=matrix[i][j];
                    matrix[i][j]=matrix[j][i];
                    matrix[j][i]=temp;
                }
            }
        }
        for(int i=0; i<n; i++){
            int st=0;
            int end=n-1;
            while(st<end){
                int temp=matrix[i][st];
                matrix[i][st]=matrix[i][end];
                matrix[i][end]=temp;
                st++;
                end--;
            }
        }
    return matrix;
    }
}