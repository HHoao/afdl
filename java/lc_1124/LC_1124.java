package lc_1124;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

/*
 *@author: �ƺ�
 *@date : 2022��1��12��
 *@todo:1124. �������õ��ʱ���
����һ�ݹ���ʱ��� hours�������¼��ĳһλԱ��ÿ��Ĺ���Сʱ����

������Ϊ��Ա��һ���еĹ���Сʱ������ 8 Сʱ��ʱ����ô��һ����ǡ����۵�һ�졹��

��ν���������õ�ʱ��Ρ�����ζ�����ʱ���ڣ������۵����������ϸ� ���ڡ������۵���������

���㷵�ء���������ʱ��Ρ�����󳤶ȡ�

 

ʾ�� 1��

���룺hours = [9,9,6,0,6,6,9]
�����3
���ͣ���ı�������ʱ����� [9,9,6]��
ʾ�� 2��

���룺hours = [6,6,6]
�����0
*/
public class LC_1124 {
	public static void main(String[] args) {
		System.out.println(new Solution().longestWPI(new int[] {8,7,7,8,6,11,12}));
	} 
}
//�ҵ����+ǰ׺��
class Solution {
    public int longestWPI(int[] hours) {
        int n = hours.length;
        Map<Integer, Integer> map = new HashMap<>();
        Map<Integer, Integer> map1  = new HashMap<>();
        int[] preSum = new int[n];
        preSum[0] = hours[0] > 8 ? 1 : -1; 
        for (int i = 1; i < n; i++) {
        	preSum[i] += preSum[i - 1] + (hours[i] > 8 ? 1 : -1);
        }
        int ans = 0;
        for (int i = 0; i < n; i++){
            if (hours[i] > 8){
                ans = Math.max(ans, Math.max(i - map.getOrDefault(preSum[i], i) + 1, 
                i - map1.getOrDefault(preSum[i], i) - 1));
                if (!map.containsKey(preSum[i]))
                    map.put(preSum[i], i);
            }else{
                if (i < n - 1 && preSum[i] > preSum[i + 1]){
                    if (!map1.containsKey(preSum[i]))
                        map1.put(preSum[i], i);
                }
            }
            if (preSum[i] > 0){
                ans = i + 1;
            }
        }
        return ans;
    }
}
//����ջ
class Solution1 {
    public int longestWPI(int[] hours) {
        int n = hours.length;
        int[] preSum = new int[n+1];
        int ans = 0;
        for (int i = 0; i < n; i++){
            preSum[i + 1] = preSum[i] + (hours[i] > 8 ? 1 : -1);
        }
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(0);
        for (int i = 0; i <= n; i++){
            if (preSum[stack.peek()] > preSum[i]){
                stack.push(i);
            }
        }
        int k = n;
        while (k > ans){
            while (!stack.isEmpty() && preSum[k] > preSum[stack.peek()]){
                ans = Math.max(ans, k - stack.pop());
            }
            k--;
        }
        return ans;
    }
}