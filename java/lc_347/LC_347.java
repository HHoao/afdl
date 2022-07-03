package lc_347;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/*
 *@author: �ƺ�
 *@date : 2021��12��17��
 *@todo:347. ǰ K ����ƵԪ��
����һ���������� nums ��һ������ k �����㷵�����г���Ƶ��ǰ k �ߵ�Ԫ�ء�����԰� ����˳�� ���ش𰸡�
*/
public class LC_347 {

}

//��ϣ��
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int n = nums.length;
        for (int i = 0; i < n; i++){
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        PriorityQueue<Integer[]> pq = new PriorityQueue<>((a, b)->b[1]-a[1]);
        int[] ret = new int[k];
        List<Map.Entry<Integer, Integer>> entrys = new ArrayList<>(map.entrySet());
        entrys.sort((a, b)->b.getValue() - a.getValue());
        for (int i = 0; i < k; i++){
            ret[i] = entrys.get(i).getKey();
        }
        return ret;
    }
}
//����+���ȶ���(���)
class Solution1 {
    public int[] topKFrequent(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length;
        PriorityQueue<Integer[]> pq = new PriorityQueue<>((a, b)-> b[1]-a[1]);
        Integer[] numf = new Integer[]{nums[0], 1};
        for (int i = 1; i < n; i++){
            if (nums[i] != nums[i - 1]){
                pq.offer(numf);
                numf = new Integer[]{nums[i], 1};
            }else{
                numf[1]++;
            }
        }
        pq.offer(numf);
        int[] ret = new int[k];
        for (int i = 0; i < k; i++){
            ret[i] = pq.poll()[0];
        }
        return ret;
    }
}
//��ϣ�����С��(���ȶ���)
class Solution2 {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int n = nums.length;
        for (int i = 0; i < n; i++){
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        PriorityQueue<Integer[]> pq = new PriorityQueue<>((a, b)-> b[1]-a[1]);
        for (Map.Entry<Integer, Integer> entrys : map.entrySet()){
            pq.offer(new Integer[]{entrys.getKey(), entrys.getValue()});
        }
        int[] ret = new int[k];
        for (int i = 0; i < k; i++){
            ret[i] = pq.poll()[0];
        }
        return ret;
    }
}