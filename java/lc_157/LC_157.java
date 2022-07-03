package lc_157;

/**
 * @author �ƺ�
 *162. Ѱ�ҷ�ֵ
��ֵԪ����ָ��ֵ������������ֵ��Ԫ�ء�

����һ���������� nums���ҵ���ֵԪ�ز�������������������ܰ��������ֵ������������£����� �κ�һ����ֵ ����λ�ü��ɡ�

����Լ��� nums[-1] = nums[n] = -�� ��
 */
public class LC_157 {

}
//���Բ���
class Solution {
    public int findPeakElement(int[] nums) {
        for (int i = 0; i <nums.length - 1; i++){
            if (nums[i] > nums[i + 1 ]) return i;
        }
        return nums.length - 1;
    }
}
//���ֲ���
class Solution1{
	public int findPeakElement(int[] nums) {
		int l = 0, r= nums.length;
		while (l < r) {
			int mid= (l + r) >> 1;
			if (nums[mid] > nums[mid + 1]) {
				r = mid;
			}else {
				l = mid + 1;
			}
		}
		return l;
	}
}