package lc_1217;

/*
 *@author: �ƺ�
 *@date : 2021��12��3��
 *@todo:1217. �����
�����Ϸ�����һЩ���룬ÿ�������λ�ô������� chips ���С�

����Զ� �κγ��� ִ���������ֲ���֮һ�����޲���������0 ��Ҳ���ԣ���

���� i ����������������ƶ� 2 ����λ������Ϊ 0��
���� i ����������������ƶ� 1 ����λ������Ϊ 1��
�ʼ��ʱ��ͬһλ����Ҳ���ܷ����������߸���ĳ��롣

���ؽ����г����ƶ���ͬһλ�ã�����λ�ã�������Ҫ����С���ۡ�
*/
public class LC_1217 {

}

class Solution {
    public int minCostToMoveChips(int[] position) {
        int  n = position.length;
        int singular = 0, even = 0;
        for (int i = 0; i < n; i++){
            if (position[i] % 2 == 1){
                singular++;
            }else{
                even++;
            }
        }
        return Math.min(singular, even);
    }
}