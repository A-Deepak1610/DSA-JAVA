class Solution {
    public List<String> letterCombinations(String digits) {
        List<String>res=new ArrayList<>();
        String[] map = {
            "",
            "", 
            "abc",
            "def",
            "ghi",
            "jkl",
            "mno",
            "pqrs",
            "tuv",
            "wxyz"
        };
        backTrack(0,digits,new StringBuilder(),map,res);
        return res;
    }
    private void backTrack(int index,String digits,StringBuilder path,String[] map,List<String>res){
        if(index==digits.length()){
            res.add(path.toString());
            return ;
        }
        String s=map[digits.charAt(index)-'0'];
        for(char ch:s.toCharArray()){
            path.append(ch);
            backTrack(index+1,digits,path,map,res);
            path.deleteCharAt(path.length()-1);
        }
    }
}