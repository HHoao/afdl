package lc_769;

/*
 *@author: �ƺ�
 *@date : 2022��1��24��
 *@todo:769. ������������Ŀ�
����arr��[0, 1, ..., arr.length - 1]��һ�����У����ǽ��������ָ�ɼ������顱��������Щ��ֱ��������֮��������������ʹ�����ӵĽ���Ͱ�����������ԭ������ͬ��

��������ܽ�����ֳɶ��ٿ飿

ʾ�� 1:

����: arr = [4,3,2,1,0]
���: 1
����:
������ֳ�2����߸���飬���޷��õ�����Ľ����
���磬�ֳ� [4, 3], [2, 1, 0] �Ľ���� [3, 4, 0, 1, 2]���ⲻ����������顣
ʾ�� 2:

����: arr = [1,0,2,3,4]
���: 4
����:
���ǿ��԰����ֳ����飬���� [1, 0], [2, 3, 4]��
Ȼ�����ֳ� [1, 0], [2], [3], [4] ���Եõ����Ŀ�����
*/
public class LC_769 {

}
//̰��
class Solution {
    public int maxChunksToSorted(int[] arr) {
        int n = arr.length;
        int start = 0, end = 0;
        boolean[] visited = new boolean[n + 1];
        int ans = 0;
        for (int i = 0; i < n; i++){
            visited[arr[i]] = true;
            end = Math.max(end, arr[i]);
            while (visited[start]){
                if (start == end){
                    ans++;
                }
                start++;
            }
        }
        return ans;
    }
}
//�ٷ�
class Solution1 {
    public int maxChunksToSorted(int[] arr) {
        int ans = 0, max = 0;
        for (int i = 0; i < arr.length; ++i) {
            max = Math.max(max, arr[i]);
            //max==iʱ˵��ǰ��պ���0��i��������
            if (max == i) ans++;
        }
        return ans;
    }
}
