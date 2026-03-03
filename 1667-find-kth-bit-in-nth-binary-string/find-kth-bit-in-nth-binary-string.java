class Solution {
    public char findKthBit(int n, int k) {
        String  s="0";
        for(int i=2;i<=n;i++){
            s=s+"1"+reverseInvert(s);
        }
        return s.charAt(k-1);
    }
    private String reverseInvert(String s){
        StringBuilder sb=new  StringBuilder();
        int n=s.length();
        for(int i=0;i<n;i++){
            sb.append((s.charAt(n-i-1)=='1'?'0':'1'));
        }
        return sb.toString();
    }
}