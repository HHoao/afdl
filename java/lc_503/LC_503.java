package lc_503;

import java.util.ArrayDeque;
import java.util.Deque;

/*
 *@author: �ƺ�
 *@date : 2021��10��28��
 *@todo:503. ��һ������Ԫ�� II
����һ��ѭ�����飨���һ��Ԫ�ص���һ��Ԫ��������ĵ�һ��Ԫ�أ������ÿ��Ԫ�ص���һ������Ԫ�ء����� x ����һ�������Ԫ���ǰ��������˳���������֮��ĵ�һ�������������������ζ����Ӧ��ѭ��������������һ�������������������ڣ������ -1��
*/
public class LC_503 {

}

//����ջ
class Solution {
    public int[] nextGreaterElements(int[] nums) {
        Deque<Integer> stack = new ArrayDeque<>();
        int n = nums.length;
        int[] ans = new int[n];
        for (int i = 0; i < n; i++){
            if (stack.isEmpty() || nums[i] <= nums[stack.peek()]){
                stack.push(i);
            }else{
                ans[stack.pop()] = nums[i];
                while(!stack.isEmpty() && nums[i] > nums[stack.peek()]){
                    ans[stack.pop()] = nums[i];
                }
                stack.push(i);
            }
        }
        for (int i = 0; i < n; i++){
            if (nums[i] > nums[stack.peek()]){
                ans[stack.pop()] = nums[i];
                
                while(stack.size() != 1 && nums[i] > nums[stack.peek()]){
                    ans[stack.pop()] = nums[i];
                }
            }
        }
        while(!stack.isEmpty()){
            ans[stack.pop()] = -1;
        }
        return ans;
    }
}