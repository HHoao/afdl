package lc_227;

import java.util.Deque;
import java.util.LinkedList;

public class LC_227 {
	public static void main(String[] args) {
		Solution s = new Solution();
		System.out.println(s.calculate("1+2+3*(4+5)"));
	}
}
class Solution {
    public int calculate(String s) {
        /*
            �� �������˷������� ת��Ϊ �ӷ�
            ĳ���� num, ���ǰ��Ķ�Ӧ��������� -����ô �� -num ѹ��ջ��
            ����������ֻ�������ջ��Ԫ��ȫ����������ɼӷ����������ɵõ����ս��

            �������ţ������ڵݹ�����
            ��
            3 * (2 + 4 * 3) + 2
          = 3 * calculate(2 + 4 * 3) + 2
          = 3 * 24 + 2
          �����ǿ��Խ������ڵ��ַ�������һ������ʽ���ٵݹ���ñ����������շ���һ����ֵ
        */
        int[] i = new int[1];
        return dfs(s, i);
    }
    private int dfs(String s, int[] i){
        Deque<Integer> stack = new LinkedList<>();

        //��¼ĳ���������������� "42"����ô�������� num = 4��Ȼ������ 2 ,num = num * 10 + 2 = 42
        int num = 0;
        char op = '+';
        for(; i[0] < s.length(); i[0]++){
            char ch = s.charAt(i[0]);

            //���������ţ��ݹ������ڲ���ʽ
            if(ch == '('){
                ++i[0];
                num = dfs(s, i);
            }
            
            if(Character.isDigit(ch)){
                num = num * 10 + (ch - '0');
            }
            //�������֣����ǿո������ �� '(' �� ')' �� ���� �������һ���ַ�����ô����ǰ���¼�� op ������ ������ѹջ��Ȼ���µ������ ch ��ֵ�� op
            if(!Character.isDigit(ch) && ch != ' ' || i[0] == s.length() - 1){
                switch(op){
                    case '+':
                        stack.push(num); break;
                    case '-':
                        stack.push(-num); break;
                    case '*':
                        int pre = stack.pop();
                        stack.push(pre * num);
                        break;
                    case '/':
                        pre = stack.pop();
                        stack.push(pre / num);
                        break;
                }
                num = 0;
                op = ch;
            }
            /*
            ���������ţ��˳�ѭ����Ȼ��������� ������һ�� dfs
            ��һ��д���������Ϊ���� ch Ϊ ������ ʱ����ô������Ҫ�Ƚ�ǰ���Ѿ��õ��� num ѹ��ջ�У����˳�ѭ��
            */
            if(ch == ')'){
                break;
            }
        }
        int res = 0;
        while(!stack.isEmpty()){
            res += stack.pop();
        }
        return res;
    }
}