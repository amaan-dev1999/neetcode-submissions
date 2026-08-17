class Solution {
    public int[] twoSum(int[] numbers, int target) {
       int firstPointer = 0;
        int secondPointer = numbers.length-1;

        while(firstPointer<secondPointer){
            if(numbers[firstPointer]+numbers[secondPointer]==target){
                return new int[]{firstPointer+1, secondPointer+1};
            } else if(numbers[firstPointer]+numbers[secondPointer]<target){
                firstPointer++;
            } else {
                secondPointer--;
            }
        }

        return null;
    }


}
