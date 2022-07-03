package lc_41;



/**
 * @author �ƺ�
 *41. ȱʧ�ĵ�һ������
����һ��δ������������飬�����ҳ�����û�г��ֵ���С����������

 

ʾ�� 1:

����: [1,2,0]
���: 3
ʾ�� 2:

����: [3,4,-1,1]
���: 2
ʾ�� 3:

����: [7,8,9,11,12]
���: 1
 

��ʾ��

����㷨��ʱ�临�Ӷ�ӦΪO(n)������ֻ��ʹ�ó�������Ķ���ռ䡣
 */
public class LC_41 {

}
//ԭ�ع�ϣ
class Solution {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; ++i) {
            if (nums[i] <= 0) {
                nums[i] = n + 1;
            }
        }
        for (int i = 0; i < n; ++i) {
            int num = Math.abs(nums[i]);
            if (num <= n) {
                nums[num - 1] = -Math.abs(nums[num - 1]);
            }
        }
        for (int i = 0; i < n; ++i) {
            if (nums[i] > 0) {
                return i + 1;
            }
        }
        return n + 1;
    }
}
