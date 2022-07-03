package lc_724;

import java.util.Arrays;

/*
 *@author: �ƺ�
 *@date : 2021��12��31��
 *@todo:724. Ѱ������������±�
����һ���������� nums ������������ �����±� ��

���� �����±� �������һ���±꣬���������Ԫ����ӵĺ͵����Ҳ�����Ԫ����ӵĺ͡�

��������±�λ����������ˣ���ô�����֮����Ϊ 0 ����Ϊ���±����಻����Ԫ�ء���һ����������±�λ���������Ҷ�ͬ�����á�

��������ж�������±꣬Ӧ�÷��� ������ ����һ����������鲻���������±꣬���� -1 ��
���룺nums = [1, 7, 3, 6, 5, 6]
�����3
���ͣ�
�����±��� 3 ��
�����֮�� sum = nums[0] + nums[1] + nums[2] = 1 + 7 + 3 = 11 ��
�Ҳ���֮�� sum = nums[4] + nums[5] = 5 + 6 = 11 ��������ȡ�
*/
public class LC_724 {

}
//ǰ׺��
class Solution {
    public int pivotIndex(int[] nums) {
        int n = nums.length;
        int sum = Arrays.stream(nums).sum();
        int tol = 0;
        for (int i = 0; i < n; i++){   
            if (tol == (sum - nums[i]) - tol){	
                return i;
            }
            tol += nums[i];
        }
        return -1;
    }
}