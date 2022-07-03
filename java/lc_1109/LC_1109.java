package lc_1109;

/*
 *@author: �ƺ�
 *@date : 2022��1��9��
 *@todo:1109. ����Ԥ��ͳ��
������ n �����࣬���Ƿֱ�� 1 �� n ���б�š�

��һ�ݺ���Ԥ���� bookings �����е� i ��Ԥ����¼ bookings[i] = [firsti, lasti, seatsi] ��ζ���ڴ� firsti �� lasti ������ firsti �� lasti ���� ÿ������ ��Ԥ���� seatsi ����λ��

���㷵��һ������Ϊ n ������ answer�������Ԫ����ÿ������Ԥ������λ������

 

ʾ�� 1��

���룺bookings = [[1,2,10],[2,3,20],[2,5,25]], n = 5
�����[10,55,45,25,25]
���ͣ�
������        1   2   3   4   5
Ԥ����¼ 1 ��   10  10
Ԥ����¼ 2 ��       20  20
Ԥ����¼ 3 ��       25  25  25  25
����λ����      10  55  45  25  25
��ˣ�answer = [10,55,45,25,25]
ʾ�� 2��

���룺bookings = [[1,2,10],[2,2,15]], n = 2
�����[10,25]
���ͣ�
������        1   2
Ԥ����¼ 1 ��   10  10
Ԥ����¼ 2 ��       15
����λ����      10  25
��ˣ�answer = [10,25]
*/
public class LC_1109 {

}
//�ҵ����+����(1492ms)
class Solution {
    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] ans = new int[n];
        int k = bookings.length;
        for (int i = 0; i < k; i++){
            for (int j = bookings[i][0]; j <= bookings[i][1]; j++){
                ans[j - 1] += bookings[i][2];
            }
        }
        return ans;
    }
}
//�ҵ����+�������(2ms)
class Solution1 {
    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] ans = new int[n];
        int k = bookings.length;
        for (int i = 0; i < k; i++){
            ans[bookings[i][0] - 1] += bookings[i][2];
            if (bookings[i][1] < n)
                ans[bookings[i][1]] -= bookings[i][2];
        }
        for (int i = 1; i < n; i++){
            ans[i] += ans[i - 1];
        }
        return ans;
    }
}