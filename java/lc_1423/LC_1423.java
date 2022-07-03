package lc_1423;

import java.util.Arrays;

/*
 *@author: �ƺ�
 *@date : 2022��1��18��
 *@todo:1423. �ɻ�õ�������
���ſ��� �ų�һ�У�ÿ�ſ��ƶ���һ����Ӧ�ĵ������������������� cardPoints ������

ÿ���ж�������Դ��еĿ�ͷ����ĩβ��һ�ſ��ƣ���������������� k �ſ��ơ�

��ĵ����������õ����е����п��Ƶĵ���֮�͡�

����һ���������� cardPoints ������ k�����㷵�ؿ��Ի�õ���������

 

ʾ�� 1��

���룺cardPoints = [1,2,3,4,5,6,1], k = 3
�����12
���ͣ���һ���ж��������������ƣ���ĵ������� 1 �����ǣ��������ұߵĿ��ƽ��������Ŀɻ�õ��������Ų��������ұߵ������ƣ����յ���Ϊ 1 + 6 + 5 = 12 ��
ʾ�� 2��

���룺cardPoints = [2,2,2], k = 2
�����4
���ͣ����������������ſ��ƣ��ɻ�õĵ������� 4 ��
*/
public class LC_1423 {

}
//ǰ׺��
class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int n = cardPoints.length;
        int ans = 0;
        int[] pre = new int[n + 1];
        for (int i = 1; i <= n; i++){
            pre[i] = pre[i - 1] + cardPoints[i - 1];
        }
        for (int i = 0; i <= k; i++){
            ans = Math.max(ans, pre[i] + pre[n] - pre[n  - (k - i)]);
        }
        return ans;
    }
}
//����������
class Solution1 {
    public int maxScore(int[] cardPoints, int k) {
        int n = cardPoints.length;
        // �������ڴ�СΪ n-k
        int windowSize = n - k;
        // ѡǰ n-k ����Ϊ��ʼֵ
        int sum = 0;
        for (int i = 0; i < windowSize; ++i) {
            sum += cardPoints[i];
        }
        int minSum = sum;
        for (int i = windowSize; i < n; ++i) {
            // ��������ÿ�����ƶ�һ�����Ӵ��Ҳ���봰�ڵ�Ԫ��ֵ�������ٴ�����뿪���ڵ�Ԫ��ֵ
            sum += cardPoints[i] - cardPoints[i - windowSize];
            minSum = Math.min(minSum, sum);
        }
        return Arrays.stream(cardPoints).sum() - minSum;
    }
}
