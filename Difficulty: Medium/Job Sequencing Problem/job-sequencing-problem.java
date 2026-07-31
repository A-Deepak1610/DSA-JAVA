class Pair {
	int deadLine, profit;
	Pair(int deadLine, int profit) {
		this.deadLine = deadLine;
		this.profit = profit;
	}
}
class Solution {
	public ArrayList<Integer> jobSequencing(int[] deadline, int[] profit) {
		ArrayList<Integer>res = new ArrayList<>();
		int n = profit.length;
		int maxDeadLine = 0;
		Pair[] pair = new Pair[n];
		for (int i = 0; i<n; i++) {
			pair[i] = new Pair(deadline[i], profit[i]);
		}
		Arrays.sort(pair, (a, b)->a.deadLine - b.deadLine);
		PriorityQueue<Integer>pq=new PriorityQueue<>();
		for(Pair p:pair){
		    pq.add(p.profit);
		    if(pq.size()>p.deadLine)pq.poll();
		}
		int count=0,maxProfit=0;
		for(Integer p:pq){
		    count++;
		    maxProfit+=p;
		}
		res.add(count);
		res.add(maxProfit);
		return res;
	}
}
