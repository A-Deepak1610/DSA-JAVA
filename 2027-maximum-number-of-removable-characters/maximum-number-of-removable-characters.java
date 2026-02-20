class Solution {
    public int maximumRemovals(String s, String p, int[] removable) {
        int n=removable.length;
        int l=0,r=n,k=0;
        while(l<=r){
            int mid=l+(r-l)/2;
            if(isSubsequence(s,p,removable,mid)){
                k=mid;
                l=mid+1;
            }
            else r=mid-1;
        }
        return k;
    }
     private boolean isSubsequence(String s, String p, int[] removable, int k) {
        boolean[] removed = new boolean[s.length()];
        for (int i = 0; i < k; i++) {
            removed[removable[i]] = true;
        }
        int j = 0;
        for (int i = 0; i < s.length() && j < p.length(); i++) {
            if (!removed[i] && s.charAt(i) == p.charAt(j)) {
                j++;
            }
        }
        return j == p.length();
    }
}