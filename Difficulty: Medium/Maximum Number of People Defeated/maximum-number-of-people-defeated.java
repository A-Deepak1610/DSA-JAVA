class Solution {
    int maxPeopleDefeated(int p) {
        int i=1,count=0;
        while(p>=i*i){
            p-=i*i;
            i++;
            count++;
        }
        return count;
    }
};