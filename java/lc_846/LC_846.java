package lc_846;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
 *@author: �ƺ�
 *@date : 2021��12��30��
 *@todo:846. һ��˳��
Alice ������һ���ƣ�����Ҫ����������Щ�ƣ��ֳ������飬ʹÿһ����������� groupSize �������� groupSize ������������ɡ�

����һ���������� hand ���� hand[i] ��д�ڵ� i ���ƣ���һ������ groupSize ���������������������Щ�ƣ����� true �����򣬷��� false ��
*/
public class LC_846 {

}
class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        int n = hand.length;
        if (n % groupSize != 0) return false;
        Map<Integer, Integer> map = new HashMap<>();
        Arrays.sort(hand);
        for (int i = 0; i < n; i++){
            map.put(hand[i], map.getOrDefault(hand[i], 0) + 1);
        }
        
        for (int i = 0; i < n; i++){
            if (map.containsKey(hand[i])){
                for (int j = 0; j < groupSize; j++){
                    if (map.containsKey(hand[i]+j)){
                        int count = map.get(hand[i] + j);
                        if (count - 1 != 0){
                            map.put(hand[i] + j, map.get(hand[i] + j) - 1);
                        }else{
                            map.remove(hand[i] +j);
                        }
                    }else{
                        return false;
                    }
                }
            }
        }
        return true;
    }
}