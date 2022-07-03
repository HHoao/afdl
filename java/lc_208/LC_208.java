package lc_208;

import java.util.HashSet;
import java.util.Set;

/**
 * @author �ƺ�
 *208. ʵ�� Trie (ǰ׺��)
Trie���������� "try"������˵ ǰ׺�� ��һ���������ݽṹ�����ڸ�Ч�ش洢�ͼ����ַ������ݼ��еļ�����һ���ݽṹ���൱���Ӧ���龰�������Զ������ƴд��顣

����ʵ�� Trie �ࣺ

Trie() ��ʼ��ǰ׺������
void insert(String word) ��ǰ׺���в����ַ��� word ��
boolean search(String word) ����ַ��� word ��ǰ׺���У����� true�������ڼ���֮ǰ�Ѿ����룩�����򣬷��� false ��
boolean startsWith(String prefix) ���֮ǰ�Ѿ�������ַ��� word ��ǰ׺֮һΪ prefix ������ true �����򣬷��� false ��
 */
public class LC_208 {

}
//�ҵĴ���
class Trie {
    private Set<String> dic;
    /** Initialize your data structure here. */
    public Trie() {
        this.dic = new HashSet<String>();
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        dic.add(word);
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        return dic.contains(word);
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        for (String str : dic){
            if (str.startsWith(prefix)){
                return true;
            }
        }
        return false;
    }
}
//����
class Trie1 {
    public  Trie1[] tries;
    public  boolean isEnd;

    public Trie1() {
        this.tries = new Trie1[26];
        this.isEnd = false;
    }
    
    public void insert(String word) {
        Trie1 trie = this;
        int n = word.length();
        for (int i = 0; i < n; i++){
            char ch = word.charAt(i);
            int index=  ch - 'a';
            if (trie.tries[index] == null) 
                trie.tries[index] = new Trie1();
            trie = trie.tries[index];
        }
        trie.isEnd = true;
    }
    
    public boolean search(String word) {
        Trie1 trie = this;
        int n = word.length();
        for (int i = 0; i < n; i++){
            int index = word.charAt(i) - 'a';
            if (trie.tries[index] == null){
                return false;
            }
            trie = trie.tries[index];
        }
        return trie.isEnd;
    }
    
    public boolean startsWith(String prefix) {
        Trie1 trie = this;
        int n = prefix.length();
        for (int i = 0; i < n; i++){
            int index = prefix.charAt(i) - 'a';
            if (trie.tries[index] == null){
                return false;
            }
            trie = trie.tries[index];
        }
        return true;
    }
}
//�ٷ�
class Trie2 {
    private Trie2[] children;
    private boolean isEnd;

    public Trie2() {
        children = new Trie2[26];
        isEnd = false;
    }
    
    public void insert(String word) {
        Trie2 node = this;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            int index = ch - 'a';
            if (node.children[index] == null) {
                node.children[index] = new Trie2();
            }
            node = node.children[index];
        }
        node.isEnd = true;
    }
    
    public boolean search(String word) {
        Trie2 node = searchPrefix(word);
        return node != null && node.isEnd;
    }
    
    public boolean startsWith(String prefix) {
        return searchPrefix(prefix) != null;
    }

    private Trie2 searchPrefix(String prefix) {
        Trie2 node = this;
        for (int i = 0; i < prefix.length(); i++) {
            char ch = prefix.charAt(i);
            int index = ch - 'a';
            if (node.children[index] == null) {
                return null;
            }
            node = node.children[index];
        }
        return node;
    }
}