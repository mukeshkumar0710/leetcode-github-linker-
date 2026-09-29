class Solution {
    public int[] runningSum(int[] nums) {
        int[] ans= new int[nums.length];
        for(int i=0; i<nums.length; i++){
            int j=0;
            while(j<=i){
                ans[i]+= nums[j];
                j++;
            }
        }
        return ans;
    }
}