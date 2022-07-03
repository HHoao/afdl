package lc_166;

import java.util.HashMap;
import java.util.Map;

/**
 * @author �ƺ�
 *166. ������С��
���������������ֱ��ʾ�����ķ��� numerator �ͷ�ĸ denominator���� �ַ�����ʽ����С�� ��

���С������Ϊѭ��С������ѭ���Ĳ������������ڡ�

������ڶ���𰸣�ֻ�践�� ����һ�� ��

�������и��������룬��֤ ���ַ����ĳ���С�� 104 ��
 */
public class LC_166 {

}
//�ҵĴ���
class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        if (numerator == 0 || denominator == 0) return "0";
        Map<Long, Integer> letterIndex = new HashMap<>();
        StringBuffer sbu = new StringBuffer("");
        if (numerator < 0 ^ denominator < 0) {
            sbu.append("-");
        }
        long dividend = Math.abs(Long.valueOf(numerator));
        long divisor = Math.abs(Long.valueOf(denominator));
        long i = dividend % divisor;
        long n = dividend / divisor;
        if (i!=0) {
            sbu.append(n+".");
        } else {
            sbu.append(n);
        }
        letterIndex.put(i, sbu.length());

        
        while (i != 0){
            dividend = i * 10;
            i = dividend % divisor;
            n = dividend / divisor;

            sbu.append(Math.abs(n));
            
            if (letterIndex.containsKey(i)){
                int index = letterIndex.get(i);
                String str = sbu.substring(index, sbu.length());
                sbu.replace(index, sbu.length(), "("+str+")");
                break;
            }
            letterIndex.put(i, sbu.length());
        }
        return sbu.toString();
    }
}
//�ٷ�
class Solution1{
    public String fractionToDecimal(int numerator, int denominator) {
        if (numerator == 0) {
            return "0";
        }
        StringBuilder fraction = new StringBuilder();
        // If either one is negative (not both)
        if (numerator < 0 ^ denominator < 0) {
            fraction.append("-");
        }
        // Convert to Long or else abs(-2147483648) overflows
        long dividend = Math.abs(Long.valueOf(numerator));
        long divisor = Math.abs(Long.valueOf(denominator));
        fraction.append(String.valueOf(dividend / divisor));
        long remainder = dividend % divisor;
        if (remainder == 0) {
            return fraction.toString();
        }
        fraction.append(".");
        Map<Long, Integer> map = new HashMap<>();
        while (remainder != 0) {
            if (map.containsKey(remainder)) {
                fraction.insert(map.get(remainder), "(");
                fraction.append(")");
                break;
            }
            map.put(remainder, fraction.length());
            remainder *= 10;
            fraction.append(String.valueOf(remainder / divisor));
            remainder %= divisor;
        }
        return fraction.toString();
    }
}