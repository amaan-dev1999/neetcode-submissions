class Solution {
    public boolean isPalindrome(String s) {
        String sNoSpaces = s.replaceAll("[^a-zA-Z0-9]", "");
        sNoSpaces = sNoSpaces.toLowerCase();
        int start=0;
        int end = sNoSpaces.length()-1;

        while(start<=end){
            if(sNoSpaces.charAt(start) == sNoSpaces.charAt(end)){
                start++;
                end--;
            } else {
                return false;
            }
        }

        return true;
    }
}
