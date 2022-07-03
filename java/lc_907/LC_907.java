package lc_907;

import java.util.ArrayDeque;
import java.util.Deque;

/*
 *@author: �ƺ�
 *@date : 2022��1��25��
 *@todo:907. ���������Сֵ֮��
����һ���������� arr���ҵ� min(b) ���ܺͣ����� b �ķ�ΧΪ arr ��ÿ���������������顣

���ڴ𰸿��ܴܺ���� ���ش�ģ 10^9 + 7 ��

 

ʾ�� 1��

���룺arr = [3,1,2,4]
�����17
���ͣ�
������Ϊ [3]��[1]��[2]��[4]��[3,1]��[1,2]��[2,4]��[3,1,2]��[1,2,4]��[3,1,2,4]�� 
��СֵΪ 3��1��2��4��1��1��2��1��1��1����Ϊ 17��
ʾ�� 2��

���룺arr = [11,81,94,43,3]
�����444
*/
public class LC_907 {
	public static void main(String[] args) {
		System.out.println(new Solution1().sumSubarrayMins(new int[] {3, 1, 2, 4}));
	}
}
//������ʱ
class Solution {
    public int sumSubarrayMins(int[] arr) {
        int n = arr.length;
        long ans = 0;
        for (int i = 1; i <= n; i++){
            for (int j = 0; j <= n - i; j++){
                int min = Integer.MAX_VALUE;
                for (int k = j; k < j + i; k++){	
                    min = Math.min(min, arr[k]);
                }
                ans += min;
                ans %= (1e+9 + 7);
            }
        }
        return (int)ans;
    }
}
//����ջ
class Solution1 {
	static final long MOD = 1000000000 + 7;
    public int sumSubarrayMins(int[] arr) {
        int n = arr.length;
        Deque<Integer> stack = new ArrayDeque<>();
        long ans = 0;
        int[] arr1 = new int[n + 2];
        arr1[0] = -1;
        arr1[n+1] = -1;
        System.arraycopy(arr, 0, arr1, 1, n);
        arr = arr1;
        for (int i = 0; i < n+2; i++){
            while (!stack.isEmpty() && arr[i] < arr[stack.peek()]){
                int curMinIndex = stack.pop();
                ans = (ans + (long)(arr[curMinIndex] * (i - curMinIndex)) * (curMinIndex - (stack.isEmpty() ? -1 : stack.peek()))) % MOD;
            }
            stack.push(i);
        }
        return (int)ans;
    }
}