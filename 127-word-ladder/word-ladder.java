class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String>set=new HashSet(wordList);
        if(!set.contains(endWord))return 0;
        int steps=1;
        Queue<String>queue=new LinkedList<>();
        queue.add(beginWord);
        while(!queue.isEmpty()){
            int size=queue.size();
            while(size-->0){
                String word=queue.poll();
                if(word.equals(endWord))return steps;
                char[] chars=word.toCharArray();
                for(int i=0;i<word.length();i++){
                    char original=chars[i];
                    for(int j=0;j<26;j++){
                        chars[i]=(char)('a'+j);
                        String newWord=new String(chars);
                        if(set.contains(newWord)){
                            queue.add(newWord);
                            set.remove(newWord);
                        }
                    }
                    chars[i]=original;
                }
            }
            steps++;
        }
    return 0;
    }
}