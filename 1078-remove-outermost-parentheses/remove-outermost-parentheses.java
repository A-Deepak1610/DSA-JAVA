class Solution {
    public String removeOuterParentheses(String s) {
        StringBuilder sb=new StringBuilder();
        Stack<Character>stack=new Stack<>();
        for(char ch:s.toCharArray()){
            if(ch=='('){
                if(!stack.isEmpty())sb.append(ch);
                stack.push(ch);
            }
            else{
                if(stack.size()>1){
                    sb.append(ch);
                }
                stack.pop();
            }
        }
        return sb.toString();
    }
}