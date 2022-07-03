package lc_544;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/*
 *@author: �ƺ�
 *@date : 2021��5��2��
 *@todo:554. שǽ
�����ǰ��һ�¾��εġ��� n ��ש����ɵ�שǽ����Щש��߶���ͬ��Ҳ����һ����λ�ߣ����ǿ�Ȳ�ͬ��ÿһ��ש��Ŀ��֮��Ӧ����ȡ�

������Ҫ��һ�� �Զ����� �ġ����� ���� ש��Ĵ��ߡ�����㻭����ֻ�Ǵ�ש��ı�Ե�������Ͳ��㴩�����ש���㲻������ǽ��������ֱ��Ե֮һ���ߣ�������Ȼ��û�д���һ��ש�ġ�

����һ����ά���� wall ��������������ǽ�������Ϣ�����У�wall[i] ��һ�������������ÿ��ש�Ŀ�ȵ����顣����Ҫ�ҳ�����������ʹ������ ������ש���������� �����ҷ��� ������ש������ ��
*/
public class LC_544 {

}
//�ҵĴ���
class Solution {
    public int leastBricks(List<List<Integer>> wall) {
        int n = wall.size();
        TreeMap<Integer, Integer> brickMap = new TreeMap<>((a, b) -> a - b);
        for (int i = 0; i < n; i++){
            List<Integer> subWall = wall.get(i);
            int sum = 0;
            for (int j = 0; j < subWall.size() - 1; j++){
                int size = subWall.get(j);
                sum += size;
                int col = brickMap.getOrDefault(sum, 0);
                brickMap.put(sum, col+1);
            }
        }
        if (brickMap.isEmpty()) return n;
        List<Map.Entry<Integer, Integer>> enL = new ArrayList<>(brickMap.entrySet());
        Collections.sort(enL, new Comparator<Map.Entry<Integer, Integer>>(){
            public int compare(Map.Entry<Integer, Integer> m1, Map.Entry<Integer, Integer> m2){
                return m2.getValue() - m1.getValue();
            }
        });
        return n - enL.get(0).getValue();
    }
}
//�ٷ�
class Solution1 {
    public int leastBricks(List<List<Integer>> wall) {
        Map<Integer, Integer> cnt = new HashMap <Integer, Integer>();
        for (List<Integer> widths : wall) {
            int n = widths.size();
            int sum = 0;
            for (int i = 0; i < n - 1; i++) {
                sum += widths.get(i);
                cnt.put(sum, cnt.getOrDefault(sum, 0) + 1);
            }
        }
        int maxCnt = 0;
        for (Map.Entry<Integer, Integer> entry : cnt.entrySet()) {
            maxCnt = Math.max(maxCnt, entry.getValue());
        }
        return wall.size() - maxCnt;
    }
}