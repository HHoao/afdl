package lc_287;

/*
 *@author: �ƺ�
 *@date : 2021��5��7��
 *@todo:287. Ѱ���ظ���
����һ������ n + 1 ������������ nums �������ֶ��� 1 �� n ֮�䣨���� 1 �� n������֪���ٴ���һ���ظ���������

���� nums ֻ�� һ���ظ������� ���ҳ� ����ظ����� ��
*/
public class LC_287 {

}
//����ָ��
class Solution {
    public int findDuplicate(int[] nums) {
        int slow = nums[0], fast = nums[0];
        while(true){
            slow = nums[slow];
            fast = nums[nums[fast]];
            if(slow == fast){
                slow = nums[0];
                while(slow != fast){
                    slow = nums[slow];
                    fast = nums[fast];
                }
                return slow;
            }
        }
    }
}
//˫ָ��
class Solution1 {
    public int findDuplicate(int[] nums) {
        int n = nums.length;
        int l = 1, r = n - 1, ans = -1;
        while (l <= r) {
            int mid = (l + r) >> 1;
            int cnt = 0;
            for (int i = 0; i < n; ++i) {
                if (nums[i] <= mid) {
                    cnt++;
                }
            }
            if (cnt <= mid) {
                l = mid + 1;
            } else {
                r = mid - 1;
                ans = mid;
            }
        }
        return ans;
    }
}