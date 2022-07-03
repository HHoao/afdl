package lc_690;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 *@author: �ƺ�
 *@date : 2021��5��1��
 *690. Ա������Ҫ��
����һ������Ա����Ϣ�����ݽṹ����������Ա�� Ψһ�� id ����Ҫ�� �� ֱϵ������ id ��

���磬Ա�� 1 ��Ա�� 2 ���쵼��Ա�� 2 ��Ա�� 3 ���쵼��������Ӧ����Ҫ��Ϊ 15 , 10 , 5 ����ôԱ�� 1 �����ݽṹ�� [1, 15, [2]] ��Ա�� 2�� ���ݽṹ�� [2, 10, [3]] ��Ա�� 3 �����ݽṹ�� [3, 5, []] ��ע����ȻԱ�� 3 Ҳ��Ա�� 1 ��һ���������������� ������ֱϵ ���������û��������Ա�� 1 �����ݽṹ�С�

��������һ����˾������Ա����Ϣ���Լ�����Ա�� id ���������Ա������������������Ҫ��֮�͡�
*/
public class LC_690 {

}
class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
};
class Solution {
    Map<Integer, Employee> epM;
    int res;
    public int getImportance(List<Employee> employees, int id) {
        res = 0;
        epM = new HashMap<>();
        for (Employee e: employees){
            epM.put(e.id, e);
        }
        addImport(id);
        return res;
    }
    public void addImport(int id){
        Employee boss = epM.get(id);
        res += boss.importance;
        for (Integer uid : boss.subordinates){
            addImport(uid);
        }
    }
}