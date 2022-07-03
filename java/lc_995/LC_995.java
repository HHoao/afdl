package lc_995;

/*
 *@author: �ƺ�
 *@date : 2022��1��2��
 *@todo:995. K ����λ����С��ת����
�ڽ����� 0 �� 1 ������ A �У�һ�� K λ��ת����ѡ��һ������Ϊ K �ģ������������飬ͬʱ���������е�ÿ�� 0 ����Ϊ 1����ÿ�� 1 ����Ϊ 0��

��������� K λ��ת����С�������Ա�����û��ֵΪ 0 ��Ԫ�ء���������ܣ����� -1��

 

ʾ�� 1��

���룺A = [0,1,0], K = 1
�����2
���ͣ��ȷ�ת A[0]��Ȼ��ת A[2]��
ʾ�� 2��

���룺A = [1,1,0], K = 2
�����-1
���ͣ���������������ת��СΪ 2 �������飬���Ƕ�����ʹ�����Ϊ [1,1,1]��
*/
public class LC_995 {
	public static void main(String[] args) {
		new Solution().minKBitFlips(new int[] {0,0,0,1,0,1,1,0},3);
	}
}
//�������
class Solution {
    public int minKBitFlips(int[] nums, int k) {
        int n = nums.length;
        int[] diff = new int[n + 1];
        int ans = 0, revCnt = 0;
        for (int i = 0; i < n; ++i) {
        	revCnt += diff[i];
            if ((nums[i] + revCnt) % 2 == 0) {
                if (i + k > n) {
                    return -1;
                }
                ++ans;
                ++revCnt;
                --diff[i + k];
            }
        }
        return ans;
    }
}
//��������
class Solution1 {
    public int minKBitFlips(int[] nums, int k) {
        int n = nums.length;
        int ans = 0, revCnt = 0;
        for (int i = 0; i < n; ++i) {
            if (i >= k && nums[i - k] > 1) {
                revCnt ^= 1;
                nums[i - k] -= 2; // ��ԭ����Ԫ�أ��������޸����� nums�������ʡ��
            }
            if (nums[i] == revCnt) {
                if (i + k > n) {
                    return -1;
                }
                ++ans;
                revCnt ^= 1;
                nums[i] += 2;
            }
        }
        return ans;
    }
}