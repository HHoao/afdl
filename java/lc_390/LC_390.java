package lc_390;

/*
 *@author: �ƺ�
 *@date : 2022��1��2��
 *@todo:390. ������Ϸ
����һ����1 �� n ����������б�
���ȣ������ң��ӵ�һ�����ֿ�ʼ��ÿ��һ�����ֽ���ɾ����ֱ���б��ĩβ��
�ڶ�������ʣ�µ������У����ҵ��󣬴ӵ�����һ�����ֿ�ʼ��ÿ��һ�����ֽ���ɾ����ֱ���б�ͷ��
���ǲ����ظ��������������Һʹ��ҵ�������У�ֱ��ֻʣ��һ�����֡�
���س���Ϊ n ���б��У����ʣ�µ����֡�
ʾ����

����:
n = 9,
1 2 3 4 5 6 7 8 9
2 4 6 8
2 6
6

���:
6
*/
public class LC_390 {

}
//ģ��
class Solution {
    public int lastRemaining(int n) {
        int l = 1, r = n;
        int tier = 1;
        int spite = 1;
        while (l < r){
            l = tier == 1 ? l + spite : (r - spite - (r - l - spite) / (spite * 2) * spite * 2);
            r = tier == 0 ? r - spite : (l + (r - l) / (spite * 2) * spite * 2);
            tier = (tier +1) % 2;
            spite*=2;
        }
        return l;
    }
}
//�ٷ�ģ��
class Solution1 {
    public int lastRemaining(int n) {
        int a1 = 1;
        int k = 0, cnt = n, step = 1;
        while (cnt > 1) {
            if (k % 2 == 0) { // ����
                a1 = a1 + step;
            } else { // ����
                a1 = (cnt % 2 == 0) ? a1 : a1 + step;
            }
            k++;
            cnt = cnt >> 1;
            step = step << 1;
        }
        return a1;
    }
}