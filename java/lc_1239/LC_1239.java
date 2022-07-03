package lc_1239;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 *@author: �ƺ�
 *@date : 2021��12��2��
 *@todo:1239. �����ַ�������󳤶�
����һ���ַ������� arr���ַ��� s �ǽ� arr ĳһ�������ַ����������õ��ַ�������� s �е�ÿһ���ַ���ֻ���ֹ�һ�Σ���ô������һ�����н⡣

�뷵�����п��н� s ������ȡ�
*/
public class LC_1239 {

}
//����
class Solution {
    public int dfs(boolean[] hasWord, int k, List<String> arr){
        int n = arr.size();
        int l = 0;
        for (int i = k; i < n; i++){
            String str = arr.get(i);
            int strlen = str.length();
            boolean hasCom = false;
            boolean[] copyArr = Arrays.copyOf(hasWord, 26);
            for (int j = 0; j < strlen; j++){
                if (copyArr[str.charAt(j) - 'a']) {
                    hasCom =true;
                    break;
                }else{
                    copyArr[str.charAt(j) - 'a'] = true;
                }
            }
            if (!hasCom){
                for (int j = 0; j < strlen; j++){
                    copyArr[str.charAt(j) - 'a'] = true;
                }
                l = Math.max(l, dfs(copyArr, i, arr)+strlen);
            }
        }
        return l;
    }
    public int maxLength(List<String> arr) {
        int s = arr.size();
        return dfs(new boolean[26], 0, arr);
    }
}
//����+λ����
class Solution1 {
    public int maxLength(List<String> arr) {
        int ans = 0;
        List<Integer> masks = new ArrayList<Integer>();
        masks.add(0);
        for (String s : arr) {
            int mask = 0;
            for (int i = 0; i < s.length(); ++i) {
                int ch = s.charAt(i) - 'a';
                if (((mask >> ch) & 1) != 0) { // �� mask ���� ch����˵�� s �����ظ���ĸ���޷����ɿ��н�
                    mask = 0;
                    break;
                }
                mask |= 1 << ch; // �� ch ���� mask ��
            }
            if (mask == 0) {
                continue;
            }
            int n = masks.size();
            for (int i = 0; i < n; ++i) {
                int m = masks.get(i);
                if ((m & mask) == 0) { // m �� mask �޹���Ԫ��
                    masks.add(m | mask);
                    ans = Math.max(ans, Integer.bitCount(m | mask));
                }
            }
        }
        return ans;
    }
}