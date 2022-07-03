package lc_207;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author �ƺ�
 *207. �γ̱�
�����ѧ�ڱ���ѡ�� numCourses �ſγ̣���Ϊ 0 �� numCourses - 1 ��

��ѡ��ĳЩ�γ�֮ǰ��ҪһЩ���޿γ̡� ���޿γ̰����� prerequisites ���������� prerequisites[i] = [ai, bi] ����ʾ���Ҫѧϰ�γ� ai �� ���� ��ѧϰ�γ�  bi ��

���磬���޿γ̶� [0, 1] ��ʾ����Ҫѧϰ�γ� 0 ������Ҫ����ɿγ� 1 ��
�����ж��Ƿ����������пγ̵�ѧϰ��������ԣ����� true �����򣬷��� false ��
 */
public class LC_207 {

}
//����������� //��������
class Solution {
    List<List<Integer>> edges;
    int[] visited;
    boolean valid = true;

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        edges = new ArrayList<List<Integer>>();
        for (int i = 0; i < numCourses; ++i) {
            edges.add(new ArrayList<Integer>());
        }
        visited = new int[numCourses];
        for (int[] info : prerequisites) {
            edges.get(info[1]).add(info[0]);
        }
        for (int i = 0; i < numCourses && valid; ++i) {
            if (visited[i] == 0) {
                dfs(i);
            }
        }
        return valid;
    }

    public void dfs(int u) {
        visited[u] = 1;
        for (int v: edges.get(u)) {
            if (visited[v] == 0) {
                dfs(v);
                if (!valid) {
                    return;
                }
            } else if (visited[v] == 1) {
                valid = false;
                return;
            }
        }
        visited[u] = 2;
    }
}
//����������� ��������
class Solution1 {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> courses = new ArrayList<>();
        int visited = 0;
        int[] degree = new int[numCourses];
        Deque<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < numCourses; i++){
            courses.add(new ArrayList<>());
        }
        for (int[] info : prerequisites){
            courses.get(info[1]).add(info[0]);
            degree[info[0]]++;
        }
        for (int i = 0; i < numCourses; i++){
            if (degree[i] == 0){
                queue.offer(i);
            }
        }
        while (!queue.isEmpty()){
            visited++;
            int v = queue.poll();
            for (int k :courses.get(v)){
                degree[k]--;
                if (degree[k] == 0){
                    queue.offer(k);
                }
            }
        }
        return visited == numCourses;
    }
}
//�ҵĴ���
class Solution2 {
    private boolean[] visited;
    private Map<Integer, List<Integer>> courseMap;
    private Map<Integer, Integer> indexMap;
    private boolean[] canStu;
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        visited = new boolean[numCourses];
        courseMap = new HashMap<>();
        indexMap = new HashMap<>();
        canStu = new boolean[numCourses];
        int n = prerequisites.length;
        for (int i = 0; i < n; i++){
            int pre = prerequisites[i][0];
            int post = prerequisites[i][1];
            if (pre == post) return false;
            List<Integer> list = courseMap.getOrDefault(pre, new ArrayList<>());
            list.add(post);
            courseMap.put(pre, list);
            indexMap.put(pre, i);
        }
        for (int i = 0; i < n; i++){
            if (!dfs(numCourses, i, prerequisites)){
                return false;
            }
        }
        return true;
    }
    public boolean dfs(int numCourses, int n, int[][] prerequisites){
        if (visited[prerequisites[n][1]] == true) return false;
        if (!courseMap.containsKey(prerequisites[n][1]) || canStu[prerequisites[n][0]] == true) return true;
        
        int cur = prerequisites[n][0];
        List<Integer> temp = courseMap.get(cur);
        int size = temp.size();
        for (int i = 0; i < size; i++){
            int pre = temp.get(i);
            if (courseMap.containsKey(pre)){
                int index = indexMap.get(pre);
                visited[cur] = true;
                canStu[cur] = dfs(numCourses, index, prerequisites);
                visited[cur] = false;
                if (!canStu[cur]) return false;
            }
        }
        return true;
    }
}