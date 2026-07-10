class Solution {
    public int getCount(int n) {
        int count=0;
        int left=1,right=1,sum=0;
        while(left<n){
            if(sum<n){
                sum+=right;
                right++;
            }
            else if(sum>n){
                sum-=left;
                left++;
            }
            else {
                count++;
                sum-=left;
                left++;
            }
            
        }
        return count;
    }
};