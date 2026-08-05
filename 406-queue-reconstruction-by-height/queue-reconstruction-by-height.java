class Solution {
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people,(a,b)->{
            if(a[0]==b[0])return a[1]-b[1];
            return b[0]-a[0];
        });
        List<int[]>list=new ArrayList<>();
        int n=people.length;
        for(int[] p:people){
            int h=p[0],k=p[1];
            list.add(k,p);
        }
        return list.toArray(int[][]::new);
    }
}