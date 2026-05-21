class Solution {
    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        Set<String>set=new HashSet<>();
        for(int n:arr1){
            String s=String.valueOf(n);
            StringBuilder temp = new StringBuilder();
            for(int i=0;i<s.length();i++){
                temp.append(s.charAt(i));
                set.add(temp.toString());
            }
        }
        int maxLen=0;
        for(int n:arr2){
            String s=String.valueOf(n);
            StringBuilder temp = new StringBuilder();
            for(int i=0;i<s.length();i++){
                temp.append(s.charAt(i));
                if(set.contains(temp.toString())){
                    maxLen=Math.max(maxLen,temp.length());
                }
            }
        }
        return maxLen;
    }
}