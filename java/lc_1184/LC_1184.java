package lc_1184;

import java.util.Arrays;

/*
 *@author: �ƺ�
 *@date : 2021��12��12��
 *@todo:1184. ����վ��ľ���
���ι���·������ n ��վ��������� 0 �� n - 1 ���б�š�������֪ÿһ�����ڹ���վ֮��ľ��룬distance[i] ��ʾ���Ϊ i �ĳ�վ�ͱ��Ϊ (i + 1) % n �ĳ�վ֮��ľ��롣

�����ϵĹ����������԰�˳ʱ�����ʱ��ķ�����ʻ��

���س˿ʹӳ����� start ��Ŀ�ĵ� destination ֮�����̾��롣
*/
public class LC_1184 {

}
class Solution {
    public int distanceBetweenBusStops(int[] distance, int start, int destination) {
        int dis = 0;
        int sum = Arrays.stream(distance).sum();
        for (int i = Math.min(start, destination); i < Math.max(start, destination); i++){
            dis += distance[i];
        }
        return Math.min(sum - dis, dis);
    }
}