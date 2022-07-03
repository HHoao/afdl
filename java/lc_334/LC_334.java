package lc_334;

/*
 *@author: �ƺ�
 *@date : 2022��1��12��
 *@todo:334. ��������Ԫ������
����һ���������� nums ���ж�����������Ƿ���ڳ���Ϊ 3 �ĵ��������С�

���������������Ԫ���±� (i, j, k) ������ i < j < k ��ʹ�� nums[i] < nums[j] < nums[k] ������ true �����򣬷��� false ��

 

ʾ�� 1��

���룺nums = [1,2,3,4,5]
�����true
���ͣ��κ� i < j < k ����Ԫ�鶼��������
ʾ�� 2��

���룺nums = [5,4,3,2,1]
�����false
���ͣ������������������Ԫ��
ʾ�� 3��

���룺nums = [2,1,5,0,4,6]
�����true
���ͣ���Ԫ�� (3, 4, 5) �������⣬��Ϊ nums[3] == 0 < nums[4] == 4 < nums[5] == 6
*/
public class LC_334 {

}
//�ҵ����
class Solution {
    public boolean increasingTriplet(int[] nums) {
        int n = nums.length;
        if (n < 3) return false;
        int f = nums[0], s = Integer.MAX_VALUE;
        for (int i = 1; i < n; i++){
        	if (nums[i] <= f){
                f = nums[i];
            }else if (nums[i] <= s){
                s = nums[i];
            }else{
                return true;
            }
        }
        return false;
    }
}