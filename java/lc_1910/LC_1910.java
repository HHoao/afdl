package lc_1910;

/*
 *@author: �ƺ�
 *@date : 2021��12��19��
 *@todo:1910. ɾ��һ���ַ��������г��ֵĸ������ַ���
���������ַ��� s �� part ������� s ����ִ�����²���ֱ�� ���� ���ַ��� part ����ɾ����

�ҵ� s �� ����� �����ַ��� part ���������� s ��ɾ����
���㷵�ش� s ��ɾ������ part ���ַ����Ժ�õ���ʣ���ַ�����

һ�� ���ַ��� ��һ���ַ������������ַ����С�
*/
public class LC_1910 {

}

//����api
class Solution {
    public String removeOccurrences(String s, String part) {
        StringBuffer sb = new StringBuffer(s);
        int index = sb.indexOf(part);
        int m = part.length();
        while (index != -1){
            sb.delete(index, index+m);
            index = sb.indexOf(part);
        }
        return sb.toString();
    }
}