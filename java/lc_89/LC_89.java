package lc_89;

import java.util.ArrayList;
import java.util.List;

/**
 * @author �ƺ�
 *89. ���ױ���
���ױ�����һ������������ϵͳ���ڸ�ϵͳ�У�������������ֵ����һ��λ���Ĳ��졣

����һ�����������λ���ķǸ����� n����ӡ����ױ������С���ʹ�ж����ͬ�𰸣���Ҳֻ��Ҫ��������һ�֡�

���ױ������б����� 0 ��ͷ��
 */
public class LC_89 {
	
}
class Solution1{
    public List<Integer> grayCode(int n) {
        List<Integer> res = new ArrayList<Integer>() {{ add(0); }};
        int head = 1;
        for (int i = 0; i < n; i++) {
            for (int j = res.size() - 1; j >= 0; j--)
                res.add(head + res.get(j));
            head <<= 1;
        }
        return res;
    }
}

