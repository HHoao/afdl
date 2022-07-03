package lc_300;

/*
 *@author: �ƺ�
 *@date : 2021��6��26��
 *@todo:300. �����������
����һ���������� nums ���ҵ�������ϸ���������еĳ��ȡ�

���������������������������У�ɾ������ɾ���������е�Ԫ�ض����ı�����Ԫ�ص�˳�����磬[3,6,2,7] ������ [0,3,1,6,2,2,7] �������С�

 
*/
public class LC_300 {
}

//��̬�滮
class Solution{
    public int lengthOfLIS(int[] nums) {
        if (nums.length == 0) return -1;
        int n = nums.length;
        int dp[] = new int[n];
        dp[0] = 1;
        int max = 1;
        for (int i = 1; i < n; i++){
            dp[i] = 1;
            for (int j = 0; j <i; j++){
                if (nums[i] > nums[j]){
                    dp[i] = Math.max(dp[i], dp[j]+1);
                }
            }
            max = Math.max(dp[i], max);
        }
        return max;
    }
}
//̰��+����
class Solution1 {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        if (n == 0) return -1;
        if (n == 1) return 1;
        int len = 1;
        int di[] = new int[n+1];
        di[1] = nums[0];
        for (int i = 1; i < n; i++){
            if (nums[i] > di[len]){
                di[++len] = nums[i];
            }else{
                int l = 1, r = len, pos = 0;
                while (l <= r){
                    int mid = l + (r - l)/ 2;
                    if (di[mid] < nums[i]){
                        pos = mid;
                        l = mid + 1;
                    }else{
                        r = mid - 1;
                    }
                }
                di[pos+1] = nums[i];
            }
        }
        return len;
    }
}
