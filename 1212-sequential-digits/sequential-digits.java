class Solution {
    public List<Integer> sequentialDigits(int low, int high) {
        List<Integer> res=new ArrayList<>();
        for(int st=1;st<=9;st++){
            int num=0,currDig=st;
            while(num<=high&&currDig<=9){
                num=num*10+currDig;
                currDig++;
                if(num>=low&&num<=high)res.add(num);
            }    
        }
        Collections.sort(res);
        return res;
    }
}