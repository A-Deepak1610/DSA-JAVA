class Solution {
    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> pairs=new ArrayList<>();
        Map<String,Integer> map=new HashMap<>();
        for(int i=0;i<words.length;i++)map.put(words[i],i);
        for(int idx=0;idx<words.length;idx++){
            String s=words[idx];
            for(int i=0;i<=s.length();i++){
                String prefix=s.substring(0,i);
                String sufix=s.substring(i);
                if(isPal(prefix)){
                    String rev=reverse(sufix);
                    if(map.containsKey(rev)&&map.get(rev)!=idx){
                        pairs.add(Arrays.asList(map.get(rev),idx));
                    }
                }
                if(i!=s.length()&&isPal(sufix)){
                    String rev=reverse(prefix);
                    if(map.containsKey(rev)&&map.get(rev)!=idx){
                        pairs.add(Arrays.asList(idx,map.get(rev)));
                    }

                }
            }
        }
        return pairs;
    }
    private boolean isPal(String s){
       int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
    private String reverse(String s){
        return new StringBuilder(s).reverse().toString();
    }
}