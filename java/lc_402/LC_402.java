package lc_402;

import java.util.ArrayDeque;
import java.util.Deque;

/*
 *@author: �ƺ�
 *@date : 2022��1��21��
 *@todo:402. �Ƶ� K λ����
����һ�����ַ�����ʾ�ķǸ����� num ��һ������ k ���Ƴ�������е� k λ���֣�ʹ��ʣ�µ�������С���������ַ�����ʽ���������С�����֡�

 
ʾ�� 1 ��

���룺num = "1432219", k = 3
�����"1219"
���ͣ��Ƴ����������� 4, 3, �� 2 �γ�һ���µ���С������ 1219 ��
ʾ�� 2 ��

���룺num = "10200", k = 1
�����"200"
���ͣ��Ƶ���λ�� 1 ʣ�µ�����Ϊ 200. ע������������κ�ǰ���㡣
*/
public class LC_402 {

}
//����ջ
class Solution {
    public String removeKdigits(String num, int k) {
        Deque<Character> deque = new ArrayDeque<>();
        int curMoveCount = 0, n = num.length();
        char[] numArr = num.toCharArray();
        for (int i = 0; i < n; i++){
            while (!deque.isEmpty() && deque.peek() > numArr[i] && curMoveCount < k){
                curMoveCount++;
                deque.pop();
            }
            deque.push(numArr[i]);
        }
        while (curMoveCount < k){
            deque.pop();
            curMoveCount++;
        }
        StringBuffer sb = new StringBuffer();
        while (!deque.isEmpty()){
            sb.append(deque.pop());
        }
        sb.reverse();
        while (sb.length() > 0 && sb.charAt(0) == '0') sb.deleteCharAt(0);
        return sb.length() == 0 ? "0" : sb.toString();
    }
}