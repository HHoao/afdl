package lc_721;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 *@author: �ƺ�
 *@date : 2021��12��17��
 *@todo:721. �˻��ϲ�
����һ���б� accounts��ÿ��Ԫ�� accounts[i] ��һ���ַ����б����е�һ��Ԫ�� accounts[i][0] �� ���� (name)������Ԫ���� emails ��ʾ���˻��������ַ��

���ڣ�������ϲ���Щ�˻�����������˻�����һЩ��ͬ�������ַ���������˻��ض�����ͬһ���ˡ���ע�⣬��ʹ�����˻�������ͬ�����ƣ�����Ҳ�������ڲ�ͬ���ˣ���Ϊ���ǿ��ܾ�����ͬ�����ơ�һ�����������ӵ�������������˻������������˻���������ͬ�����ơ�

�ϲ��˻��󣬰����¸�ʽ�����˻���ÿ���˻��ĵ�һ��Ԫ�������ƣ�����Ԫ���� ���ַ� ASCII ˳������ �������ַ���˻���������� ����˳�� ���ء�
*/
public class LC_721 {

}
//���鼯
class Solution {
    class UnionFind{
        public Map<String, String> parent;
        public Map<String, String> name;
        UnionFind(){
            parent = new HashMap<>();
            name = new HashMap<>();
        }
        String find(String email){
            String p = parent.getOrDefault(email, email);
            if (p == email){
                return p;
            }else{
                String ans = find(p);
                this.parent.put(email, ans);
                return ans;
            }
        }
        void insert(String e, String n){
            String p = parent.getOrDefault(e, e);
            parent.put(e, p);
            this.name.put(p, n);
        }
        void union(String e1, String e2){
            e1 = find(e1);
            e2 = find(e2);
            this.parent.put(e1, e2);
        }
    }
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        int size = accounts.size();
        UnionFind uf = new UnionFind();
        for (int i = 0; i < size; i++){
            List<String> account = accounts.get(i);
            int n = account.size();
            for (int j = 1; j < n; j++){
                uf.insert(account.get(j), account.get(0));
                if (j > 1){
                    uf.union(account.get(j - 1), account.get(j));
                }
            }
        }
        Map<String, List<String>> eMap = new HashMap<>();
        List<List<String>> ret = new ArrayList<>();
        List<Map.Entry<String, String>> parentEntry = new ArrayList<>(uf.parent.entrySet());
        for (Map.Entry<String, String> entry : parentEntry){
            String p = uf.find(entry.getKey());
            List<String> list = eMap.getOrDefault(p, new ArrayList<>());
            
            if (list.size() == 0){
                list.add(p);
            }
            if (entry.getKey() != p)
                list.add(entry.getKey());
            eMap.put(p, list);
        }
        Comparator<String> cp = new Comparator<>(){
            public int compare(String a, String b){
                int len = a.length() > b.length() ? b.length() : a.length();
                for (int i = 0; i < len; i++){
                    if (a.charAt(i) == b.charAt(i)){
                        continue;
                    }
                    if (a.charAt(i) < b.charAt(i)){
                        return -1;
                    }else{
                        return 1;
                    }
                }
                return a.length() - b.length();
            }
        };
        for (Map.Entry<String, List<String>> s : new ArrayList<>(eMap.entrySet())){
            List<String> user = s.getValue();
            Collections.sort(user, cp);
            s.getValue().add(0, uf.name.get(s.getValue().get(0)));
            ret.add(s.getValue());
        }
        return ret;
    }
}