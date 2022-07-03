package lc_1004;

import java.util.HashMap;
import java.util.Map;

/*
 *@author: �ƺ�
 *@date : 2022��1��2��
 *@todo:1004. �������1�ĸ��� III
����һ�������� 0 �� 1 ��ɵ����� A�����������Խ� K ��ֵ�� 0 ��� 1 ��

���ؽ����� 1 �����������������ĳ��ȡ�

 

ʾ�� 1��

���룺A = [1,1,1,0,0,0,1,1,1,1,0], K = 2
�����6
���ͣ� 
[1,1,1,0,0,1,1,1,1,1,1]
�������ִ� 0 ��ת�� 1����������鳤��Ϊ 6��
*/
public class LC_1004 {

}
//ǰ׺�� + ��ϣ��
class Solution {
    public int longestOnes(int[] nums, int k) {
        int n = nums.length;
        int ans = 0;
        Map<Integer, Integer> map = new HashMap<>();
        int zeroCount = 0;
        for (int i = 0; i < n; i++){
            if (nums[i] == 0){
                zeroCount++;
                map.put(zeroCount, i);
            }
            ans = zeroCount <= k ? i + 1 : Math.max(ans, i - map.get(zeroCount - k));
        } 
        return ans;
    }
}
//ǰ׺��+����
class Solution1 {
    public int longestOnes(int[] nums, int k) {
        int n = nums.length;
        int ans = 0;
        int[] map = new int[n+1];
        int zeroCount = 0;
        for (int i = 0; i < n; i++){
            if (nums[i] == 0){
                zeroCount++;
                map[zeroCount] = i;
            }
            ans = zeroCount <= k ? i + 1 : Math.max(ans, i - map[zeroCount - k]);
        } 
        return ans;
    }
}
//ǰ׺��+����
class Solution2 {
    public int longestOnes(int[] nums, int k) {
        int n = nums.length;
        int[] P = new int[n + 1];
        for (int i = 1; i <= n; ++i) {
            P[i] = P[i - 1] + (1 - nums[i - 1]);
        }

        int ans = 0;
        for (int right = 0; right < n; ++right) {
            int left = binarySearch(P, P[right + 1] - k);
            ans = Math.max(ans, right - left + 1);
        }
        return ans;
    }

    public int binarySearch(int[] P, int target) {
        int low = 0, high = P.length - 1;
        while (low < high) {
            int mid = (high - low) / 2 + low;
            if (P[mid] < target) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }
}
//��������
class Solution3 {
    public int longestOnes(int[] nums, int k) {
        int n = nums.length;
        int left = 0, lsum = 0, rsum = 0;
        int ans = 0;
        for (int right = 0; right < n; ++right) {
            rsum += 1 - nums[right];
            while (lsum < rsum - k) {
                lsum += 1 - nums[left];
                ++left;
            }
            ans = Math.max(ans, right - left + 1);
        }
        return ans;
    }
}
