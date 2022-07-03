package lc_36;

import java.util.HashMap;

/**
 * @author �ƺ�
 *36. ��Ч������
�ж�һ�� 9x9 �������Ƿ���Ч��ֻ��Ҫ�������¹�����֤�Ѿ�����������Ƿ���Ч���ɡ�

���� 1-9 ��ÿһ��ֻ�ܳ���һ�Ρ�
���� 1-9 ��ÿһ��ֻ�ܳ���һ�Ρ�
���� 1-9 ��ÿһ���Դ�ʵ�߷ָ��� 3x3 ����ֻ�ܳ���һ�Ρ�


��ͼ��һ������������Ч��������

�������ֿո��������������֣��հ׸��� '.' ��ʾ��
 */
public class LC_36 {

}

class Solution {
	public boolean isValidSudoku(char[][] board) {
		// init data
		@SuppressWarnings("unchecked")
		HashMap<Integer, Integer>[] rows = new HashMap[9];
		@SuppressWarnings("unchecked")
		HashMap<Integer, Integer>[] columns = new HashMap[9];
		@SuppressWarnings("unchecked")
		HashMap<Integer, Integer>[] boxes = new HashMap[9];
		for (int i = 0; i < 9; i++) {
			rows[i] = new HashMap<Integer, Integer>();
			columns[i] = new HashMap<Integer, Integer>();
			boxes[i] = new HashMap<Integer, Integer>();
		}

		// validate a board
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				char num = board[i][j];
				if (num != '.') {
					int n = (int) num;
					int box_index = (i / 3) * 3 + j / 3;

					// keep the current cell value
					rows[i].put(n, rows[i].getOrDefault(n, 0) + 1);
					columns[j].put(n, columns[j].getOrDefault(n, 0) + 1);
					boxes[box_index].put(n, boxes[box_index].getOrDefault(n, 0) + 1);

					// check if this value has been already seen before
					if (rows[i].get(n) > 1 || columns[j].get(n) > 1 || boxes[box_index].get(n) > 1)
						return false;
				}
			}
		}

		return true;
	}
}
