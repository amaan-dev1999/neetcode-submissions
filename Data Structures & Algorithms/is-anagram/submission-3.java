class Solution {
    public boolean isAnagram(String s, String t) {
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
