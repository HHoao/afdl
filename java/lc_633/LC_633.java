package lc_633;

/**
 * @author �ƺ�
 *633. ƽ����֮��
����һ���Ǹ����� c ����Ҫ�ж��Ƿ������������ a �� b��ʹ�� a2 + b2 = c ��
 */
public class LC_633 {

}
//˫ָ��
class Solution {
    public boolean judgeSquareSum(int c) {
        long  l = 0, r = (int) Math.sqrt(c);
        while (l <= r){
            long total = l * l + r * r;
            if (total == c) return true;
            if (total < c){
                l++;
            }else if (total > c){
                r--;
            }
        }
        return false;
    }
}
//math sql����
class Solution1 {
    public boolean judgeSquareSum(int c) {
        for (long a = 0; a * a <= c; a++) {
            double b = Math.sqrt(c - a * a);
            if (b == (int) b) {
                return true;
            }
        }
        return false;
    }
}