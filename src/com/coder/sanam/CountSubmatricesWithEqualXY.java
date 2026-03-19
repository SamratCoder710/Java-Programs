package com.coder.sanam;

public class CountSubmatricesWithEqualXY {

    public static void main(String[] args) {
        CountSubmatricesWithEqualXY countSubmatricesWithEqualXY = new CountSubmatricesWithEqualXY();
        //"X","Y","."],["Y",".","."]
        int res = countSubmatricesWithEqualXY.numberOfSubmatrices(new char[][]{{'X','Y','.'},{'Y','.','.'}});
        System.out.println(res);
    }


    public int numberOfSubmatricesOptimized(char[][] grid) {
        int m = grid.length, n = grid[0].length;
        int ans = 0;

        int[][] px = new int[m][n];
        int[][] py = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                px[i][j] = (grid[i][j] == 'X') ? 1 : 0;
                py[i][j] = (grid[i][j] == 'Y') ? 1 : 0;

                if (i > 0) {
                    px[i][j] += px[i - 1][j];
                    py[i][j] += py[i - 1][j];
                }
                if (j > 0) {
                    px[i][j] += px[i][j - 1];
                    py[i][j] += py[i][j - 1];
                }
                if (i > 0 && j > 0) {
                    px[i][j] -= px[i - 1][j - 1];
                    py[i][j] -= py[i - 1][j - 1];
                }

                if (px[i][j] == py[i][j] && px[i][j] > 0) {
                    ans++;
                }
            }
        }

        return ans;
    }

    public int numberOfSubmatrices(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int count = 0;
        String[][] arr = new String[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                int x=0,y = 0;
                char ch = grid[i][j];
                if(ch == 'X'){
                    x++;
                }else if(ch == 'Y'){
                    y++;
                }

                if(i > 0){
                    String above = arr[i-1][j];
                    String[] sArr = above.split(":");
                    x += Integer.parseInt(sArr[0]);
                    y += Integer.parseInt(sArr[1]);
                }

                if(j>0){
                    String left = arr[i][j-1];
                    String[] sArr = left.split(":");
                    x += Integer.parseInt(sArr[0]);
                    y += Integer.parseInt(sArr[1]);
                }

                //remove double count of diag
                if(i > 0 && j > 0){
                    String diag = arr[i-1][j-1];
                    String[] sArr = diag.split(":");
                    x -= Integer.parseInt(sArr[0]);
                    y -= Integer.parseInt(sArr[1]);
                }

                arr[i][j] = x + ":" + y;
                if(x == y && x >= 1){
                    count++;
                }
            }
        }
        return count;
    }

}
