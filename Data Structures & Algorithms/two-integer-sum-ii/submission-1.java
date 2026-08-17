class Solution {
    public int[] twoSum(int[] numbers, int target) {
        for(int i = 0; i< numbers.length; i++){
            int complement = target - numbers[i];
            int complementIndex = primeSearch(numbers, complement, i+1, numbers.length-1);
            if(complementIndex!=-1){
                return new int[]{i+1,complementIndex+1};
            }
        }
        return null;
    }

    public static int primeSearch(int[] numbers, int complement, int start, int end){
        int low = start;
        int high = end;

        while(low<=high){
            int mid = (high + low)/2;
            if(numbers[mid] == complement){
                return mid;
            } else if(numbers[mid]<complement){
                low = mid+1;
            } else {
                high = mid-1;
            }
        }

        return -1;
    }
}
