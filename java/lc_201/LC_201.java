package lc_201;

/**
 * @author �ƺ�
 *201. ���ַ�Χ��λ��
������������ left �� right ����ʾ���� [left, right] �����ش��������������� ��λ�� �Ľ�������� left ��right �˵㣩��
 */
public class LC_201 {

}
//��λ
class Solution {
    public int rangeBitwiseAnd(int left, int right) {
        int cnt = 0;
        while (left != right){
            cnt++;
            left = left>>>1;
            right = right>>>1;
        }
        return right << cnt;
    }
}
//��������Brian Kernighan �㷨
class Solution1 {
    public int rangeBitwiseAnd(int left, int right) {
        while (left < right){
            right = right & right - 1;
        }
        return right;
    }
}