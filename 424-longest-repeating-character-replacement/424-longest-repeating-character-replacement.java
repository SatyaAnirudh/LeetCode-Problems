class Solution {
    public int characterReplacement(String s, int k) {
        
        int start=0,maxLetters=0,res=0;
        HashMap<Character,Integer> map=new HashMap<>();
        
        for(int end=0;end<s.length();end++){
            
            char right=s.charAt(end);
            map.put(right,map.getOrDefault(right,0)+1);
            maxLetters= Math.max(maxLetters,map.get(right));
            
            if(end-start+1 - maxLetters > k){
                
                char left=s.charAt(start++);
                map.put(left,map.getOrDefault(left,0)-1);
                
            }
            
            res=Math.max(res,end-start+1);
            
        }
        
        return res;
        
        
    }
}