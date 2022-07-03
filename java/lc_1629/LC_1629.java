package lc_1629;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
 *@author: �ƺ�
 *@date : 2022��1��9��
 *@todo:1629. ��������ʱ����ļ�
LeetCode �����һ����ʽ���̣����ڲ���������ԡ�������Ա������һϵ�м����ܼ� n ������ÿ��һ����

����һ������Ϊ n ���ַ��� keysPressed ������ keysPressed[i] ��ʾ���������е� i �������µļ���releaseTimes ��һ���������е��б����� releaseTimes[i] ��ʾ�ɿ��� i ������ʱ�䡣�ַ���������� �±궼�� 0 ��ʼ ���� 0 ������ʱ��Ϊ 0 ʱ�����£�������ÿ������ ǡ�� ��ǰһ�����ɿ�ʱ�����¡�

������Ա��Ҫ�ҳ����� ����ʱ��� �ļ����� i �ΰ����ĳ���ʱ��Ϊ releaseTimes[i] - releaseTimes[i - 1] ���� 0 �ΰ����ĳ���ʱ��Ϊ releaseTimes[0] ��

ע�⣬�����ڼ䣬ͬһ���������ڲ�ͬʱ�̱���ΰ��£���ÿ�εĳ���ʱ�䶼���ܲ�ͬ��

�뷵�ذ��� ����ʱ��� �ļ�������ж�������ļ����򷵻� ����ĸ˳��������� ���Ǹ�����

 

ʾ�� 1��

���룺releaseTimes = [9,29,49,50], keysPressed = "cbcd"
�����"c"
���ͣ�����˳��ͳ���ʱ�����£�
���� 'c' ������ʱ�� 9��ʱ�� 0 ���£�ʱ�� 9 �ɿ���
���� 'b' ������ʱ�� 29 - 9 = 20���ɿ���һ������ʱ�� 9 ���£�ʱ�� 29 �ɿ���
���� 'c' ������ʱ�� 49 - 29 = 20���ɿ���һ������ʱ�� 29 ���£�ʱ�� 49 �ɿ���
���� 'd' ������ʱ�� 50 - 49 = 1���ɿ���һ������ʱ�� 49 ���£�ʱ�� 50 �ɿ���
��������ʱ����ļ��� 'b' �� 'c'���ڶ��ΰ���ʱ��������ʱ�䶼�� 20
'c' ����ĸ˳�����б� 'b' �����Դ��� 'c'
ʾ�� 2��

���룺releaseTimes = [12,23,36,46,62], keysPressed = "spuda"
�����"a"
���ͣ�����˳��ͳ���ʱ�����£�
���� 's' ������ʱ�� 12
���� 'p' ������ʱ�� 23 - 12 = 11
���� 'u' ������ʱ�� 36 - 23 = 13
���� 'd' ������ʱ�� 46 - 36 = 10
���� 'a' ������ʱ�� 62 - 46 = 16
��������ʱ����ļ��� 'a' ������ʱ�� 16
*/
public class LC_1629 {

}
//һ�α���
class Solution {
    public char slowestKey(int[] releaseTimes, String keysPressed) {
        List<Character> ans = new ArrayList<>();
        int n = releaseTimes.length;
        int maxDuring = 0, preDuring = 0, curDuring = 0;
        for (int i = 0; i < n; i++){
            curDuring = releaseTimes[i] - preDuring;
            preDuring = releaseTimes[i];
            if (curDuring < maxDuring){
                continue;
            }
            if (curDuring > maxDuring){
                maxDuring = curDuring;
                ans.clear();
            }
            ans.add(keysPressed.charAt(i));
        }
        Collections.sort(ans);
        return ans.get(ans.size() - 1);
    }
}
//�ٷ�
class Solution1 {
    public char slowestKey(int[] releaseTimes, String keysPressed) {
        int n = releaseTimes.length;
        char ans = keysPressed.charAt(0);
        int maxTime = releaseTimes[0];
        for (int i = 1; i < n; i++) {
            char key = keysPressed.charAt(i);
            int time = releaseTimes[i] - releaseTimes[i - 1];
            if (time > maxTime || (time == maxTime && key > ans)) {
                ans = key;
                maxTime = time;
            }
        }
        return ans;
    }
}