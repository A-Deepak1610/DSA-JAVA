class Solution {
    public int openLock(String[] deadend, String target) {
        Set<String> deadends=new HashSet<>(Arrays.asList(deadend));
        Set<String> visited=new HashSet<>();
        Queue<String>queue=new LinkedList<>();
        int turns=0;
        if(deadends.contains("0000"))return -1;
        queue.add("0000");
        while(!queue.isEmpty()){
            int n=queue.size();
            for(int i=0;i<n;i++){
                String curr=queue.poll();
                if(curr.equals(target))return turns;
                for(int j=0;j<4;j++){
                    int currdigit=curr.charAt(j)-'0';
                    int option1 = (currdigit == 9) ? 0 : currdigit + 1;
                    int option2 = (currdigit == 0) ? 9 : currdigit - 1;        
                    String next1=curr.substring(0,j)+String.valueOf(option1)+curr.substring(j+1,4);
                    String next2=curr.substring(0,j)+String.valueOf(option2)+curr.substring(j+1,4);
                    if(!deadends.contains(next1)&&!visited.contains(next1)){
                        visited.add(next1);
                        queue.add(next1);
                    }
                    if(!deadends.contains(next2)&&!visited.contains(next2)){
                        visited.add(next2);
                        queue.add(next2);
                    }
                }
            }
            turns++;
        }
        return -1;
    }
}