package lc_1442;

import java.util.HashMap;
import java.util.Map;

/*
 *@author: �ƺ�
 *@date : 2022��1��18��
 *@todo:	1442. �γ������������������Ԫ����Ŀ
����һ���������� arr ��

����Ҫ��������ȡ�����±� i��j �� k ������ (0 <= i < j <= k < arr.length) ��

a �� b �������£�

a = arr[i] ^ arr[i + 1] ^ ... ^ arr[j - 1]
b = arr[j] ^ arr[j + 1] ^ ... ^ arr[k]
ע�⣺^ ��ʾ ��λ��� ������

�뷵���ܹ��� a == b ��������Ԫ�� (i, j , k) ����Ŀ��

 

ʾ�� 1��

���룺arr = [2,3,1,6,7]
�����4
���ͣ������������Ԫ��ֱ��� (0,1,2), (0,2,2), (2,3,4) �Լ� (2,4,4)
ʾ�� 2��

���룺arr = [1,1,1,1,1]
�����10
*/
public class LC_1442 {

}
//����ѭ��
class Solution {
    public int countTriplets(int[] arr) {
        int n = arr.length;
        int ans = 0;
        int[] pre = new int[n + 1];
        for (int i = 1; i <= n; i++){
            pre[i] = pre[i - 1] ^ arr[i - 1];
        }
        for (int i = 1; i <= n; i++){
            for (int k = i + 1; k <= n; k++){
                for (int j = i + 1; j <= k; j++){
                    if ((pre[j - 1] ^ pre[i - 1]) == (pre[k] ^ pre[j-1])){
                        ans++;
                    }
                }
            }
        }
        return ans;
    }
}
//����ѭ��
class Solution1 {
    public int countTriplets(int[] arr) {
        int n = arr.length;
        int ans = 0;
        int[] pre = new int[n + 1];
        for (int i = 1; i <= n; i++){
            pre[i] = pre[i - 1] ^ arr[i - 1];
        }
        for (int i = 0; i < n; i++){    
            for (int k = i+1; k < n; k++){
                if (pre[i] == pre[k+1]){
                    ans += k - i;
                }
            }
        }
        return ans;
    }
}
//��ϣ��
class Solution2 {
    public int countTriplets(int[] arr) {
        int n = arr.length;
        Map<Integer, Integer> cnt = new HashMap<Integer, Integer>();
        Map<Integer, Integer> total = new HashMap<Integer, Integer>();
        int ans = 0, s = 0;
        for (int k = 0; k < n; ++k) {
            int val = arr[k];
            if (cnt.containsKey(s ^ val)) {
                ans += cnt.get(s ^ val) * k - total.get(s ^ val);
            }
            cnt.put(s, cnt.getOrDefault(s, 0) + 1);
            total.put(s, total.getOrDefault(s, 0) + k);
            s ^= val;
        }
        return ans;
    }
}