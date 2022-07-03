package lc_1371;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
 *@author: �ƺ�
 *@date : 2022��1��18��
 *@todo:1371. ÿ��Ԫ������ż���ε�����ַ���
����һ���ַ��� s �����㷵��������������������ַ����ĳ��ȣ�ÿ��Ԫ����ĸ���� 'a'��'e'��'i'��'o'��'u' �������ַ����ж�ǡ�ó�����ż���Ρ�

 

ʾ�� 1��

���룺s = "eleetminicoworoep"
�����13
���ͣ�����ַ����� "leetminicowor" �������� e��i��o �� 2 �����Լ� 0 �� a��u ��
ʾ�� 2��

���룺s = "leetcodeisgreat"
�����5
���ͣ�����ַ����� "leetc" �����а��� 2 �� e ��
*/
public class LC_1371 {
	public static void main(String[] args) {
		System.out.println(new Solution1().findTheLongestSubstring("tyrwpvlifrgjghlcicyocusukhmjbkfkzsjhkdrtsztchhazhmcircxcauajyzlppedqyzkcqvffyeekjdwqtjegerxbyktzvrxwgfjnrfbwvhiycvoznriroroamkfipazunsabwlseseeiimsmftchpafqkquovuxhhkpvphwnkrtxuiuhbcyqulfqyzgjjwjrlfwwxotcdtqsmfeingsxyzbpvmwulmqfrxbqcziudixceytvvwcohmznmfkoetpgdntrndvjihmxragqosaauthigfjergijsyivozzfrlpndygsmgjzdzadsxarjvyxuecqlszjnqvlyqkadowoljrmkzxvspdummgraiutxxxqgotqnxwjwfotvqglqavmsnmktsxwxcpxhuujuanxueuymzifycytalizwnvrjeoipfoqbiqdxsnclcvoafqwfwcmuwitjgqghkiccwqvloqrxbfjuxwriltxhmrmfpzitkwhitwhvatmknyhzigcuxfsosxetioqfeyewoljymhdwgwvjcdhmkpdfbbztaygvbpwqxtokvidtwfdhmhpomyfhhjorsmgowikpsdgcbazapkmsjgmfyuezaamevrbsmiecoujabrbqebiydncgapuexivgvomkuiiuuhhbszsflntwruqblrnrgwrnvcwixtxycifdebgnbbucqpqldkberbovemywoaxqicizkcjbmbxikxeizmzdvjdnhqrgkkqzmspdeuoqrxswqrajxfglmqkdnlescbjzurknjklikxxqqaqdekxkzkscoipolxmcszbebqpsizhwsxklzulmjotkrqfaeivhsedfynxtbzdrviwdgicusqucczgufqnaslpwzjhgtphnovlrgz"));
	}
}
//�����������(��ʱ)
class Solution1 {
    public int findTheLongestSubstring(String s) {
        return dfs(s);
    }
    private int dfs(String s){
        int n = s.length();
        Map<Character, Integer> map = new HashMap<>();
        map.put('a', 0);
        map.put('e', 0);
        map.put('i', 0);
        map.put('o', 0);
        map.put('u', 0);
        for (int i = 0; i < n; i++){
            char c = s.charAt(i);
            if (map.containsKey(c)){
                map.put(c, map.get(c) ^ 1);
            }
        }
        char split = 0;
        for (Map.Entry<Character, Integer> entry : map.entrySet()){
            if (entry.getValue() == 1){
                split = entry.getKey();
                break;
            }
        }
        if (split == 0){
            return n;
        }
        int i = s.indexOf(split), j = s.lastIndexOf(split), ans = 0;
        int len = dfs(s.substring(0, i));
        int len2 = i != j ? Math.max(dfs(s.substring(i+1, n)), dfs(s.substring(0, j))): dfs(s.substring(i+1, n));
        ans = Math.max(ans, Math.max(len, len2));
        return ans;
    }
}
//ǰ׺��
class Solution {
    public int findTheLongestSubstring(String s) {
        int n = s.length();
        int[] pos = new int[1 << 5];
        Arrays.fill(pos, -1);
        int ans = 0, status = 0;
        pos[0] = 0;
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if (ch == 'a') {
                status ^= (1 << 0);
            } else if (ch == 'e') {
                status ^= (1 << 1);
            } else if (ch == 'i') {
                status ^= (1 << 2);
            } else if (ch == 'o') {
                status ^= (1 << 3);
            } else if (ch == 'u') {
                status ^= (1 << 4);
            }
            if (pos[status] >= 0) {
                ans = Math.max(ans, i + 1 - pos[status]);
            } else {
                pos[status] = i + 1;
            }
        }
        return ans;
    }
}