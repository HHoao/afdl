package lc_446;

import java.util.HashMap;
import java.util.Map;

/*
 *@author: �ƺ�
 *@date : 2021��12��2��
 *@todo:446. �Ȳ����л��� II - ������
����һ���������� nums ������ nums ������ �Ȳ������� ����Ŀ��

���һ�������� ����������Ԫ�� ������������������Ԫ��֮����ͬ����Ƹ�����Ϊ�Ȳ����С�

���磬[1, 3, 5, 7, 9]��[7, 7, 7, 7] �� [3, -1, -5, -9] ���ǵȲ����С�
�����磬[1, 1, 2, 5, 7] ���ǵȲ����С�
�����е��������Ǵ�������ɾ��һЩԪ�أ�Ҳ���ܲ�ɾ�����õ���һ�����С�

���磬[2,5,10] �� [1,2,1,2,4,1,5,10] ��һ�������С�
��Ŀ���ݱ�֤����һ�� 32-bit ������
*/
public class LC_446 {

}
//��̬�滮+��ϣ��
class Solution{
	public int numberOfArithmeticSlices(int[] nums) {
		int n = nums.length;
		int ans = 0;
		Map<Long, Integer>[] f = new Map[n];
		for (int i = 0; i < n; i++) {
			f[i] = new HashMap<>();
		}
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < i; j++) {
				Long d = 1L * nums[i] - nums[j];
				int cnt = f[j].getOrDefault(d, 0);
				ans += cnt;
				f[i].put(d, f[i].getOrDefault(d, 0) + cnt + 1);
			}
		}
		return ans;
	}
}
