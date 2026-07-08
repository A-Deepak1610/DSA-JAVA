class Worker{
    int quality,wage;
    double ratio;
    Worker(int quality,int wage){
        this.quality=quality;
        this.wage=wage;
        ratio=(double)wage/quality;
    }
}
class Solution {
    public double mincostToHireWorkers(int[] quality, int[] wage, int k) {
        int n=quality.length;
        Worker[] worker=new Worker[n];
        for(int i=0;i<n;i++)worker[i]=new Worker(quality[i],wage[i]);
        Arrays.sort(worker,(a,b)->Double.compare(a.ratio,b.ratio));
        double minWage=Double.MAX_VALUE;
        PriorityQueue<Integer>pq=new PriorityQueue<>((a,b)->b-a);
        int qualitySum=0;
        for(Worker w:worker){
            qualitySum+=w.quality;
            pq.add(w.quality);
            if(pq.size()==k){
                minWage=Math.min(minWage,qualitySum*w.ratio);
                qualitySum-=pq.poll();
            }
        }
        return minWage;
    }
}