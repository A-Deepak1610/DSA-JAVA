class Solution {
    int[] nums;
    int[] left;
    int[] right;
    int lis(int i) {
        if (left[i] != -1) {
            return left[i];
        }
        left[i] = 1;
        for (int j = i - 1; j >= 0; j--) {
            if (nums[j] < nums[i]) {
                left[i] = Math.max(left[i], lis(j) + 1);
            }
        }
        return left[i];
    }
    int lds(int i) {
        if (right[i] != -1) {
            return right[i];
        }
        right[i] = 1;
        for (int j = i + 1; j < nums.length; j++) {
            if (nums[j] < nums[i]) {
                right[i] = Math.max(right[i], lds(j) + 1);
            }
        }
        return right[i];
    }
    public int minimumMountainRemovals(int[] nums) {
        this.nums = nums;
        int n = nums.length;
        left = new int[n];
        right = new int[n];
        Arrays.fill(left, -1);
        Arrays.fill(right, -1);
        int maxMountain = 0;
        for (int i = 0; i < n; i++) {
            int increasing = lis(i);
            int decreasing = lds(i);
            if (increasing > 1 && decreasing > 1) {
                int mountainLength = increasing + decreasing - 1;
                maxMountain = Math.max(maxMountain, mountainLength);
            }
        }
        return n - maxMountain;
    }
}