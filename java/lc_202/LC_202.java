package lc_202;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author �ƺ�
 *202. ������
��дһ���㷨���ж�һ���� n �ǲ��ǿ�������

��������������Ϊ��

����һ����������ÿһ�ν������滻Ϊ��ÿ��λ���ϵ����ֵ�ƽ���͡�
Ȼ���ظ��������ֱ���������Ϊ 1��Ҳ������ ����ѭ�� ��ʼ�ձ䲻�� 1��
��� ���Ա�Ϊ  1����ô��������ǿ�������
��� n �ǿ������ͷ��� true �����ǣ��򷵻� false ��
 */
public class LC_202 {

}
//�ҵĴ���
class Solution {
    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        set.add(n);
        while (n != 1){
            int sum = 0;
            while (n != 0){
                int i = n %10;
                n /= 10;
                sum = sum + i * i;
            }
            
            if (set.contains(sum)) return false;
            set.add(sum);
            n = sum;
        }
        return true;
    }
}
//����ָ��
class Solution1 {

    public int getNext(int n) {
       int totalSum = 0;
       while (n > 0) {
           int d = n % 10;
           n = n / 10;
           totalSum += d * d;
       }
       return totalSum;
   }

   public boolean isHappy(int n) {
       int slowRunner = n;
       int fastRunner = getNext(n);
       while (fastRunner != 1 && slowRunner != fastRunner) {
           slowRunner = getNext(slowRunner);
           fastRunner = getNext(getNext(fastRunner));
       }
       return fastRunner == 1;
   }
}
//����������ѧ
class Solution2 {
    private static Set<Integer> cycleMembers =
        new HashSet<>(Arrays.asList(4, 16, 37, 58, 89, 145, 42, 20));

    public int getNext(int n) {
        int totalSum = 0;
        while (n > 0) {
            int d = n % 10;
            n = n / 10;
            totalSum += d * d;
        }
        return totalSum;
    }


    public boolean isHappy(int n) {
        while (n != 1 && !cycleMembers.contains(n)) {
            n = getNext(n);
        }
        return n == 1;
    }
}