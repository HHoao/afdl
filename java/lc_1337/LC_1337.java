package lc_1337;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/*
 *@author: �ƺ�
 *@date : 2021��8��1��
 *@todo:
 *1337. ������ս���������� K ��
����һ����СΪ m * n �ľ��� mat�����������ɾ��˺�ƽ����ɣ��ֱ��� 1 �� 0 ��ʾ��

���㷵�ؾ�����ս���������� k �е�������������������ǿ����

����� i �еľ����������ڵ� j �У��������о���������ͬ�� i С�� j����ô������Ϊ�� i �е�ս�����ȵ� j ������

���� ���� ����һ���еĿ�ǰλ�ã�Ҳ����˵ 1 ���ǳ����� 0 ֮ǰ��

 
*/
public class LC_1337 {
	public static void main(String[] args) {
		int i = 0;
		int[] j  = {i, 0};
	}
}

//MySolution
class Solution {
    public int[] kWeakestRows(int[][] mat, int k) {
        List<int[]> army = new ArrayList<>();
        int row = mat.length,  column = mat[0].length;
        for (int i = 0; i < row; i++){
            int[] info = {i, 0};
            for (int j = 0; j < column; j++){
                if (mat[i][j] == 0){
                    break;
                }
                info[1]++;
            }
            army.add(info);
        }
        Collections.sort(army, new Comparator<int[]>(){
           public int compare(int[] army1, int[] army2){
               return army1[1] - army2[1] == 0 ? army1[0] - army2[0] : army1[1] - army2[1];
           } 
        });
        int[] most_power = new int[k];
        for (int i = 0; i < k; i++){
            most_power[i] = army.get(i)[0];
        }
        return most_power;
    }
}