class Solution {
    public int countTriplets(int[] nums, int l, int r) {
        Arrays.sort(nums);
        return countLessEqual(nums, r) - countLessEqual(nums, l - 1);
    }
    private int countLessEqual(int[] nums, int target) {
        int count = 0;
        for (int i = 0; i < nums.length - 2; i++) {
            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum <= target) {
                    count += right - left;
                    left++;
                } else {
                    right--;
                }
            }
        }

        return count;
    }
}