package lc_119;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author �ƺ�
 *119. ������� II
����һ���Ǹ����� k������ k �� 33������������ǵĵ� k �С�



����������У�ÿ�����������Ϸ������Ϸ������ĺ͡�
 */
public class LC_119 {
	
}
//��ǰ����
class Solution {
    public List<Integer> getRow(int rowIndex) {
    	if (rowIndex == 0) return Arrays.asList(1);
    	if (rowIndex == 1) return Arrays.asList(1, 1);
    	List<Integer> res = new ArrayList<>() {{
    		add(1);
    		add(1);
    	}};
    	int preNum = 0;
    	int postNum = 0;
    	for (int i = 2; i < rowIndex + 1; i++) {
    		preNum = res.get(0);
    		for (int j = 1; j < res.size(); j++) {
    			postNum = res.get(j);
				res.set(j, preNum + postNum);
				preNum = postNum;
    		}
    		res.add(1);
    	}
    	return res;
    }
}

//�ٷ�����//�Ӻ���ǰ
class Solution1 {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> row = new ArrayList<Integer>();
        row.add(1);
        for (int i = 1; i <= rowIndex; ++i) {
            row.add(0);
            for (int j = i; j > 0; --j) {
                row.set(j, row.get(j) + row.get(j - 1));
            }
        }
        return row;
    }
}
//���Ե���
class Solution2 {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> row = new ArrayList<Integer>();
        row.add(1);
        for (int i = 1; i <= rowIndex; ++i) {
            row.add((int) ((long) row.get(i - 1) * (rowIndex - i + 1) / i));
        }
        return row;
    }
}
