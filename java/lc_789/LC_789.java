package lc_789;

/*
 *@author: �ƺ�
 *@date : 2021��12��23��
 *@todo:789. �����谭��
���ڽ���һ���򻯰�ĳԶ�����Ϸ����� [0, 0] �㿪ʼ���������Ŀ�ĵ��� target = [xtarget, ytarget] ����ͼ����һЩ�谭�ߣ������� ghosts �������� i ���谭�ߴ� ghosts[i] = [xi, yi] ���������������Ϊ �������� ��

ÿһ�غϣ�����谭���ǿ���ͬʱ�򶫣������ϣ����ĸ������ƶ���ÿ�ο����ƶ�������ԭλ�� 1 ����λ ����λ�á���Ȼ��Ҳ����ѡ�� ���� �����ж��� ͬʱ ������

�����������κ��谭��ץס�� ֮ǰ ����Ŀ�ĵأ��谭�߿��Բ�ȡ�����ж���ʽ��������Ϊ���ѳɹ����������谭��ͬʱ������һ��λ�ã�����Ŀ�ĵأ������������ѳɹ���

ֻ�������п��ܳɹ�����ʱ����� true ��������� false ��
*/
public class LC_789 {

}
//�����پ���
class Solution {
    public boolean escapeGhosts(int[][] ghosts, int[] target) {
        int n = ghosts.length;
        int dis = Math.abs(0 - target[0]) + Math.abs(0 - target[1]);
        for (int i = 0; i < n ;i++){
            int gDis = Math.abs(ghosts[i][0] - target[0]) + Math.abs(ghosts[i][1] - target[1]);
            if (gDis <= dis){
                return false;
            }
        }
        return true;
    }
}