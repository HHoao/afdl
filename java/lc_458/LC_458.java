package lc_458;

/*
 *@author: �ƺ�
 *@date : 2021��12��22��
 *@todo:458. ������С��
�� buckets ͰҺ�壬���� ���� ��һͰ���ж�ҩ������װ�Ķ���ˮ�����Ǵ���ۿ�������һ����Ϊ��Ū�����ֻˮͰ���ж�ҩ�������ιһЩ��ȣ�ͨ���۲����Ƿ���������жϡ����ҵ��ǣ���ֻ�� minutesToTest ����ʱ����ȷ����ͰҺ�����ж��ġ�

ι��Ĺ������£�

ѡ�����ɻ������ι��
��������С��ͬʱ��������������Ͱ�е�ˮ�����Ҹù��̲���Ҫʱ�䡣
С�����ˮ�󣬱����� minutesToDie ���ӵ���ȴʱ�䡣�����ʱ�����ֻ�ܹ۲죬�����������ι��
���� minutesToDie ���Ӻ����кȵ���ҩ��������ȥ���������������������
�ظ���һ���̣�ֱ��ʱ�����ꡣ
����Ͱ����Ŀ buckets ��minutesToDie �� minutesToTest �������ڹ涨ʱ�����ж��ĸ�Ͱ�ж������ ��С ������
*/
public class LC_458 {

}
//�ҵ����
class Solution {
    public int poorPigs(int buckets, int minutesToDie, int minutesToTest) {
        int decimal = minutesToTest  / minutesToDie + 1;
        int count = 0;
        while (Math.pow(decimal, count) < buckets){
            count++;
        }
        return count;
    }
}
//��̬�滮
class Solution2 {
    public int poorPigs(int buckets, int minutesToDie, int minutesToTest) {
        if (buckets == 1) {
            return 0;
        }
        int[][] combinations = new int[buckets + 1][buckets + 1];
        combinations[0][0] = 1;
        int iterations = minutesToTest / minutesToDie;
        int[][] f = new int[buckets][iterations + 1];
        for (int i = 0; i < buckets; i++) {
            f[i][0] = 1;
        }
        for (int j = 0; j <= iterations; j++) {
            f[0][j] = 1;
        }
        for (int i = 1; i < buckets; i++) {
            combinations[i][0] = 1;
            combinations[i][i] = 1;
            for (int j = 1; j < i; j++) {
                combinations[i][j] = combinations[i - 1][j - 1] + combinations[i - 1][j];
            }
            for (int j = 1; j <= iterations; j++) {
                for (int k = 0; k <= i; k++) {
                    f[i][j] += f[k][j - 1] * combinations[i][i - k];
                }
            }
            if (f[i][iterations] >= buckets) {
                return i;
            }
        }
        return 0;
    }
}
//��ѧ
class Solution1 {
    public int poorPigs(int buckets, int minutesToDie, int minutesToTest) {
        int states = minutesToTest / minutesToDie + 1;
        int pigs = (int) Math.ceil(Math.log(buckets) / Math.log(states));
        return pigs;
    }
}
