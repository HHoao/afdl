package lc_263;

/**
 * @author �ƺ�
 *263. ����
����һ������ n �������ж� n �Ƿ�Ϊ ���� ������ǣ����� true �����򣬷��� false ��

���� ����ֻ���������� 2��3 ��/�� 5 ����������
 */
public class LC_263 {

}
//�ݹ�
class Solution {
    public boolean isUgly(int n) {
        return dfs(n);
    }

    public boolean dfs(int n){
        if (n == 1) return true;
        if (n == 0) return false;
        return  (n % 3 == 0 && dfs(n / 3)) || (n % 2 == 0 && dfs(n / 2)) || (n % 5 == 0 && dfs(n / 5));
    }
}
//����
class Solution1 {
    public boolean isUgly(int n) {
      if(n<1){
          return false;
      }
      while(n%5==0){
          n=n/5;
      }
      while(n%3==0){
          n=n/3;
      }
      while(n%2==0){
          n=n/2;
      }
      return n==1;
    }
}