package lc_66;

/**
 * @author �ƺ�
 *66. ��һ
����һ���� ���� ��ɵ� �ǿ� ��������ʾ�ķǸ��������ڸ����Ļ����ϼ�һ��

���λ���ִ�����������λ�� ������ÿ��Ԫ��ֻ�洢�������֡�

����Լ���������� 0 ֮�⣬��������������㿪ͷ
 */
public class LC_67 {

}
class Solution {
    public int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            digits[i]++;
            digits[i] = digits[i] % 10;
            if (digits[i] != 0) return digits;
        }
        digits = new int[digits.length + 1];
        digits[0] = 1;
        return digits;
    }
}
