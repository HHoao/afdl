package lc_81;

/**
 * @author �ƺ�
 *81. ������ת�������� II
���谴�����������������Ԥ��δ֪��ĳ�����Ͻ�������ת��

( ���磬���� [0,0,1,2,2,5,6] ���ܱ�Ϊ [2,5,6,0,0,1,2] )��

��дһ���������жϸ�����Ŀ��ֵ�Ƿ�����������С������ڷ��� true�����򷵻� false��
 */
public class LC_81 {

}
class Solution{
	public boolean search(int[] nums, int target) {
	    if (nums == null || nums.length == 0) {
	        return false;
	    }
	    int start = 0;
	    int end = nums.length - 1;
	    int mid;
	    while (start <= end) {
	        mid = start + (end - start) / 2;
	        if (nums[mid] == target) {
	            return true;
	        }
	        if (nums[start] == nums[mid]) {
	            start++;
	            continue;
	        }
	        //ǰ�벿������
	        if (nums[start] < nums[mid]) {
	            if (nums[mid] > target && nums[start] <= target) {
	                end = mid - 1;
	            } else {
	                start = mid + 1;
	            }
	        } else {
	            if (nums[mid] < target && nums[end] >= target) {
	                start = mid + 1;
	            } else {  //����ȥ��벿����
	                end = mid - 1;
	
	            }
	        }
	    }
	    //һֱû�ҵ�������false
	    return false;
	}
}
