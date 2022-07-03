package lc_126;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 * @author �ƺ�
 *126. ���ʽ��� II
�����������ʣ�beginWord �� endWord����һ���ֵ� wordList���ҳ����д� beginWord �� endWord �����ת�����С�ת������ѭ���¹���

ÿ��ת��ֻ�ܸı�һ����ĸ��
ת����õ��ĵ��ʱ������ֵ��еĵ��ʡ�
˵��:

���������������ת�����У�����һ�����б�
���е��ʾ�����ͬ�ĳ��ȡ�
���е���ֻ��Сд��ĸ��ɡ�
�ֵ��в������ظ��ĵ��ʡ�
����Լ��� beginWord �� endWord �Ƿǿյģ��Ҷ��߲���ͬ��
 */
public class LC_126 {
	public static void main(String[] args) {
        List<String> wordList = new ArrayList<>();
        wordList.add("hot");
        wordList.add("dot");
        wordList.add("dog");
        wordList.add("lot");
        wordList.add("log");
        wordList.add("cog");


        Solution solution = new Solution();
        String beginWord = "hit";
        String endWord = "cog";
        List<List<String>> res = solution.findLadders(beginWord, endWord, wordList);
        System.out.println(res);
    }
}
//�����������//��ͼ
class Solution {
    private static final int INF = 1 << 20;
    private Map<String, Integer> wordId; // ���ʵ�id��ӳ��
    private ArrayList<String> idWord; // id�����ʵ�ӳ��
    private ArrayList<Integer>[] edges; // ͼ�ı�

    public Solution() {
        wordId = new HashMap<>();
        idWord = new ArrayList<>();
    }

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        int id = 0;
        // ��wordList���е��ʼ���wordId�� ��ͬ��ֻ����һ�� // ��Ϊÿһ�����ʷ���һ��id
        for (String word : wordList) {
            if (!wordId.containsKey(word)) { 
                wordId.put(word, id++);
                idWord.add(word);
            }
        }
        // ��endWord����wordList�� ���޽�
        if (!wordId.containsKey(endWord)) {
            return new ArrayList<>();
        }
        // ��beginWordҲ����wordId��
        if (!wordId.containsKey(beginWord)) {
            wordId.put(beginWord, id++);
            idWord.add(beginWord);
        }

        // ��ʼ������õ�����
        edges = new ArrayList[idWord.size()];
        for (int i = 0; i < idWord.size(); i++) {
            edges[i] = new ArrayList<>();
        }
        // ��ӱ�
        for (int i = 0; i < idWord.size(); i++) {
            for (int j = i + 1; j < idWord.size(); j++) {
                // �����߿���ͨ��ת���õ� �������Ǽ佨һ�������
                if (transformCheck(idWord.get(i), idWord.get(j))) {
                    edges[i].add(j);
                    edges[j].add(i);
                }
            }
        }

        int dest = wordId.get(endWord); // Ŀ��ID
        List<List<String>> res = new ArrayList<>(); // ���
        int[] cost = new int[id]; // ��ÿ����Ĵ���
        for (int i = 0; i < id; i++) {
            cost[i] = INF; // ÿ����Ĵ��۳�ʼ��Ϊ�����
        }

        // ����������� ������cost��Ϊ0
        Queue<ArrayList<Integer>> q = new LinkedList<>();
        ArrayList<Integer> tmpBegin = new ArrayList<>();
        tmpBegin.add(wordId.get(beginWord));
        q.add(tmpBegin);
        cost[wordId.get(beginWord)] = 0;

        // ��ʼ�����������
        while (!q.isEmpty()) {
            ArrayList<Integer> now = q.poll();
            int last = now.get(now.size() - 1); // ������ʵĵ�
            if (last == dest) { // ���õ�Ϊ�յ���������res��
                ArrayList<String> tmp = new ArrayList<>();
                for (int index : now) {
                    tmp.add(idWord.get(index)); // ת��Ϊ��Ӧ��word
                }
                res.add(tmp);
            } else { // �õ㲻Ϊ�յ� ��������
                for (int i = 0; i < edges[last].size(); i++) {
                    int to = edges[last].get(i);
                    // �˴�<=Ŀ�����ڰѴ�����ͬ�Ĳ�ͬ·��ȫ����������
                    if (cost[last] + 1 <= cost[to]) {
                        cost[to] = cost[last] + 1;
                        // ��to����·����
                        ArrayList<Integer> tmp = new ArrayList<>(now); tmp.add(to);
                        q.add(tmp); // �����·���������
                    }
                }
            }
        }
        return res;
    }

    // �����ַ����Ƿ����ͨ���ı�һ����ĸ�����
    boolean transformCheck(String str1, String str2) {
        int differences = 0;
        for (int i = 0; i < str1.length() && differences < 2; i++) {
            if (str1.charAt(i) != str2.charAt(i)) {
                ++differences;
            }
        }
        return differences == 1;
    } 
}
//˫��ͼ
class Solution1 {

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        // �Ƚ� wordList �ŵ���ϣ��������ж�ĳ�������Ƿ��� wordList ��
        List<List<String>> res = new ArrayList<>();
        Set<String> wordSet = new HashSet<>(wordList);
        if (wordSet.size() == 0 || !wordSet.contains(endWord)) {
            return res;
        }
        // �� 1 ����ʹ��˫�������ȱ����õ���̽���б� successors
        // key���ַ�����value��������ȱ��������� key �ĺ�̽���б�
        Map<String, Set<String>> successors = new HashMap<>();
        boolean found = bidirectionalBfs(beginWord, endWord, wordSet, successors);
        if (!found) {
            return res;
        }
        // �� 2 �������ں�̽���б� successors ��ʹ�û����㷨�õ��������·���б�
        Deque<String> path = new ArrayDeque<>();
        path.addLast(beginWord);
        dfs(beginWord, endWord, successors, path, res);
        return res;
    }

    private boolean bidirectionalBfs(String beginWord,
                                     String endWord,
                                     Set<String> wordSet,
                                     Map<String, Set<String>> successors) {
        // ��¼���ʹ��ĵ���
        Set<String> visited = new HashSet<>();
        visited.add(beginWord);
        visited.add(endWord);

        Set<String> beginVisited = new HashSet<>();
        beginVisited.add(beginWord);
        Set<String> endVisited = new HashSet<>();
        endVisited.add(endWord);

        int wordLen = beginWord.length();
        boolean forward = true;
        boolean found = false;
        // �ڱ�֤�� beginVisited ���ǽ�С�����Ե��ڣ���С�ļ���ǰ���£�&& !endVisited.isEmpty() ����ʡ��
        while (!beginVisited.isEmpty() && !endVisited.isEmpty()) {
            // һֱ��֤ beginVisited ����Խ�С�ļ��ϣ������������
            if (beginVisited.size() > endVisited.size()) {
                Set<String> temp = beginVisited;
                beginVisited = endVisited;
                endVisited = temp;

                // ֻҪ�������͸��ķ����Ա�ά�� successors �Ķ���
                forward = !forward;
            }
            Set<String> nextLevelVisited = new HashSet<>();
            // Ĭ�� beginVisited ��С���ϣ���˴� beginVisited ����
            for (String currentWord : beginVisited) {
                char[] charArray = currentWord.toCharArray();
                for (int i = 0; i < wordLen; i++) {
                    char originChar = charArray[i];
                    for (char j = 'a'; j <= 'z'; j++) {
                        if (charArray[i] == j) {
                            continue;
                        }
                        charArray[i] = j;
                        String nextWord = new String(charArray);
                        if (wordSet.contains(nextWord)) {
                            if (endVisited.contains(nextWord)) {
                                found = true;
                                // ����һ���ҵ������Ժ󣬻������һ���ϵ��ӵ�����̽���б�
                                addToSuccessors(successors, forward, currentWord, nextWord);
                            }

                            if (!visited.contains(nextWord)) {
                                nextLevelVisited.add(nextWord);
                                addToSuccessors(successors, forward, currentWord, nextWord);
                            }
                        }
                    }
                    charArray[i] = originChar;
                }
            }
            beginVisited = nextLevelVisited;
            visited.addAll(nextLevelVisited);
            if (found) {
                break;
            }
        }
        return found;
    }

    private void dfs(String beginWord,
                     String endWord,
                     Map<String, Set<String>> successors,
                     Deque<String> path,
                     List<List<String>> res) {

        if (beginWord.equals(endWord)) {
            res.add(new ArrayList<>(path));
            return;
        }

        if (!successors.containsKey(beginWord)) {
            return;
        }

        Set<String> successorWords = successors.get(beginWord);
        for (String successor : successorWords) {
            path.addLast(successor);
            dfs(successor, endWord, successors, path, res);
            path.removeLast();
        }
    }

    private void addToSuccessors(Map<String, Set<String>> successors, boolean forward,
                                 String currentWord, String nextWord) {
        if (!forward) {
            String temp = currentWord;
            currentWord = nextWord;
            nextWord = temp;
        }

        // Java 1.8 �Ժ�֧��
        successors.computeIfAbsent(currentWord, a -> new HashSet<>());
        successors.get(currentWord).add(nextWord);
    }


    
}