class Solution {
    public int clumsy(int n) {
        Stack<Integer>stack=new Stack<>();
        stack.push(n);
        int ops=0;
        for(int i=n-1;i>=1;i--){
            if(ops==0){
                stack.push(stack.pop()*i);
                ops=1;
            }
            else if(ops==1){
                stack.push(stack.pop()/i);
                ops=2;
            }
            else if(ops==2){
                stack.push(i);
                ops=3;
            }
            else if(ops==3){
                stack.push(-i);
                ops=0;
            }
        }
        int fact=0;
        while(!stack.isEmpty()){
            fact+=stack.pop();
        }
        return fact;
    }
}