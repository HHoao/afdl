package lc_154;

/**
 * @author �ƺ�
 *154. Ѱ����ת���������е���Сֵ II
���谴�����������������Ԥ��δ֪��ĳ�����Ͻ�������ת��

( ���磬���� [0,1,2,4,5,6,7] ���ܱ�Ϊ [4,5,6,7,0,1,2] )��

���ҳ�������С��Ԫ�ء�

ע�������п��ܴ����ظ���Ԫ�ء�
 */
public class LC_154 {

}
//�ҵĴ��� ����
class Solution {
    public int findMin(int[] nums) {
        int l = 0, r = nums.length - 1;
        while (l < r){
            int mid = (l+r) >> 1;
            if (nums[mid] == nums[r]) r--;
            else if (nums[mid] < nums[r]){
                r = mid;
            }else{
                l = mid + 1;
            }
        }
        return nums[l];
    }
}
//[0, 1, 2, 2, 2]
//[2, 2, 0, 1, 2]
//[2, 2, 2, 0, 1]
//[2, 2, 2, 0, 2]
//[2, 0, 2, 2, 2]
//�ٷ� ����
class Solution1 {
    public int findMin(int[] nums) {
        int low = 0;
        int high = nums.length - 1;
        while (low < high) {
            int pivot = low + (high - low) / 2;
            if (nums[pivot] < nums[high]) {
                high = pivot;
            } else if (nums[pivot] > nums[high]) {
                low = pivot + 1;
            } else {
                high -= 1;
            }	
        }
        return nums[low];
    }
}
