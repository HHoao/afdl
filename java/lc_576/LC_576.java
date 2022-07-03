package lc_576;

/*
 *@author: �ƺ�
 *@date : 2021��8��15��
 *@todo:����һ����СΪ m x n �������һ���������ʼ����Ϊ [startRow, startColumn] ������Խ����Ƶ����ĸ����������ڵĵ�Ԫ���ڣ����Դ�������߽絽������֮�⣩���� ��� �����ƶ� maxMove ����

����������� m��n��maxMove��startRow �Լ� startColumn ���ҳ������ؿ��Խ����Ƴ��߽��·����������Ϊ�𰸿��ܷǳ��󣬷��ض� 109 + 7 ȡ�� ��Ľ����

��Դ�����ۣ�LeetCode��
���ӣ�https://leetcode-cn.com/problems/out-of-boundary-paths
����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
*/
public class LC_576 {
	public static void main(String[] args) {
		Solution so = new Solution();
		System.out.println(so.findPaths(2, 2, 2, 0, 0));
	}
}
class Solution {
    int ans, m, n, maxMove;
    private void move(int row, int column, int n){
        if (row == m || row < 0 || column < 0 || column == this.n){
            ans++;
            return;
        }
        if (n == maxMove){
           return; 
        }
        
        move(row+1, column, n+1);
        move(row-1, column, n+1);
        move(row, column+1, n+1);
        move(row, column-1, n+1);
    }
    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        this.m = m; 
        this.n = n; 
        this.maxMove = maxMove; 
        this.ans = 0;
        move(startRow, startColumn, 0);
        return ans;
    }
}