package lc_1307;

import java.util.Arrays;

/*
 *@author: �ƺ�
 *@date : 2021��12��21��
 *@todo:1307. ��������
����һ�����̣������ words ��ʾ���ұ��� result ��ʾ��

����Ҫ�������¹����鷽���Ƿ�ɽ⣺

ÿ���ַ����ᱻ�����һλ���֣�0 - 9����
ÿ�Բ�ͬ���ַ�����ӳ�䵽��ͬ�����֡�
ÿ�� words[i] �� result ���ᱻ�����һ��û��ǰ��������֡�
�������֮�ͣ�words�������Ҳ����֣�result���� 
������̿ɽ⣬���� True�����򷵻� False��
*/
public class LC_1307 {

}
class Solution {
    int[] c2N = new int[26]; //char to num
    int[] n2C = new int[10]; //num to char
    boolean[] not0 = new boolean[26]; //��Ϊ0����ĸ
    public boolean isSolvable(String[] words, String result) {
        int maxWord = 1;
        for (String word : words) {
            //��¼����Ϊǰ�������ĸ
            if (word.length() > 1) {
                not0[word.charAt(0) - 'A'] = true;
            } 
            maxWord = Math.max(maxWord, word.length());
            //�������word���ȴ���result���ȣ��޽�
            if (word.length() > result.length()) {
                return false;
            }
        }
        //���word����+1С��result���ȣ��޽�
        if (maxWord + 1 < result.length()) {
            return false;
        }
        //��¼����Ϊǰ�������ĸ
        if (result.length() > 1) {
            not0[result.charAt(0) - 'A'] = true;
        }
        Arrays.fill(c2N, -1);
        Arrays.fill(n2C, -1);
        return dfs(words, result, 0, 0, 0);
    }

    public boolean dfs(String[] words, String result, int wordIdx, int pos, int x) { //wordIdxΪ��ǰ��������word������posΪ�Ѿ�У��͵ĵ��������� xΪ��λ
        //������result��һλ֮ǰ������λΪ0��ǡ���ҵ���
        if (pos == result.length()) {
            return x == 0;
        }

        //������һ��words��
        if (wordIdx == words.length) {
            //����word����posλ�õ����ֺ�
            int sum = x;
            for (String word : words) {
                //���word���Ȳ�����ֱ������
                if (word.length() > pos) {
                    sum += c2N[word.charAt(word.length() - 1 - pos) - 'A'];
                }
            }
            int num = sum % 10;
            char c = result.charAt(result.length() - 1 - pos);
            //result����posλ�õ���ĸ�Ѿ���ӳ�䣬��������num
            if (c2N[c - 'A'] != -1) {
                if (c2N[c - 'A'] == num) {
                    //wordidx�ص�0�� pos��ǰ��һ������λ����Ϊsum / 10
                    return dfs(words, result, 0, pos + 1, sum / 10);
                }
                return false; 
            } else {
                //���num�Ѿ���������ĸӳ�䣬�޽�
                if (n2C[num] != -1) {
                    return false;
                }
                //result����posλ�õ���ĸӳ��Ϊnum
                c2N[c - 'A'] = num;
                n2C[num] = (int) c;
                boolean check = dfs(words, result, 0, pos + 1, sum / 10);
                if (check) {
                    return true;
                }
                n2C[num] = -1;
                c2N[c - 'A'] = -1;
                return false;
            }
        } else { //��ĳһ��words�ı�����
            String word = words[wordIdx];
            //��ǰword���Ȳ��㣬wordidx��ǰ��һ��
            if (word.length() <= pos) {
                return dfs(words, result, wordIdx + 1, pos, x);
            } else {
                char c = word.charAt(word.length() - 1 - pos);
                //word�ڵ���posλ���Ѿ���ӳ��
                if (c2N[c - 'A'] != -1) {
                    return dfs(words, result, wordIdx + 1, pos, x);
                } else {
                    //�����λ����ĸ����Ϊ0��������1~9��Ϊ�����
                    if (not0[c - 'A']) {
                        for (int i = 1; i < 10; i++) {
                            if (n2C[i] == -1) {
                                n2C[i] = c;
                                c2N[c - 'A'] = i;
                                //wordIdx��ǰ��һ����pos����
                                boolean check = dfs(words, result, wordIdx + 1, pos, x);
                                if (check) {
                                    return true;
                                }
                                c2N[c - 'A'] = -1;
                                n2C[i] = -1;
                            }
                        }
                    } else {
                        //��0-9��Ϊ�����
                        for (int i = 0; i < 10; i++) {
                            if (n2C[i] == -1) {
                                n2C[i] = c;
                                c2N[c - 'A'] = i;
                                boolean check = dfs(words, result, wordIdx + 1, pos, x);
                                if (check) {
                                    return true;
                                }
                                c2N[c - 'A'] = -1;
                                n2C[i] = -1;
                            }
                        }
                    }
                }
            }
        }
        //���з�����������
        return false;
    }
}