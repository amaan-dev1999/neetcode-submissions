class Solution {
    public int[] twoSum(int[] nums, int target) {
         Map<Integer, List<Integer>> map = new HashMap<>();
        for(int i = 0; i<nums.length; i++){
            if(map.containsKey(nums[i])){
                map.get(nums[i]).add(i);
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(i);
                map.put(nums[i], list);
            }
        }

        for(int i = 0 ; i < nums.length; i++){
            int value = target-nums[i];
            List<Integer> arr = map.get(value);
            if(map.containsKey(value) && value!=nums[i]){
                return new int[]{i, arr.getLast()};
            }
            if(map.containsKey(value) && value==nums[i] && arr.size()>1){
                return new int[]{i, arr.getLast()};
            }
        }


        return null;
    }
}
