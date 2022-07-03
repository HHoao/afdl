package lc_1190;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/*
 *@author: �ƺ�
 *@date : 2021��12��18��
 *@todo:1190. ��תÿ�����ż���Ӵ�
����һ���ַ��� s��������СдӢ����ĸ�����ţ���

���㰴�մ������ڵ����˳����㷴תÿ��ƥ�������е��ַ��������������յĽ����

ע�⣬���Ľ���� ��Ӧ �����κ����š�
*/
public class LC_1190 {
	public static void main(String[] args) {
		System.out.println(new Solution2().reverseParentheses("(ed(et(oc))el)"));
	}
}
//����
class Solution {
    public String reverseParentheses(String s) {
        Map<Integer, StringBuilder> tierMap = new HashMap<>();
        int n = s.length();
        int curTier = 0;
        StringBuilder sb = new StringBuilder("");
        for (int i = 0; i < n; i++){
            char c = s.charAt(i);
            if (c == '('){
                tierMap.put(curTier, sb);
                sb = new StringBuilder("");
                curTier++;
            }else if (c == ')'){
                if (curTier % 2 == 0){
                    tierMap.get(curTier - 1).insert(0, sb);
                }else{
                    tierMap.get(curTier - 1).append(sb);
                }
                curTier--;
                sb = tierMap.get(curTier);
            }else{
            	if (curTier % 2 == 0){
            		sb.append(c);
            	}else{
            		sb.insert(0, c);
            	}
            }
        }
        return tierMap.get(0).toString();
    }
}
//ջ
class Solution1 {
    public String reverseParentheses(String s) {
        int n = s.length();
        int curTier = 0;
        StringBuffer sb = new StringBuffer("");
        Deque<String> stack = new ArrayDeque<>();
        for (int i = 0; i < n; i++){
            char c = s.charAt(i);
            if (c == '('){
                stack.push(sb.toString());
                sb.setLength(0);
            }else if (c == ')'){
                sb.reverse();
                sb.insert(0, stack.pop());
            }else{
                sb.append(c);
            }
        }
        
        return sb.toString();
    }
}
//Ԥ��������
class Solution2 {
    public String reverseParentheses(String s) {
        int n = s.length();
        int[] pair = new int[n];
        Deque<Integer> stack = new LinkedList<Integer>();
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else if (s.charAt(i) == ')') {
                int j = stack.pop();
                pair[i] = j;
                pair[j] = i;
            }
        }

        StringBuffer sb = new StringBuffer();
        int index = 0, step = 1;
        while (index < n) {
            if (s.charAt(index) == '(' || s.charAt(index) == ')') {
                index = pair[index];
                step = -step;
            } else {
                sb.append(s.charAt(index));
            }
            index += step;
        }
        return sb.toString();
    }
}
