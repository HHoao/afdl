package lc_190;

/**
 * @author �ƺ�
 *190. �ߵ�������λ
�ߵ������� 32 λ�޷��������Ķ�����λ��

 

��ʾ��

��ע�⣬��ĳЩ���ԣ��� Java���У�û���޷����������͡�����������£���������������ָ��Ϊ�з����������ͣ����Ҳ�ӦӰ������ʵ�֣���Ϊ�����������з��ŵĻ����޷��ŵģ����ڲ��Ķ����Ʊ�ʾ��ʽ������ͬ�ġ�
�� Java �У�������ʹ�ö����Ʋ���Ƿ�����ʾ�з�����������ˣ�������� ʾ�� 2 �У������ʾ�з������� -3�������ʾ�з������� -1073741825��
 

����:
�����ε�������������㽫����Ż�����㷨��
 */
public class LC_190 {

}
class Solution {
    public int reverseBits(int n) {
        int rev = 0;
        for (int i = 1; i <= 32; i++){
            rev |= (1 & n ) << (32 - i);
            n = n >> 1;
        }
        return rev;
    }
}
class Solution1 {
    public int reverseBits(int n) {
        int ret=0;
        int m=0;
        while(m!=32){//ѭ��32��
            if((n&1)==0)ret=ret*2;//�ж����һλ��0����1
            else ret=ret*2+1;
            n=n>>1;//��n����
            m++;//��¼ѭ������
        }
        return ret;
    }
}
//λ�������
class Solution2 {
	private int M1 = 0x55555555;
	private int M2 = 0x33333333;
	private int M4 = 0x0f0f0f0f;
	private int M8 = 0x00ff00ff;
	public int reverseBits(int n) {
		n = n >>> 1 & M1 | (n & M1) << 1;
		n = n >>> 2 & M2 | (n & M2) << 2;
		n = n >>> 4 & M4 | (n & M4) << 4;
		n = n >>> 8 & M8 | (n & M8) << 8;
		return n >>> 16 | n << 16;
	}
}
