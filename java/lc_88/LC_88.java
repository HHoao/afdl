package lc_88;

/**
 * @author �ƺ� 88. �ϲ������������� �������������������� nums1 �� nums2�����㽫 nums2 �ϲ��� nums1 �У�ʹ
 *         nums1 ��Ϊһ���������顣
 * 
 *         ��ʼ�� nums1 �� nums2 ��Ԫ�������ֱ�Ϊ m �� n ������Լ��� nums1 �Ŀռ��С���� m +
 *         n�������������㹻�Ŀռ䱣������ nums2 ��Ԫ�ء�
 */
public class LC_88 {

}

//˫ָ��//��ǰ����
class Solution {
	public void merge(int[] nums1, int m, int[] nums2, int n) {
		// Make a copy of nums1.
		int[] nums1_copy = new int[m];
		System.arraycopy(nums1, 0, nums1_copy, 0, m);

		// Two get pointers for nums1_copy and nums2.
		int p1 = 0;
		int p2 = 0;

		// Set pointer for nums1
		int p = 0;

		// Compare elements from nums1_copy and nums2
		// and add the smallest one into nums1.
		while ((p1 < m) && (p2 < n))
			nums1[p++] = (nums1_copy[p1] < nums2[p2]) ? nums1_copy[p1++] : nums2[p2++];

		// if there are still elements to add
		if (p1 < m)
			System.arraycopy(nums1_copy, p1, nums1, p1 + p2, m + n - p1 - p2);
		if (p2 < n)
			System.arraycopy(nums2, p2, nums1, p1 + p2, m + n - p1 - p2);
	}
}

//����2 : ˫ָ�� / �Ӻ���ǰ
class Solution2 {
	public void merge(int[] nums1, int m, int[] nums2, int n) {
		int p1 = m - 1;
		int p2 = n - 1;
		int p = m + n - 1;
		while ((p1 >= 0) && (p2 >= 0))
			nums1[p--] = (nums1[p1] < nums2[p2]) ? nums2[p2--] : nums1[p1--];
		System.arraycopy(nums2, 0, nums1, 0, p2 + 1);
	}
}
