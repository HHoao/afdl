package lc_167;

/**
 * @author �ƺ�
 *167. ����֮�� II - ������������
����һ���Ѱ��� ��������  ���������� numbers ��������������ҳ��������������֮�͵���Ŀ���� target ��

����Ӧ���Գ���Ϊ 2 �������������ʽ���������������±�ֵ��numbers ���±� �� 1 ��ʼ���� �����Դ�����Ӧ������ 1 <= answer[0] < answer[1] <= numbers.length ��

����Լ���ÿ������ֻ��ӦΨһ�Ĵ𰸣������㲻�����ظ�ʹ����ͬ��Ԫ�ء�
 */
public class LC_167 {

}
//˫ָ��
class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int l = 0, r = numbers.length - 1;
        while (l < r - 1){
            if (numbers[l] + numbers[r] == target) break;
            if (numbers[l] + numbers[r] > target){
                r--;
            }else{
                l++;
            }
        }
        return new int[]{l+1, r+1};
    }
}