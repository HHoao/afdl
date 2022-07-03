package lc_539;

import java.util.Arrays;
import java.util.List;

/*
 *@author: �ƺ�
 *@date : 2022��1��18��
 *@todo:539. ��Сʱ���
����һ�� 24 Сʱ�ƣ�Сʱ:���� "HH:MM"����ʱ���б��ҳ��б�����������ʱ�����Сʱ���Է�������ʾ��

 

ʾ�� 1��

���룺timePoints = ["23:59","00:00"]
�����1
ʾ�� 2��

���룺timePoints = ["00:00","23:59","00:00"]
�����0
*/
public class LC_539 {

}
class Solution {
    public int findMinDifference(List<String> timePoints) {
        int n = timePoints.size();
        int[] f = new int[2 * n];
        for (int i = 0; i < n; i++){
            String[] tis = timePoints.get(i).split(":");
            f[i] = Integer.valueOf(tis[0]) * 60 + Integer.valueOf(tis[1]);
            f[n + i] = 24 * 60 + f[i];
        }
        Arrays.sort(f);
        int ans = 2147483647;
        for (int i = 1; i < 2 * n; i++){
            ans = Math.min(ans, f[i] - f[i - 1]);
        }
        return ans;
    }
}