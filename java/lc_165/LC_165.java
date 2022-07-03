package lc_165;

/**
 * @author �ƺ�
 *165. �Ƚϰ汾��
���������汾�� version1 �� version2 ������Ƚ����ǡ�

�汾����һ�������޶�����ɣ����޶�����һ�� '.' ���ӡ�ÿ���޶����� ��λ���� ��ɣ����ܰ��� ǰ���� ��ÿ���汾�����ٰ���һ���ַ����޶��Ŵ����ұ�ţ��±�� 0 ��ʼ������ߵ��޶����±�Ϊ 0 ����һ���޶����±�Ϊ 1 ���Դ����ơ����磬2.5.33 �� 0.1 ������Ч�İ汾�š�

�Ƚϰ汾��ʱ���밴�����ҵ�˳�����αȽ����ǵ��޶��š��Ƚ��޶���ʱ��ֻ��Ƚ� �����κ�ǰ����������ֵ ��Ҳ����˵���޶��� 1 ���޶��� 001 ��� ������汾��û��ָ��ĳ���±괦���޶��ţ�����޶�����Ϊ 0 �����磬�汾 1.0 С�ڰ汾 1.1 ����Ϊ�����±�Ϊ 0 ���޶�����ͬ�����±�Ϊ 1 ���޶��ŷֱ�Ϊ 0 �� 1 ��0 < 1 ��

���ع������£�

��� version1 > version2 ���� 1��
��� version1 < version2 ���� -1��
����֮�ⷵ�� 0��
 */
public class LC_165 {

}
//�ҵĴ���
class Solution {
    public int compareVersion(String version1, String version2) {
        String[] ss1 = version1.split("\\.");
        String[] ss2 = version2.split("\\.");
        int k = ss1.length, j = ss2.length;
        int n = Math.max(k, j);
        int state = 0;
        for (int i = 0; i < n; i++){
            int num1 = 0, num2 = 0;
            if (k > i) num1 = Integer.valueOf(ss1[i]);
            if (j > i) num2 = Integer.valueOf(ss2[i]);
            if (i < k && i < j && num1 == num2) continue;
            state = (k == n && i >= j && num1 != 0) ? 1 : 0;
            if (state != 0) return state;
            state = (j == n && i >= k && num2 != 0) ? -1 : 0;
            if (i < k && i < j){
                state = (num1 < num2) ? -1 : 1;
            }

            if (state != 0) return state;
        }
        return state;
    }
}
//�ٷ�
class Solution1 {
	public int compareVersion(String version1, String version2) {
		String[] nums1 = version1.split("\\.");
		String[] nums2 = version2.split("\\.");
		int n1 = nums1.length, n2 = nums2.length;

		// compare versions
		int i1, i2;
		for (int i = 0; i < Math.max(n1, n2); ++i) {
			i1 = i < n1 ? Integer.parseInt(nums1[i]) : 0;
			i2 = i < n2 ? Integer.parseInt(nums2[i]) : 0;
			if (i1 != i2) {
				return i1 > i2 ? 1 : -1;
			}
		}
    // the versions are equal
    return 0;
  }
}
//˫ָ��һ�α���
class Solution2 {	
    public int compareVersion(String version1, String version2) {
        int l = 0, r = 0;
        int n = version1.length(), m = version2.length();
        int max = Math.max(n, m);
        while (l < n || r < m){
            int a= 0, b = 0;
            while(l < n && version1.charAt(l) != '.') a = a * 10 + version1.charAt(l++) - '0';
            while(r < m && version2.charAt(r) != '.') b = b * 10 + version2.charAt(r++) - '0';
            if (a > b) return 1;
            else if (a < b) return -1;
            l++;
            r++;
        }
        return 0;
    }
}
