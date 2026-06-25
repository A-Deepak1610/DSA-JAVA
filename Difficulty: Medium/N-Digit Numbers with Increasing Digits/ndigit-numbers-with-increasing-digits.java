class Solution {
    public static ArrayList<Integer> increasingNumbers(int n) {
        ArrayList<Integer>res=new ArrayList<>();
        if(n>9)return res;
        if(n==1)res.add(0);
        for(int i=1;i<10;i++){
            generate(i,i,n-1,res);
        }
        return res;
    }
    private static void generate(int currentDigit,int currentNum,int n,ArrayList<Integer>res ){
        if(n==0){
            res.add(currentNum);
            return;
        }
        for(int i=currentDigit+1;i<10;i++){
            generate(i,currentNum*10+i,n-1,res);
        }
    }
}
