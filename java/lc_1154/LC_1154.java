package lc_1154;

import java.time.LocalDate;

/*
 *@author: �ƺ�
 *@date : 2021��12��21��
 *@todo:1154. һ���еĵڼ���
����һ���ַ��� date ���� YYYY-MM-DD ��ʽ��ʾһ�� ���й�Ԫ���귨 ���ڡ�������㲢���ظ������ǵ���ĵڼ��졣

ͨ������£�������Ϊ 1 �� 1 ����ÿ��ĵ� 1 �죬1 �� 2 ����ÿ��ĵ� 2 �죬�������ơ�ÿ���µ����������й�Ԫ���귨�������������һ�¡�
*/
public class LC_1154 {

}
class Solution {
    public int dayOfYear(String date) {
        LocalDate localDate = LocalDate.parse(date);
        return localDate.getDayOfYear();
    }
}