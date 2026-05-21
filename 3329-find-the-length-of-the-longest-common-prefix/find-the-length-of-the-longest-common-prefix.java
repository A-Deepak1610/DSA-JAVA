class Solution {
    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        Set<String>set=new HashSet<>();
        for(int n:arr1){
            String s=String.valueOf(n);
            String temp="";
            for(int i=0;i<s.length();i++){
                temp=temp+s.charAt(i);
                set.add(temp);
            }
        }
        int maxLen=0;
        for(int n:arr2){
            String s=String.valueOf(n);
            String temp="";
            for(int i=0;i<s.length();i++){
                temp=temp+s.charAt(i);
                if(set.contains(temp)){
                    maxLen=Math.max(maxLen,temp.length());
                }
            }
        }
        return maxLen;
    }
}