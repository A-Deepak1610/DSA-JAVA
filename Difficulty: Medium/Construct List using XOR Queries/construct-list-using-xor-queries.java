class Solution {
    public ArrayList<Integer> constructList(int[][] queries) {
        ArrayList<Integer> list=new ArrayList<>();
        list.add(0);
        int xor=0;
        for(int[] query:queries){
            if(query[0]==0)list.add(query[1]^xor);
            else xor^=query[1];
        }
        for(int i=0;i<list.size();i++){
            list.set(i,list.get(i)^xor);
        }
        Collections.sort(list);
        return list;
    }
}