package lc_329;

/*
 *@author: �ƺ�
 *@date : 2021��10��26��
 *@todo:329. �����е������·��
����һ�� m x n �������� matrix ���ҳ����� �����·�� �ĳ��ȡ�

����ÿ����Ԫ����������ϣ��£������ĸ������ƶ��� �� ���� �� �Խ��� �������ƶ����ƶ��� �߽��⣨���������ƣ���
*/
public class LC_329 {

}
//���仯����
class Solution {
    int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    int rows, columns;
    public int longestIncreasingPath(int[][] matrix) {
        rows = matrix.length;
        columns = matrix[0].length;
        int[][] memo = new int[rows][columns];
        int ans = 1;
        for (int i = 0; i < rows; i++){
            for (int j = 0; j < columns; j++){
                ans = Math.max(ans, dfs(matrix, i, j, memo));
            }
        }
        return ans;
    }
    public int dfs(int[][] matrix, int row, int column, int[][] memo){
        if (memo[row][column] != 0){
            return memo[row][column];
        }
        memo[row][column]++;
        for (int[] dir : dirs){
            int newRow = row + dir[0], newColumn = column + dir[1];
            if (newRow >= 0 && newColumn >= 0 && newRow < rows && newColumn < columns && matrix[newRow][newColumn] > matrix[row][column])
            memo[row][column] = Math.max(memo[row][column], dfs(matrix, newRow, newColumn, memo)+1);
        }
        return memo[row][column];
    }
}