package lc_913;

import java.util.Arrays;

/*
 *@author: �ƺ�
 *@date : 2022��1��4��
 *@todo:913. è������
��λ��ҷֱ����è��������һ�� ���� ͼ�Ͻ�����Ϸ�����������ж���

ͼ����ʽ�ǣ�graph[a] ��һ���б������� ab ��ͼ�е�һ���ߵ����нڵ� b ��ɡ�

����ӽڵ� 1 ��ʼ����һ��������è�ӽڵ� 2 ��ʼ���ڶ����������ڽڵ� 0 ����һ������

��ÿ����ҵ��ж��У����� ���� ����ͼ�������ڵ�ǰλ����ͨ��һ�����ƶ������磬��������ڽڵ� 1 ����ô�������ƶ��� graph[1] �е���һ�ڵ㡣

���⣬è�޷��ƶ������У��ڵ� 0����

Ȼ����Ϸ�ڳ���������������֮һʱ������

���è�����������ͬһ���ڵ㣬è��ʤ��
������󵽴ﶴ�У������ʤ��
���ĳһλ���ظ����֣�������ҵ�λ�ú��ƶ�˳������һ���ж���ͬ������Ϸƽ�֡�
����һ��ͼ graph ����������λ��Ҷ��������״̬������Ϸ��

��������ʤ���򷵻� 1��
���è��ʤ���򷵻� 2��
���ƽ�֣��򷵻� 0 ��
 
ʾ�� 1��


���룺graph = [[2,5],[3],[0,4,5],[1,4,5],[2,3],[0,2,3]]
�����0
*/
public class LC_913 {

}
class Solution {
    static final int MOUSE_WIN = 1;
    static final int CAT_WIN = 2;
    static final int DRAW = 0;
    int n;
    int[][] graph;
    int[][][] dp;

    public int catMouseGame(int[][] graph) {
        this.n = graph.length;
        this.graph = graph;
        this.dp = new int[n][n][n * 2];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }
        return getResult(1, 2, 0);
    }

    public int getResult(int mouse, int cat, int turns) {
        if (turns == n * 2) {
            return DRAW;
        }
        if (dp[mouse][cat][turns] < 0) {
            if (mouse == 0) {
                dp[mouse][cat][turns] = MOUSE_WIN;
            } else if (cat == mouse) {
                dp[mouse][cat][turns] = CAT_WIN;
            } else {
                getNextResult(mouse, cat, turns);
            }
        }
        return dp[mouse][cat][turns];
    }

    public void getNextResult(int mouse, int cat, int turns) {
        int curMove = turns % 2 == 0 ? mouse : cat;
        int defaultResult = curMove == mouse ? CAT_WIN : MOUSE_WIN;
        int result = defaultResult;
        int[] nextNodes = graph[curMove];
        for (int next : nextNodes) {
            if (curMove == cat && next == 0) {
                continue;
            }
            int nextMouse = curMove == mouse ? next : mouse;
            int nextCat = curMove == cat ? next : cat;
            int nextResult = getResult(nextMouse, nextCat, turns + 1);
            if (nextResult != defaultResult) {
                result = nextResult;
                if (result != DRAW) {
                    break;
                }
            }
        }
        dp[mouse][cat][turns] = result;
    }
}
