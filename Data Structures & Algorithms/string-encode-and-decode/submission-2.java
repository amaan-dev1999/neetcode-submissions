class Solution {

    public String encode(List<String> strs) {
        StringBuilder encodedString = new StringBuilder();
        for(String n: strs){
            int length = n.length();
            encodedString.append(length).append("#").append(n);
        }
        return String.valueOf(encodedString);
    }

    public List<String> decode(String str) {
        List<String> strs = new ArrayList<>();
        StringBuilder value = new StringBuilder();
        int index = 0;
        while(index<str.length()){
            char c = str.charAt(index);
            if(c != '#'){
                value.append(c);
                index++;

            } else if(Integer.parseInt(value.toString())==0){
                strs.add("");
                index++;
            }

            else{
                int initialIndex = index+1;
                String s = value.toString();
                int finalIndex = Integer.parseInt(s)+ initialIndex;
                String strDecoded = str.substring(initialIndex, finalIndex);
                strs.add(strDecoded);
                index = finalIndex;
                value = new StringBuilder();
            }
        }
        return strs;
    }
}
