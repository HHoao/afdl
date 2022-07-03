package lc_1094;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/*
 *@author: �ƺ�
 *@date : 2022��1��9��
 *@todo:1094. ƴ��
��������һλ˳�糵˾������������� capacity ������λ���������ؿ͡����ڵ�·�����ƣ��� ֻ�� ��һ��������ʻ��Ҳ����˵���������ͷ��ı䷽������Խ�������Ϊһ����������

�����һ�ݳ˿��г̼ƻ��� trips[][]������ trips[i] = [num_passengers, start_location, end_location] �����˵� i ��˿͵��г���Ϣ��

������͵ĳ˿�������
�˿͵��ϳ��ص㣻
�Լ��˿͵��³��ص㡣
��Щ�����ĵص�λ���Ǵ���� ��ʼ ����λ����ǰ��ʻ����Щ�ص�����ľ��루����һ���������ʻ�����ϣ���

������ݸ������г̼ƻ���ͳ��ӵ���λ�������ж���ĳ��Ƿ����˳����ɽ������г˿͵����񣨵��ҽ�������������и������г��н������г˿�ʱ������ true�������뷵�� false����
*/
public class LC_1094 {

}
//�ҵĲ������
class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        int n = trips.length;
        int[] s = new int[1001];
        
        Arrays.sort(trips, (a, b) -> a[1] - b[1]);
        int curS = 0;
        for (int i = 0; i < n; i++){
            while (curS < trips[i][1]){
                curS++;
                if (curS > 0) s[curS] += s[curS - 1];
            }
            s[curS] += trips[i][0];
            s[trips[i][2]] -= trips[i][0];
            if (s[curS] > capacity) return false;
        }
        return true;
    }
}
//�ٷ����
class Solution1 {
    public boolean carPooling(int[][] trips, int capacity) {
        int m = trips.length;
        int max = 0;
        // �ҵ���Զ��վ��
        for(int[] trip : trips){
            max = Math.max(trip[2], max);
        }
        int[] diff = new int[max + 1];
        for(int i = 0; i < m; i++){
            int np = trips[i][0];
            int sl = trips[i][1];
            int el = trips[i][2];
            // �ϳ�
            diff[sl] += np;
            // �³�
            diff[el] -=  np;
        }
        int start = diff[0];
        if(start > capacity) return false;
        // �ж�ÿһʱ���µĳ˿�����
        for(int i = 1; i <= max; i++){
            start = start + diff[i];
            if(start > capacity) return false;
        }
        return true;
    }
}
//С����
class Solution2 {
    public boolean carPooling(int[][] trips, int capacity) {
        //����һ�����³�˳���С����
        PriorityQueue<int[]> heap=new PriorityQueue<>(Comparator.comparingInt(o -> o[2]));
        //���ϳ�˳������
        Arrays.sort(trips, Comparator.comparingInt(o -> o[1]));
        for (int[] trip : trips) {
            //���ϳ�
            capacity -= trip[0];
            //��λ�������³�
            if (capacity < 0) {
                while (!heap.isEmpty() && heap.peek()[2] <= trip[1]) capacity += heap.poll()[0];//���µĶ�����
                if (capacity < 0) return false;//������� ���껹���оͷ���
            }
            //�ӵ�������
            heap.offer(trip);
        }
        return true;
}
}