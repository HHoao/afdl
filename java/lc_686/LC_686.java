package lc_686;

import java.util.Random;

/*
 *@author: �ƺ�
 *@date : 2021��12��22��
 *@todo:686. �ظ������ַ���ƥ��
���������ַ��� a �� b��Ѱ���ظ������ַ��� a ����С������ʹ���ַ��� b ��Ϊ���Ӻ���ַ��� a ���Ӵ�������������򷵻� -1��

ע�⣺�ַ��� "abc" �ظ����� 0 ���� ""���ظ����� 1 ���� "abc"���ظ����� 2 ���� "abcabc"��
*/
public class LC_686 {

}
//ģ��
class Solution {
    public int repeatedStringMatch(String a, String b) {
        // ���b������a�����ڵ��ַ���ֱ�ӷ���-1
        boolean[] arr = new boolean[26];
        for (int i = 0; i < a.length(); i++) {
            arr[a.charAt(i) - 'a'] = true;
        }
        for (int i = 0; i < b.length(); i++) {
            if (!arr[b.charAt(i) - 'a']) {
                return -1;
            }
        }

        int count = b.length() / a.length();
        StringBuilder sb = new StringBuilder(a.repeat(count));
        for (int i = 0; i <= 2; i++) {
            if (sb.indexOf(b) >= 0) {
                return count + i;
            }
            sb.append(a);
        }

        return -1;
    }
}
//Rabin-Karp
class Solution2 {
    static final int kMod1 = 1000000007;
    static final int kMod2 = 1337;

    public int repeatedStringMatch(String a, String b) {
        int an = a.length(), bn = b.length();
        int index = strStr(a, b);
        if (index == -1) {
            return -1;
        }
        if (an - index >= bn) {
            return 1;
        }
        return (bn + index - an - 1) / an + 2;
    }

    public int strStr(String haystack, String needle) {
        int n = haystack.length(), m = needle.length();
        if (m == 0) {
            return 0;
        }

        int k1 = 1000000009;
        int k2 = 1337;
        Random random = new Random();
        int kMod1 = random.nextInt(k1) + k1;
        int kMod2 = random.nextInt(k2) + k2;

        long hashNeedle = 0;
        for (int i = 0; i < m; i++) {
            char c = needle.charAt(i);
            hashNeedle = (hashNeedle * kMod2 + c) % kMod1;
        }
        long hashHaystack = 0, extra = 1;
        for (int i = 0; i < m - 1; i++) {
            hashHaystack = (hashHaystack * kMod2 + haystack.charAt(i % n)) % kMod1;
            extra = (extra * kMod2) % kMod1;
        }
        for (int i = m - 1; (i - m + 1) < n; i++) {
            hashHaystack = (hashHaystack * kMod2 + haystack.charAt(i % n)) % kMod1;
            if (hashHaystack == hashNeedle) {
                return i - m + 1;
            }
            hashHaystack = (hashHaystack - extra * haystack.charAt((i - m + 1) % n)) % kMod1;
            hashHaystack = (hashHaystack + kMod1) % kMod1;
        }
        return -1;
    }
}
//KMP
class Solution1 {
    static final int kMod1 = 1000000007;
    static final int kMod2 = 1337;

    public int repeatedStringMatch(String a, String b) {
        int an = a.length(), bn = b.length();
        int index = strStr(a, b);
        if (index == -1) {
            return -1;
        }
        if (an - index >= bn) {
            return 1;
        }
        return (bn + index - an - 1) / an + 2;
    }

    public int strStr(String haystack, String needle) {
        int n = haystack.length(), m = needle.length();
        if (m == 0) {
            return 0;
        }

        int k1 = 1000000009;
        int k2 = 1337;
        Random random = new Random();
        int kMod1 = random.nextInt(k1) + k1;
        int kMod2 = random.nextInt(k2) + k2;

        long hashNeedle = 0;
        for (int i = 0; i < m; i++) {
            char c = needle.charAt(i);
            hashNeedle = (hashNeedle * kMod2 + c) % kMod1;
        }
        long hashHaystack = 0, extra = 1;
        for (int i = 0; i < m - 1; i++) {
            hashHaystack = (hashHaystack * kMod2 + haystack.charAt(i % n)) % kMod1;
            extra = (extra * kMod2) % kMod1;
        }
        for (int i = m - 1; (i - m + 1) < n; i++) {
            hashHaystack = (hashHaystack * kMod2 + haystack.charAt(i % n)) % kMod1;
            if (hashHaystack == hashNeedle) {
                return i - m + 1;
            }
            hashHaystack = (hashHaystack - extra * haystack.charAt((i - m + 1) % n)) % kMod1;
            hashHaystack = (hashHaystack + kMod1) % kMod1;
        }
        return -1;
    }
}