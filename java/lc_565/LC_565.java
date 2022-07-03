package lc_565;

/*
 *@author: �ƺ�
 *@date : 2021��12��20��
 *@todo:565. ����Ƕ��
������0��ʼ����ΪN������A������0��N - 1�������������ҵ����ļ���S���������С������ S[i] = {A[i], A[A[i]], A[A[A[i]]], ... }���������µĹ���

����ѡ������Ϊi��Ԫ��A[i]ΪS�ĵ�һ��Ԫ�أ�S����һ��Ԫ��Ӧ����A[A[i]]��֮����A[A[A[i]]]... �Դ����ƣ��������ֱ��S�����ظ���Ԫ�ء�
*/
public class LC_565 {
}
//����ָ��
class Solution {
    public int arrayNesting(int[] nums) {
        int n = nums.length;
        boolean[] vis = new boolean[n];
        int ret = 0;
        for (int i = 0; i < n; i++){
            if (vis[nums[i]]){
                continue;
            }
            vis[i] = true;
            int l = i, q = i;
            int s1 = 1;
            while(true){
                l = nums[l];
                q = nums[q];
                vis[q] = true;
                q = nums[q];
                vis[q] = true;
                if (l == q) {
                    break;
                }
                s1++;
            }
            ret = Math.max(ret, s1);
        }
        return ret;
    }
}
//��ʹ�ö���ռ�
class Solution1 {
    public int arrayNesting(int[] nums) {
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != Integer.MAX_VALUE) {
                int start = nums[i], count = 0;
                while (nums[start] != Integer.MAX_VALUE) {
                    int temp = start;
                    start = nums[start];
                    count++;
                    nums[temp] = Integer.MAX_VALUE;
                }
                res = Math.max(res, count);
            }
        }
        return res;
    }
}
//�ٷ�
class Solution2 {
    public int arrayNesting(int[] nums) {
        boolean[] visited = new boolean[nums.length];
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            if (!visited[i]) {
                int start = nums[i], count = 0;
                do {
                    start = nums[start];
                    count++;
                    visited[start] = true;
                }
                while (start != nums[i]);
                res = Math.max(res, count);
            }
        }
        return res;
    }
}