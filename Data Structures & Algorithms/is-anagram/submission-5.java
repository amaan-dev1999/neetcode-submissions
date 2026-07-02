class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length()!= t.length()){
            return false;
        }
        Map<String, Integer> map = new HashMap<>();
        for(int i =0; i<s.length();i++){
            if(map.containsKey(String.valueOf(s.charAt(i)))){
                map.put(String.valueOf(s.charAt(i)), map.get(String.valueOf(s.charAt(i)))+1);
            } else {
                map.put(String.valueOf(s.charAt(i)), 1);
            }
        }

        for(int i=0 ; i <t.length(); i++){
            if(map.containsKey(String.valueOf(t.charAt(i)))){
                map.put(String.valueOf(t.charAt(i)), map.get(String.valueOf(t.charAt(i)))-1);
            } else {
                return false;
            }
        }

        for(Map.Entry<String, Integer> entry : map.entrySet()){
            if (entry.getValue() != 0){
                return false;
            }
        }
       return true;
    }
}
