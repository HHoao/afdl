package lc_134;

/**
 * @author �ƺ�
 *134. ����վ
��һ����·���� N ������վ�����е� i ������վ������ gas[i] ����

����һ�������������޵ĵ��������ӵ� i ������վ������ i+1 ������վ��Ҫ�������� cost[i] ����������е�һ������վ��������ʼʱ����Ϊ�ա�

���������ƻ�·��ʻһ�ܣ��򷵻س���ʱ����վ�ı�ţ����򷵻� -1��

˵��: 

�����Ŀ�н⣬�ô𰸼�ΪΨһ�𰸡�
���������Ϊ�ǿ����飬�ҳ�����ͬ��
���������е�Ԫ�ؾ�Ϊ�Ǹ�����
 */
public class LC_134 {

}	
class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        int i = 0;
        while (i < n) {
            int sumOfGas = 0, sumOfCost = 0;
            int cnt = 0;
            while (cnt < n) {
                int j = (i + cnt) % n;
                sumOfGas += gas[j];
                sumOfCost += cost[j];
                if (sumOfCost > sumOfGas) {
                    break;
                }
                cnt++;
            }
            if (cnt == n) {
                return i;
            } else {
                i = i + cnt + 1;
            }
        }
        return -1;
    }
}