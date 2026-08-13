class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length ==0){
            return 0;
        }

        Set<Integer> numsSet = new HashSet<>();


        int currentLongestSeq = 1;
        int prevLongestSeq = 1;
        for(int n: nums){
            numsSet.add(n);
        }


        //find potential candidate for start of the sequence
        Map<Integer, Boolean> candidates = new HashMap<>();

        for(int n: numsSet){
            if(!numsSet.contains(n-1) && numsSet.contains(n+1)){
                candidates.put(n, true);
            }
        }

        //traverse the hashmap
        for(Map.Entry<Integer, Boolean> e : candidates.entrySet()){
            boolean c = true;
            int currentValue = e.getKey();
            while(c){
                if(numsSet.contains(currentValue+1)){
                    currentLongestSeq++;
                    currentValue++;
                } else if (currentLongestSeq>=prevLongestSeq){
                        prevLongestSeq=currentLongestSeq;
                        currentLongestSeq=1;
                        c=false;

                } else {
                    currentLongestSeq=1;
                    c=false;
                }
            }
        }


        return prevLongestSeq;    
        }
}
