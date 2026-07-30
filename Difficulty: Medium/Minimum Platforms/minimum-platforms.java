class Solution {
    public int minPlatform(int arr[], int dep[]) {
        Arrays.sort(arr);
        Arrays.sort(dep);
        int n=arr.length,i=0,j=0,platForm=0,maxPlatForm=0;
        while(i<n&&j<n){
            if(arr[i]<=dep[j]){
                platForm++;
                i++;
            }
            else {
                platForm--;
                j++;
            }
            maxPlatForm=Math.max(maxPlatForm,platForm);
        }
        return maxPlatForm;
    }
}
