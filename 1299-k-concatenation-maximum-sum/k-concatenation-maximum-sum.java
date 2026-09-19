class Solution {
    public int kConcatenationMaxSum(int[] arr, int k) {
        long MOD = 1_000_000_007L;
        long total = 0;
        for (int num : arr) {
            total += num;
        }
        int n = arr.length;
        int copies = Math.min(k, 2);
        long current = 0;
        long best = 0;
        for (int i = 0; i < n * copies; i++) {
            current = Math.max(0L, current + arr[i % n]);
            best = Math.max(best, current);
        }
        if (k > 2 && total > 0) {
            best += total * (k - 2);
        }
        return (int) (best % MOD);
    }
}