package lc_765;

/*
 *@author: �ƺ�
 *@date : 2021��12��18��
 *@todo:765. ����ǣ��
N �����������������е� 2N ����λ�ϣ���Ҫǣ���Է����֡� �������ٽ�����λ�Ĵ������Ա�ÿ�����¿��Բ�������һ�� һ�ν�����ѡ���������ˣ�������վ����������λ��

�˺���λ�� 0 �� 2N-1 ��������ʾ�������ǰ�˳���ţ���һ���� (0, 1)���ڶ����� (2, 3)���Դ����ƣ����һ���� (2N-2, 2N-1)��

��Щ���µĳ�ʼ��λ  row[i] �������ʼ���ڵ� i ����λ�ϵ��˾����ġ�
*/
public class LC_765 {

}
class Solution {
    public int minSwapsCouples(int[] row) {
        int res=0;
        for(int i = 0; i < row.length; i+=2){
            int a = row[i];
            int b = a^1;
            if(row[i+1] == b)
                continue;
            for(int j = i + 1; j < row.length; ++j){
                if(row[j] == b){
                    int tmp = row[j];
                    row[j] = row[i + 1];
                    row[i + 1] = tmp;
                    ++res;
                    break;
                }
            }
        }
        return res;
    }
}