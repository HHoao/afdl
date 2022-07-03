package lc_299;

/*
 *@author: �ƺ�
 *@date : 2021��5��9��
 *@todo:299. ��������Ϸ
���ں�����һ���� �����֣�Bulls and Cows����Ϸ������Ϸ�������£�

��д��һ���������֣��������Ѳ���������Ƕ��١�
����ÿ�²�һ�Σ���ͻ����һ����ʾ���������Ĳ²��������ж���λ�������ֺ�ȷ��λ�ö��¶��ˣ���Ϊ��Bulls��, ��ţ�����ж���λ�������ֲ¶��˵���λ�ò��ԣ���Ϊ��Cows��, ��ţ����
���Ѹ�����ʾ�����£�ֱ���³��������֡�
��д��һ�������������ֺ����ѵĲ²���������ʾ�ĺ����������ַ����ĸ�ʽΪ xAyB ��x �� y �������֣�A ��ʾ��ţ���� B ��ʾ��ţ��

xA ��ʾ�� x λ���ֳ��������������У���λ�ö�����������һ�¡�
yB ��ʾ�� y λ���ֳ��������������У���λ�����������ֲ�һ�¡�
��ע���������ֺ����ѵĲ²��������ܺ����ظ����֣�ÿλ����ֻ��ͳ��һ�Ρ�
*/
public class LC_299 {

}
class Solution {
    public String getHint(String secret, String guess) {
        int bulls = 0, cows = 0;
        
        int[] count = new int[10];
        for (int i = 0; i < secret.length(); i++){
            if (secret.charAt(i) == guess.charAt(i)){
                bulls++;
            }else{
                count[secret.charAt(i) - '0']++;
            }
        }
        for (int i = 0; i < secret.length(); i++){
            int j = guess.charAt(i) - '0';
            int k = secret.charAt(i) - '0';
            if (count[j] != 0 && j != k){
                cows++;
                count[j]--;
            }
        }
        return bulls + "A"+cows+"B";
    }
}