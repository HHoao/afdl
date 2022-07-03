package lc_1310;

/*
 *@author: �ƺ�
 *@date : 2022��1��17��
 *@todo:1310. ����������ѯ
��һ������������ arr���ָ���һ����Ӧ�Ĳ�ѯ���� queries������ queries[i] = [Li, Ri]��

����ÿ����ѯ i���������� Li �� Ri �� XOR ֵ���� arr[Li] xor arr[Li+1] xor ... xor arr[Ri]����Ϊ���β�ѯ�Ľ����

������һ������������ѯ queries ���н�������顣
ʾ�� 1��

���룺arr = [1,3,4,8], queries = [[0,1],[1,2],[0,3],[3,3]]
�����[2,7,14,8] 
���ͣ�
������Ԫ�صĶ����Ʊ�ʾ��ʽ�ǣ�
1 = 0001 
3 = 0011 
4 = 0100 
8 = 1000 
��ѯ�� XOR ֵΪ��
[0,1] = 1 xor 3 = 2 
[1,2] = 3 xor 4 = 7 
[0,3] = 1 xor 3 xor 4 xor 8 = 14 
[3,3] = 8
*/
public class LC_1310 {

}
//ǰ׺��
class Solution {
    public int[] xorQueries(int[] arr, int[][] queries) {
        int n = arr.length, m = queries.length;
        int[] xorA = new int[n+1];
        xorA[0] = arr[0];
        for (int i = 1; i < n; i++){
            xorA[i] = xorA[i - 1] ^ arr[i];
        }
        int[] ans = new int[m];
        for (int i = 0; i < m; i++){
            ans[i] = queries[i][0] > 0 ? xorA[queries[i][0] - 1] ^ xorA[queries[i][1]] : xorA[queries[i][1]];
        }
        return ans;
    }
}