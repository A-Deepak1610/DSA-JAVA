class Solution {
    public long makeSimilar(int[] nums, int[] target) {
        List<Integer> numsEven = new ArrayList<>();
        List<Integer> numsOdd = new ArrayList<>();
        List<Integer> targetEven = new ArrayList<>();
        List<Integer> targetOdd = new ArrayList<>();
        for (int x : nums) {
            if ((x & 1) == 0)
                numsEven.add(x);
            else
                numsOdd.add(x);
        }
        for (int x : target) {
            if ((x & 1) == 0)
                targetEven.add(x);
            else
                targetOdd.add(x);
        }
        Collections.sort(numsEven);
        Collections.sort(numsOdd);
        Collections.sort(targetEven);
        Collections.sort(targetOdd);
        long operations = 0;
        for (int i = 0; i < numsEven.size(); i++) {
            if (targetEven.get(i) > numsEven.get(i)) {
                operations += (targetEven.get(i) - numsEven.get(i)) / 2;
            }
        }
        for (int i = 0; i < numsOdd.size(); i++) {
            if (targetOdd.get(i) > numsOdd.get(i)) {
                operations += (targetOdd.get(i) - numsOdd.get(i)) / 2;
            }
        }
        return operations;
    }
}