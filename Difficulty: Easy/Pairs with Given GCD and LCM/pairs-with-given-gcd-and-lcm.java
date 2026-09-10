class Solution {
    public int pairCount(int x, int y) {
        long product = (long) x * y;
        int count = 0;

        for (long a = 1; a * a <= product; a++) {

            if (product % a == 0) {
                long b = product / a;

                if (gcd(a, b) == x) {
                    if (a == b) {
                        count++;
                    } else {
                        count += 2; // (a,b) and (b,a)
                    }
                }
            }
        }

        return count;
    }

    private long gcd(long a, long b) {
        while (b != 0) {
            long temp = a % b;
            a = b;
            b = temp;
        }

        return a;
    }
}