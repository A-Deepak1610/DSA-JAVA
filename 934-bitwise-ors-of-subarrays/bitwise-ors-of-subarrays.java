class Solution {
    public int subarrayBitwiseORs(int[] arr) {
        Set<Integer> prev = new HashSet<>();
        Set<Integer> all = new HashSet<>();
        for (int num : arr) {
            Set<Integer> curr = new HashSet<>();
            curr.add(num);
            for (int val : prev) {
                curr.add(val | num);
            }
            all.addAll(curr);
            prev = curr;
        }
        return all.size();
    }
}