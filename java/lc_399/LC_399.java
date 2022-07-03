package lc_399;

import java.util.HashMap;
import java.util.Map;
import java.util.List;

/*
 *@author: �ƺ�
 *@date : 2021��12��13��
 *@todo:399. ������ֵ
����һ������������ equations ��һ��ʵ��ֵ���� values ��Ϊ��֪���������� equations[i] = [Ai, Bi] �� values[i] ��ͬ��ʾ��ʽ Ai / Bi = values[i] ��ÿ�� Ai �� Bi ��һ����ʾ�����������ַ�����

����һЩ������ queries ��ʾ�����⣬���� queries[j] = [Cj, Dj] ��ʾ�� j �����⣬���������֪�����ҳ� Cj / Dj = ? �Ľ����Ϊ�𰸡�

���� ��������Ĵ� ���������ĳ���޷�ȷ���Ĵ𰸣����� -1.0 �������𰸡���������г����˸�������֪������û�г��ֵ��ַ�����Ҳ��Ҫ�� -1.0 �������𰸡�

ע�⣺����������Ч�ġ�����Լ�����������в�����ֳ���Ϊ 0 ��������Ҳ������κ�ì�ܵĽ����
*/
public class LC_399 {

}
class Pair{
    public String parent;
    public Double weight;
    Pair(String parent, Double weight){
        this.parent = parent;
        this.weight = weight;
    }
}
class UnionFind{
    Map<String, Pair> edges;
    UnionFind(){
        edges = new HashMap<>();
    }
    Pair find(String str){
        if (!edges.containsKey(str)){
            edges.put(str, new Pair(str, 1.0));
        }
        Pair edge  = edges.get(str);
        if (edge.parent.equals(str)){
            return edge;
        }
        Pair par = find(edge.parent);
        edge.parent = par.parent;
        edge.weight *= par.weight;
        return edge;
    }

    void union(String x, String y, Double value){
        Pair xP = find(x);
        Pair yP = find(y);
        if (yP.parent == xP.parent){
            return;
        }
        if (xP.parent.equals(x)){
            xP.parent = y;
            xP.weight = value;
            return;
        }
        edges.get(xP.parent).weight = value /  xP.weight;
        edges.get(xP.parent).parent = y;
    }
    boolean connected(String x, String y){
        return find(x).parent.equals(find(y).parent);
    }
    Double device(String x, String y){
        if (!edges.containsKey(x) || !edges.containsKey(y) || !connected(x, y)) {
            return -1.0;
        }
        return edges.get(x).weight / edges.get(y).weight;
    }
}
class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        int size = equations.size();
        UnionFind unionFind = new UnionFind();
        for (int i = 0; i < size; i++){
            List<String> equation = equations.get(i);
            unionFind.union(equation.get(0) , equation.get(1), values[i]);
        }
        int n = queries.size();
        double[] ans = new double[n];
        for (int i = 0; i < n; i++){
            ans[i] = unionFind.device(queries.get(i).get(0), queries.get(i).get(1));
        }
        return ans;
    }
}
