package lc_517;

import java.util.Arrays;

/*
 *@author: �ƺ�
 *@date : 2021��9��29��
 *@todo:517. ����ϴ�»�
������ n ̨����ϴ�»�����ͬһ���ϡ���ʼ��ʱ��ÿ̨ϴ�»��ڿ�����һ�������·���Ҳ�����ǿյġ�

��ÿһ�������У������ѡ������ m (1 <= m <= n) ̨ϴ�»������ͬʱ��ÿ̨ϴ�»���һ���·��͵����ڵ�һ̨ϴ�»���

����һ���������� machines �����������ÿ̨ϴ�»��е������������������������ϴ�»���ʣ�µ������������ȵ� ���ٵĲ������� ���������ʹÿ̨ϴ�»��������������ȣ��򷵻� -1 ��
*/
public class LC_517 {

}
class Solution {
    public int findMinMoves(int[] machines) {
        int tot = Arrays.stream(machines).sum();
        int n = machines.length;
        if (tot % n != 0) {
            return -1;
        }
        int avg = tot / n;
        int ans = 0, sum = 0;
        for (int num : machines) {
            num -= avg;
            sum += num;
            ans = Math.max(ans, Math.max(Math.abs(sum), num));
        }
        return ans;
    }
}
