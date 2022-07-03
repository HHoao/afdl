package lc_96;

/**
 * @author �ƺ�
 *96. ��ͬ�Ķ���������
����һ������ n������ 1 ... n Ϊ�ڵ���ɵĶ����������ж����֣�
 */
public class LC_96 {
	
}
// 1 1, 2 2, 3 5 
//��̬�滮
class Solution {
    public int numTrees(int n) {
        int[] G = new int[n + 1];
        G[0] = 1;
        G[1] = 1;

        for (int i = 2; i <= n; ++i) {
            for (int j = 1; j <= i; ++j) {
                G[i] += G[j - 1] * G[i - j];
            }
        }
        return G[n];	
    }
}
//��ѧ
class Solution1 {
    public int numTrees(int n) {
        // ��ʾ��������������Ҫ�� long ���ͷ�ֹ��������е����
        long C = 1;
        for (int i = 0; i < n; ++i) {
            C = C * 2 * (2 * i + 1) / (i + 2);
        }
        return (int) C;
    }
}
