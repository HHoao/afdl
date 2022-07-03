package lc_93;

import java.util.ArrayList;
import java.util.List;

/**
 * @author �ƺ�
 *93. ��ԭ IP ��ַ
����һ��ֻ�������ֵ��ַ��������Ա�ʾһ�� IP ��ַ���������п��ܴ� s ��õ� ��Ч IP ��ַ ������԰��κ�˳�򷵻ش𰸡�

��Ч IP ��ַ �������ĸ�������ÿ������λ�� 0 �� 255 ֮����ɣ��Ҳ��ܺ���ǰ�� 0��������֮���� '.' �ָ���

���磺"0.1.2.201" �� "192.168.1.1" �� ��Ч IP ��ַ������ "0.011.255.245"��"192.168.1.312" �� "192.168@1.1" �� ��Ч IP ��ַ��
 */
public class LC_93 {
	public static void main(String[] args) {
		Solution solution = new Solution();
		List<String> list = solution.restoreIpAddresses("101023");
		for (String str : list) {
			System.out.println(str);
		}
	}
}
//����
class Solution {
	int ADDRESS_POINT = 4;
    public List<String> restoreIpAddresses(String s) {
    	List<String> ans = new ArrayList<String>();
    	dfs(s, ans, new StringBuffer(),0, 0 );
    	return ans;
    }
    public void dfs(String s, List<String> ans, StringBuffer stb, int n, int size) {
    	if (size == s.length() && n == ADDRESS_POINT) {
    		StringBuffer subans = new StringBuffer(stb);
    		ans.add(subans.deleteCharAt(subans.length()-1).toString());
    		return ;
    	}
    	if (n >= ADDRESS_POINT) {
    		return;
    	}
    	for (int i = 1; i <= ADDRESS_POINT - 1 ; i++) {
    		if (size + i > s.length()) return;
    		String subs = s.substring(size, size + i);
    		int val = Integer.valueOf(subs);
    		if (subs.charAt(0) == '0' && subs.length() > 1) continue;
    		if (val <= 255) {
    			stb.append(subs + '.');
    			dfs(s, ans, stb, n + 1, size + i);
    			stb.delete(stb.length() - subs.length() - 1, stb.length());
    		}
    	}
    }
}
//�ٷ�
class Solution1 {
    static final int SEG_COUNT = 4;
    List<String> ans = new ArrayList<String>();
    int[] segments = new int[SEG_COUNT];

    public List<String> restoreIpAddresses(String s) {
        segments = new int[SEG_COUNT];
        dfs(s, 0, 0);
        return ans;
    }

    public void dfs(String s, int segId, int segStart) {
        // ����ҵ��� 4 �� IP ��ַ���ұ��������ַ�������ô����һ�ִ�
        if (segId == SEG_COUNT) {
            if (segStart == s.length()) {
                StringBuffer ipAddr = new StringBuffer();
                for (int i = 0; i < SEG_COUNT; ++i) {
                    ipAddr.append(segments[i]);
                    if (i != SEG_COUNT - 1) {
                        ipAddr.append('.');
                    }
                }
                ans.add(ipAddr.toString());
            }
            return;
        }

        // �����û���ҵ� 4 �� IP ��ַ���Ѿ����������ַ�������ô��ǰ����
        if (segStart == s.length()) {
            return;
        }

        // ���ڲ�����ǰ���㣬�����ǰ����Ϊ 0����ô��һ�� IP ��ַֻ��Ϊ 0
        if (s.charAt(segStart) == '0') {
            segments[segId] = 0;
            dfs(s, segId + 1, segStart + 1);
        }

        // һ�������ö��ÿһ�ֿ����Բ��ݹ�
        int addr = 0;
        for (int segEnd = segStart; segEnd < s.length(); ++segEnd) {
            addr = addr * 10 + (s.charAt(segEnd) - '0');
            if (addr > 0 && addr <= 0xFF) {
                segments[segId] = addr;
                dfs(s, segId + 1, segEnd + 1);
            } else {
                break;
            }
        }
    }
}
