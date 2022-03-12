class Solution {
    public int minimumDifference(int[] nums, int k) {
        
        Arrays.sort(nums);
        
        int start=0;
        int res=Integer.MAX_VALUE;
        
        for(int end=0;end<nums.length;end++){
            
            if(end-start+1 == k){
                
                res = Math.min(res,nums[end]-nums[start]);
                start++;
                
            }
            
        }
        return res;
    }
}