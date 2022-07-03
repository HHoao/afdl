package lc_228;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author �ƺ�
 *228. ��������
����һ�����ظ�Ԫ�ص������������� nums ��

���� ǡ�ø����������������� �� ��С���� ���䷶Χ�б�Ҳ����˵��nums ��ÿ��Ԫ�ض�ǡ�ñ�ĳ�����䷶Χ�����ǣ����Ҳ���������ĳ����Χ�������� nums ������ x ��

�б��е�ÿ�����䷶Χ [a,b] Ӧ�ð����¸�ʽ�����

"a->b" ����� a != b
"a" ����� a == b
 */
public class LC_228 {

}
//�ҵĴ���
class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> res = new ArrayList<>();
        int n = nums.length;
        if (n == 0) return res;
        int l = nums[0];
        int r = nums[0];
        for (int i = 1; i < n; i++){
            if (nums[i] == r + 1){
                r = nums[i];
            }else{
                res.add(l == r ? "" + l : l + "->"+r);
                l = nums[i];
                r = nums[i];
            }
        }
        res.add(l == r ? "" + l : l + "->"+r);
        return res;
    }
}