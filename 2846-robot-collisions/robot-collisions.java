class Pair{
    int position,health,index;
    char direction;
    Pair(int position,int health,char direction,int index){
        this.position=position;
        this.health=health;
        this.direction=direction;
        this.index=index;
    }
}
class Solution {
    public List<Integer> survivedRobotsHealths(int[] positions, int[] healths, String directions) {
        int n=positions.length;
        Pair[] arr=new Pair[n];
        for(int i=0;i<n;i++){
            arr[i]=new Pair(positions[i],healths[i],directions.charAt(i),i);
        }
        Arrays.sort(arr,(a,b)->a.position-b.position);
        Stack<Pair>stack=new Stack<>();
        for(Pair pair:arr){
            boolean destroyed=false;
            while(!stack.isEmpty()&&stack.peek().direction=='R'&&pair.direction=='L'){
                if(stack.peek().health<pair.health){
                    stack.pop();
                    pair.health--;
                }
                else if(stack.peek().health==pair.health){
                    stack.pop();
                    destroyed=true;
                    break;
                }
                else{
                    Pair newPair=stack.pop();
                    newPair.health--;
                    stack.push(newPair);
                    destroyed=true;
                    break;
                }
            }
            if(!destroyed)stack.push(pair);
        }
        int[] result=new int[n];
        Arrays.fill(result,-1);
        List<Integer>list=new ArrayList<>();
        for(Pair pair:stack){
            result[pair.index]=pair.health;
        }
        for(int num:result){
            if(num!=-1)list.add(num);
        }
        return list;
    }
}