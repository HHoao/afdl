package lc_77;

import java.util.ArrayList;
import java.util.List;

/**
 * @author �ƺ�
 *77. ���
������������ n �� k������ 1 ... n �����п��ܵ� k ��������ϡ�
 */
public class LC_77 {
	
}
class Solution {
    List<Integer> temp = new ArrayList<Integer>();
    List<List<Integer>> ans = new ArrayList<List<Integer>>();

    public List<List<Integer>> combine(int n, int k) {
        dfs(1, n, k);
        return ans;
    }

    public void dfs(int cur, int n, int k) {
        // ��֦��temp ���ȼ������� [cur, n] �ĳ���С�� k�������ܹ��������Ϊ k �� temp
        if (temp.size() + (n - cur + 1) < k) {
            return;
        }
        // ��¼�Ϸ��Ĵ�
        if (temp.size() == k) {
            ans.add(new ArrayList<Integer>(temp));
            return;
        }
        // ����ѡ��ǰλ��
        temp.add(cur);
        dfs(cur + 1, n, k);
        temp.remove(temp.size() - 1);
        // ���ǲ�ѡ��ǰλ��
        dfs(cur + 1, n, k);
    }
}
