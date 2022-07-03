package lc_1104;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
 *@author: �ƺ�
 *@date : 2021��7��29��
 *@todo:1104. ������Ѱ·
��һ�����޵Ķ������ϣ�ÿ���ڵ㶼�������ӽڵ㣬���еĽڵ� ���� ���ΰ� ��֮�� ���ν��б�ǡ�

����ͼ��ʾ���������У�������һ�С������С������С������У��������ҵ�˳����б�ǣ�

��ż���У������ڶ��С������С������С������У������ҵ����˳����б�ǡ�



��������ĳһ���ڵ�ı�� label�����㷵�شӸ��ڵ㵽�ñ��Ϊ label �ڵ��·������·������;���Ľڵ�������ɵġ�
*/
public class LC_1104 {
	public static void main(String[] args) {
		Solution so = new Solution();
		System.out.println(so.pathInZigZagTree(1));
	}
}
class Solution {
    public List<Integer> pathInZigZagTree(int label) {
        List<Integer> ans = new ArrayList<>();
        int k = label;
        int tier = 0;
        while(k > 0){
            tier++;
            k /= 2;
        }
        while (tier > 0){
            ans.add(label);
            int pre_tier_num_total = (int)Math.pow(2, tier - 1) - 1;
            int pre_tier_num = (int)Math.pow(2, tier -2)-1;
            label = pre_tier_num_total - label/2 + pre_tier_num + 1;
            tier--;
        }
        Collections.reverse(ans);
        return ans;
    }
}