class Solution {
    public int findContentChildren(int[] g, int[] s) {
        int child=0;
        int n1=g.length,n2=s.length;
        Arrays.sort(s);
        Arrays.sort(g);
        int i=0,j=0;
        while(i<n1&&j<n2){
            if(s[j]>=g[i]){
                child++;
                i++;
                j++;
            }
            else j++;
        }
        return child;
    }
}