package lc_638;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 *@author: �ƺ�
 *@date : 2021��12��1��
 *@todo:638. �����
�� LeetCode �̵��У� �� n �����۵���Ʒ��ÿ����Ʒ���ж�Ӧ�ļ۸�Ȼ����Ҳ��һЩ�������ÿ����������Żݵļ۸���������һ����Ʒ��

����һ���������� price ��ʾ��Ʒ�۸����� price[i] �ǵ� i ����Ʒ�ļ۸�����һ���������� needs ��ʾ�����嵥������ needs[i] ����Ҫ����� i ����Ʒ��������

����һ������ special ��ʾ�������special[i] �ĳ���Ϊ n + 1 ������ special[i][j] ��ʾ�� i ����������ں��� j ����Ʒ���������� special[i][n] ��Ҳ���������е����һ��������Ϊ�� i ��������ļ۸�

���� ȷ�� ���㹺���嵥���軨�ѵ���ͼ۸�����Գ�����ô�������Żݻ���㲻�ܹ��򳬳������嵥ָ����������Ʒ����ʹ�����ή������۸��������������޴ι���
*/
class Solution {
    Map<List<Integer>, Integer> memo = new HashMap<>();
    public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        int n = needs.size();
        List<List<Integer>> filterSpecial = new ArrayList<>();
        for (List<Integer> sp : special){
            int totalCount = 0, totalPrice = 0;
            for (int i = 0; i < n; i++){
                totalCount += sp.get(i);
                totalPrice += sp.get(i) * price.get(i);
            }
            if (totalCount > 0 && totalPrice > sp.get(n)){
                filterSpecial.add(sp);
            }
        }
        return dfs(price, filterSpecial, needs);
    }
    public int dfs(List<Integer> price, List<List<Integer>> special, List<Integer> needs){
        if (!memo.containsKey(needs)){
            int minPrice = 0;
            for (int i = 0; i < needs.size(); i++){
                minPrice += needs.get(i) *price.get(i);
            }
            for (List<Integer> sp : special){
                List<Integer> aftNeeds = new ArrayList<>();
                for (int i = 0; i < needs.size(); i++){
                    if (sp.get(i) > needs.get(i)){
                        break;
                    }else{
                        aftNeeds.add(needs.get(i) - sp.get(i));
                    }
                }
                if (aftNeeds.size() == needs.size()){
                    minPrice = Math.min(minPrice, dfs(price, special, aftNeeds) + sp.get(needs.size()));
                }
            }
            memo.put(needs, minPrice);
        }
        return memo.get(needs);
    }
}