package lc_2034;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.TreeMap;

/*
 *@author: �ƺ�
 *@date : 2022��1��23��
 *@todo:2034. ��Ʊ�۸񲨶�
����һ֧��Ʊ�۸������������������ÿһ����¼����һ�� ʱ��� �͸�ʱ����Ʊ��Ӧ�� �۸� ��

���ɵ��ǣ����ڹ�Ʊ�г����ڵĲ����ԣ���Ʊ�۸��¼���ܲ��ǰ�ʱ��˳�����ġ�ĳЩ����£��еļ�¼�����Ǵ�ġ������������ͬʱ����ļ�¼�������������У�ǰһ����¼��Ϊ�����¼������ֵļ�¼ ���� ǰһ������ļ�¼��

�������һ���㷨��ʵ�֣�

���� ��Ʊ��ĳһʱ����Ĺ�Ʊ�۸������֮ǰͬһʱ����ļ۸���һ������ ���� ֮ǰ�Ĵ���۸�
�ҵ���ǰ��¼�� ���¹�Ʊ�۸� �����¹�Ʊ�۸� ����Ϊʱ�������Ĺ�Ʊ�۸�
�ҵ���ǰ��¼���Ʊ�� ��߼۸� ��
�ҵ���ǰ��¼���Ʊ�� ��ͼ۸� ��
����ʵ�� StockPrice �ࣺ

StockPrice() ��ʼ�����󣬵�ǰ�޹�Ʊ�۸��¼��
void update(int timestamp, int price) ��ʱ��� timestamp ���¹�Ʊ�۸�Ϊ price ��
int current() ���ع�Ʊ ���¼۸� ��
int maximum() ���ع�Ʊ ��߼۸� ��
int minimum() ���ع�Ʊ ��ͼ۸� ��
 

ʾ�� 1��

���룺
["StockPrice", "update", "update", "current", "maximum", "update", "maximum", "update", "minimum"]
[[], [1, 10], [2, 5], [], [], [1, 3], [], [4, 2], []]
�����
[null, null, null, 5, 10, null, 5, null, 2]

���ͣ�
StockPrice stockPrice = new StockPrice();
stockPrice.update(1, 10); // ʱ���Ϊ [1] ����Ӧ�Ĺ�Ʊ�۸�Ϊ [10] ��
stockPrice.update(2, 5);  // ʱ���Ϊ [1,2] ����Ӧ�Ĺ�Ʊ�۸�Ϊ [10,5] ��
stockPrice.current();     // ���� 5 ������ʱ���Ϊ 2 ����Ӧ�۸�Ϊ 5 ��
stockPrice.maximum();     // ���� 10 ����߼۸��ʱ���Ϊ 1 ���۸�Ϊ 10 ��
stockPrice.update(1, 3);  // ֮ǰʱ���Ϊ 1 �ļ۸���󣬼۸����Ϊ 3 ��
                          // ʱ���Ϊ [1,2] ����Ӧ��Ʊ�۸�Ϊ [3,5] ��
stockPrice.maximum();     // ���� 5 ����������߼۸�Ϊ 5 ��
stockPrice.update(4, 2);  // ʱ���Ϊ [1,2,4] ����Ӧ�۸�Ϊ [3,5,2] ��
stockPrice.minimum();     // ���� 2 ����ͼ۸�ʱ���Ϊ 4 ���۸�Ϊ 2 ��
*/
public class LC_2034 {

}
//��ϣ��+�����б�
class StockPrice {
    private Integer lastTimeStamp;
    private Map<Integer, Integer> stockPriceMap;
    private TreeMap<Integer, Set<Integer>> priceRank;
    public StockPrice() {
        stockPriceMap = new HashMap<>();
        priceRank = new TreeMap<>();
        lastTimeStamp = null;
    }
    
    public void update(int timestamp, int price) {
        Integer prePrice = stockPriceMap.get(timestamp);
        if (prePrice != null){
            Set<Integer> timeSet =  priceRank.get(prePrice);
            timeSet.remove(timestamp);
            if (timeSet.isEmpty()){
                priceRank.remove(prePrice);
            }
        }
        lastTimeStamp = lastTimeStamp != null ? Math.max(timestamp, lastTimeStamp) : timestamp;
        stockPriceMap.put(timestamp, price);
        Set<Integer> timeSet = priceRank.get(price);
        if (timeSet == null){
            timeSet = new HashSet<>();
            priceRank.put(price, timeSet);
            timeSet.add(timestamp);
        }else{
            timeSet.add(timestamp);
        }
    }
    
    public int current() {
        return stockPriceMap.get(lastTimeStamp);
    }
    
    public int maximum() {
        return priceRank.lastKey();
    }
    
    public int minimum() {
        return priceRank.firstKey();
    }
}

/**
 * Your StockPrice object will be instantiated and called as such:
 * StockPrice obj = new StockPrice();
 * obj.update(timestamp,price);
 * int param_2 = obj.current();
 * int param_3 = obj.maximum();
 * int param_4 = obj.minimum();
 */
//��ϣ��+������
class StockPrice1 {
    private Integer lastTimeStamp;
    private Map<Integer, Integer> stampMap;
    private PriorityQueue<int[]> minHeap;
    private PriorityQueue<int[]> maxHeap;
    public StockPrice1() {
        lastTimeStamp = 0;
        stampMap = new HashMap<>();
        minHeap = new PriorityQueue<>((a, b)->a[0] - b[0]);
        maxHeap = new PriorityQueue<>((a, b)->b[0] - a[0]);
    }
    
    public void update(int timestamp, int price) {
        stampMap.put(timestamp, price);
        minHeap.offer(new int[]{price, timestamp});
        maxHeap.offer(new int[]{price, timestamp});
        lastTimeStamp = Math.max(timestamp, lastTimeStamp);
    }
    
    public int current() {
        return stampMap.get(lastTimeStamp);
    }
    
    public int maximum() {
        while (true){
            int[] maxPrice = maxHeap.peek();
            if (stampMap.get(maxPrice[1]) == maxPrice[0]){
                return maxPrice[0];
            }else{
                maxHeap.poll();  
            }
        }
    }
    
    public int minimum() {
        while (true){
            int[] minPrice = minHeap.peek();
            if (stampMap.get(minPrice[1]) == minPrice[0]){
                return minPrice[0];
            }else{
                minHeap.poll();  
            }
        }
    }
}

/**
 * Your StockPrice object will be instantiated and called as such:
 * StockPrice obj = new StockPrice();
 * obj.update(timestamp,price);
 * int param_2 = obj.current();
 * int param_3 = obj.maximum();
 * int param_4 = obj.minimum();
 */