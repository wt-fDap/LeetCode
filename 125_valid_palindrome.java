import java.util.*;
class Solution {
    public boolean isPalindrome(String s) {
        s=s.toLowerCase();
        StringBuilder sb=new StringBuilder(s);
        for(int i=0; i<sb.length(); i++){
            if(!Character.isLetterOrDigit(sb.charAt(i))){
                sb.deleteCharAt(i);
                i--;
            }
        }
        String original=sb.toString();
        int st=0; int end=sb.length()-1;
        while(st<end){
            char temp= sb.charAt(st);
            sb.setCharAt(st, sb.charAt(end));
            sb.setCharAt(end, temp);
            st++;
            end--;
        }
        return sb.toString().equals(original);
    }
}