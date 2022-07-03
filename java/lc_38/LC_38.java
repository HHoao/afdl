package lc_38;

import java.util.Stack;

/**
 * @author �ƺ�
 *38. �������
����һ�������� n �����������еĵ� n �

��������С���һ���������У������� 1 ��ʼ�������е�ÿһ��Ƕ�ǰһ���������

����Խ����������ɵݹ鹫ʽ����������ַ������У�

countAndSay(1) = "1"
countAndSay(n) �Ƕ� countAndSay(n-1) ��������Ȼ��ת������һ�������ַ�����
ǰ�������£�

1.     1
2.     11
3.     21
4.     1211
5.     111221
��һ�������� 1 
����ǰһ�������� 1 �� �� һ �� 1 �������� "11"
����ǰһ�������� 11 �� �� �� �� 1 �� ������ "21"
����ǰһ�������� 21 �� �� һ �� 2 + һ �� 1 �� ������ "1211"
����ǰһ�������� 1211 �� �� һ �� 1 + һ �� 2 + �� �� 1 �� ������ "111221"
Ҫ ���� һ�������ַ���������Ҫ���ַ����ָ�Ϊ ��С �������飬ÿ���鶼����������� ��ͬ�ַ� ��ɡ�Ȼ�����ÿ���飬�������ַ���������Ȼ�������ַ����γ�һ�������顣Ҫ������ת��Ϊ�����ַ������Ƚ�ÿ���е��ַ������������滻���ٽ���������������������

���磬�����ַ��� "3322251" ����������ͼ��
 */
public class LC_38 {
	public static void main(String[] args) {
		Solution2 s = new Solution2();
		System.out.println(s.countAndSay(3));
	}
}
//�ҵ������ݹ�
class Solution{
    public String countAndSay(int n) {
       // if (n == 1){
         //   return "" + 1;
        //}
        return desBefo(n-1);
    }
    public String desBefo(int num) {
		if (num == 0) {
			return "1";
		}
		String result = desBefo(num-1);
		Stack<String> stack = new Stack<String>();
		for (int i = 0; i< result.length();i++) {
			stack.push(result.substring(i, i+1));
		}
		Stack<String> s = searchCom(stack);
		String temp_num = "";
		while(s.size() >0) {
			String n = s.pop();
			temp_num += n;
			
		}
		return temp_num;
	}
	public Stack<String> searchCom(Stack<String> stack) {//111221
		Stack<String> s = new Stack<String>();//312211
		int cnt = 0;
		String bef_num = stack.peek();
		while(stack.size() > 0 ) {
			String com_num = stack.pop();
			if (com_num.equals(bef_num)) {
				cnt++;
			}else {
				s.push(bef_num);
				s.push(cnt+"");
				cnt = 1;
			}
			if (stack.size() == 0) {
				s.push(com_num);
				s.push(cnt+"");
			}
			bef_num = com_num;
		}
		return s;
	}
}
class Solution2 {
    public String countAndSay(int n) {
        StringBuffer pre = new StringBuffer("1");
        StringBuffer cur = new StringBuffer("1");
        for(int i=1;i<n;i++){
            pre = cur;
            cur = new StringBuffer();
            int start =0,end = 0;
            //��ʼ����ǰһ���ʼ����
            while(end<pre.length()){
                while(end<pre.length() && pre.charAt(start) ==pre.charAt(end)){
                    end++;
                }
                //Ԫ�س��ִ�����Ԫ�ؽ���ƴ��
                cur = cur.append(Integer.toString(end-start)).append(pre.charAt(start));
                start = end;
            }

        }
        return cur.toString();
    }
}
class Solution3 {
    public String countAndSay(int n) {
        String last;
        if (n == 1) {
            return "1";
        } else {
            last = countAndSay(n - 1);
        }

        int length = 2;
        int currIndex = 1;
        //long value = 0;
        char prev = last.charAt(0); //��ʾ��ǰ��group��char

        while (currIndex < last.length()) {
            if (prev != last.charAt(currIndex)) {
                prev = last.charAt(currIndex);
                length += 2;
            }
            currIndex++;
        }

        char[] chars = new char[length];
        int group = 0;
        prev = last.charAt(0);
        chars[1] = prev;
        currIndex = 1;
        length = 1;
        while (currIndex < last.length()) {
            if (prev == last.charAt(currIndex)) {
                length++;
            } else {
                chars[2 * group] = ((char) (length + 48));
                chars[2 * group + 1] = prev;
                prev = last.charAt(currIndex);
                length = 1;
                group++;
            }
            currIndex++;
        }

        chars[2 * group] = ((char) (length + 48));
        chars[2 * group + 1] = prev;

        return new String(chars);
    }

}