class Solution {
    public int[] nextGreaterElements(int[] nums) {
        Stack<Integer>stack=new Stack<>();
        int n=nums.length;
        int[] result=new int[n];
        for(int i=2*n-1;i>=0;i--){
            int idx=i%n;
            while(!stack.isEmpty()&&stack.peek()<=nums[idx])stack.pop();
            if(stack.isEmpty())result[idx]=-1;
            else result[idx]=stack.peek();
            stack.push(nums[idx]);
        }
        return result;
    }
}