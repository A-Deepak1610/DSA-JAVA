class Pair{
    int val,pos,count;
    Pair(int val,int pos){
        this.val=val;
        this.pos=pos;
        this.count=Integer.bitCount(val);
    }
}
class Solution {
    ArrayList<Integer> sortBySetBitCount(int[] arr) {
        int n=arr.length;
        Pair[] pair=new Pair[n];
        for(int i=0;i<n;i++){
            pair[i]=new Pair(arr[i],i);
        }
        Arrays.sort(pair,(a,b)->{
            if(a.count>b.count)return -1;
            else if(b.count>a.count)return 1;
            else {
                if(a.pos<b.pos)return -1;
                else return 1;
            }
        });
        ArrayList<Integer> list=new ArrayList<>();
        for(int i=0;i<n;i++){
            list.add(pair[i].val);
        }
        return list;
    }
}