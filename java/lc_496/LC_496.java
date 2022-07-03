package lc_496;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

/*
 *@author: �ƺ�
 *@date : 2022��1��22��
 *@todo:496. ��һ������Ԫ�� I
nums1 ������ x �� ��һ������Ԫ�� ��ָ x �� nums2 �ж�Ӧλ�� �Ҳ� �� ��һ�� �� x ���Ԫ�ء�

�������� û���ظ�Ԫ�� ������ nums1 �� nums2 ���±�� 0 ��ʼ����������nums1 �� nums2 ���Ӽ���

����ÿ�� 0 <= i < nums1.length ���ҳ����� nums1[i] == nums2[j] ���±� j �������� nums2 ȷ�� nums2[j] �� ��һ������Ԫ�� �������������һ������Ԫ�أ���ô���β�ѯ�Ĵ��� -1 ��

����һ������Ϊ nums1.length ������ ans ��Ϊ�𰸣����� ans[i] ������������ ��һ������Ԫ�� ��

 

ʾ�� 1��

���룺nums1 = [4,1,2], nums2 = [1,3,4,2].
�����[-1,3,-1]
���ͣ�nums1 ��ÿ��ֵ����һ������Ԫ������������
- 4 ���üӴ�б���ʶ��nums2 = [1,3,4,2]����������һ������Ԫ�أ����Դ��� -1 ��
- 1 ���üӴ�б���ʶ��nums2 = [1,3,4,2]����һ������Ԫ���� 3 ��
- 2 ���üӴ�б���ʶ��nums2 = [1,3,4,2]����������һ������Ԫ�أ����Դ��� -1 ��
ʾ�� 2��

���룺nums1 = [2,4], nums2 = [1,2,3,4].
�����[3,-1]
���ͣ�nums1 ��ÿ��ֵ����һ������Ԫ������������
- 2 ���üӴ�б���ʶ��nums2 = [1,2,3,4]����һ������Ԫ���� 3 ��
- 4 ���üӴ�б���ʶ��nums2 = [1,2,3,4]����������һ������Ԫ�أ����Դ��� -1 ��
*/
public class LC_496 {

}
//����ջ+Ͱ
class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int n = nums1.length, m = nums2.length;
        Deque<Integer> deque = new ArrayDeque<>();
        deque.offer(nums2[0]);
        int[] f = new int[10001];
        for (int i = 1; i < m; i++){
            while (!deque.isEmpty() && nums2[i] > deque.peek()){
                f[deque.pop()] = nums2[i];
            }
            deque.push(nums2[i]);
        }
        int[] ans = new int[n];
        for (int i = 0; i < n; i++){
            ans[i] = f[nums1[i]] != 0 ? f[nums1[i]] : -1;
        }
        return ans;
    }
}

//����ջ+��ϣ��
class Solution1 {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int n = nums1.length, m = nums2.length;
        Deque<Integer> deque = new ArrayDeque<>();
        deque.offer(nums2[0]);
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 1; i < m; i++){
            while (!deque.isEmpty() && nums2[i] > deque.peek()){
                map.put(deque.pop(), nums2[i]);
            }
            deque.push(nums2[i]);
        }
        int[] ans = new int[n];
        for (int i = 0; i < n; i++){
            Integer nextEle = map.get(nums1[i]);
            ans[i] = nextEle != null ? nextEle : -1;
        }
        return ans;
    }
}