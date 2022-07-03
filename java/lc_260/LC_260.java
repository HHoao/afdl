package lc_260;

/*
 *@author: �ƺ�
 *@date : 2021��5��2��
 *260. ֻ����һ�ε����� III
����һ���������� nums������ǡ��������Ԫ��ֻ����һ�Σ���������Ԫ�ؾ��������Ρ� �ҳ�ֻ����һ�ε�������Ԫ�ء�����԰� ����˳�� ���ش𰸡�

 

���ף�����㷨Ӧ�þ�������ʱ�临�Ӷȡ����ܷ��ʹ�ó����ռ临�Ӷ���ʵ�֣�
*/
public class LC_260 {

}
class Solution {
    public int[] singleNumber(int[] nums) {
        int k = 0;
        for (int num : nums){
            k = k ^ num;
        }
        int n = 1;
        while ((k & n) == 0){
            n <<= 1;
        }
        int a = 0, b = 0;
        for (int num : nums){
            if ((num & n) == 0){
                a = a ^ num;
            }else{
                b = b ^ num;
            }
        }
        return new int[]{a, b};
    }
}