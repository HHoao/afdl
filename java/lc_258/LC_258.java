package lc_258;

/**
 * @author �ƺ�
 *258. ��λ���
����һ���Ǹ����� num������������λ�ϵ�������ӣ�ֱ�����Ϊһλ����
 */
public class LC_258 {

}
class Solution {
    public int addDigits(int num) {
        while (num >= 10){
            int t = 0;
            while (num > 0){
                int n = num % 10;
                num /= 10;
                t += n;
            }
            num = t;
        }
        return num;
    }
}
class Solution1 {
    public int addDigits(int num) {
        return (num -1) % 9 + 1;
    }
}