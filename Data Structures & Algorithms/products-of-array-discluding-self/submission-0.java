class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];
        int product = 1;
        int withZeroProduct = 1;
        int zeroFrequency = 0;
        int zeroIndex = 0;
        for(int i=0; i< nums.length; i++){
            if(nums[i]==0){
                zeroFrequency++;
                zeroIndex=i;
            }
            if(nums[i]!=0) {
                withZeroProduct = withZeroProduct * nums[i];
            }
            product = product*nums[i];
        }
        if(zeroFrequency>1){
            Arrays.fill(result, 0);
            return result;
        }

        if(zeroFrequency==1){
            Arrays.fill(result, 0);
            result[zeroIndex]= withZeroProduct;
            return result;
        }

        for(int i = 0; i < nums.length; i++){
            result[i] = product/nums[i];
        }

        return result;
    }
}  
