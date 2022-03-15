class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        
        int sum=0,res=0;
        HashMap<Integer,Integer> map=new HashMap<>();
        HashSet<Integer> set=new HashSet<>();
        
        for(int end=0,start=0;end<nums.length;){
            
            if(set.add(nums[end])){
                
                sum += nums[end++];
                res=Math.max(sum,res);
            }
            else{
                set.remove(nums[start]);
                sum -= nums[start++];
                
            }
            
        }
        
        return res;
        
        
    }
}