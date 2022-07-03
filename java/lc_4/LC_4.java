package lc_4;

import java.util.*;

public class LC_4{
	public static void main(String[] args){
		Scanner s = new Scanner(System.in);
		
		Set<Integer> s1 = new HashSet<Integer>();
		Set<Integer> s2= new HashSet<Integer>();

		System.out.printf("����s1��������(��������ֹ):");
		while(s.hasNextInt()){
			int a = s.nextInt();
			s1.add(a);
		}

		System.out.printf("����s2��������(��������ֹ):");
		Scanner k = new Scanner(System.in);
		while(k.hasNextInt()){
			int a = k.nextInt();
			s2.add(a);
		}
		k.close();
		s.close();

		Iterator<Integer> it1= s1.iterator();
		Iterator<Integer> it2 = s2.iterator();
		
		int[] i1 = new int[s1.size()];
		int[] i2 = new int[s2.size()];
		int len = 0;
		while(it1.hasNext()){
			i1[len] = it1.next();
			len++;
		}
		len = 0;
		while(it2.hasNext()){
			i2[len] = it2.next();
			len++;
		}
		Arrays.sort(i1);
		Arrays.sort(i2);
	
		for(len = 0; len < i1.length;len++) {
			System.out.printf("%d  ",i1[len] );
		}
		for(len = 0; len < i2.length;len++) {
			System.out.printf("%d  ",i2[len] );
		}
		System.out.println(Solution.findMedianSortedArrays(i1, i2));
	}
}

class Solution {
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int length1 = nums1.length, length2 = nums2.length;
        int totalLength = length1 + length2;
        if (totalLength % 2 == 1) {
            int midIndex = totalLength / 2;
            double median = getKthElement(nums1, nums2, midIndex + 1);
            return median;
        } else {
            int midIndex1 = totalLength / 2 - 1, midIndex2 = totalLength / 2;
            double median = (getKthElement(nums1, nums2, midIndex1 + 1) + getKthElement(nums1, nums2, midIndex2 + 1)) / 2.0;
            return median;
        }
    }

	public static int getKthElement(int[] nums1, int[] nums2, int k) {
        /* ��Ҫ˼·��Ҫ�ҵ��� k (k>1) С��Ԫ�أ���ô��ȡ pivot1 = nums1[k/2-1] �� pivot2 = nums2[k/2-1] ���бȽ�
         * ����� "/" ��ʾ����
         * nums1 ��С�ڵ��� pivot1 ��Ԫ���� nums1[0 .. k/2-2] ���� k/2-1 ��
         * nums2 ��С�ڵ��� pivot2 ��Ԫ���� nums2[0 .. k/2-2] ���� k/2-1 ��
         * ȡ pivot = min(pivot1, pivot2)������������С�ڵ��� pivot ��Ԫ�ع��Ʋ��ᳬ�� (k/2-1) + (k/2-1) <= k-2 ��
         * ���� pivot �������Ҳֻ���ǵ� k-1 С��Ԫ��
         * ��� pivot = pivot1����ô nums1[0 .. k/2-1] ���������ǵ� k С��Ԫ�ء�����ЩԪ��ȫ�� "ɾ��"��ʣ�µ���Ϊ�µ� nums1 ����
         * ��� pivot = pivot2����ô nums2[0 .. k/2-1] ���������ǵ� k С��Ԫ�ء�����ЩԪ��ȫ�� "ɾ��"��ʣ�µ���Ϊ�µ� nums2 ����
         * �������� "ɾ��" ��һЩԪ�أ���ЩԪ�ض��ȵ� k С��Ԫ��ҪС���������Ҫ�޸� k ��ֵ����ȥɾ�������ĸ���
         */

        int length1 = nums1.length, length2 = nums2.length;
        int index1 = 0, index2 = 0;

        while (true) {
            // �߽����
            if (index1 == length1) {
                return nums2[index2 + k - 1];
            }
            if (index2 == length2) {
                return nums1[index1 + k - 1];
            }
            if (k == 1) {
                return Math.min(nums1[index1], nums2[index2]);
            }
            
            // �������
            int half = k / 2;
            int newIndex1 = Math.min(index1 + half, length1) - 1;
            int newIndex2 = Math.min(index2 + half, length2) - 1;
            int pivot1 = nums1[newIndex1], pivot2 = nums2[newIndex2];
            if (pivot1 <= pivot2) {
                k -= (newIndex1 - index1 + 1);
                index1 = newIndex1 + 1;
            } else {
                k -= (newIndex2 - index2 + 1);
                index2 = newIndex2 + 1;
            }
        }
    }
}