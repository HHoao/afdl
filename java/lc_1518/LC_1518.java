package lc_1518;

/*
 *@author: �ƺ�
 *@date : 2021��12��17��
 *@todo:1518. ��������
С�����������ڴ������� numExchange ���վ�ƿ���Զһ�һƿ�¾ơ��㹺���� numBottles ƿ�ơ�

����ȵ��˾�ƿ�еľƣ���ô��ƿ�ͻ��ɿյġ�

������� ��� �ܺȵ�����ƿ�ơ�
*/
public class LC_1518 {

}
//ģ��
class Solution {
    public int numWaterBottles(int numBottles, int numExchange) {
        int ans = numBottles;
        while (numBottles >= numExchange){
            ans += numBottles / numExchange;
            numBottles = numBottles / numExchange + numBottles % numExchange;
        }
        return ans;
    }
}
//��ѧ
class Solution1 {
    public int numWaterBottles(int numBottles, int numExchange) {
        int cnt = numBottles / (numExchange - 1);
        return (numBottles % (numExchange - 1) == 0) ? numBottles +  cnt - 1 : numBottles + cnt;
    }
}