package lc_1996;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/*
 *@author: �ƺ�
 *@date : 2022��1��28��
 *@todo:1996. ��Ϸ������ɫ������
�����ڲμ�һ�����ɫ��Ϸ��ÿ����ɫ����������Ҫ���ԣ����� �� ���� ������һ����ά�������� properties ������ properties[i] = [attacki, defensei] ��ʾ��Ϸ�е� i ����ɫ�����ԡ�

�������һ��������ɫ�Ĺ����ͷ����ȼ� ���ϸ���� �ý�ɫ�Ĺ����ͷ����ȼ�������Ϊ�ý�ɫΪ ����ɫ ������ʽ�أ������Ϊ��ɫ i ���� ���ڵ���һ����ɫ j ����ô attackj > attacki �� defensej > defensei ��

���� ����ɫ ��������

 

ʾ�� 1��

���룺properties = [[5,5],[6,3],[3,6]]
�����0
���ͣ������ڹ����ͷ������ϸ����������ɫ�Ľ�ɫ��
ʾ�� 2��

���룺properties = [[2,2],[3,3]]
�����1
���ͣ���һ����ɫ������ɫ����Ϊ�ڶ�����ɫ�Ĺ����ͷ����ϸ���ڸý�ɫ��
*/
public class LC_1996 {

}
//������ʱ
class Solution {
    public int numberOfWeakCharacters(int[][] properties) {
        int n = properties.length;
        int ans = 0;
        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                if (properties[i][0] < properties[j][0] && properties[i][1] < properties[j][1]){
                    ans++;
                    break;
                }
            }
        }
        return ans;
    }
}
//����
class Solution1 {
    public int numberOfWeakCharacters(int[][] properties) {
        Arrays.sort(properties, (a, b)->a[0] == b[0] ? a[1] - b[1] : b[0] - a[0]);
        int maxDef = 0;
        int ans = 0;
        for (int[] property : properties){
            if (property[1] < maxDef){
                ans++;
            }else{
                maxDef = property[1];
            }
        }
        return ans;
    }
}
//����ջ
class Solution3 {
    public int numberOfWeakCharacters(int[][] properties) {
        Arrays.sort(properties, (o1, o2) -> {
            return o1[0] == o2[0] ? (o2[1] - o1[1]) : (o1[0] - o2[0]);
        });
        int ans = 0;
        Deque<Integer> st = new ArrayDeque<Integer>();
        for (int[] p : properties) {
            while (!st.isEmpty() && st.peek() < p[1]) {
                st.pop();
                ans++;
            }
            st.push(p[1]);
        }
        return ans;
    }
}