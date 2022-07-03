package lc_397;

/*
 *@author: �ƺ�
 *@date : 2021��10��27��
 *@todo:397. �����滻
����һ�������� n ������������²�����

��� n ��ż�������� n / 2�滻 n ��
��� n ��������������� n + 1��n - 1�滻 n ��
n ��Ϊ 1 �������С�滻�����Ƕ��٣�
*/
public class LC_397 {
	public static void main(String[] args) {
		System.out.println(new Solution().integerReplacement(21));
	}
}
//�ݹ�
class Solution {
    public int integerReplacement(int n) {
        return (int)dfs(n);
    }
    long dfs(long i){
        if(i==1)return 0;
        if(i==2)return 1;
        if((i&1) == 1){
            return (long)Math.min(dfs((i+1)/2)+2,dfs(i-1)+1);
        }else return dfs(i/2)+1;
    }
}