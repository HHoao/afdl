package lc_LCP23;

import java.util.Arrays;

/*
 *@author: �ƺ�
 *@date : 2021��10��2��
 *@todo:LCP 23. ħ������
�����м��ϣ�ħ��ʦ����С������������ħ��ʦ�ĵ���Ϊ�ֱ�д������ 1~N �� N �ſ��ƣ�Ȼ����С��˼��һ�� N �ſ��Ƶ����� target��

ħ��ʦ��Ŀ�����ҵ�һ������ k��k >= 1����ʹ�ó�ʼ����˳��Ϊ 1~N �Ŀ��ƾ��������ϴ�Ʒ�ʽ���ձ��С����������� target�������ϴ�Ʒ�ʽΪ��

��һ����ħ��ʦ����ǰλ�� ż��λ�� �Ŀ��ƣ��±��� 1 ��ʼ�������� ��ǰ����˳�� ����λ�� ����λ�� �Ŀ���֮ǰ�����磺����ǰ���� [1,2,3,4,5] λ��ż��λ�õ� [2,4] ��������λ�õ� [1,3,5] ǰ�����б�Ϊ [2,4,1,3,5]��
�ڶ���������ǰ��������С�ڵ��� k����ħ��ʦ������˳��ȡ��ȫ�����ƣ�����ǰ������������ k����ȡ��ǰ k �ſ��ƣ�ʣ�࿨�Ƽ����ظ����������裬ֱ�����п���ȫ����ȡ�ߣ�
���ư���ħ��ʦȡ��˳�򹹳ɵ�������Ϊ��ħ��ȡ�����С����뷵���Ƿ����������� k ʹ�á�ħ��ȡ�����С�ǡ�þ��� target���Ӷ���С�۸е����һ����

ʾ�� 1��

���룺target = [2,4,3,1,5]

�����true

���ͣ����� target ����Ϊ 5����ʼ����Ϊ��1,2,3,4,5������ѡ�� k = 2��
��һ�Σ�����ǰ���� [1,2,3,4,5] λ��ż��λ�õ� [2,4] ��������λ�õ� [1,3,5] ǰ�����б�Ϊ [2,4,1,3,5]��ȡ��ǰ 2 �ſ��� 2,4��ʣ�� [1,3,5]��
�ڶ��Σ�����ǰ���� [1,3,5] λ��ż��λ�õ� [3] ��������λ�õ� [1,5] ǰ�����б�Ϊ [3,1,5]��ȡ��ǰ 2 �� 3,1��ʣ�� [5]��
�����Σ���ǰ����Ϊ [5]��ȫ��ȡ����
������ְ���ȡ��˳�򹹳ɵġ�ħ��ȡ�����С�2,4,3,1,5 ǡ��Ϊ target��

ʾ�� 2��

���룺target = [5,4,3,2,1]

�����false

���ͣ��޷��ҵ�һ������ k ����ʹ��ħ��ȡ�����С�ǡ��Ϊ target��
*/
public class LCP23 {
	public static void main(String[] args) {
		
		Solution so = new Solution();
		System.out.println(so.isMagic(new int[] {2,4,6,10,14,18,26,34,42,15,31,8,40,29,38,20,41,16,35,13,36,12,23,24,37,30,28,27,17,22,25,7,1,9,11,21,5,19,43,33,32,39,3}));
	}
}
//�Ż�
class Solution {
	public boolean isMagic(int[] target) {
		int n = target.length;
		int[] orgin = new int[n];
		for (int i = 0; i < n; i++) orgin[i] = i + 1;
		int start = 0;
		int[] get = new int[n], odds = new int[(n + 1) / 2], even = new int[n / 2];
		int io = 0, ie = 0, res_size = n, index = 0;
		for (int i = 0; i < n; i++) if (i % 2 == 1) even[ie++] = orgin[i]; else odds[io++] = orgin[i];
		for (int i = 0; i < n; i++)
			if (target[i] == (i < ie ? even[i] : odds[i - ie]))
				start++;
			else
				break;
		if (start == 0) return false;
		while (index < n) {
			odds = new int[(res_size + 1) / 2];
			even = new int[res_size / 2];
			io = 0;
			ie = 0;
			for (int i = 0; i < res_size; i++)
				if (i % 2 == 1) even[ie++] = orgin[i];
				else odds[io++] = orgin[i];
			if (start <= res_size) {
				for (int i = 0; i < start; i++) get[index++] = i < ie ? even[i] : odds[i - ie];
				for (int i = start; i < res_size; i++) orgin[i - start] = i < ie ? even[i] : odds[i - ie];
				res_size -= start;
			} else {
				for (int i = 0; i < ie; i++) get[index++] = even[i];
				for (int i = 0; i < io; i++) get[index++] = odds[i];
			}
		}
		boolean res = true;
		for (int i = 0; i < n; i++) if (get[i] != target[i]) res = false;
		if (res) return true;
		return false;
	}
}
class Solution1 {
    public boolean isMagic(int[] target) {
        int n = target.length;
        int[] orgin = new int[n];
        for (int i = 0; i < n; i++){
            orgin[i] = i+1;
        }
        int start = 0;
        for (int i = 0; i < n; i++) {
        	if (target[i] % 2 == 0 && target[i] / 2 == (start+1)) {
        		start++;
        	}else break;
        }
        if (start == 0) return false;
        
        for(int k = start; k <= n; k++) {
        	int[] residue = Arrays.copyOf(orgin, n);
            int[] get = new int[n];
            int res_size = n;
            int index = 0;
	        while (index < n){
	            int[] odds = new int[(res_size+1) / 2];
	            int[] even = new int[res_size/2];
	            int io = 0, ie = 0;
	            for (int i = 0; i < res_size; i++){
	                if (i % 2 == 1){
	                    even[ie++] = residue[i];
	                }else{
	                    odds[io++] = residue[i];
	                }
	            }
	            if (k <= res_size){
	                for (int i = 0; i < k; i++){
	                    if (i < ie)
	                        get[index++] = even[i];
	                    else
	                        get[index++] = odds[i - ie];
	                }
	                res_size -= k;
	                for (int i = k; i < res_size+k; i++) {
	                	residue[i - k] = i < ie ? even[i] : odds[i - ie];
	                }
	            }else{
	                for (int i = 0; i < ie; i++){
	                    get[index++] = even[i];
	                }
	                for (int i = 0; i < io; i++){
	                    get[index++] = odds[i];
	                }
	            }
	        }
	        boolean res = true;
	        for (int i = 0; i < n; i++){
	            if (get[i] != target[i])
	                res =false;
	        }
	        if (res) return true;
        }
        
        return false;
    }
}