class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> countMap = new HashMap<>();
        List<Integer> output = new ArrayList<>();
        for(int n: nums){
            if(countMap.containsKey(n)){
                int count = countMap.get(n);
                countMap.put(n,count+1);
            } else {
                countMap.put(n, 1);
            }
        }

        int[][] arr = new int[countMap.size()][2];
        int idx = 0;
        for(Map.Entry<Integer, Integer> e: countMap.entrySet()){
            arr[idx][0] = e.getKey();
            arr[idx][1]= e.getValue();
            idx++;
        }

        System.out.println(Arrays.deepToString(arr));

        Arrays.sort(arr, (a,b) -> Integer.compare(b[1], a[1]));
        System.out.println(Arrays.deepToString(arr));

        int count = 0;
        while(count<k){
            output.add(arr[count][0]);
            count++;
        }


        int[] result = new int[output.size()];
        System.out.println(output);
        for(int i =0; i <output.size(); i++){
           result[i] = output.get(i);
        }

        return result;
    }
}
