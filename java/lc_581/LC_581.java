package lc_581;

import java.util.ArrayDeque;
import java.util.Deque;

/*
 *@author: �ƺ�
 *@date : 2022��1��22��
 *@todo:581. �����������������
����һ���������� nums ������Ҫ�ҳ�һ�� ���������� �����������������������������ô�������鶼���Ϊ��������

�����ҳ���������� ��� �����飬��������ĳ��ȡ�

 

ʾ�� 1��

���룺nums = [2,6,4,8,10,9,15]
�����5
���ͣ���ֻ��Ҫ�� [6, 4, 8, 10, 9] ��������������ô���������Ϊ��������
ʾ�� 2��

���룺nums = [1,2,3,4]
�����0
ʾ�� 3��

���룺nums = [1]
�����0
*/
public class LC_581 {

}
//����ջ
class Solution {
    public int findUnsortedSubarray(int[] nums) {
        int n = nums.length;
        Deque<Integer> deque = new ArrayDeque<>();
        int minIndex = Integer.MAX_VALUE, maxIndex = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++){
            while(!deque.isEmpty() && nums[i] < nums[deque.peek()]){
                int ind = deque.pop();
                minIndex = Math.min(minIndex, ind);
                maxIndex = Math.max(maxIndex, ind);
            }
            deque.push(i);
        }
        deque.clear();
        for (int i = n - 1; i >= 0; i--){
            while(!deque.isEmpty() && nums[i] > nums[deque.peek()]){
                int ind = deque.pop();
                minIndex = Math.min(minIndex, ind);
                maxIndex = Math.max(maxIndex, ind);
            }
            deque.push(i);
        }
        if (minIndex == Integer.MAX_VALUE) return 0;
        return maxIndex - minIndex + 1;
    }
}
//һ�α���
class Solution1 {
    public int findUnsortedSubarray(int[] nums) {
        int n = nums.length;
        int maxn = Integer.MIN_VALUE, right = -1;
        int minn = Integer.MAX_VALUE, left = -1;
        for (int i = 0; i < n; i++) {
            if (maxn > nums[i]) {
                right = i;
            } else {
                maxn = nums[i];
            }
            if (minn < nums[n - i - 1]) {
                left = n - i - 1;
            } else {
                minn = nums[n - i - 1];
            }
        }
        return right == -1 ? 0 : right - left + 1;
    }
}