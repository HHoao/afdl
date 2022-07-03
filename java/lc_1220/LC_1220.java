package lc_1220;

/*
 *@author: �ƺ�
 *@date : 2022��1��17��
 *@todo:1220. ͳ��Ԫ����ĸ���е���Ŀ
����һ������ n�������æͳ��һ�����ǿ��԰����������γɶ��ٸ�����Ϊ n ���ַ�����

�ַ����е�ÿ���ַ���Ӧ����СдԪ����ĸ��'a', 'e', 'i', 'o', 'u'��
ÿ��Ԫ�� 'a' ���涼ֻ�ܸ��� 'e'
ÿ��Ԫ�� 'e' ����ֻ�ܸ��� 'a' ������ 'i'
ÿ��Ԫ�� 'i' ���� ���� �ٸ�����һ�� 'i'
ÿ��Ԫ�� 'o' ����ֻ�ܸ��� 'i' ������ 'u'
ÿ��Ԫ�� 'u' ����ֻ�ܸ��� 'a'
���ڴ𰸿��ܻ�ܴ��������㷵�� ģ 10^9 + 7 ֮��Ľ����

 

ʾ�� 1��

���룺n = 1
�����5
���ͣ����п��ܵ��ַ����ֱ��ǣ�"a", "e", "i" , "o" �� "u"��
ʾ�� 2��

���룺n = 2
�����10
���ͣ����п��ܵ��ַ����ֱ��ǣ�"ae", "ea", "ei", "ia", "ie", "io", "iu", "oi", "ou" �� "ua"��
ʾ�� 3��

���룺n = 5
�����68
*/
public class LC_1220 {

}
//ģ��
class Solution {
    static final int remainder = 1000000000 + 7;
    public int countVowelPermutation(int n) {
        long pac = 1, pec = 1, pic = 1, poc = 1, puc = 1;
        long a_c = 1, e_c = 1, i_c = 1, o_c = 1, u_c = 1;
        for (int i = 1; i < n; i++){
            a_c = pec + pic + puc;
            e_c = pac + pic;
            i_c = pec + poc;
            o_c = pic;
            u_c = pic + poc;

            pac = a_c % remainder;
            pec = e_c % remainder;
            pic = i_c % remainder;
            poc = o_c % remainder;
            puc = u_c % remainder;
        }
        return (int)((a_c + e_c +i_c+ o_c + u_c) % remainder);
    }
}