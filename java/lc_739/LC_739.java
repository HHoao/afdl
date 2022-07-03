package lc_739;

import java.util.ArrayDeque;
import java.util.Deque;

/*
 *@author: �ƺ�
 *@date : 2022��1��23��
 *@todo:739. ÿ���¶�
�����ÿ�� ���� �б� temperatures ���������ÿһ����Ҫ�ȼ���Ż��и��ߵ��¶ȡ������������֮�󶼲������ߣ����ڸ�λ���� 0 �����档

ʾ�� 1:

����: temperatures = [73,74,75,71,69,72,76,73]
���: [1,1,4,2,1,1,0,0]
ʾ�� 2:

����: temperatures = [30,40,50,60]
���: [1,1,1,0]
ʾ�� 3:

����: temperatures = [30,60,90]
���: [1,1,0]
*/
public class LC_739 {

}
//����ջ
class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        Deque<Integer> monoStack = new ArrayDeque<>();
        int[] ans = new int[n];
        for (int i = 0; i < n; i++){
            while (!monoStack.isEmpty() && temperatures[i] > temperatures[monoStack.peek()]){
                int popIndex = monoStack.pop();
                ans[popIndex] = i - popIndex;
            }
            monoStack.push(i);
        }
        return ans;
    }
}