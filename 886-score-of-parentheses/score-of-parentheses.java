class Solution {
    public int scoreOfParentheses(String s) {
        Stack<Integer> stack=new Stack<>();
        stack.add(0);
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if(ch=='(')stack.push(0);
            else{
                int curVal=stack.pop();
                curVal=(curVal==0?1:curVal*2);
                stack.push(stack.pop()+curVal);
            }
        }
        return stack.pop();
    }
}