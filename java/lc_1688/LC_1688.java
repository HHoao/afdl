package lc_1688;

/*
 *@author: �ƺ�
 *@date : 2022��1��25��
 *@todo:
*/
public class LC_1688 {

}
//ģ��
class Solution {
    public int numberOfMatches(int n) {
        int ans = 0;
        while (n > 1){
            ans+= n / 2;
            n = (n+1)/2;
        }
        return ans;
    }
}
//��ѧ
class Solution1 {
    public int numberOfMatches(int n) {
        return n - 1;
    }
}