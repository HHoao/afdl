package lc_1534;

/*
 *@author: �ƺ�
 *@date : 2021��12��2��
 *@todo:1534. ͳ�ƺ���Ԫ��
����һ���������� arr ���Լ� a��b ��c ��������������ͳ�����к���Ԫ���������

�����Ԫ�� (arr[i], arr[j], arr[k]) ��������ȫ������������Ϊ����һ�� ����Ԫ�� ��

0 <= i < j < k < arr.length
|arr[i] - arr[j]| <= a
|arr[j] - arr[k]| <= b
|arr[i] - arr[k]| <= c
���� |x| ��ʾ x �ľ���ֵ��

���� ����Ԫ������� ��

 
*/
public class LC_1534 {

}
//����
class Solution {
    public int countGoodTriplets(int[] arr, int a, int b, int c) {
        int n = arr.length;
        int ans = 0;
        for (int i = 0; i < n - 2; i++){
            for (int j = i + 1; j < n - 1; j++){
                if (!(Math.abs(arr[i] - arr[j]) <= a)) continue;
                for (int k = j + 1;k < n; k++){
                    if (Math.abs(arr[j] - arr[k]) <= b && Math.abs(arr[i] - arr[k]) <= c) ans++;
                }
            }
        }
        return ans;
    }
}
