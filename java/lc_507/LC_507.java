package lc_507;

/*
 *@author: �ƺ�
 *@date : 2021��12��31��
 *@todo:507. ������
����һ�� ��������������ͳ������������������ ������ ֮����ȣ����ǳ���Ϊ ������������

����һ�� ���� n�� ����������������� true�����򷵻� false
*/
public class LC_507 {

}
//ö��
class Solution {
    public boolean checkPerfectNumber(int num) {
        if (num == 1) {
            return false;
        }

        int sum = 1;
        for (int d = 2; d * d <= num; ++d) {
            if (num % d == 0) {
                sum += d;
                if (d * d < num) {
                    sum += num / d;
                }
            }
        }
        return sum == num;
    }
}
//ŷ������
class Solution1 {
    public boolean checkPerfectNumber(int num) {
        return num == 6 || num == 28 || num == 496 || num == 8128 || num == 33550336;
    }
}