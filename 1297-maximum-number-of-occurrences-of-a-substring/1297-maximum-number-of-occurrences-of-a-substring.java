class Solution {
    public int maxFreq(String s, int maxLetters, int minSize, int maxSize) {
        
        int start=0,res=0,curr=0;
        HashMap<Character,Integer> charMap=new HashMap<>();
        HashMap<String,Integer> subStrMap=new HashMap<>();
        
        for(int end=0;end<s.length();end++){
            char right=s.charAt(end);
            charMap.put(right,charMap.getOrDefault(right,0)+1);
            
            if(end-start+1 >= minSize && end-start+1<=maxSize){
                //System.out.println(s.substring(start,end+1));
                if(charMap.size()<= maxLetters){
                    String sub=s.substring(start,end+1);
                    subStrMap.put(sub,subStrMap.getOrDefault(sub,0)+1);
                }
                char left=s.charAt(start);
                charMap.put(left,charMap.getOrDefault(left,0)-1);
                if(charMap.get(left)==0)charMap.remove(left);
                start++;
            }
            
            //res=subStrMap.entrySet().stream().map(e -> e.getValue()).
            //System.out.println(subStrMap+"..."+charMap);
        }
        
        res=subStrMap.entrySet().stream().map(e -> e.getValue()).max((a,b)->(a-b)).orElse(0);
        
        return res;
        
    }
}