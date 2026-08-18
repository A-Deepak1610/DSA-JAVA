class Solution {
    public int maxDistance(int[] position, int m) {
        Arrays.sort(position);
        int low = 1;
        int high = position[position.length - 1] - position[0];
        int answer = 0;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (canPlace(position, m, mid)) {
                answer = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return answer;
    }
    private boolean canPlace(int[] arr, int m, int dist) {
        int count = 1;
        int last = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] - last >= dist) {
                count++;
                last = arr[i];
                if (count == m) return true;
            }
        }
        return false;
    }
}