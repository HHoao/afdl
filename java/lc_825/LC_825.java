package lc_825;

import java.util.Arrays;

/*
 *@author: �ƺ�
 *@date : 2021��12��27��
 *@todo:825. ���������
���罻ý����վ���� n ���û�������һ���������� ages ������ ages[i] �ǵ� i ���û������䡣

�����������һ������Ϊ�棬��ô�û� x ���������û� y��x != y�����ͺ�������

age[y] <= 0.5 * age[x] + 7
age[y] > age[x]
age[y] > 100 && age[x] < 100
����x ������ y ����һ����������

ע�⣬��� x �� y ����һ����������y ����Ҳ�� x ����һ�������������⣬�û��������Լ����ͺ�������

�����ڸ��罻ý����վ�ϲ����ĺ�������������
*/
public class LC_825 {

}
class Solution {
    public int numFriendRequests(int[] ages) {
        int n = ages.length;
        int ans = 0;
        Arrays.sort(ages);
        for (int i = 0; i < n; i++){
            for (int j = i - 1; j >= 0; j--){
                if ((ages[i]+1) * 0.5 + 7 < ages[j]){
                    ans = ages[i] == ages[j] ? 2 : 1;
                }else{
                    break;
                }
            }
        }
        return ans;
    }
}
//˫ָ��
class Solution1 {
    public int numFriendRequests(int[] ages) {
        int n = ages.length;
        int ans = 0;
        Arrays.sort(ages);
        int left = 0, right = 0;
        for (int age : ages){
            if (age < 15) {
                continue;
            }
            while (ages[left] <= 0.5 * age + 7){
                left++;
            }
            while (right + 1 < n && ages[right + 1] <= age) {
                ++right;
            }
            ans += right - left;
        }
            
        return ans;
    }
}
//���������������� + ǰ׺��
class Solution2 {
    public int numFriendRequests(int[] ages) {
        int[] cnt = new int[121];
        for (int age : ages) {
            ++cnt[age];
        }
        int[] pre = new int[121];
        for (int i = 1; i <= 120; ++i) {
            pre[i] = pre[i - 1] + cnt[i];
        }
        int ans = 0;
        for (int i = 15; i <= 120; ++i) {
            if (cnt[i] > 0) {
                int bound = (int) (i * 0.5 + 8);
                ans += cnt[i] * (pre[i] - pre[bound - 1] - 1);
            }
        }
        return ans;
    }
}