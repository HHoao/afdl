package lc_173;

import java.util.Arrays;

/**
 * @author �ƺ�
 *173. ����������������
ʵ��һ��������������������BSTIterator ����ʾһ�����������������������BST���ĵ�������
BSTIterator(TreeNode root) ��ʼ�� BSTIterator ���һ������BST �ĸ��ڵ� root ����Ϊ���캯����һ���ָ�����ָ��Ӧ��ʼ��Ϊһ���������� BST �е����֣��Ҹ�����С�� BST �е��κ�Ԫ�ء�
boolean hasNext() �����ָ���Ҳ�����������֣��򷵻� true �����򷵻� false ��
int next()��ָ�������ƶ���Ȼ�󷵻�ָ�봦�����֡�
ע�⣬ָ���ʼ��Ϊһ���������� BST �е����֣����Զ� next() ���״ε��ý����� BST �е���СԪ�ء�

����Լ��� next() ����������Ч�ģ�Ҳ����˵�������� next() ʱ��BST ��������������ٴ���һ����һ�����֡�
 */
public class LC_173 {

}
//����
class Solution {
    public String largestNumber(int[] nums) {
        int n = nums.length;
        // ת���ɰ�װ���ͣ��Ա㴫�� Comparator ���󣨴˴�Ϊ lambda ���ʽ��
        Integer[] numsArr = new Integer[n];
        for (int i = 0; i < n; i++) {
            numsArr[i] = nums[i];
        }

        Arrays.sort(numsArr, (x, y) -> {
            long sx = 10, sy = 10;
            while (sx <= x) {
                sx *= 10;
            }
            while (sy <= y) {
                sy *= 10;
            }
            return (int) (-sy * x - y + sx * y + x);
        });

        if (numsArr[0] == 0) {
            return "0";
        }
        StringBuilder ret = new StringBuilder();
        for (int num : numsArr) {
            ret.append(num);
        }
        return ret.toString();
    }
}