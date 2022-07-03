package lc_1185;
import java.time.LocalDate;

/*
 *@author: �ƺ�
 *@date : 2022��1��3��
 *@todo:1185. һ���еĵڼ���
����һ�����ڣ��������һ���㷨���ж����Ƕ�Ӧһ���е���һ�졣

����Ϊ����������day��month �� year���ֱ��ʾ�ա��¡��ꡣ

�����صĽ���������⼸��ֵ�е�һ�� {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"}��
*/
public class LC_1185 {

}
//����API


class Solution {
    public String dayOfTheWeek(int day, int month, int year) {
        LocalDate date = LocalDate.of(year, month, day);
        String str = date.getDayOfWeek().toString();
        return str.charAt(0) + str.substring(1, str.length()).toLowerCase();
    }
}
//�ٷ�ģ��
class Solution1 {
  public String dayOfTheWeek(int day, int month, int year) {
      String[] week = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
      int[] monthDays = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30};
      /* �������֮ǰ����ݵ��������� */
      int days = 365 * (year - 1971) + (year - 1969) / 4;
      /* ��������У������·�֮ǰ���·ݵ��������� */
      for (int i = 0; i < month - 1; ++i) {
          days += monthDays[i];
      }
      if ((year % 400 == 0 || (year % 4 == 0 && year % 100 != 0)) && month >= 3) {
          days += 1;
      }
      /* �����·��е��������� */
      days += day;
      return week[(days + 3) % 7];
  }
}