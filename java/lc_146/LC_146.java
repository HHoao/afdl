package lc_146;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author �ƺ�
 *146. LRU �������
�����������յ����ݽṹ����ƺ�ʵ��һ��  LRU (�������ʹ��) ������� ��
ʵ�� LRUCache �ࣺ

LRUCache(int capacity) ����������Ϊ���� capacity ��ʼ�� LRU ����
int get(int key) ����ؼ��� key �����ڻ����У��򷵻عؼ��ֵ�ֵ�����򷵻� -1 ��
void put(int key, int value) ����ؼ����Ѿ����ڣ�����������ֵ������ؼ��ֲ����ڣ��������顸�ؼ���-ֵ���������������ﵽ����ʱ����Ӧ����д��������֮ǰɾ�����δʹ�õ�����ֵ���Ӷ�Ϊ�µ�����ֵ�����ռ䡣
 

���ף����Ƿ������ O(1) ʱ�临�Ӷ�����������ֲ�����
 */
public class LC_146 {

}
class LRUCache extends LinkedHashMap<Integer, Integer>{
    private int capacity;
    
    public LRUCache(int capacity) {
        super(capacity, 0.75F, true);
        this.capacity = capacity;
    }

    public int get(int key) {
        return super.getOrDefault(key, -1);
    }

    public void put(int key, int value) {
        super.put(key, value);
    }
    protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
        return size() > capacity; 
    }
}
