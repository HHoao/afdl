package lc_457;

import java.util.Arrays;
import java.util.TreeSet;

/*
 *@author: �ƺ�
 *@date : 2021��12��20��
 *@todo:475. ��ů��
�����Ѿ����١� ������������һ���й̶����Ȱ뾶�Ĺ�ů�������з��ݹ�ů��

�ڼ������ļ��Ȱ뾶��Χ�ڵ�ÿ�����ݶ����Ի�ù�ů��

���ڣ�����λ��һ��ˮƽ���ϵķ��� houses �͹�ů�� heaters ��λ�ã������ҳ������ؿ��Ը������з��ݵ���С���Ȱ뾶��

˵�������й�ů������ѭ��İ뾶��׼�����ȵİ뾶Ҳһ����
*/
public class LC_457 {
	public static void main(String[] args) {
		System.out.println(new Solution2().findRadius(new int[] {1, 2, 3, 80, 100, 4},  new int[] {1, 2, 3, 80, 100, 4}));
	}
}
//����
class Solution {
    public int findRadius(int[] houses, int[] heaters) {
        int n = houses.length, m = heaters.length;
        int res = 0;
        Arrays.sort(heaters);
        for (int i = 0; i <n; i++){
            int tmp = Integer.MAX_VALUE;
            for (int j = 0; j < m; j++){
                
                tmp = Math.min(tmp, Math.abs(houses[i] - heaters[j]));
            }
            res = Math.max(res, tmp);
        }
        return res;
    }
}
//TreeSet
class Solution1 {
    public int findRadius(int[] houses, int[] heaters) {
        int n = houses.length, m = heaters.length;
        int res = 0;
        TreeSet<Integer> ts = new TreeSet<>();
        for (int i = 0; i < m; i++){
            ts.add(heaters[i]);
        }
        for (int i = 0; i <n; i++){
            Integer c = ts.ceiling(houses[i]);
            Integer f = ts.floor(houses[i]);
            if (c != null && f != null){
                res = Math.max(res, Math.min(c - houses[i], houses[i] - f));
            }else if (c == null){
                res = Math.max(res, houses[i] - f);
            }else{
                res = Math.max(res, c - houses[i]);
            }
        }
        return res;
    }
}

//һ�α���
class Solution2 {
    public int findRadius(int[] houses, int[] heaters) {
        int n = houses.length, m = heaters.length;
        int res = 0;
        Arrays.sort(houses);
        Arrays.sort(heaters);
        int heaterInd = 0;
        for (int i = 0; i < n; i++){
            while (heaterInd < m - 1 && (Math.abs(houses[i] - heaters[heaterInd]) >= 
            Math.abs(houses[i] - heaters[heaterInd+1]))){
                heaterInd++;
            }
            res = Math.max(res, Math.abs(houses[i] - heaters[heaterInd]));
        }
        return res;
    }
}