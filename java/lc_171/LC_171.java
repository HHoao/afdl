package lc_171;

/**
 * @author �ƺ�
 *171. Excel�������
����һ��Excel����е������ƣ���������Ӧ������š�
 */
public class LC_171 {

}
//�ҵĴ���
class Solution {
    public int titleToNumber(String columnTitle) {
        int n = columnTitle.length();
        int sum = 0;
        for (int i = 0; i < n; i++){
            char c = columnTitle.charAt(i);
            sum += (c - 64)* Math.pow(26, n - i - 1);
        }
        return sum;
    }
}