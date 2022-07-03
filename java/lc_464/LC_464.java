package lc_464;

/*
 *@author: �ƺ�
 *@date : 2021��11��12��
 *@todo:464. ����Ӯ��
�� "100 game" �����Ϸ�У������������ѡ��� 1 �� 10 �������������ۼ������ͣ���ʹ���ۼ������ʹﵽ�򳬹� 100 ����ң���Ϊʤ�ߡ�

������ǽ���Ϸ�����Ϊ ����Ҳ����ظ�ʹ�������� �أ�

���磬������ҿ��������ӹ����������г�ȡ�� 1 �� 15 �����������Żأ���ֱ���ۼ������� >= 100��

����һ������ maxChoosableInteger ���������п�ѡ��������������һ������ desiredTotal���ۼƺͣ����ж��ȳ��ֵ�����Ƿ�����Ӯ��������λ�����Ϸʱ��������ѣ���

����Լ��� maxChoosableInteger ������� 20�� desiredTotal ������� 300��
*/
public class LC_464 {

}
//���仯����(��̬�滮)
class Solution {
    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        if(maxChoosableInteger >= desiredTotal) return true;
        if((1 + maxChoosableInteger) * maxChoosableInteger / 2 < desiredTotal) return false;
        return dfs(maxChoosableInteger, 0, desiredTotal, new Boolean[1 << maxChoosableInteger]);
    }
    public boolean dfs(int maxChoosableInteger, int n, int desiredTotal, Boolean[] dp){
        if (dp[n] != null) return dp[n];
        for (int i = 0; i < maxChoosableInteger; i++){
            if ((n & 1 << i) != 0) continue;
            if (i + 1 >= desiredTotal || !dfs(maxChoosableInteger, n | 1 << i, desiredTotal - i - 1, dp)){
                return dp[n] = true;
            }
        }
        return dp[n] = false;
    }
}