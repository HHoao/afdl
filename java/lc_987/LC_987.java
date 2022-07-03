package lc_987;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import tools.TreeNode;

/*
 *@author: �ƺ�
 *@date : 2021��8��1��
 *@todo:
 *987. �������Ĵ������
����������ĸ���� root ����������㷨����������� ������� ���С�

��λ�� (row, col) ��ÿ�������ԣ��������ӽ��ֱ�λ�� (row + 1, col - 1) �� (row + 1, col + 1) �����ĸ����λ�� (0, 0) ��

�������� ������� ������ߵ��п�ʼֱ�����ұߵ��н�������������ÿһ���ϵ����н�㣬�γ�һ��������λ�ô��ϵ�������������б����ͬ��ͬ�����ж����㣬�򰴽���ֵ��С�����������

���ض������� ������� ���С�
*/
public class LC_987 {

}
class Solution {
    int min_column = 0;
    int max_column = 0;
    int row_num = 0;
    Map<Integer, Map<Integer, List<Integer>>> ansMap;
    
    public void getColumn(TreeNode root, int row, int column){
        if (root == null) return;
        if (row > row_num) row_num = row;
        if (column < min_column) min_column = column;
        if (column > max_column) max_column = column;
        
        Map<Integer, List<Integer>> column_map = ansMap.getOrDefault(column, new HashMap<>());
        List<Integer> row_list = column_map.getOrDefault(row, new ArrayList<>());
        row_list.add(root.val);
        column_map.put(row, row_list);
        ansMap.put(column, column_map);
        
        getColumn(root.left, row + 1, column - 1);
        getColumn(root.right, row + 1, column + 1);
    }
    
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        ansMap = new HashMap<Integer, Map<Integer, List<Integer>>>();
        getColumn(root, 0, 0);
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        for (int i = min_column; i <= max_column; i++){
            Map<Integer, List<Integer>> map = ansMap.get(i);
            List<Integer> column_list = new ArrayList<>();
            for (int j = 0; j <= row_num; j++){
                List<Integer> row_list = map.get(j);
                if (row_list != null){
                    Collections.sort(row_list);
                    for (int k = 0; k < row_list.size(); k++){
                        column_list.add(row_list.get(k));
                    }
                }
            }
               
            ans.add(column_list);
        }
        return ans;
    }
}