package lc_275;

/*
 *@author: �ƺ�
 *@date : 2021��5��4��
 *@todo:275. H ָ�� II
����һλ�о������ı����ô��������飨�����ô����ǷǸ��������������Ѿ����� �������� ����дһ��������������о��ߵ� h ָ����

h ָ���Ķ���: ��h ���������ô�������high citations����һ��������Ա�� h ָ����ָ���������� ��N ƪ�����У��ܹ��� h ƪ���ķֱ����������� h �Ρ�������� N - h ƪ����ÿƪ�����ô��������� h �Ρ���"
*/
public class LC_275 {

}
//�ҵĴ���
class Solution {
    public int hIndex(int[] citations) {
        int n = citations.length;
        if (citations[n - 1] == 0) return 0;
        int l = 0, r = n - 1;
        while (l <= r){
            int mid = (l + r + 1) >> 1;
            if (citations[mid] == n - mid){
                return n - mid;
            }
            if (citations[mid] > n - mid){
                r = mid - 1;
            }else{
                l = mid + 1;
            }
        }
        return n - l - 1;
    }
}