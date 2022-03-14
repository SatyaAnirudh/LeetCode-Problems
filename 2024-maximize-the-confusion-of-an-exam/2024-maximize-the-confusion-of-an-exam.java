class Solution {
    public int maxConsecutiveAnswers(String answerKey, int k) {
        
        HashMap<Character,Integer> map=new HashMap<>();
        int start=0,res=0,maxRepeatCount=0;
        
        for(int end=0;end<answerKey.length();end++){
            char right =answerKey.charAt(end);
            map.put(right,map.getOrDefault(right,0)+1);
            maxRepeatCount=Math.max(maxRepeatCount,map.get(right));
            
            if(end-start+1 - maxRepeatCount > k ){
                char left =answerKey.charAt(start);
                if(map.get(left)>=0){
                    if(map.get(left)==0)map.remove(left);
                    map.put(left,map.get(left)-1);
                }
                start++;
            }
            res= Math.max(res,end-start+1);
            
        }
        return res;
        
    }
}