class Solution {
    public int partitionString(String s) {
        Set<Character> set=new HashSet<>();
        int count=0;
        for(char ch:s.toCharArray()){
            if(!set.contains(ch))set.add(ch);
            else {
                set.clear();
                set.add(ch);
                count++;
            }
        }
        return count+1;
    }
}