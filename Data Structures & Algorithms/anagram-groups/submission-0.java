class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> output = new ArrayList<>();
        HashMap<Integer, Boolean> indexTracker = new HashMap<>();
        for(int i =0; i <strs.length; i++){
            if(!indexTracker.containsKey(i)) {
                List<String> validAnagrams = new ArrayList<>();
                for (int j = 0; j < strs.length; j++) {
                    if (i != j && isAnagramUsingHashMap(strs[i], strs[j]) && !indexTracker.containsKey(j)) {
                        indexTracker.put(j, true);
                        validAnagrams.add(strs[j]);
                    }
                }
                validAnagrams.add(strs[i]);
                output.add(validAnagrams);
                indexTracker.put(i, true);
            }
        }
        return output;
    }

    public static boolean isAnagramUsingHashMap(String s , String t) {
        if(s.length()!= t.length()){
            return false;
        }
        Map<Character, Integer> map = new HashMap<>();
        for(int i =0; i<s.length();i++){
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c,0)+1);
        }

        for(int i=0 ; i <t.length(); i++){
            char c = t.charAt(i);
            Integer count = map.get(c);

            if(count == null || count ==0 ){
                return false;
            }
            map.put(c, count-1);
        }

        return true;
    }
}
