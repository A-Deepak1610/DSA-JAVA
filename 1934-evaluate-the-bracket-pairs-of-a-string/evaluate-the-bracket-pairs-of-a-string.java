class Solution {
    public String evaluate(String s, List<List<String>> knowledge) {
        HashMap<String,String> map=new HashMap<>();
        StringBuilder sb=new StringBuilder();
        for(List<String> li:knowledge) map.put(li.get(0),li.get(1));
        int i=0,n=s.length();
        while(i<n){
            if(s.charAt(i)=='('){
                String temp="";
                i++;
                while(s.charAt(i)!=')'){
                    temp+=s.charAt(i);
                    i++;
                }
                sb.append(map.getOrDefault(temp,"?"));
                i++;
            }
            else{
                sb.append(s.charAt(i));
                i++;
            }
        }
        return sb.toString();
    }
}