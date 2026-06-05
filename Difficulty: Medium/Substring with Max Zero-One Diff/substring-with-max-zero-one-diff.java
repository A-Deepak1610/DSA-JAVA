class Solution {
    int maxSubstring(String s) {
        int  currSum=0;
        int  maxSum=-1;
        for(char ch:s.toCharArray()){
            if(ch=='0')currSum++;
            else currSum--;
            if(currSum<0)currSum=0;
            maxSum=Math.max(currSum,maxSum);
        }
        return maxSum==0?-1:maxSum;
    }
}