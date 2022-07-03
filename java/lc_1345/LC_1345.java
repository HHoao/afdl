package lc_1345;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 *@author: �ƺ�
 *@date : 2022��1��21��
 *@todo:1345. ��Ծ��Ϸ IV
����һ���������� arr ����һ��ʼ������ĵ�һ��Ԫ�ش����±�Ϊ 0����

ÿһ��������Դ��±� i �����±꣺

i + 1 ���㣺i + 1 < arr.length
i - 1 ���㣺i - 1 >= 0
j ���㣺arr[i] == arr[j] �� i != j
���㷵�ص����������һ��Ԫ�ص��±괦����� ���ٲ������� ��

ע�⣺�κ�ʱ���㶼���������������档

 

ʾ�� 1��

���룺arr = [100,-23,-23,404,100,23,23,23,3,404]
�����3
���ͣ�������Ҫ��Ծ 3 �Σ��±�����Ϊ 0 --> 4 --> 3 --> 9 ���±� 9 Ϊ��������һ��Ԫ�ص��±ꡣ
ʾ�� 2��

���룺arr = [7]
�����0
���ͣ�һ��ʼ�������һ��Ԫ�ش��������㲻��Ҫ��Ծ��
ʾ�� 3��

���룺arr = [7,6,9,6,9,6,9,7]
�����1
���ͣ������ֱ�Ӵ��±� 0 �������±� 7 ����Ҳ������������һ��Ԫ�ش���
*/
public class LC_1345 {

}
//�ҵ����(��ʱ)
class Solution {
    public int minJumps(int[] arr) {
        int n = arr.length;
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++){
            map.putIfAbsent(arr[i], new ArrayList<>());
            map.get(arr[i]).add(i);
        }
        boolean[] visited = new boolean[n];
        Deque<Integer> deque = new ArrayDeque<>();
        deque.offer(0);
        visited[0] = true;
        int ans = 0;
        while (!deque.isEmpty()){
            int size = deque.size();
            for (int i = 0; i < size; i++){
                int curIndex = deque.poll();
                if (curIndex == n - 1) return ans;
                List<Integer> canJumpList = map.get(arr[curIndex]);
                for (Integer point : canJumpList){
                    if (visited[point]) continue;
                    deque.offer(point);
                }
                if (curIndex - 1 >= 0 && !visited[curIndex - 1]) deque.offer(curIndex - 1);
                if (curIndex + 1 < arr.length && !visited[curIndex + 1]) deque.offer(curIndex + 1);
            }
            ans++;
        }
        return ans;
    }
}
//�Ż�
class Solution1 {
    public int minJumps(int[] arr) {
        int n = arr.length;
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++){
            map.putIfAbsent(arr[i], new ArrayList<>());
            map.get(arr[i]).add(i);
        }
        boolean[] visited = new boolean[n];
        Deque<Integer> deque = new ArrayDeque<>();
        deque.offer(0);
        visited[0] = true;
        int ans = 0;
        while (!deque.isEmpty()){
            int size = deque.size();
            for (int i = 0; i < size; i++){
                int curIndex = deque.poll();
                if (curIndex == n - 1) return ans;
                if (map.containsKey(arr[curIndex])){ //����һ�����
                    List<Integer> canJumpList = map.get(arr[curIndex]);
                    for (Integer point : canJumpList){
                        if (visited[point]) continue;
                        deque.offer(point);
                        visited[point] = true;
                    }
                    map.remove(arr[curIndex]);
                }
                if (curIndex - 1 >= 0 && !visited[curIndex - 1]) {
                    deque.offer(curIndex - 1);
                    visited[curIndex - 1] = true;
                }
                if (curIndex + 1 < arr.length && !visited[curIndex + 1]) {
                    deque.offer(curIndex + 1);
                    visited[curIndex + 1] = true;
                }
            }
            ans++;
        }
        return ans;
    }
}
//���˶�����if��һ��
class Solution2 {
    public int minJumps(int[] arr) {
        int n = arr.length;
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++){
            map.putIfAbsent(arr[i], new ArrayList<>());
            map.get(arr[i]).add(i);
        }
        boolean[] visited = new boolean[n];
        Deque<Integer> deque = new ArrayDeque<>();
        deque.offer(0);
        visited[0] = true;
        int ans = 0;
        while (!deque.isEmpty()){
            int size = deque.size();
            for (int i = 0; i < size; i++){
                int curIndex = deque.poll();
                if (curIndex == n - 1) return ans;
                if (map.containsKey(arr[curIndex])){
                    List<Integer> canJumpList = map.get(arr[curIndex]);
                    for (Integer point : canJumpList){
                        if (point == arr.length - 1) {
                            return ans + 1;
                        }
                        if (visited[point]) continue;
                        deque.offer(point);
                        visited[point] = true;
                    }
                    map.remove(arr[curIndex]);
                }
                if (curIndex - 1 >= 0 && !visited[curIndex - 1]) {
                    deque.offer(curIndex - 1);
                    visited[curIndex - 1] = true;
                }
                if (curIndex + 1 < arr.length && !visited[curIndex + 1]) {
                    if (curIndex + 1 == arr.length - 1) {
                        return ans + 1;
                    }
                    deque.offer(curIndex + 1);
                    visited[curIndex + 1] = true;
                }
            }
            ans++;
        }
        return ans;
    }
}