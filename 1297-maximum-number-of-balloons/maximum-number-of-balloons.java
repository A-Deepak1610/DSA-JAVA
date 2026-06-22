class Solution {
    public int maxNumberOfBalloons(String text) {
        Map<Character,Integer>map=new HashMap<>();
        map.put('b',0);
        map.put('a',0);
        map.put('l',0);
        map.put('o',0);
        map.put('n',0);
        for(char ch:text.toCharArray()){
            if(ch=='b'||ch=='a'||ch=='l'||ch=='o'||ch=='n'){
                map.put(ch,map.getOrDefault(ch,0)+1);
            }
        }
        int ballon=0;
        while(true){
            if(map.get('b')>=1&&map.get('a')>=1&&map.get('l')>=2&&map.get('o')>=2&&map.get('n')>=1){
                ballon++;
                map.put('b',map.get('b')-1);
                map.put('a',map.get('a')-1);
                map.put('l',map.get('l')-2);
                map.put('o',map.get('o')-2);
                map.put('n',map.get('n')-1);
            }
            else break;
        }
        return ballon;
    }
}