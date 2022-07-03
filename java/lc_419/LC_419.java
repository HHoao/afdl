package lc_419;

/*
 *@author: �ƺ�
 *@date : 2021��12��18��
 *@todo:419. �װ��ϵ�ս��
����һ����СΪ m x n �ľ��� board ��ʾ�װ壬���У�ÿ����Ԫ�������һ��ս�� 'X' ������һ����λ '.' �������ڼװ� board �Ϸ��õ� ս�� ��������

ս�� ֻ��ˮƽ���ߴ�ֱ������ board �ϡ����仰˵��ս��ֻ�ܰ� 1 x k��1 �У�k �У��� k x 1��k �У�1 �У�����״���죬���� k �����������С������ս��֮��������һ��ˮƽ��ֱ�Ŀ�λ�ָ� ����û�����ڵ�ս������
*/
public class LC_419 {

}
//һ�α���
class Solution {
    public int countBattleships(char[][] board) {
        int n = board.length, m = board[0].length;
        int ret = 0;
        for (int i = 0; i < n; i++){
            for (int j = 0; j < m; j++){
                if (board[i][j] == 'X'){
                    if (i > 0 && board[i - 1][j] == 'X'){
                        continue;
                    }
                    if (j > 0 && board[i][j - 1] == 'X'){
                        continue;
                    }
                    ret++;
                }
            }
        }
        return ret;
    }
}