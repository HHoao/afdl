package lc_241;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author �ƺ�
 *241. Ϊ������ʽ������ȼ�
����һ���������ֺ���������ַ�����Ϊ���ʽ������ţ��ı����������ȼ��������ͬ�Ľ��������Ҫ�������п��ܵ���ϵĽ������Ч��������Ű��� +, - �Լ� * ��
 */
public class LC_241 {

}
//�ҵĴ���
class Solution {
    public List<Integer> diffWaysToCompute(String expression) {
        int count = 0;
        for (int i = 0; i < expression.length(); i++){
            if (Character.isDigit(expression.charAt(i))){
                count++;
            }
        }
        if (count == expression.length()){
            return Arrays.asList(Integer.valueOf(expression)); 
        }
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i < expression.length(); i++){
            char c = expression.charAt(i);
            if (c == '*' || c == '-' || c == '+'){
                List<Integer> l = diffWaysToCompute(expression.substring(0, i));
                List<Integer> r = diffWaysToCompute(expression.substring(i+1, expression.length()));
                for (Integer n : l){
                    for (Integer m : r){
                        if (c == '*'){
                            list.add(n * m);
                        }else if (c == '-'){
                            list.add(n - m);
                        }else{
                            list.add(n +m);
                        }
                    }
                }
            }
        }
        return list;
    }
}