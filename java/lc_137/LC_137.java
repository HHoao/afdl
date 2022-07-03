package lc_137;

/**
 * @author �ƺ�
 *137. ֻ����һ�ε����� II
����һ���ǿ��������飬����ĳ��Ԫ��ֻ����һ�����⣬����ÿ��Ԫ�ؾ����������Ρ��ҳ��Ǹ�ֻ������һ�ε�Ԫ�ء�

˵����

����㷨Ӧ�þ�������ʱ�临�Ӷȡ� ����Բ�ʹ�ö���ռ���ʵ����
 */
public class LC_137 {

}
//λ���� + ����״̬��
class Solution{
	public int singleNumber(int[] nums) {
		int ones = 0, twos = 0;
		for (int num :nums) {
			ones  = ones ^ num & ~ twos;
			twos = twos ^ num & ~ ones;
		}
		return ones;
	}
}
//������������ͳ��
class Solution1 {
    public int singleNumber(int[] nums) {
        int[] counts = new int[32];
        for(int num : nums) {
            for(int j = 0; j < 32; j++) {
                counts[j] += num & 1;
                num >>>= 1;
            }
        }
        int res = 0, m = 3;
        for(int i = 0; i < 32; i++) {
            res <<= 1;
            res |= counts[31 - i] % m;
        }
        return res;
    }
}