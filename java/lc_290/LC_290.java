package lc_290;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/*
 *@author: �ƺ�
 *@date : 2021��5��8��
 *@todo:290. ���ʹ���
����һ�ֹ��� pattern ��һ���ַ��� str ���ж� str �Ƿ���ѭ��ͬ�Ĺ��ɡ�

����� ��ѭ ָ��ȫƥ�䣬���磬 pattern ���ÿ����ĸ���ַ��� str �е�ÿ���ǿյ���֮�������˫�����ӵĶ�Ӧ���ɡ�
*/
public class LC_290 {

}
//�ҵĴ���
class Solution {
    public boolean wordPattern(String pattern, String s) {
        Map<Character, String> map = new HashMap<>();
        Set<String> set = new HashSet<>();
        String[] strs = s.split(" ");
        if (pattern.length() != strs.length) return false;
        for (int i = 0; i < pattern.length(); i++){
            char ch = pattern.charAt(i);
            
            if (!map.containsKey(ch)){
                if (set.contains(strs[i])) return false;
                map.put(ch, strs[i]);
                set.add(strs[i]);
            }else{
                if (!map.get(ch).equals(strs[i])){
                    return false;
                }
            }
        }
        return true;
    }
}