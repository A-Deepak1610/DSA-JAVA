class Solution {
    public int maxSubArray(int[] nums) {
        int maxSum = Integer.MIN_VALUE;
        int sum = 0;
        for(int i=0; i<nums.length; i++) {
            sum+=nums[i];
            maxSum = Math.max(sum,maxSum);
            sum = sum < 0 ? 0 : sum;
        }
        return maxSum;
    }
}
// class Solution {
//     public int maxSubArray(int[] nums) {
//         int previous = nums[0];
//         int ans = nums[0];
//         for (int i = 1; i < nums.length; i++) {
//             int current = Math.max(
//                 nums[i],
//                 previous + nums[i]
//             );
//             ans = Math.max(ans, current);
//             previous = current;
//         }
//         return ans;
//     }
// }