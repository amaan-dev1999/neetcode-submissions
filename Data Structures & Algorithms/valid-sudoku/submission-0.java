class Solution {


    public static boolean hasDuplicate(char[] arr){
        Set<Character> seen = new HashSet<>();
        for(char c: arr){
            if(!seen.add(c) && c != '.'){
                return true;
            }
        }
        return false;
    }

    public static char[][] transpose(char[][] board){
        int n = board.length;
        char[][] transposed = new char[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                transposed[i][j] = board[j][i];
            }
        }

        return transposed;
    }




    public boolean isValidSudoku(char[][] board) {
        for (char[] chars : board) {
            boolean isDuplicate = hasDuplicate(chars);
            if (isDuplicate) {
                return false;
            }
        }

        char[][] columnArray = transpose(board);

        for (char[] chars : columnArray) {
            boolean isDuplicate = hasDuplicate(chars);
            if (isDuplicate) {
                return false;
            }
        }

        char[][] subboxArray = new char[board.length][board.length];

        int initialBucketIndex = 0;
        int prevJIndex = 0;
        int jIndex = 0;

        for(int i =0 ; i<9 ; i++){
            int bucket = initialBucketIndex;
            jIndex=prevJIndex;
            for(int j =0 ; j<9 ; j++){
                subboxArray[bucket][jIndex] = board[i][j];
                jIndex++;
                if((j+1)%3==0){
                    bucket++;
                    jIndex = prevJIndex;
                }
            }
            if((i+1)%3==0){
                initialBucketIndex+=3;
                prevJIndex=0;
            } else {
                prevJIndex = prevJIndex+3;
            }

        }

        for (char[] chars : subboxArray) {
            boolean isDuplicate = hasDuplicate(chars);
            if (isDuplicate) {
                return false;
            }
        }


        return true;
    }
}
