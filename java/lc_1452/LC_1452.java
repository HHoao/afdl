package lc_1452;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 *@author: �ƺ�
 *@date : 2021��12��20��
 *@todo:1452. �ղ��嵥
����һ������ favoriteCompanies ������ favoriteCompanies[i] �ǵ� i ���û��ղصĹ�˾�嵥���±�� 0 ��ʼ����

���ҳ����������κ����ղصĹ�˾�嵥���Ӽ����ղ��嵥�������ظ��嵥�±ꡣ�±���Ҫ���������С�
*/
public class LC_1452 {
	public static void main(String[] args) {
		List<List<String>> list = new ArrayList<>();
		list.add(Arrays.asList("leetcode","google","facebook"));
		list.add(Arrays.asList("google","microsoft"));
		list.add(Arrays.asList("google","facebook"));
		list.add(Arrays.asList("google"));
		list.add(Arrays.asList("amazon"));
		System.out.println(new Solution().peopleIndexes(list));
	}
}
//�ֵ���
class Solution {
    class Node{
        Node[] words;
        boolean isEnd;
        List<Integer> companys;
        Node(){
            words = new Node[26];
            isEnd = false;
        }
        public void insert(String str, Integer company){
            char[] cs = str.toCharArray();
            int n = str.length();
            Node curNode = this;
            for (int i = 0; i < n; i++){
                if (curNode.words[cs[i] - 'a'] == null){
                    curNode.words[cs[i] - 'a'] = new Node();
                }
                curNode = curNode.words[cs[i] - 'a'];
            }
            
            if (!curNode.isEnd){
                curNode.isEnd = true;
                curNode.companys = new ArrayList<>();
                curNode.companys.add(company);
            }else{
                curNode.companys.add(company);
            }
        }
        public List<Integer> getCompanys(String str){
            char[] cs = str.toCharArray();
            int n = str.length();
            Node curNode = this;
            for (int i = 0; i < n; i++){
                if (curNode.words[cs[i] - 'a'] == null){
                    return null;
                }else{
                    curNode = curNode.words[cs[i] - 'a'];
                }
            }
            return curNode.companys;
        }
    }
    Node dictionary;
    
    public List<Integer> peopleIndexes(List<List<String>> favoriteCompanies) {
        dictionary = new Node();
        int n = favoriteCompanies.size();
        Map<List<String>, Integer> indexMap = new HashMap<>();
        for (int i = 0; i < n; i++){
            indexMap.put(favoriteCompanies.get(i), i);
        } 
        Collections.sort(favoriteCompanies, (a, b)->{
           return b.size() - a.size(); 
        });
        List<Integer> ret = new ArrayList<>();
        for (int i = 0; i < n; i++){
            Map<Integer, Integer> companySigns = new HashMap<>();
            List<String> collect = favoriteCompanies.get(i);
            Integer index = indexMap.get(collect);
            boolean isSon = false;
            int m = collect.size();
            for (int j = 0; j < m; j++){
                List<Integer> companys = dictionary.getCompanys(collect.get(j));
                if (companys != null){
                    for (Integer company : companys){
                        Integer companySign;
                        companySign = companySigns.getOrDefault(company, 0) + 1;
                        companySigns.put(company, companySign);
                        if (companySign == m){
                            isSon = true;
                        }
                    }
                }
                dictionary.insert(collect.get(j), index);
            }
            if (!isSon){
                ret.add(index);
            }
        }
        Collections.sort(ret);
        return ret;
    }
}